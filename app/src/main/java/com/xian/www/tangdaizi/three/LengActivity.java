package com.xian.www.tangdaizi.three;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/25.
 */

public class LengActivity extends Activity {

    private int position = 0;
    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.content)
    TextView content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_leng);
        //using butter knife
        ButterKnife.inject(this);
        getBundle();
        setContent();
    }


    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey("position")) {
                position = bundle.getInt("position");
            }
        }
    }

    private void setContent() {
        if (position == 0) {
            title_text.setText("【八拓将军】");
            content.setText("        唐太宗李世民有个弟弟叫李元婴，被太宗封为滕王。唐高宗即位后，看不惯这位滕王叔叔的骄横放纵，先后把他贬到洪州、滁州、隆州。滕王每到一处，都要兴造亭台楼阁，天天游山玩水，饮酒作乐。\n" +
                    "\r\n        滕王在担任隆州刺史的时候，经常做一些违法乱纪的勾当。他手下负责纠察的录事参军裴聿（yù）好几次当面劝谏他的行为。有一次，裴聿把李元婴批评恼了，元婴让侍卫上前去扇裴聿的耳光，啪啪啪啪贴了好几个大嘴巴。裴聿抗争不得，也只能暂时忍着。\n" +
                    "\r\n        不久，裴聿回京接受考核，在面见皇帝的时候把自己进谏被打的事情报告给高宗。高宗听了很气愤，问裴聿：“他打了你几下？”裴聿脱口说道：“前后一共八搨！（搨 tà，捶打的意思）”高宗说：“那你的官阶提升八阶！”这样，裴聿从正八品上阶跃升至正六品上阶。\n" +
                    "\r\n        裴聿回来后，对人叹息道：“我真是命不好，当时要是说挨了九搨，现在就成了五品官了！”这件事一时之间传为笑谈，大家送给裴聿一个外号：八搨将军。\n" +
                    "\r\n        后来，人们也把靠打报告而获得官职的人称为“八搨将军”，表达讽刺的意味。\n" +
                    "\r\n        （冯梦龙《古今谭概》）");
        } else if (position == 1) {
            title_text.setText("度量衡");
            content.setText("(1)长度\n" +
                    "\r\n        10寸=1尺(略少于1英尺)\n" +
                    "\r\n        5尺=1步(双步度)\n" +
                    "\r\n        10尺=1丈\n" +
                    "\r\n        1800尺=1里(接近1/3英里)\n" +
                    "\r\n(2)面积\n" +
                    "\r\n        1亩=宽1步*长240步的狭长地带(接近0.14英亩)\n" +
                    "\r\n        100亩=1顷(接近14英亩)\n" +
                    "\r\n(3)容量\n" +
                    "\r\n        3升=1大升(标准容器单位)\n" +
                    "\r\n        10大升=1斗\n" +
                    "\r\n        10斗=1斛\n" +
                    "\r\n(4)重量\n" +
                    "\r\n        1斛=1石(接近1.3/4蒲式耳)\n" +
                    "\r\n        3两=1大两(标准单位)\n" +
                    "\r\n        16两=1近(接近1.1/2英镑)\n" +
                    "\r\n(5)布\n" +
                    "\r\n        1皮丝=宽1.8尺*长40尺\n" +
                    "\r\n        1段麻=宽1.8尺*长50尺\n" +
                    "\r\n        唐宋元是我国封建社会全盛时期，明代中叶出现了资本主义萌芽。唐代将衡重单位24铢1两改为10钱1两。宋代又将容量单位10斗1斛改为5斗1斛，2斛1石(10斗)。清末光绪二十九年规定以尺、升、两为度量衡的基本单位，终于建立了中国两千多年来独特的、统一的、科学的度量衡单位制体系。");
        } else if (position == 2) {
            title_text.setText("古人的避暑措施");
            content.setText("      唐代的高官显贵，有的建立起私家避暑设施，规模自然比不得皇家。但也巧妙得很。其中专供纳凉用的水亭，就是唐代官吏设置的一种避暑建筑。《唐语林》卷五记载御史大夫王某“宅第有一雨亭。檐上飞流四注，当夏处之，凛若高秋”。刘禹锡《刘驸马水亭避暑》诗也描述了水亭特色：“千竿竹翠数莲红，水阁虚凉玉簟空。琥珀盏红疑漏雨，水晶帘莹更通风。”这种水亭，利用机械将冷水输送到亭顶的水罐中贮存，然后让水从房檐四周流下，形成雨帘，从而起到避暑降温的效果。唐代显贵杨国忠更是异想天开，造了座冰山来避暑。《开元天宝遗事》卷上记载：“杨氏子弟，每至伏中，取大冰使匠琢为山，周围于宴席间。”此外，每当寒冬季节，都有专职官吏负责采集天然冰块，贮存于“冰井”之中，炎夏期间取出，以供皇家和贵族使用。这一传统历史悠久，《诗经》中即有记载，是我国一传统风俗，亦称“藏冰”。这种习俗一直流传到民国年间。\n");
        } else if (position == 3) {
            title_text.setText("唐朝人烧梨");
            content.setText("      梨子在唐朝北方，是比较常见的水果，但唐朝人喜欢吃的却是蒸熟的梨。“田家老翁无可作，昼甑蒸梨香漠漠。”（出自贯休《田家作》。）这诗句就说明，唐朝老翁白天闲着没事，就会在家蒸个梨吃。在唐朝，除了最流行的蒸梨外，还有“炉端烧梨”。武则天的重孙子唐肃宗李亨，便曾经在夜里闲坐，因为心爱的臣子李泌不吃荤腥，李亨便亲自烧梨给他吃。\n" +
                    "\r\n        在唐朝，梨不算太贵太珍异的水果，在北方城镇的市场上比较容易买到，而且各地都有自己的名优品种。像长安地区最有名的叫“哀家梨”，洛阳报德寺的梨传说最大的一个重六斤，常山真定梨、青州水梨、郑州鹅梨等也都名扬天下。可见，唐朝不缺梨吃，但一定要蒸着或烧着吃。");
        } else if (position == 4) {
            title_text.setText("深井冰（储存冰的方法）");
            content.setText("      冬天于河面取冰，放入地窖或冰窖，覆盖上棉被，隔绝与外界的空气交换和温度交换。或存于井下 保持温度\n" +
                    "\r\n        大约到了唐朝末期，人们在生产火药时开采出大量硝石，发现硝石溶于水时会吸收大量的热，可使水降温到结冰，从此人们可以在夏天制冰了。\n");
        } else if (position == 5) {
            title_text.setText("狗咬人怎么判？");
            content.setText("      《三字经》说：“马牛羊，鸡犬豕。此六畜，人所饲。”狗是人类最忠实的朋友之一，在几千年前就被人类驯化而入家畜之列，它的主要任务是看家护院、守夜防患。狗的个性虽然对主人忠诚，但也常常招惹是非，其中狗咬人自古至今是民间屡见不鲜的事件，也往往是引发邻里纠纷的一个不安定因素。\n" +
                    "\r\n        令人想像不到的是，唐代律令对狗咬人这样的小小民事案件，竟作出了详细而明确的处理规定，他们以法律为准绳，把狗分成了遵纪守法的狗和违法乱纪的狗，对违法乱纪的狗，视其情节，给予相应处理。同时对违法养狗的人，也制定了承担的法律责任。\n" +
                    "\r\n        在唐代，如果出现狗咬人的事儿，首先是要弄清楚几个问题：是狗主动攻击人，还是人故意放狗咬，是明知狗咬人而管不好，还是被咬的人故意逗狗而被咬。弄清了这几个问题，对人和狗的处理就好办了，只要翻开《唐律疏议厩库》就能找到合适的处理办法。\n" +
                    "\r\n        最不听话的狗是爱惹是生非型的狗，它们往往向过路的行人主动发威，伤害无故。对这样的狗，唐朝的律令处理态度是坚决的，手段也是非常严厉的，让现在的动物保护者绝对无法理解。在这种情况下，行人是没有责任的，狗要承担全部的法律责任。《唐令拾遗·杂令第三十三》“畜产抵人”条规定：“啮人者，截两耳”。对这样的狗，人们要用剪刀把它的两只耳朵剪掉，借以惩罚。\n" +
                    "\r\n        当然，很多狗咬人事件的责任并不完全都在狗，而狗的主人没有管理好自己的狗也往往是造成狗咬人事件的另一个重要原因。凡是出现这种情况，狗咬了人，狗和狗的主人都要承担相应的法律责任。《唐律》规定，“以不施标帜羁绊及狂犬不杀之故，致杀伤人者，以过失论。过失者，各依其罪从赎法。”由于养狗者的过失而导致狗咬人的，则各依其罪予以赔偿。所以养的狗要拴好，狂犬要杀掉，否则，如果出现狗咬人事件，人和狗都要受到处罚，各笞四十。\n" +
                    "\r\n        还有一种情况，就是养狗的人故意放狗咬死咬伤人，这种行为是极端恶劣的。《唐律》为此专门设置了一条惩处的条款叫“故放令杀伤人”。故意放狗者，减斗杀伤一等。唐律把杀人行为分为故杀、斗杀和戏杀三种。“斗杀”是指“原无杀心，因相斗殴而杀人者”，此相当于现代的伤害致死罪。同时，在量刑时还要考虑狗咬的人贵贱、尊卑、长幼、亲属等情况，酌情加减治罪。\n" +
                    "\r\n        故意放狗咬伤的人，还有二十天的保辜期，辜內死的，放狗的人要承担杀人的刑责；受伤者限外死去或者限内以其他原因死亡的，伤人者只承担伤人的刑事责任。这是对伤人罪的后果不是立即显露时，规定加害方在一定期限内对被害方伤情变化负责的一项特别制度。\n" +
                    "\r\n        唐朝制定律令的人考虑得特别细，就连给狗看病时被咬也有交待。如果是花钱雇人给狗看病而不小心被咬伤，养狗的人不需要承担责任，如果是不花钱请人为狗看病而被咬伤，狗的主人要依法予以赔偿。当然，一些无聊的人逗狗玩儿时而被咬伤，狗和狗的主人也不需要承担任何法律责任。\n" +
                    "\r\n        狗咬人本是生活中一件再平常不过的事情，而唐朝的法律对处理此类案件却规定得如此之细，并照顾到了人与人、人与狗之间的各种权力，其中充满了公平与和谐。这令人想到了唐朝一些年份犯人只有几十人的原因，也令人联系到了贞观之治、开元盛世等唐朝鼎盛的背后，律令所起到的无可替代的作用。\n");
        } else if (position == 6) {
            title_text.setText("唐朝外国人众多");
            content.setText("      唐朝时候的“老外”，可以是以下几种人。第一种人指的是跟汉族人长得不一样的少数民族、其他民族。第二种情况才是外国人。唐朝在唐高宗的时候，其西部的边境已经到了咸海，地域包括伊朗东部地区。在中亚地区，当地的许多官职都要听命于唐朝的。很多国家的国王一面在当地当国王，同时却拥有一个唐朝的官号，或者是都督，或者是刺史等等。这在唐朝叫做羁縻制度，就是一种类似附属国一样的关系。从唐太宗开始唐朝的皇帝就有一个名称，叫天可汗，这个“天可汗”是一个区域性的含义，就是周边其他国家，唐朝的皇帝可以给他们发号施令，有点像有限范围内的天下共主。\n");
        } else if (position == 7) {
            title_text.setText("皇帝给大臣赐护肤品");
            content.setText("      中国古代自汉以后大多数时间都实行夏历，夏历的十二月为一年的末尾，称为腊月，十二月八日称为腊日。腊日是一年岁末祭祀百神的日子，在唐朝腊日时皇帝要向大臣们派发礼包，大臣们收到礼包后要上表圣上感谢恩德，得了免费的礼包说些好话也是情理之中的事，这种上表多数靠秘书代劳。\n" +
                    "\r\n        刘禹锡就曾经替别人写过两份谢腊日赐赠的上表，一篇是贞元十七年替淮南节度使杜佑写的《谢历日、面脂、口脂表》，另一份是替御史中丞李汶写的《为李中丞谢赐紫雪面脂等表》。\n" +
                    "\r\n        从这两份谢表中可以得知，皇帝腊日派发给大臣的礼品有：新年历日、紫雪、红雪、面脂、口脂、澡豆等。\n" +
                    "\r\n        腊日赐口脂面脂不知起于何时，杜甫写过一首《腊日》的诗，诗的后四句为：“纵酒欲谋良夜醉，还家初散紫宸朝。口脂面药随恩泽，翠管银罂下九宵。”罂是一种口小腹大的小罐，杜甫这首诗写于唐肃宗乾元元年，可见至少在那个时候就有了这种赐赠。\n" +
                    "\r\n        紫雪、红雪都是唐代的化妆品，刘禹锡在谢表中形容说：这种化妆品“膏凝雪莹，含液腾芳”，由此可见是一种芳香的膏状物。谢表中还写到：这种化妆品“功能去疾，永绝于疠疵；泽可饰容，顿光于蒲柳。”蒲柳是指蒲树和柳树，二者都属于落叶较早的树种，古人因而用蒲柳来比喻人的容颜早衰。而紫雪、红雪则可以消除皮肤上的病疵，使早衰的面容焕发容光。搽了之后小豆豆不见了，二十变成十八。\n" +
                    "\r\n        紫雪和红雪装在盒子或罐子中，盒子有金花银盒，带棱角的木盒。罐子这是银质的罂罐。\n" +
                    "\r\n        唐代的王焘写过一本《外台秘要》，记载了许多前人及当时的药方，比如武则天用来养生的《则天大圣皇后炼益母草留颜方》，书中有《紫雪丹》的配方，内含滑石、石膏 、磁石 、羚羊角 、青木香 、犀角 、沉香 、丁香 、玄参 、甘草 、朴硝 、朱砂 、麝香、黄金等十几种药物，明代的李时珍在《本草纲目》中也记有紫雪、红雪的验方，只是不知道和唐代皇帝赐给大臣们的紫雪、红雪是不是一种东西。看来这些都是高档化妆品。");

        }
    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
}