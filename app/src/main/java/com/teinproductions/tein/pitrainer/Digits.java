package com.teinproductions.tein.pitrainer;


import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

public class Digits implements Serializable {

    public static final String FILE_NAME = "saved_digits";
    public static final String DIGITS = "digits";
    public static final String NAME = "name";
    public static final String INTEGER_PART = "integer_part";
    public static final String FRACTIONAL_PART = "fractional_part";

    public static Digits[] digits;

    /**
     * The name of the Digits which is currently selected in the application
     */
    public static Digits currentDigit;

    /**
     * The name of a Digits has to be unique
     */
    private String name;

    /**
     * The integerPart are/is the digit(s) in front of the decimal point,
     * the fractionalPart are the digits after it.
     */
    private String integerPart, fractionalPart;

    public Digits() {
    }

    public Digits(String name, String integerPart, String fractionalPart) {
        this.name = name;
        this.integerPart = integerPart;
        this.fractionalPart = fractionalPart;
    }

    public static void initDigits(Context context) {
        Digits[] preloaded = preloaded(context);
        Digits[] saved = savedDigits(context);

        digits = new Digits[preloaded.length + saved.length];
        System.arraycopy(saved, 0, digits, 0, saved.length);
        System.arraycopy(preloaded, 0, digits, saved.length, preloaded.length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntegerPart() {
        return integerPart;
    }

    public void setIntegerPart(String integerPart) {
        this.integerPart = integerPart;
    }

    public String getFractionalPart() {
        return fractionalPart;
    }

    public void setFractionalPart(String fractionalPart) {
        this.fractionalPart = fractionalPart;
    }

    public static Digits[] preloaded(Context context) {
        return new Digits[]{
                new Digits(context.getString(R.string.pi), "3",
                        "141592653589793238462643383279502884197169399375105820974944592307816406" +
                                "2862089986280348253421170679821480865132823066470938446095505822317253594" +
                                "0812848111745028410270193852110555964462294895493038196442881097566593344" +
                                "6128475648233786783165271201909145648566923460348610454326648213393607260" +
                                "2491412737245870066063155881748815209209628292540917153643678925903600113" +
                                "3053054882046652138414695194151160943305727036575959195309218611738193261" +
                                "1793105118548074462379962749567351885752724891227938183011949129833673362" +
                                "4406566430860213949463952247371907021798609437027705392171762931767523846" +
                                "7481846766940513200056812714526356082778577134275778960917363717872146844" +
                                "0901224953430146549585371050792279689258923542019956112129021960864034418" +
                                "1598136297747713099605187072113499999983729780499510597317328160963185950" +
                                "2445945534690830264252230825334468503526193118817101000313783875288658753" +
                                "3208381420617177669147303598253490428755468731159562863882353787593751957" +
                                "7818577805321712268066130019278766111959092164201989380952572010654858632" +
                                "7886593615338182796823030195203530185296899577362259941389124972177528347" +
                                "9131515574857242454150695950829533116861727855889075098381754637464939319" +
                                "2550604009277016711390098488240128583616035637076601047101819429555961989" +
                                "4676783744944825537977472684710404753464620804668425906949129331367702898" +
                                "9152104752162056966024058038150193511253382430035587640247496473263914199" +
                                "2726042699227967823547816360093417216412199245863150302861829745557067498" +
                                "3850549458858692699569092721079750930295532116534498720275596023648066549" +
                                "9119881834797753566369807426542527862551818417574672890977772793800081647" +
                                "0600161452491921732172147723501414419735685481613611573525521334757418494" +
                                "6843852332390739414333454776241686251898356948556209921922218427255025425" +
                                "6887671790494601653466804988627232791786085784383827967976681454100953883" +
                                "7863609506800642251252051173929848960841284886269456042419652850222106611" +
                                "8630674427862203919494504712371378696095636437191728746776465757396241389" +
                                "0865832645995813390478027590099465764078951269468398352595709825822620522" +
                                "4894077267194782684826014769909026401363944374553050682034962524517493996" +
                                "5143142980919065925093722169646151570985838741059788595977297549893016175" +
                                "3928468138268683868942774155991855925245953959431049972524680845987273644" +
                                "6958486538367362226260991246080512438843904512441365497627807977156914359" +
                                "9770012961608944169486855584840635342207222582848864815845602850601684273" +
                                "9452267467678895252138522549954666727823986456596116354886230577456498035" +
                                "5936345681743241125150760694794510965960940252288797108931456691368672287" +
                                "4894056010150330861792868092087476091782493858900971490967598526136554978" +
                                "1893129784821682998948722658804857564014270477555132379641451523746234364" +
                                "5428584447952658678210511413547357395231134271661021359695362314429524849" +
                                "3718711014576540359027993440374200731057853906219838744780847848968332144" +
                                "5713868751943506430218453191048481005370614680674919278191197939952061419" +
                                "6634287544406437451237181921799983910159195618146751426912397489409071864" +
                                "9423196156794520809514655022523160388193014209376213785595663893778708303" +
                                "9069792077346722182562599661501421503068038447734549202605414665925201497" +
                                "4428507325186660021324340881907104863317346496514539057962685610055081066" +
                                "5879699816357473638405257145910289706414011097120628043903975951567715770" +
                                "0420337869936007230558763176359421873125147120532928191826186125867321579" +
                                "1984148488291644706095752706957220917567116722910981690915280173506712748" +
                                "5832228718352093539657251210835791513698820914442100675103346711031412671" +
                                "1136990865851639831501970165151168517143765761835155650884909989859982387" +
                                "3455283316355076479185358932261854896321329330898570642046752590709154814" +
                                "1654985946163718027098199430992448895757128289059232332609729971208443357" +
                                "3265489382391193259746366730583604142813883032038249037589852437441702913" +
                                "2765618093773444030707469211201913020330380197621101100449293215160842444" +
                                "8596376698389522868478312355265821314495768572624334418930396864262434107" +
                                "7322697802807318915441101044682325271620105265227211166039666557309254711" +
                                "0557853763466820653109896526918620564769312570586356620185581007293606598" +
                                "7648611791045334885034611365768675324944166803962657978771855608455296541" +
                                "2665408530614344431858676975145661406800700237877659134401712749470420562" +
                                "2305389945613140711270004078547332699390814546646458807972708266830634328" +
                                "5878569830523580893306575740679545716377525420211495576158140025012622859" +
                                "4130216471550979259230990796547376125517656751357517829666454779174501129" +
                                "9614890304639947132962107340437518957359614589019389713111790429782856475" +
                                "0320319869151402870808599048010941214722131794764777262241425485454033215" +
                                "7185306142288137585043063321751829798662237172159160771669254748738986654"),
                new Digits(context.getString(R.string.tau), "6",
                        "28318530717958647692528676655900576839" +
                                "4338798750211641949889184615632812572417997256069650684234135964296173" +
                                "0265646132941876892191011644634507188162569622349005682054038770422111" +
                                "1928924589790986076392885762195133186689225695129646757356633054240381" +
                                "8291297133846920697220908653296426787214520498282547449174013212631176" +
                                "3497630418419256585081834307287357851807200226610610976409330427682939" +
                                "0388302321886611454073151918390618437223476386522358621023709614892475" +
                                "9925499134703771505449782455876366023898259667346724881313286172042789" +
                                "8927904494743814043597218874055410784343525863535047693496369353388102" +
                                "6400113625429052712165557154268551557921834727435744293688180244990686" +
                                "0293099170742101584559378517847084039912224258043921728068836319627259" +
                                "5495426199210374144226999999967459560999021194634656321926371900489189" +
                                "1069381660528504461650668937007052386237634202000627567750577317506641" +
                                "6762841234355338294607196506980857510937462319125727764707575187503915" +
                                "5637155610643424536132260038557532223918184328403978761905144021309717"),
                new Digits(context.getString(R.string.euler_number), "2",
                        "718281828459045235360287471352662497757247093699959574966" +
                                "967627724076630353547594571382178525166427427466391932003059" +
                                "921817413596629043572900334295260595630738132328627943490763" +
                                "233829880753195251019011573834187930702154089149934884167509" +
                                "244761460668082264800168477411853742345442437107539077744992" +
                                "069551702761838606261331384583000752044933826560297606737113" +
                                "200709328709127443747047230696977209310141692836819025515108" +
                                "657463772111252389784425056953696770785449969967946864454905" +
                                "987931636889230098793127736178215424999229576351482208269895" +
                                "193668033182528869398496465105820939239829488793320362509443" +
                                "117301238197068416140397019837679320683282376464804295311802" +
                                "328782509819455815301756717361332069811250996181881593041690" +
                                "351598888519345807273866738589422879228499892086805825749279" +
                                "610484198444363463244968487560233624827041978623209002160990" +
                                "235304369941849146314093431738143640546253152096183690888707" +
                                "016768396424378140592714563549061303107208510383750510115747" +
                                "704171898610687396965521267154688957035035402123407849819334" +
                                "321068170121005627880235193033224745015853904730419957777093" +
                                "503660416997329725088687696640355570716226844716256079882651" +
                                "787134195124665201030592123667719432527867539855894489697096" +
                                "409754591856956380236370162112047742722836489613422516445078" +
                                "182442352948636372141740238893441247963574370263755294448337" +
                                "998016125492278509257782562092622648326277933386566481627725" +
                                "164019105900491644998289315056604725802778631864155195653244" +
                                "258698294695930801915298721172556347546396447910145904090586" +
                                "298496791287406870504895858671747985466775757320568128845920" +
                                "541334053922000113786300945560688166740016984205580403363795" +
                                "376452030402432256613527836951177883863874439662532249850654" +
                                "995886234281899707733276171783928034946501434558897071942586" +
                                "398772754710962953741521115136835062752602326484728703920764" +
                                "310059584116612054529703023647254929666938115137322753645098" +
                                "889031360205724817658511806303644281231496550704751025446501" +
                                "172721155519486685080036853228183152196003735625279449515828" +
                                "418829478761085263981395599006737648292244375287184624578036" +
                                "192981971399147564488262603903381441823262515097482798777996" +
                                "437308997038886778227138360577297882412561190717663946507063" +
                                "304527954661855096666185664709711344474016070462621568071748" +
                                "187784437143698821855967095910259686200235371858874856965220" +
                                "005031173439207321139080329363447972735595527734907178379342" +
                                "163701205005451326383544000186323991490705479778056697853358" +
                                "048966906295119432473099587655236812859041383241160722602998" +
                                "330535370876138939639177957454016137223618789365260538155841" +
                                "587186925538606164779834025435128439612946035291332594279490" +
                                "433729908573158029095863138268329147711639633709240031689458" +
                                "636060645845925126994655724839186564209752685082307544254599" +
                                "376917041977780085362730941710163434907696423722294352366125" +
                                "572508814779223151974778060569672538017180776360346245927877" +
                                "846585065605078084421152969752189087401966090665180351650179" +
                                "250461950136658543663271254963990854914420001457476081930221" +
                                "206602433009641270489439039717719518069908699860663658323227" +
                                "870937650226014929101151717763594460202324930028040186772391" +
                                "028809786660565118326004368850881715723866984224220102495055" +
                                "188169480322100251542649463981287367765892768816359831247788" +
                                "652014117411091360116499507662907794364600585194199856016264" +
                                "790761532103872755712699251827568798930276176114616254935649" +
                                "590379804583818232336861201624373656984670378585330527583333" +
                                "793990752166069238053369887956513728559388349989470741618155" +
                                "012539706464817194670834819721448889879067650379590366967249" +
                                "499254527903372963616265897603949857674139735944102374432970" +
                                "935547798262961459144293645142861715858733974679189757121195" +
                                "618738578364475844842355558105002561149239151889309946342841" +
                                "393608038309166281881150371528496705974162562823609216807515" +
                                "017772538740256425347087908913729172282861151591568372524163" +
                                "077225440633787593105982676094420326192428531701878177296023" +
                                "541306067213604600038966109364709514141718577701418060644363" +
                                "681546444005331608778314317444081194942297559931401188868331" +
                                "483280270655383300469329011574414756313999722170380461709289" +
                                "457909627166226074071874997535921275608441473782330327033016" +
                                "823719364800217328573493594756433412994302485023573221459784" +
                                "328264142168487872167336701061509424345698440187331281010794" +
                                "512722373788612605816566805371439612788873252737389039289050" +
                                "686532413806279602593038772769778379286840932536588073398845" +
                                "721874602100531148335132385004782716937621800490479559795929" +
                                "059165547050577751430817511269898518840871856402603530558373" +
                                "783242292418562564425502267215598027401261797192804713960068" +
                                "916382866527700975276706977703643926022437284184088325184877" +
                                "047263844037953016690546593746161932384036389313136432713768" +
                                "884102681121989127522305625675625470172508634976536728860596" +
                                "675274086862740791285657699631378975303466061666980421826772" +
                                "456053066077389962421834085988207186468262321508028828635974" +
                                "683965435885668550377313129658797581050121491620765676995065" +
                                "971534476347032085321560367482860837865680307306265763346977" +
                                "429563464371670939719306087696349532884683361303882943104080" +
                                "029687386911706666614680001512114344225602387447432525076938" +
                                "707777519329994213727721125884360871583483562696166198057252"),
                new Digits(context.getString(R.string.sqrt2), "1",
                        "4142135623730950488016887242096980785696718753769480731766797379907324784621" +
                                "07038850387534327641572735013846230912297024924836055850737212644121497099935831" +
                                "41322266592750559275579995050115278206057147010955997160597027453459686201472851" +
                                "74186408891986095523292304843087143214508397626036279952514079896872533965463318" +
                                "08829640620615258352395054745750287759961729835575220337531857011354374603408498" +
                                "84716038689997069900481503054402779031645424782306849293691862158057846311159666" +
                                "87130130156185689872372352885092648612494977154218334204285686060146824720771435" +
                                "85487415565706967765372022648544701585880162075847492265722600208558446652145839" +
                                "88939443709265918003113882464681570826301005948587040031864803421948972782906410" +
                                "45072636881313739855256117322040245091227700226941127573627280495738108967504018" +
                                "36986836845072579936472906076299694138047565482372899718032680247442062926912485" +
                                "90521810044598421505911202494413417285314781058036033710773091828693147101711116" +
                                "83916581726889419758716582152128229518488472089694633862891562882765952635140542" +
                                "26765323969461751129160240871551013515045538128756005263146801712740265396947024" +
                                "03005174953188629256313851881634780015693691768818523786840522878376293892143006" +
                                "55869568685964595155501644724509836896036887323114389415576651040883914292338113" +
                                "20605243362948531704991577175622854974143899918802176243096520656421182731672625" +
                                "75395947172559346372386322614827426222086711558395999265211762526989175409881593" +
                                "48640083457085181472231814204070426509056532333398436457865796796519267292399875" +
                                "36661721598257886026336361782749599421940377775368142621773879919455139723127406" +
                                "68983299898953867288228563786977496625199665835257761989393228453447356947949629" +
                                "52168891485492538904755828834526096524096542889394538646625744927556381964410316" +
                                "97983306185201937938494005715633372054806854057586799967012137223947582142630658" +
                                "51322174088323829472876173936474678374319600015921888073478576172522118674904249" +
                                "77366929207311096369721608933708661156734585334833295254675851644710757848602463" +
                                "60083444911481858765555428645512331421992631133251797060843655970435285641008791" +
                                "85007603610091594656706768836055717400767569050961367194013249356052401859991050" +
                                "62108163597726431380605467010293569971042425105781749531057255934984451126922780" +
                                "34491350663756874776028316282960553242242695753452902883876844642917328277088831" +
                                "80870253398523381227499908123718925407264753678503048215918018861671089728692292" +
                                "01197599880703818543332536460211082299279293072871780799888099176741774108983060" +
                                "80032631181642798823117154363869661702999934161614878686018045505553986913115186" +
                                "01038637532500455818604480407502411951843056745336836136745973744239885532851793" +
                                "08960373898915173195874134428817842125021916951875593444387396189314549999906107" +
                                "58704909026088351763622474975785885836803745793115733980209998662218694992259591" +
                                "32764236194105921003280261498745665996888740679561673918595728886424734635858868" +
                                "64496822386006983352642799056283165613913942557649062065186021647263033362975075" +
                                "69787060660685649816009271870929215313236828135698893709741650447459096053747279" +
                                "65244770940992412387106144705439867436473384774548191008728862221495895295911878" +
                                "92149179833981083788278153065562315810360648675873036014502273208829351341387227" +
                                "68417667843690529428698490838455744579409598626074249954916802853077398938296036" +
                                "21335398753205091998936075139064444957684569934712763645071632791547015977335486" +
                                "38939423257277540038260274785674172580951416307159597849818009443560379390985590" +
                                "16827215403458158152100493666295344882710729239660232163823826661262683050257278" +
                                "11694510353793715688233659322978231929860646797898640920856095581426143636310046" +
                                "15594332550474493975933999125419532300932175304476533964706627611661753518754646" +
                                "20967634558738616488019884849747926404506544489691004079421181692579685756378488" +
                                "14989864168549949163576144840470210339892153423770372333531156459443897036531667" +
                                "21949049351882905806307401346862641672470110653463493916407146285567980177933814" +
                                "42404526913706660977763878486623800339232437047411533187253190601916599645538115" +
                                "78884138084332321053376746181217801429609283241136275254088737290512940733947943" +
                                "30619439569367020794295158782283493219316664111301549594698378977674344435393377" +
                                "09957134988407890850815892366070088658105470949790465722988880892461282816013133" +
                                "70102908029099974564784958154561464871551639050241985790613109345878330620026220" +
                                "73724716766854554999049940857108099257599288932366154382719550057816251330381531" +
                                "46577907926868500806984428479152424275441026805756321565322061885751225113063937" +
                                "02536292716196825125919202521605870118959673224423926742373449076464672737534796" +
                                "45988191498079317180024238554538860383683108007791824664627541174442500187277795" +
                                "18164383451463461299020763343017968554385631667723518389336667042222110939144930" +
                                "28796381283988931173130843004212555018549850652945563776603146125590910461138476" +
                                "82823595924772286290426427361632645854433928772638603431498048963973633297548859" +
                                "25681149296836126725898573833216436663487023477302610106130507298611534129948808" +
                                "77447311122954265275165366591173014236062652586907719821703709810464436047722673" +
                                "92829874152593069562063847108274082184906737233058743029709242899481739244078693" +
                                "75284401044399048520878851914193541512900681735170306938697059004742515765524807" +
                                "84473621441050162008454441222559562029847259403528019067980680983003964539856859" +
                                "30458625260637797453559927747299064888745451242496076378010863900191058092874764" +
                                "72075110923860595019543228160208879621516233852161287522851802529287618325703717" +
                                "28574067639449098254644221846543088066105802015847284067126302545937989065081685" +
                                "71371656685941300533197036596403376674146104956376510308366134893109478026812935" +
                                "57331890551970520184515039969098663152512411611192594055280856498931958983456233" +
                                "19836834948808061715624391128663127978483719789533690152776005498055166350197855" +
                                "57110140555297633841275044686046476631832661165182067501204766991098721910444744" +
                                "03268943641595942792199442355371870429955924031409171284815854386600538571358363" +
                                "98163094524075570093251682434416824083619792733728252154622469615332170268299509" +
                                "79089034594858878349439616204358422497397187113958927305092197054917176961600445" +
                                "58089942787888036916943289459514722672292612485069617316380941082186004528610269" +
                                "65475763043102560271523139694821355198214097165490973199928349256740974903922971" +
                                "26348693414574933198041718076111963902278664075922434167762466236238913110270343" +
                                "30457636814112832132630858223945621959808661293999620123415617631817431242008901" +
                                "49838485604808798646083935964923665142968125773143229145687168276219961182782695" +
                                "31574983802624651759054103976181287604216386134502213262727756612441133610775195" +
                                "55774950865636067378665062318564069912280187574178549466125327599769796059776059" +
                                "07564891066610158384172028185304321190446577525542775437987260548817361982675816" +
                                "86283295260789932226683602838513512281059318591028641508157056319717315183136250" +
                                "24359041463212239217663398268936825315053005989154702909537193266207341123494743" +
                                "36788469020139049784285216341442921458955828784766939464642678122190497856363552" +
                                "63368278051860098699248937786002398769169807656621943898544370805946433362333810" +
                                "58745816235475600136592435242657143083465545768002370814675732525470255074763747" +
                                "16350678515991736937932510326827606286459146182047214863703707719269268236233347" +
                                "20379245964691810526139153086280291440965482563873092730426544662929045896063751" +
                                "91871146934536197332478957270703153093090192119919999361576500350398405406742538" +
                                "79275279227247335667706078379113844889362613676570602636003151329520953952028548" +
                                "97384486256134924414708607086602676349978793420875836121947116994223848482595914" +
                                "30452810706260150896913530301772006271705440209066951491527459771970594769547409" +
                                "52102878725578568800221937177435581107939308833845586482772910086295545661413067" +
                                "21230848740227121058686323388237413884428938155444647105755651468435702946635062" +
                                "89387356986868837648032651952841465351739530273612013742030098673983851432190043" +
                                "60289826982935293994141292305803845650227072168151619410114498263013649008770483" +
                                "98488386090653368599054583895203185648041493272142390865164999431659207965953569" +
                                "43072311291162928679751715668890543932203569129332457020806719444049730494398140" +
                                "82278296027994245410831666759214248351827238172050410392742888015562233807961475" +
                                "12433514731021284545944899444996000752437519570116683417447490795882099517836768" +
                                "02323651767497230148745774272599476096219843271483529861119027287358490521797590" +
                                "83741974860267060537462315300393752123678677528486921958571375542696848278363178" +
                                "61109933680143915905974842858054516130230143979057016108898627779610750673332676" +
                                "04865492925139978139053588227689373220494148394013556035656044214017612060513180" +
                                "68919899626061848318534018362378217266375804552471962661749254228528045714420485" +
                                "78342113228008528704205488992341278554812367615377071042544698685219911228354266" +
                                "34999712748366076246241820736466617128394748473280474430403344107200428727127567" +
                                "02795675824292627194545805300266648996507956977817862194217200523716536946770419" +
                                "51119127046248360511302890464377511486948878496151188414719100012558838366606772" +
                                "08411235153558811267789571558590412576261601067513153580212427331871000635824954" +
                                "50409957940725479890031682651237311905566829151943053708489307869197428290490386" +
                                "03723116099283424317122250994547150192866648787107951995180054633883844315481724" +
                                "63548024451803084527343100062137103462573306001234973744355818096567846464153390" +
                                "51465691932456235314057791936989884236471835253758052577133112007971040683154926" +
                                "65402026046806818391437827214769063242469517128636738443139833371176159418699934" +
                                "66262345373452356794012416809229116360956372167452839170990914664850739205151605" +
                                "60473787106154702169960746569309794426121469256159342564940191229895147325447151" +
                                "81263258368897282262833295240359700727863364604594707124174729468775705958157349" +
                                "96284809956783925547424044899188707106967524250774520122936081057414265323472406" +
                                "41621410333533405511045212617503590284037454591864504727624342071770929793540102" +
                                "14096464502836834180407586081001407216192477179809859681115404464437285689592868" +
                                "31977797786934641598469745133917741537904877880830022058335046746555323028587325" +
                                "83515708599649068672875967295038725475708791695547366917087012413339221484668517" +
                                "43706661548819529332272737436041082542596603039869326542235052369108595126300831" +
                                "84675550345975839550584035670155887977736443804818213870700344023618041200211483" +
                                "72794227407873789331627081013626498289629272562445805397134142214511099995445821" +
                                "42923783881026483948233951418767468967831862868178827255582573193951815531695164" +
                                "50149435726310604569492967098625204339385207822076221910034469269663342590853058" +
                                "16044978025776325448937080062677873179548529856683948694673356963001402931314190" +
                                "25780775816945815272529343422590519791831662164448751781696775276770913043157342")
        };
    }

    public static Digits[] savedDigits(Context context) {
        String file = getFile(context);
        if (file == null) return new Digits[0];

        try {
            JSONObject jObject = new JSONObject(file);
            JSONArray jArray = jObject.getJSONArray(DIGITS);
            Digits[] digits = new Digits[jArray.length()];
            for (int i = 0; i < jArray.length(); i++) {
                digits[i] = fromJSON(jArray.getJSONObject(i));
            }
            return digits;
        } catch (JSONException e) {
            e.printStackTrace();
            return new Digits[0];
        }
    }

    public static Digits fromJSON(JSONObject jObject) {
        try {
            String name = jObject.getString(NAME);
            String integerPart = jObject.getString(INTEGER_PART);
            String fractionalPart = jObject.getString(FRACTIONAL_PART);

            return new Digits(name, integerPart, fractionalPart);
        } catch (JSONException e) {
            return null;
        }
    }

    public String toJSON() {
        return String.format("{\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\"}",
                NAME, name, INTEGER_PART, integerPart, FRACTIONAL_PART, fractionalPart);
    }

    public static String arrayToJSON(Digits[] array) {
        StringBuilder sb = new StringBuilder(String.format("{\"%s\":[", DIGITS));
        for (Digits digits : array) {
            sb.append(digits.toJSON());
        }
        return sb.append("]}").toString().replace("}{", "},{");
    }

    public static String getFile(Context context) {
        StringBuilder sb;

        try {
            FileInputStream fis = context.openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);

            sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addDigits(Context context, Digits newDigits) {
        Digits[] saved = savedDigits(context);
        Digits[] newSaved = new Digits[saved.length + 1];
        System.arraycopy(saved, 0, newSaved, 0, saved.length);
        newSaved[newSaved.length - 1] = newDigits;

        save(context, newSaved);

        String currentName = currentDigit.getName();
        initDigits(context);
        currentDigit = findDigits(currentName);
    }

    public static void save(Context context, Digits[] toSave) {
        String json = arrayToJSON(toSave);

        try {
            FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(json.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Something went wrong while saving", Toast.LENGTH_SHORT).show();
        }
    }

    public static String[] digitsNames() {
        String[] result = new String[digits.length];
        for (int i = 0; i < digits.length; i++) {
            result[i] = digits[i].getName();
        }
        return result;
    }

    public static int currentDigitsIndex() {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i].equals(currentDigit)) return i;
        }

        return 0;
    }

    public static Digits findDigits(String name) {
        for (Digits digits : Digits.digits) {
            if (digits.getName().equals(name)) return digits;
        }
        return digits[0];
    }
}