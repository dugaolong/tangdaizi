package cn.dq.www.guangchangan.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.second.UserInfoAcitvity;
import cn.dq.www.guangchangan.ui.setting.ChangeNameActivity;
import cn.dq.www.guangchangan.ui.setting.ChangePassActivity;
import cn.dq.www.guangchangan.utils.DialogUtil;
import cn.dq.www.guangchangan.utils.NetUtil;
import cn.dq.www.guangchangan.utils.ToastUtil;


/**
 * Created by dugaolong on 17/9/13.
 */

public class SetActivity extends Activity {

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
    @InjectView(R.id.btn_back_return)
    TextView btn_back_return;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);

        //using butter knife
        ButterKnife.inject(this);
        title_text.setText("设置");
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
        DialogUtil.showProgressDialog(this,"正在清理中。。。");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DialogUtil.closeProgressDialog();
            }
        },2000);
    }

    @OnClick(R.id.gengxin)   //给  设置一个点击事件
    public void gengxin() {
        if (NetUtil.checkNetState(this)&&NetUtil.isNetworkAvailable(this)) {
            DialogUtil.showProgressDialog(this, "正在加载，请稍候...");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    DialogUtil.closeProgressDialog();
                    ToastUtil.showToast(SetActivity.this, "已是最新版本");
                }
            }, 1000);
        } else {
            ToastUtil.showToast(this, "当前网络不可用");
        }
    }

    @OnClick(R.id.comment)   //给  设置一个点击事件
    public void comment() {
        try {
            String mAddress = "market://details?id=" + this.getPackageName();
            Intent marketIntent = new Intent("android.intent.action.VIEW");
            marketIntent.setData(Uri.parse(mAddress));
            startActivity(marketIntent);
        }catch (Exception e){
            ToastUtil.showToast(this,"未找到应用市场");
            e.printStackTrace();
        }
    }

    private void toast() {
        ToastUtil.showToast(this,"敬请期待");
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
