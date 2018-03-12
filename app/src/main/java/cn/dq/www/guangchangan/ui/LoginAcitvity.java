package cn.dq.www.guangchangan.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.dq.www.guangchangan.BaseActivity;
import cn.dq.www.guangchangan.beans.LoginRes;
import cn.dq.www.guangchangan.server.RequestServices;
import cn.dq.www.guangchangan.utils.Constant;
import cn.dq.www.guangchangan.utils.DialogUtil;
import cn.dq.www.guangchangan.utils.SPUtil;
import cn.dq.www.guangchangan.utils.ToastUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static android.text.TextUtils.isEmpty;


/**
 * Created by dugaolong on 17/9/13.
 */

public class LoginAcitvity extends BaseActivity {

    @InjectView(cn.dq.www.guangchangan.R.id.registe)
    TextView no_account;
    @InjectView(cn.dq.www.guangchangan.R.id.name)
    EditText et_name;
    @InjectView(cn.dq.www.guangchangan.R.id.pass)
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
            }else if(msg.what == 2){
                DialogUtil.closeProgressDialog();
                ToastUtil.showToast(mContext,"用户名或者密码错误");
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

        setContentView(cn.dq.www.guangchangan.R.layout.login);
        hideTitle(cn.dq.www.guangchangan.R.color.colorPrimary);
        //using butter knife
        ButterKnife.inject(this);

        //创建一个 SpannableString对象
        msp = new SpannableString("没有账号？注册一个");
        msp.setSpan(new ForegroundColorSpan(Color.parseColor("#97D0F8")), 5, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //设置前景色为洋红色
        no_account.setText(msp);
    }

    @OnClick(cn.dq.www.guangchangan.R.id.login_button)   //给 button1 设置一个点击事件
    public void login() {
        String name = et_name.getText().toString();
        String pass = et_pass.getText().toString();

        if(isEmpty(name)){
            ToastUtil.showToast(this,"请输入用户名");
            return;
        }
        if(isEmpty(pass)){
            ToastUtil.showToast(this,"请输入密码");
            return;
        }

        DialogUtil.showProgressDialog(this, "正在登陆...");

        //创建Retrofit实例，设置url地址
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URL_BASE)
                .client(genericClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //通过Retrofit实例，创建接口服务对象
        RequestServices requestServices = retrofit.create(RequestServices.class);
        //接口服务对象调用接口中的方法，获得Call对象
        Call<String> call = requestServices.login(name,pass);
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
                            SPUtil.appput(mContext,"name",loginRes.getUsername());
                            SPUtil.appput(mContext,"age",loginRes.getUserAge());
                            SPUtil.appput(mContext,"school",loginRes.getUserSchool());
                            SPUtil.appput(mContext,"phone",loginRes.getUserPhone());
                            SPUtil.appput(mContext,"pass",loginRes.getUserpass());
                            handler.sendEmptyMessage(1); //
                        }else if(loginRes.getIsOk().equals("0")){
                            handler.sendEmptyMessage(2); //登陆失败
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    ToastUtil.showToast(mContext,"网络异常");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                Log.i("LoginAcitvity", "onFailure");
                ToastUtil.showToast(mContext,"请求失败");
            }
        });


    }

    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                .addHeader("Accept-Encoding", "gzip, deflate")
                                .addHeader("Connection", "keep-alive")
                                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                                .addHeader("Cookie", "_ga=GA1.2.2072854642.1487668872; _octo=GH1.1.501568181.1487668872; dotcom_user=dugaolong; logged_in=yes")
                                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/601.7.7 (KHTML, like Gecko) Version/9.1.2 Safari/601.7.7")
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();

        return httpClient;
    }
//
//    @OnClick(cn.dq.www.guangchangan.R.id.iv_weixin)   //微信登录
//    public void login_weixin() {
//        startActivity(new Intent(this, WeixinLogin.class));
//        finish();
//    }
//
//    @OnClick(cn.dq.www.guangchangan.R.id.iv_weibo)   //微博登录
//    public void login_weibo() {
//        startActivity(new Intent(this, WeiboLogin.class));
//        finish();
//    }
//
//    @OnClick(cn.dq.www.guangchangan.R.id.iv_qq)   //qq登录
//    public void login_qq() {
//        startActivity(new Intent(this, QqLogin.class));
//        finish();
//    }
    @OnClick(cn.dq.www.guangchangan.R.id.registe)   //注册按钮
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
