package com.xian.www.tangdaizi.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.three.HqcJianjieActivity;
import com.xian.www.tangdaizi.three.HqcdaoyouActivity;
import com.xian.www.tangdaizi.three.HqcgushiActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/16.
 * 华清池
 */

public class HqcActivity extends Activity {

    @InjectView(R.id.jianjie)
    ImageView jianjie;
    @InjectView(R.id.daoyouzhushou)
    ImageView daoyouzhushou;
    @InjectView(R.id.xiaogushi)
    ImageView xiaogushi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sec_hqc);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.jianjie)   //简介
    public void jianjie() {
        startActivity(new Intent(this, HqcJianjieActivity.class));
    }

    @OnClick(R.id.daoyouzhushou)   //导游助手
    public void daoyouzhushou() {
        startActivity(new Intent(this, HqcdaoyouActivity.class));
    }

    @OnClick(R.id.xiaogushi)   //小故事
    public void xiaogushi() {
        startActivity(new Intent(this, HqcgushiActivity.class));
    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

}
