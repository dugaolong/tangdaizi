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

public class DmgActivity04 extends Activity {


    @InjectView(R.id.radio01)
    ImageView radio01;
    @InjectView(R.id.radio02)
    ImageView radio02;
    @InjectView(R.id.radio03)
    ImageView radio03;

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dmg_pass_04);

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
        radio03.setClickable(false);
        SPUtil.appput(getApplicationContext(), "dmg_test_four", "right");
        radio01.setImageResource(R.drawable.radio_right);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(DmgActivity04.this,DmgActivity05.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        },1000);
    }
    @OnClick(R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        SPUtil.appput(getApplicationContext(), "dmg_test_four", "wrong");
        radio02.setImageResource(R.drawable.radio_wrong);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DmgActivity04.this,DmgActivity05.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        },1000);

    }
    @OnClick(R.id.radio03)   //
    public void radio03() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        SPUtil.appput(getApplicationContext(), "dmg_test_four", "wrong");
        radio03.setImageResource(R.drawable.radio_wrong);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DmgActivity04.this,DmgActivity05.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        },1000);

    }

}
