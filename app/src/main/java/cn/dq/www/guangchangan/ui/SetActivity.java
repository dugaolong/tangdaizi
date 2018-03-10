package cn.dq.www.guangchangan.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.beans.RegisteRes;
import cn.dq.www.guangchangan.second.UserInfoAcitvity;
import cn.dq.www.guangchangan.server.RequestServices;
import cn.dq.www.guangchangan.ui.setting.ChangeNameActivity;
import cn.dq.www.guangchangan.ui.setting.ChangePassActivity;
import cn.dq.www.guangchangan.utils.Constant;
import cn.dq.www.guangchangan.utils.DataCleanManager;
import cn.dq.www.guangchangan.utils.DialogUtil;
import cn.dq.www.guangchangan.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static cn.dq.www.guangchangan.ui.LoginAcitvity.genericClient;


/**
 * Created by dugaolong on 17/9/13.
 */

public class SetActivity extends Activity {

    private Context mContext;
    @InjectView(R.id.ziliao)
    LinearLayout ziliao;
    @InjectView(R.id.geinicheng)
    LinearLayout geinicheng;
    @InjectView(R.id.gaimima)
    LinearLayout gaimima;
    @InjectView(R.id.huancun)
    RelativeLayout huancun;
    @InjectView(R.id.gengxin)
    LinearLayout gengxin;
    @InjectView(R.id.comment)
    LinearLayout comment;
    @InjectView(R.id.logout)
    LinearLayout logout;
    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.cache)
    TextView cache;
    @InjectView(R.id.btn_back_return)
    TextView btn_back_return;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                DialogUtil.closeProgressDialog();
                ToastUtil.showToast(mContext,"已是最新版本");
            }else if(msg.what == 0){
                DialogUtil.closeProgressDialog();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        mContext = this;
        //using butter knife
        ButterKnife.inject(this);
        title_text.setText("设置");
        try {
            cache.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.ziliao)   //给  设置一个点击事件
    public void ziliao() {
        startActivity(new Intent(this, UserInfoAcitvity.class));
    }

    @OnClick(R.id.geinicheng)   //给  设置一个点击事件
    public void geinicheng() {
        startActivity(new Intent(this, ChangeNameActivity.class));
    }

    @OnClick(R.id.gaimima)   //给  设置一个点击事件
    public void gaimima() {
        startActivity(new Intent(this, ChangePassActivity.class));
    }

    @OnClick(R.id.huancun)   //给  设置一个点击事件
    public void huancun() {
        showSelectDialog();
    }

    @OnClick(R.id.gengxin)   //给  设置一个点击事件
    public void gengxin() {
//        if (NetUtil.checkNetState(this) && NetUtil.isNetworkAvailable(this)) {
//            DialogUtil.showProgressDialog(this, "正在加载，请稍候...");
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    DialogUtil.closeProgressDialog();
//                    ToastUtil.showToast(SetActivity.this, "已是最新版本");
//                }
//            }, 1000);
//        } else {
//            ToastUtil.showToast(this, "当前网络不可用");
//        }
        String versionName ="1.0";
        try {
            PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        DialogUtil.showProgressDialog(this, "正在检查版本...");

        //创建Retrofit实例，设置url地址
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URL_BASE)
                .client(genericClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //通过Retrofit实例，创建接口服务对象
        RequestServices requestServices = retrofit.create(RequestServices.class);
        //接口服务对象调用接口中的对象
        Call<String> call = requestServices.checkVersion();
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
                        if(registeRes.getIsOk().equals("1")){//已是最新版本
                            handler.sendEmptyMessage(1);
                        }else if(registeRes.getIsOk().equals("0")){//需要更新
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

    @OnClick(R.id.comment)   //给  设置一个点击事件
    public void comment() {
        try {
            String mAddress = "market://details?id=" + this.getPackageName();
            Intent marketIntent = new Intent("android.intent.action.VIEW");
            marketIntent.setData(Uri.parse(mAddress));
            startActivity(marketIntent);
        } catch (Exception e) {
            ToastUtil.showToast(this, "未找到应用市场");
            e.printStackTrace();
        }
    }

    private void toast() {
        ToastUtil.showToast(this, "敬请期待");
    }

    @OnClick(R.id.logout)   //给  设置一个点击事件
    public void logout() {
//        startActivity(new Intent(this, LoginAcitvity.class));
//        finish();
        showPicker();
    }

    @OnClick(R.id.btn_back_return)   //给  设置一个点击事件
    public void btn_back_return() {
        finish();
    }

    private void showSelectDialog() {
        final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(this).create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.select_level);

        TextView content = (TextView) window.findViewById(R.id.public_exit_content);
        TextView cancle = (TextView) window.findViewById(R.id.public_exit_cancle);
        TextView submit = (TextView) window.findViewById(R.id.public_exit_submit);
        content.setTextColor(getResources().getColor(R.color.black70));
        content.setText("清除缓存会导致下载的内容删除，是否确定?");
        submit.setText("确定");
        cancle.setText("取消");
        //如果reportContent内容太多了的话，我们需要让其滚动起来，
        //具体可以查看SDK中android.text.method了解更多，代码如下：
        content.setMovementMethod(ScrollingMovementMethod.getInstance());

        cancle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
                DataCleanManager.clearAllCache(SetActivity.this);
                ToastUtil.showToast(SetActivity.this, "缓存已清除");
                cache.setText("0.0B");
            }
        });
    }

    public void showPicker() {
        final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(this).create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.select_level);

        TextView content = (TextView) window.findViewById(R.id.public_exit_content);
        TextView cancle = (TextView) window.findViewById(R.id.public_exit_cancle);
        TextView submit = (TextView) window.findViewById(R.id.public_exit_submit);
        content.setTextColor(getResources().getColor(R.color.black70));
        content.setText("你确定退出唐袋子？");
        submit.setText("确定");
        cancle.setText("取消");
        //如果reportContent内容太多了的话，我们需要让其滚动起来，
        //具体可以查看SDK中android.text.method了解更多，代码如下：
        content.setMovementMethod(ScrollingMovementMethod.getInstance());

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                dialog.dismiss();
                startActivity(new Intent(SetActivity.this, LoginAcitvity.class));
                finish();
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });
    }
}
