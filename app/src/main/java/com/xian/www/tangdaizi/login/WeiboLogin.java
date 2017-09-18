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


}
