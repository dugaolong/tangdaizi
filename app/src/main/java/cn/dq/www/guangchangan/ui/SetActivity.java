package cn.dq.www.guangchangan.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.second.UserInfoAcitvity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by dugaolong on 17/9/13.
 */

public class SetActivity extends Activity {

    @InjectView(R.id.ziliao)
    LinearLayout ziliao;
    @InjectView(R.id.gaishouji)
    LinearLayout gaishouji;
    @InjectView(R.id.gaimima)
    LinearLayout gaimima;
    @InjectView(R.id.huancun)
    LinearLayout huancun;
    @InjectView(R.id.gengxin)
    LinearLayout gengxin;
    @InjectView(R.id.guanyu)
    LinearLayout guanyu;
    @InjectView(R.id.logout)
    LinearLayout logout;
    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.btn_back_return)
    TextView btn_back_return;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);

        //using butter knife
        ButterKnife.inject(this);
        title_text.setText("设置");
    }

    @OnClick(R.id.ziliao)   //给  设置一个点击事件
    public void ziliao() {
        startActivity(new Intent(this, UserInfoAcitvity.class));
    }

    @OnClick(R.id.gaishouji)   //给  设置一个点击事件
    public void gaishouji() {
        toast();
    }

    @OnClick(R.id.gaimima)   //给  设置一个点击事件
    public void gaimima() {
        toast();
    }

    @OnClick(R.id.huancun)   //给  设置一个点击事件
    public void huancun() {
        toast();
    }

    @OnClick(R.id.gengxin)   //给  设置一个点击事件
    public void gengxin() {
        toast();
    }

    @OnClick(R.id.guanyu)   //给  设置一个点击事件
    public void guanyu() {
        toast();
    }

    private void toast() {
        Toast.makeText(this,"敬请期待",Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.logout)   //给  设置一个点击事件
    public void logout() {
//        startActivity(new Intent(this, LoginAcitvity.class));
//        finish();
        showPicker();
    }
    @OnClick(R.id.btn_back_return)   //给  设置一个点击事件
    public void btn_back_return() {
        finish();
    }


    public void showPicker() {
        final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(this).create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.select_level);

        TextView content = (TextView) window.findViewById(R.id.public_exit_content);
        TextView cancle = (TextView) window.findViewById(R.id.public_exit_cancle);
        TextView submit = (TextView) window.findViewById(R.id.public_exit_submit);
        content.setTextColor(getResources().getColor(R.color.black70));
        content.setText("你确定退出唐袋子？");
        submit.setText("确定");
        cancle.setText("取消");
        //如果reportContent内容太多了的话，我们需要让其滚动起来，
        //具体可以查看SDK中android.text.method了解更多，代码如下：
        content.setMovementMethod(ScrollingMovementMethod.getInstance());

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                dialog.dismiss();
                startActivity(new Intent(SetActivity.this, LoginAcitvity.class));
                finish();
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });
    }
}
