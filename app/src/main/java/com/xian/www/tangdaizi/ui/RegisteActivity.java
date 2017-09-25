package com.xian.www.tangdaizi.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.beans.LoginRes;
import com.xian.www.tangdaizi.server.RequestServices;
import com.xian.www.tangdaizi.utils.Constant;
import com.xian.www.tangdaizi.utils.DialogUtil;
import com.xian.www.tangdaizi.utils.SPUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static android.text.TextUtils.isEmpty;
import static com.xian.www.tangdaizi.ui.LoginAcitvity.genericClient;

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
    public Context mContext;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                DialogUtil.closeProgressDialog();
                Toast.makeText(RegisteActivity.this,"恭喜你，注册成功",Toast.LENGTH_LONG).show();
                startActivity(new Intent(RegisteActivity.this, MainActivity.class));
                finish();
            }else if(msg.what == 2){
                DialogUtil.closeProgressDialog();
                Toast.makeText(mContext,"注册失败",Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registe);
        mContext = this;
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

        //创建Retrofit实例，设置url地址
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URL_BASE)
                .client(genericClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //通过Retrofit实例，创建接口服务对象
        RequestServices requestServices = retrofit.create(RequestServices.class);
        //接口服务对象调用接口中的方法，获得Call对象
        Call<String> call = requestServices.registe(name,pass);
        //call对象执行请求
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                DialogUtil.closeProgressDialog();
                if (response!=null && !TextUtils.isEmpty(response.toString())) {
                    try {
                        String result = response.body();
                        Log.i("result==", result);
                        //返回的结果保存在response.body()中
                        LoginRes loginRes = JSON.parseObject(result, new TypeReference<LoginRes>() {});
                        if(loginRes.getIsOk().equals("1")){//登陆成功
                            handler.sendEmptyMessage(1); //
                        }else if(loginRes.getIsOk().equals("0")){
                            handler.sendEmptyMessage(2); //登陆失败
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(mContext,"网络异常",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                Log.i("LoginAcitvity", "onFailure");
                Toast.makeText(mContext,"请求失败",Toast.LENGTH_LONG).show();
            }
        });
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
