package com.xian.www.tangdaizi.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.second.zhuye.MijiDetailActivity;
import com.xian.www.tangdaizi.second.zhuye.ShipinThreeActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/16.
 * 大唐芙蓉园
 */

public class DatangActivityShipin extends Activity {

    @InjectView(R.id.play)
    RelativeLayout play;
    @InjectView(R.id.miji)
    ImageView miji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sec_datang);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

    @OnClick(R.id.play)   //播放视频
    public void play() {
        startActivity(new Intent(this, ShipinThreeActivity.class));
    }

    @OnClick(R.id.miji)   //秘籍
    public void miji() {
        startActivity(new Intent(this, MijiDetailActivity.class));
    }

}
