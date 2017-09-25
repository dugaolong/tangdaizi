package com.xian.www.tangdaizi.three;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/25.
 */

public class FushiActivity extends Activity {

    private int position = 0;
    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.content)
    TextView content;
    @InjectView(R.id.imageOne)
    ImageView imageOne;
    @InjectView(R.id.imageTwo)
    ImageView imageTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_fushi);
        //using butter knife
        ButterKnife.inject(this);
        imageTwo.setVisibility(View.GONE);
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
            title_text.setText("宫廷服饰");
            Glide.with(this).load(R.drawable.three_yi_one).into(imageOne);
            content.setText("      冠服制度是封建社会权力等级的象征，作为封建社会统治阶级精神支柱的儒学，则把恪守祖先成法作为忠孝之本，强调衣冠制度必须遵循古法，特别是作为大礼服的祭服和朝服，不能背弃先王遗制，故称法服；它具有很大的保守性和封闭性。宫廷日常服装称为常服，常服具有时代的特征。\n");
        } else if (position == 1) {
            title_text.setText("天子服饰");
            Glide.with(this).load(R.drawable.three_yi_two).into(imageOne);
            imageTwo.setVisibility(View.VISIBLE);
            Glide.with(this).load(R.drawable.three_yi_three).into(imageTwo);
            content.setText("      唐朝天子服装 ，根据穿着场合的不同，可以分为礼服和常服。\n" +
                    "\r\n        大裘冕，是天子服饰中规格最高、最为庄重的一款衣服，只在天子祭拜天神、地神的时候穿。“大裘冕”，顾名思义，就是身穿“大裘”，头戴“冕”。");
        } else if (position == 2) {
            title_text.setText("军人服饰");
            Glide.with(this).load(R.drawable.three_yi_four).into(imageOne);
            content.setText("      唐代武官的服制花色，规定武三品以上、左右武威卫饰对虎，左右豹韬卫饰豹，左右鹰扬卫饰鹰，左右玉钤卫饰对鹘，左右金吾卫饰对豸。又诸王饰盘龙及鹿，宰相饰凤池，尚书饰对雁。后又规定千牛卫饰瑞牛，左右卫饰瑞马，骁卫饰虎，武卫饰鹰，威卫饰豹，领军卫饰白泽，金吾卫饰辟邪，监门卫饰j狮子。唐太和六年又许三品以上服鹘衔瑞草、雁衔绶带及对孔雀绫袄。这类纹饰均以刺绣，按唐代服装款式，一般应绣于胸背或肩袖部位。\n");
        } else if (position == 3) {
            title_text.setText("妇女服饰");
            Glide.with(this).load(R.drawable.three_yi_five).into(imageOne);
            content.setText("      唐代女性服饰中有一种在贵妇间流行一种衫裙。它将裙带高高系在腰线以上，比如胸下，甚至系在胸线上方，历史上并没有文字记载名字叫做齐胸襦裙。这种款式无论身材丰腴还是瘦削都能达到别样的飘逸效果，尤其是在以丰腴为流行的圈子中更受欢迎。\n");
        } else if (position == 4) {
            title_text.setText("命妇服饰");
            Glide.with(this).load(R.drawable.three_yi_six).into(imageOne);
            content.setText("      皇后的三种服装有袆衣、鞠衣、钿钗襢衣；皇太子妃的三种服装有褕翟、鞠衣、钿钗礼衣。");
        } else if (position == 5) {
            title_text.setText("公卿礼服");
            Glide.with(this).load(R.drawable.three_yi_seven).into(imageOne);
            content.setText("      唐代官吏服装大致可分两类，一类为祭祀与重大政事活动的服装（祭服或朝服）；一类为比较普通的工作与社交活动的服装（公服或常服）。\n");
        } else if (position == 6) {
            title_text.setText("慢束罗裙半露胸");
            Glide.with(this).load(R.drawable.three_yi_eight).into(imageOne);
            content.setText("      慢束罗裙半露胸，并不是什么人都能做的。在唐代，只有有身份的人才能穿开胸衫，永泰公主可以半裸胸，歌女可以半裸胸以取悦于统治阶级，而平民百姓家的女子是不许半裸胸的。当时，唐朝半露胸的裙装有点类似于现代西方的夜礼服，只是不准露出肩膀和后背。");
        } else if (position == 7) {
            title_text.setText("襦裙半壁穿戴");
            Glide.with(this).load(R.drawable.three_yi_nine).into(imageOne);
            content.setText("      襦裙半臂穿戴--半臂这种服饰早在初唐即已出现;不仅在中原地区流行，西北地区的妇女也同样喜欢襦裙半臂穿戴，半臂是从短襦延边出来的一种服饰，一般都用对襟，穿在胸前结带。也有少数用\"套衫\"式的，穿时从上套下，领口宽大，呈坦胸状。半臂的下摆可以显现在外，也可以像短襦那样束在裙腰的里面。从传世的壁画，陶佣来看，穿著这种服装，里面一定要衬内衣(如短襦)，而不能单独使用。");

        }
    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
}
