package com.xian.www.tangdaizi.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.xian.www.tangdaizi.BaseActivity;
import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.login.QqLogin;
import com.xian.www.tangdaizi.login.WeiboLogin;
import com.xian.www.tangdaizi.login.WeixinLogin;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by dugaolong on 17/9/13.
 */

public class LoginAcitvity extends BaseActivity {

    @InjectView(R.id.no_account)
    TextView no_account;
    SpannableString msp = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        //隐藏状态栏
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);

        setContentView(R.layout.login);
        hideTitle(R.color.colorPrimary);
        //using butter knife
        ButterKnife.inject(this);

        //创建一个 SpannableString对象
        msp = new SpannableString("没有账号？注册一个");
        msp.setSpan(new ForegroundColorSpan(Color.parseColor("#97D0F8")), 5, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //设置前景色为洋红色
        no_account.setText(msp);
    }

    @OnClick(R.id.login_button)   //给 button1 设置一个点击事件
    public void login() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @OnClick(R.id.iv_weixin)   //微信登录
    public void login_weixin() {
        finish();
        startActivity(new Intent(this, WeixinLogin.class));
    }

    @OnClick(R.id.iv_weibo)   //微博登录
    public void login_weibo() {
        finish();
        startActivity(new Intent(this, WeiboLogin.class));
    }

    @OnClick(R.id.iv_qq)   //qq登录
    public void login_qq() {
        finish();
        startActivity(new Intent(this, QqLogin.class));
    }


    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void getIntentData() {

    }

}
