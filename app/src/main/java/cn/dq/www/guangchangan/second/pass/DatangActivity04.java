package cn.dq.www.guangchangan.second.pass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;

import cn.dq.www.guangchangan.utils.SPUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/11/10.
 */

public class DatangActivity04 extends Activity {


    @InjectView(cn.dq.www.guangchangan.R.id.radio01)
    ImageView radio01;
    @InjectView(cn.dq.www.guangchangan.R.id.radio02)
    ImageView radio02;

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(cn.dq.www.guangchangan.R.layout.datang_pass_04);

        //using butter knife
        ButterKnife.inject(this);

        handler = new Handler();
    }


    @OnClick(cn.dq.www.guangchangan.R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio01)   //
    public void radio01() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        SPUtil.appput(getApplicationContext(), "datang_test_four", "right");
        radio01.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_right);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(DatangActivity04.this,DatangActivity05.class));
                overridePendingTransition(cn.dq.www.guangchangan.R.anim.slide_in_right, cn.dq.www.guangchangan.R.anim.slide_out_left);
                finish();
            }
        },1000);
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        SPUtil.appput(getApplicationContext(), "datang_test_four", "wrong");
        radio02.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_wrong);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DatangActivity04.this,DatangActivity05.class));
                overridePendingTransition(cn.dq.www.guangchangan.R.anim.slide_in_right, cn.dq.www.guangchangan.R.anim.slide_out_left);
                finish();
            }
        },1000);

    }

}
