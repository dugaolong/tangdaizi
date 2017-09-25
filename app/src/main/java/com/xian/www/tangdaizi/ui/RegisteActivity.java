package com.xian.www.tangdaizi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.utils.DialogUtil;
import com.xian.www.tangdaizi.utils.SPUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;

/**
 * Created by dugaolong on 17/9/18.
 */

public class RegisteActivity extends Activity {

    @InjectView(R.id.name_et)
    TextView name_et;
    @InjectView(R.id.et_new_password)
    TextView et_new_password;
    @InjectView(R.id.et_reapet_password)
    TextView et_reapet_password;
    @InjectView(R.id.registe_submit_btn)
    TextView registe_submit_btn;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                DialogUtil.closeProgressDialog();
                Toast.makeText(RegisteActivity.this,"恭喜你，注册成功",Toast.LENGTH_LONG).show();
                startActivity(new Intent(RegisteActivity.this, MainActivity.class));
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registe);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.registe_submit_btn)   //qq登录
    public void registe_submit_btn() {
        String name = name_et.getText().toString();
        String pass = et_new_password.getText().toString();
        String pass_re = et_reapet_password.getText().toString();

        if(isEmpty(name)){
            Toast.makeText(this,"请输入用户名",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(pass)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(pass_re)){
            Toast.makeText(this,"请输入确认密码",Toast.LENGTH_LONG).show();
            return;
        }
        if(!pass.equals(pass_re)){
            Toast.makeText(this,"两次密码不一致",Toast.LENGTH_LONG).show();
            return;
        }

        if(!regexPassWord(pass)){
            Toast.makeText(this,"密码格式不正确",Toast.LENGTH_LONG).show();
            return;
        }
        String name_old =  SPUtil.appget(this,"name","nononono");
        if("nononono".equals(name_old)){//首次安装
            SPUtil.appput(this,"name",name);
            SPUtil.appput(this,"pass",pass);
        }else{
            if(!name_old.equals(name)){
                SPUtil.appclear(this);
                SPUtil.appput(this,"name",name);
                SPUtil.appput(this,"pass",pass);
            }
        }



        DialogUtil.showProgressDialog(this, "正在注册...");
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

    @OnClick(R.id.btn_back_return)   //返回
    public void btn_back_return() {
        startActivity(new Intent(this, LoginAcitvity.class));
        finish();
    }

    /**
     *
     * @param pwd 传入的是 密码
     * @return 如果匹配正确，满足密码规则，return true， else return false
     */
    public static boolean regexPassWord(String pwd){

        String reg1=".*[0-9].*";
        String reg2=".*[a-z].*";
        String reg3=".*[A-Z].*";
        String reg4=".*[^a-zA-Z0-9].*";
        Pattern pa1= Pattern.compile(reg1);
        Pattern pa2=Pattern.compile(reg2);
        Pattern pa3=Pattern.compile(reg3);
        Pattern pa4=Pattern.compile(reg4);
        Matcher m1=pa1.matcher(pwd);
        Matcher m2=pa2.matcher(pwd);
        Matcher m3=pa3.matcher(pwd);
        Matcher m4=pa4.matcher(pwd);
        if(m1.matches()&& m2.matches()&&m3.matches()&&m4.matches()){
            return  true;
        }else{
            return  false;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LoginAcitvity.class));
        finish();
    }

}
