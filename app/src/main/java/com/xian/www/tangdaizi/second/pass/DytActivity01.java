package com.xian.www.tangdaizi.second.pass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.utils.SPUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/11/10.
 */

public class DytActivity01 extends Activity {


    @InjectView(R.id.radio01)
    ImageView radio01;
    @InjectView(R.id.radio02)
    ImageView radio02;

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dyt_pass_01);

        //using butter knife
        ButterKnife.inject(this);

        handler = new Handler();
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
    @OnClick(R.id.radio01)   //
    public void radio01() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        SPUtil.appput(getApplicationContext(), "dyt_test_one", "wrong");
        radio01.setImageResource(R.drawable.radio_wrong);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(DytActivity01.this,DytActivity02.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        },1000);
    }
    @OnClick(R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        SPUtil.appput(getApplicationContext(), "dyt_test_one", "right");
        radio02.setImageResource(R.drawable.radio_right);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DytActivity01.this,DytActivity02.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        },1000);

    }

}
