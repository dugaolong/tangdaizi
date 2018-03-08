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
import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.beans.RegisteRes;
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

public class ChangeNameActivity extends Activity {

    @InjectView(R.id.name_et)
    EditText name_et;
    @InjectView(R.id.registe_submit_btn)
    Button registe_submit_btn;
    public Context mContext;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                DialogUtil.closeProgressDialog();
                ToastUtil.showToast(ChangeNameActivity.this,"修改成功");
                startActivity(new Intent(ChangeNameActivity.this, SetActivity.class));
                finish();
            }else if(msg.what == 0){
                DialogUtil.closeProgressDialog();
                ToastUtil.showToast(mContext,"修改失败");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.changename);
        mContext = this;
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.registe_submit_btn)
    public void registe_submit_btn() {
        final String name_et = this.name_et.getText().toString();

        if(isEmpty(name_et)){
            ToastUtil.showToast(this,"请输入昵称");
            return;
        }

        DialogUtil.showProgressDialog(this, "正在提交...");

        //创建Retrofit实例，设置url地址
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URL_BASE)
                .client(genericClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //通过Retrofit实例，创建接口服务对象
        RequestServices requestServices = retrofit.create(RequestServices.class);
        //接口服务对象调用接口中的对象
        String phone = SPUtil.appget(ChangeNameActivity.this,"phone","18309080808");
        Call<String> call = requestServices.updateName(name_et,phone);
        //call对象执行请求
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                DialogUtil.closeProgressDialog();
                Log.i("response==", response.toString());
                if (response!=null && !TextUtils.isEmpty(response.toString())) {
                    try {
                        String result = response.body();
                        Log.i("result==", result);
                        //返回的结果保存在response.body()中
                        RegisteRes registeRes = JSON.parseObject(result, new TypeReference<RegisteRes>() {});
                        if(registeRes.getIsOk().equals("1")){//修改成功
                            handler.sendEmptyMessage(1);
                        }else if(registeRes.getIsOk().equals("0")){//修改失败
                            handler.sendEmptyMessage(0);
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

    @OnClick(R.id.btn_back_return)   //返回
    public void btn_back_return() {
        finish();
    }



    @Override
    public void onBackPressed() {
        finish();
    }

}