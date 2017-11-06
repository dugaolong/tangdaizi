package com.xian.www.tangdaizi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.Window;

/**
 * Created by dugaolong on 17/9/19.
 */

public class SplashActivity extends Activity {

    private ViewPager mViewPager;
    private Handler mHandler1;
    private Handler mHandler;
    private final int SPLASH_DISPLAY_LENGHT = 2000; //延迟2秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);

        mHandler1 = new Handler();

        mHandler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
            }
        }, SPLASH_DISPLAY_LENGHT);

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        Intent mIntent = new Intent();
                        mIntent.setClass(SplashActivity.this, WelcomeActivity.class);
                        SplashActivity.this.startActivity(mIntent);
                        SplashActivity.this.finish();
                        break;
                    default:
                        break;
                }

            }
        };
    }
}
