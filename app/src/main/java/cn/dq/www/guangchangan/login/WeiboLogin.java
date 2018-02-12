package cn.dq.www.guangchangan.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.ui.LoginAcitvity;
import cn.dq.www.guangchangan.ui.MainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/17.
 */

public class WeiboLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_weibo);

        //using butter knife
        ButterKnife.inject(this);
    }

    @OnClick(R.id.login_weibo)   //给 button1 设置一个点击事件
    public void login_weixin() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @OnClick(R.id.btn_back_return)   //返回
    public void image_back() {
        startActivity(new Intent(this, LoginAcitvity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LoginAcitvity.class));
        finish();
    }


}
