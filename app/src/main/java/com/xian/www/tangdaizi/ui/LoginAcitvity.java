package com.xian.www.tangdaizi.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xian.www.tangdaizi.BaseActivity;
import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.login.QqLogin;
import com.xian.www.tangdaizi.login.WeiboLogin;
import com.xian.www.tangdaizi.login.WeixinLogin;
import com.xian.www.tangdaizi.utils.DialogUtil;
import com.xian.www.tangdaizi.utils.SPUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;


/**
 * Created by dugaolong on 17/9/13.
 */

public class LoginAcitvity extends BaseActivity {

    @InjectView(R.id.registe)
    TextView no_account;
    @InjectView(R.id.name)
    EditText et_name;
    @InjectView(R.id.pass)
    EditText et_pass;

    SpannableString msp = null;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                DialogUtil.closeProgressDialog();
                startActivity(new Intent(LoginAcitvity.this, MainActivity.class));
                finish();
            }
        }
    };

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
        String name = et_name.getText().toString();
        String pass = et_pass.getText().toString();

        if(isEmpty(name)){
            Toast.makeText(this,"请输入用户名",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(pass)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
            return;
        }

        SPUtil.appput(mContext,"name",name);
        SPUtil.appput(mContext,"pass",pass);
        DialogUtil.showProgressDialog(this, "正在登陆...");
        new Thread(new Runnable(){
            public void run(){

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.sendEmptyMessage(1); //告诉主线程执行任务

            }

        }).start();
    }

    @OnClick(R.id.iv_weixin)   //微信登录
    public void login_weixin() {
        startActivity(new Intent(this, WeixinLogin.class));
        finish();
    }

    @OnClick(R.id.iv_weibo)   //微博登录
    public void login_weibo() {
        startActivity(new Intent(this, WeiboLogin.class));
        finish();
    }

    @OnClick(R.id.iv_qq)   //qq登录
    public void login_qq() {
        startActivity(new Intent(this, QqLogin.class));
        finish();
    }
    @OnClick(R.id.registe)   //qq登录
    public void registe() {
        startActivity(new Intent(this, RegisteActivity.class));
        finish();
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
