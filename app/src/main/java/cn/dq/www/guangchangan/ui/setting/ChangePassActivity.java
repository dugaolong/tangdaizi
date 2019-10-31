package cn.dq.www.guangchangan.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.beans.RegisteRes;
import cn.dq.www.guangchangan.bmobBeans.Person;
import cn.dq.www.guangchangan.server.RequestServices;
import cn.dq.www.guangchangan.ui.SetActivity;
import cn.dq.www.guangchangan.utils.Constant;
import cn.dq.www.guangchangan.utils.DialogUtil;
import cn.dq.www.guangchangan.utils.SPUtil;
import cn.dq.www.guangchangan.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static android.text.TextUtils.isEmpty;
import static cn.dq.www.guangchangan.ui.LoginAcitvity.genericClient;

/**
 * 修改信息
 * Created by dugaolong on 17/9/18.
 */

public class ChangePassActivity extends Activity {

    @InjectView(R.id.pass_et)
    EditText pass_et;
    @InjectView(R.id.pass_repeat)
    EditText pass_repeat;
    @InjectView(R.id.registe_submit_btn)
    Button registe_submit_btn;
    public Context mContext;
    private String objectId;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                DialogUtil.closeProgressDialog();
                ToastUtil.showToast(ChangePassActivity.this, "修改成功");
                startActivity(new Intent(ChangePassActivity.this, SetActivity.class));
                finish();
            } else if (msg.what == 0) {
                DialogUtil.closeProgressDialog();
                ToastUtil.showToast(mContext, "修改失败");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.changepass);
        mContext = this;
        //using butter knife
        ButterKnife.inject(this);
        objectId = SPUtil.appget(this, "objectId", "");
    }

    @OnClick(R.id.registe_submit_btn)
    public void registe_submit_btn() {
        final String pass_et = this.pass_et.getText().toString();
        final String pass_repeat = this.pass_repeat.getText().toString();

        if (isEmpty(pass_et) || isEmpty(pass_repeat)) {
            ToastUtil.showToast(this, "请输入密码");
            return;
        }
        if (!pass_et.equals(pass_repeat)) {
            ToastUtil.showToast(this, "两次密码不一致");
            return;
        }
        DialogUtil.showProgressDialog(this, "正在提交...");
        Person p2=new Person();
//更新BmobObject的值
//  p2.setValue("user", BmobUser.getCurrentUser(this, MyUser.class));
//更新Object对象
        p2.setValue("username",pass_et);
//更新Object对象的值
//p2.setValue("bankCard.bankName","建行");
//更新Integer类型
//p2.setValue("age",11);
//更新Boolean类型
//p2.setValue("gender", true);
        p2.update(objectId, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    handler.sendEmptyMessage(1);
                }else{
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
//        //接口服务对象调用接口中的方法，获得Call对象
//        String phone = SPUtil.appget(ChangePassActivity.this,"phone","18309080808");
//        Call<String> call = requestServices.updatePass(pass_et,phone);
//        //call对象执行请求
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
//                DialogUtil.closeProgressDialog();
//                if (response!=null && !TextUtils.isEmpty(response.toString())) {
//                    try {
//                        String result = response.body();
//                        Log.i("result==", result);
//                        //返回的结果保存在response.body()中
//                        RegisteRes registeRes = JSON.parseObject(result, new TypeReference<RegisteRes>() {});
//                        if(registeRes.getIsOk().equals("1")){//修改成功
//                            handler.sendEmptyMessage(1); //
//                        }else if(registeRes.getIsOk().equals("0")){
//                            handler.sendEmptyMessage(0); //修改失败
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    ToastUtil.showToast(mContext,"网络异常");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                t.printStackTrace();
//                Log.i("LoginAcitvity", "onFailure");
//                ToastUtil.showToast(mContext,"请求失败");
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
