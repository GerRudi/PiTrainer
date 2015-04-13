package com.teinproductions.tein.pitrainer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CompleteFragment extends Fragment
        implements FragmentInterface, CompleteFragmentSettingsDialog.Listener {

    public static final String RANGE = "RANGE";
    public static final String NUM_OF_DIGITS_GIVEN = "NUM_OF_DIGITS_GIVEN";

    private ActivityInterface listener;
    private MainActivity.Digits currentDigits;

    private int range, numOfDigits;
    private String answer;

    private int selection = 0, lastTextLength = 0;
    private boolean indirectTextChange = false;

    private TextView statement; // I call this "statement" because it is "complete the statement"
    private EditText editText;
    private Keyboard keyboard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listener = (ActivityInterface) getActivity();

        View theView = inflater.inflate(R.layout.fragment_complete, container, false);

        statement = (TextView) theView.findViewById(R.id.statement_textView);
        editText = (EditText) theView.findViewById(R.id.editText);
        keyboard = (Keyboard) theView.findViewById(R.id.keyboard);

        theView.findViewById(R.id.settings_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSettings();
            }
        });

        theView.findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        setTextWatcher();
        keyboard.setEditText(editText);
        if (restoreValues()) {
            next();
        } else {
            onClickSettings();
            // Default settings:
            numOfDigits = 12;
            range = 50;
            next();
        }

        return theView;
    }

    private boolean restoreValues() {
        currentDigits = MainActivity.Digits.values()[
                getActivity().getPreferences(0).getInt(MainActivity.CURRENT_DIGITS_ORDINAL, 0)];
        range = getActivity().getPreferences(0).getInt(RANGE, -1);
        numOfDigits = getActivity().getPreferences(0).getInt(NUM_OF_DIGITS_GIVEN, -1);

        showOnScreenKeyboard(getActivity().getPreferences(0).getBoolean(MainActivity.ON_SCREEN_KEYBOARD, false));

        // If the values existed, return true; otherwise, false
        return !(range == -1 || numOfDigits == -1);
    }

    public void next() {
        editText.setText("");
        String digits = currentDigits.fractionalPart.substring(0, range);

        // You have to fill in 6 digits
        final int rangeOfIndex = range - 1 - 6 - numOfDigits;
        if (rangeOfIndex < 1) {
            Toast.makeText(getActivity(), "Check your settings", Toast.LENGTH_SHORT).show();
            return;
        }

        final int index = (int) Math.floor(Math.random() * rangeOfIndex);

        statement.setText(digits.substring(index, index + numOfDigits) + "...");
        answer = digits.substring(index + numOfDigits, index + numOfDigits + 6);
    }

    public void setTextWatcher() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (indirectTextChange) return;

                selection = editText.getSelectionStart();

                if (editText.length() == 0) {
                    listener.animateToolbarColor(true);
                    lastTextLength = editText.length();
                    return;
                }

                if (!answer.startsWith(editText.getText().toString()) && editText.length() <= 6) {
                    listener.animateToolbarColor(false);

                    // If the last typed character is wrong:
                    if (lastTextLength < editText.length() // backspace is not pressed
                            && selection != 0 // For catching index o.o.b. exception in next line
                            && editText.getText().toString().charAt(selection - 1)
                            != answer.charAt(selection - 1)) { // The typed character is wrong

                        listener.vibrate(100);
                    }
                } else if (!answer.startsWith(editText.getText().toString()) && editText.length() > 6) {
                    // Delete the typed character
                    editText.getText().delete(selection - 1, selection);
                } else if (editText.length() == 6) {
                    listener.animateToolbarColor(true);
                    next();
                    return;
                } else {
                    listener.animateToolbarColor(true);
                }

                indirectTextChange = true;
                editText.setText(toColoredSpannable());
                indirectTextChange = false;
                if (selection < editText.length()) {
                    editText.setSelection(selection);
                } else {
                    editText.setSelection(editText.length());
                }

                lastTextLength = editText.length();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private Spannable toColoredSpannable() {
        String text = editText.getText().toString();
        SpannableStringBuilder sb = new SpannableStringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != answer.charAt(i)) {
                ForegroundColorSpan redSpan = new ForegroundColorSpan(getResources().getColor(R.color.red));
                sb.setSpan(redSpan, i, i + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            }
        }

        return sb;
    }

    private void onClickSettings() {
        CompleteFragmentSettingsDialog.show(this, numOfDigits, range);
    }

    @Override
    public void setCurrentDigits(MainActivity.Digits digits) {
        currentDigits = digits;
        next();
    }

    @Override
    public void showOnScreenKeyboard(boolean show) {
        keyboard.setVisibility(show ? View.VISIBLE : View.GONE);
        listener.preventSoftKeyboardFromShowingUp(editText, show);
    }

    @Override
    public void reload() {
        restoreValues();
        next();
    }
}
