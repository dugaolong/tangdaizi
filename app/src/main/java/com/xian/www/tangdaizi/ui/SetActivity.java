package com.xian.www.tangdaizi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.second.UserInfoAcitvity;

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
        toast();
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
        startActivity(new Intent(this, LoginAcitvity.class));
        finish();
    }
    @OnClick(R.id.btn_back_return)   //给  设置一个点击事件
    public void btn_back_return() {
        finish();
    }

}
