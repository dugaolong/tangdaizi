package com.xian.www.tangdaizi.second.zhishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/11/10.
 */

public class ZsjsHighActivity03 extends Activity {


    @InjectView(R.id.radio01)
    ImageView radio01;
    @InjectView(R.id.radio02)
    ImageView radio02;
    @InjectView(R.id.radio03)
    ImageView radio03;
    @InjectView(R.id.radio04)
    ImageView radio04;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zsjs_high_03);

        //using butter knife
        ButterKnife.inject(this);

        handler  = new Handler(){
            @Override
            public void handleMessage(Message msg) {
//            super.handleMessage(msg);
                if(msg.what==0){
                    radio01.setImageResource(R.drawable.radio_no);
                    radio02.setImageResource(R.drawable.radio_no);
                    radio03.setImageResource(R.drawable.radio_no);
                    radio04.setImageResource(R.drawable.radio_no);
                    radio01.setClickable(true);
                    radio02.setClickable(true);
                    radio03.setClickable(true);
                    radio04.setClickable(true);
                }
            }
        };
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
        radio04.setClickable(false);
        radio01.setImageResource(R.drawable.radio_wrong);
        Toast.makeText(getApplicationContext(),"再想一想",Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);
    }
    @OnClick(R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio04.setClickable(false);
        radio02.setImageResource(R.drawable.radio_wrong);
        Toast.makeText(getApplicationContext(),"再想一想",Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);
    }

    @OnClick(R.id.radio03)   //
    public void radio03() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio04.setClickable(false);
        radio03.setImageResource(R.drawable.radio_wrong);
        Toast.makeText(getApplicationContext(),"再想一想",Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);
    }

    @OnClick(R.id.radio04)   //
    public void radio04() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio04.setClickable(false);
        radio04.setImageResource(R.drawable.radio_right);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ZsjsHighActivity03.this,ZsjsHighActivity04.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        },1000);
    }
}
