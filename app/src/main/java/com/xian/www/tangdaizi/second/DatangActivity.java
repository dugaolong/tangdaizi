package com.xian.www.tangdaizi.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.three.DatangJianjieActivity;
import com.xian.www.tangdaizi.three.DtdaoyouActivity;
import com.xian.www.tangdaizi.three.DtgushiActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/16.
 * 大唐芙蓉园
 */

public class DatangActivity extends Activity {

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
        setContentView(R.layout.sec_datang);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.jianjie)   //简介
    public void jianjie() {
        startActivity(new Intent(this, DatangJianjieActivity.class));
    }

    @OnClick(R.id.daoyouzhushou)   //导游助手
    public void daoyouzhushou() {
        startActivity(new Intent(this, DtdaoyouActivity.class));
    }

    @OnClick(R.id.xiaogushi)   //小故事
    public void xiaogushi() {
        startActivity(new Intent(this, DtgushiActivity.class));
    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

}
