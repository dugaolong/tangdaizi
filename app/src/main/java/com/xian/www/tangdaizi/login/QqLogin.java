package com.xian.www.tangdaizi.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.ui.LoginAcitvity;
import com.xian.www.tangdaizi.ui.MainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/17.
 */

public class QqLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_qq);

        //using butter knife
        ButterKnife.inject(this);
    }

    @OnClick(R.id.login_qq)   //给 button1 设置一个点击事件
    public void login_qq() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
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
