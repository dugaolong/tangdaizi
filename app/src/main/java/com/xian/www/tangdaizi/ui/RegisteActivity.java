package com.xian.www.tangdaizi.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.beans.RegisteRes;
import com.xian.www.tangdaizi.server.RequestServices;
import com.xian.www.tangdaizi.utils.Constant;
import com.xian.www.tangdaizi.utils.DialogUtil;
import com.xian.www.tangdaizi.utils.SPUtil;

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
    EditText name_et;
    @InjectView(R.id.age_et)
    EditText age_et;
    @InjectView(R.id.school_et)
    EditText school_et;
    @InjectView(R.id.phone_et)
    EditText phone_et;
    @InjectView(R.id.pass_et)
    EditText pass_et;
    @InjectView(R.id.registe_submit_btn)
    Button registe_submit_btn;
    public Context mContext;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                DialogUtil.closeProgressDialog();
                Toast.makeText(RegisteActivity.this,"恭喜你，注册成功",Toast.LENGTH_LONG).show();
                startActivity(new Intent(RegisteActivity.this, MainActivity.class));
                finish();
            }else if(msg.what == 1){
                DialogUtil.closeProgressDialog();
                Toast.makeText(mContext,"手机号已被注册",Toast.LENGTH_LONG).show();
            }else if(msg.what == 2){
                DialogUtil.closeProgressDialog();
                Toast.makeText(mContext,"注册失败",Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //隐藏状态栏
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        setContentView(R.layout.registe);
        mContext = this;
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.registe_submit_btn)
    public void registe_submit_btn() {
        final String name_et = this.name_et.getText().toString();
        final String age_et = this.age_et.getText().toString();
        final String school_et = this.school_et.getText().toString();
        final String phone_et = this.phone_et.getText().toString();
        final String pass_et = this.pass_et.getText().toString();

        if(isEmpty(name_et)){
            Toast.makeText(this,"请输入昵称",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(age_et)){
            Toast.makeText(this,"请输入年龄",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(school_et)){
            Toast.makeText(this,"请输学校",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(phone_et)){
            Toast.makeText(this,"请输入手机",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(pass_et)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
            return;
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
        Call<String> call = requestServices.registe(name_et,age_et,school_et,phone_et,pass_et);
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
                        RegisteRes registeRes = JSON.parseObject(result, new TypeReference<RegisteRes>() {});
                        if(registeRes.getIsOk().equals("0")){//登陆成功
                            String phone_old =  SPUtil.appget(RegisteActivity.this,"phone","nononono");
//                            if("nononono".equals(phone_old)){//首次安装
                                SPUtil.appclear(mContext);
                                SPUtil.appput(mContext,"name",name_et);
                                SPUtil.appput(mContext,"age",age_et);
                                SPUtil.appput(mContext,"school",school_et);
                                SPUtil.appput(mContext,"phone",phone_et);
                                SPUtil.appput(mContext,"pass",pass_et);
//                            }else{
//                                if(!phone_old.equals(phone_et)){
//                                    SPUtil.appclear(RegisteActivity.this);
//                                    SPUtil.appput(RegisteActivity.this,"phone",phone_et);
//                                    SPUtil.appput(RegisteActivity.this,"pass",pass_et);
//                                }
//                            }
                            handler.sendEmptyMessage(0); //
                        }else if(registeRes.getIsOk().equals("1")){
                            handler.sendEmptyMessage(1); //登陆用户已经存在
                        }else if(registeRes.getIsOk().equals("2")){
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



    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LoginAcitvity.class));
        finish();
    }

}
