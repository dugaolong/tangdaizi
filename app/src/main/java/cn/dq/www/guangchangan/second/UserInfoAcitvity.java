package cn.dq.www.guangchangan.second;

import android.app.Activity;
import android.content.Context;
import android.content.PeriodicSync;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.beans.LoginRes;
import cn.dq.www.guangchangan.bmobBeans.Person;
import cn.dq.www.guangchangan.server.RequestServices;
import cn.dq.www.guangchangan.utils.Constant;
import cn.dq.www.guangchangan.utils.DialogUtil;
import cn.dq.www.guangchangan.utils.SPUtil;
import cn.dq.www.guangchangan.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static cn.dq.www.guangchangan.ui.LoginAcitvity.genericClient;

/**
 * Created by dugaolong on 17/11/13.
 */

public class UserInfoAcitvity extends Activity {

    @InjectView(R.id.nicheng)
    TextView nicheng;
    @InjectView(R.id.nianling)
    TextView nianling;
    @InjectView(R.id.xuexiao)
    TextView xuexiao;
    @InjectView(R.id.shouji)
    TextView shouji;
//    @InjectView(R.id.mima)
//    TextView mima;
    public Context mContext;
    public LoginRes login;


    private Person person;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                DialogUtil.closeProgressDialog();
                nicheng.setText(person.getUsername());
                nianling.setText(person.getUserAge());
                xuexiao.setText(person.getUserSchool());
                shouji.setText(person.getUserPhone());
            } else if (msg.what == 0) {
                DialogUtil.closeProgressDialog();
                ToastUtil.showToast(mContext, "获取信息失败");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        mContext = this;
        //using butter knife
        ButterKnife.inject(this);
        login = new LoginRes();
        DialogUtil.showProgressDialog(this, "正在查询...");
        BmobQuery<Person> query = new BmobQuery<>();
        query.setLimit(1).order("-createdAt")
                .findObjects(new FindListener<Person>() {
                    @Override
                    public void done(List<Person> personList, BmobException e) {
                        if (e == null) {
                            person = personList.get(0);
                            handler.sendEmptyMessage(1); //
                        } else {
                            handler.sendEmptyMessage(0);
                        }
                    }
                });
//        //创建Retrofit实例，设置url地址
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Constant.URL_BASE)
//                .client(genericClient())
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build();
//
//        //通过Retrofit实例，创建接口服务对象
//        RequestServices requestServices = retrofit.create(RequestServices.class);
//        //接口服务对象调用接口中的对象
//        String phone = SPUtil.appget(UserInfoAcitvity.this, "phone", "18309080808");
//        Call<String> call = requestServices.userInfo(phone);
//        //call对象执行请求
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
//                DialogUtil.closeProgressDialog();
//                if (response != null && !TextUtils.isEmpty(response.toString())) {
//                    try {
//                        String result = response.body();
//                        Log.i("result==", result);
//                        //返回的结果保存在response.body()中
//                        LoginRes loginRes = JSON.parseObject(result, new TypeReference<LoginRes>() {
//                        });
//                        if (loginRes.getIsOk().equals("1")) {//成功
//                            SPUtil.appput(mContext, "name", loginRes.getUsername());
//                            SPUtil.appput(mContext, "age", loginRes.getUserAge());
//                            SPUtil.appput(mContext, "school", loginRes.getUserSchool());
//                            SPUtil.appput(mContext, "phone", loginRes.getUserPhone());
//                            SPUtil.appput(mContext, "pass", loginRes.getUserpass());
//
//                            login.setUsername(loginRes.getUsername());
//                            login.setUserPhone(loginRes.getUserPhone());
//                            login.setUserAge(loginRes.getUserAge());
//                            login.setUserSchool(loginRes.getUserSchool());
//                            login.setUserpass(loginRes.getUserpass());
//
//                            handler.sendEmptyMessage(1); //
//                        } else if (loginRes.getIsOk().equals("0")) {
//                            handler.sendEmptyMessage(2); //失败
//                        }
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    ToastUtil.showToast(mContext, "网络异常");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                t.printStackTrace();
//                Log.i("LoginAcitvity", "onFailure");
//                ToastUtil.showToast(mContext, "请求失败");
//            }
//        });
    }


    @OnClick(R.id.btn_back_return)   //返回
    public void btn_back_return() {
        finish();
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
