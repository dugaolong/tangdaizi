package com.xian.www.tangdaizi.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.three.DmgJianjieActivity;
import com.xian.www.tangdaizi.three.DmgdaoyouActivity;
import com.xian.www.tangdaizi.three.DmggushiActivity;
import com.xian.www.tangdaizi.ui.MainActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/16.
 * 大明宫
 */

public class DaminggongActivity extends Activity {

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
        setContentView(R.layout.sec_daminggong);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.jianjie)   //简介
    public void jianjie() {
        startActivity(new Intent(this, DmgJianjieActivity.class));
    }

    @OnClick(R.id.daoyouzhushou)   //导游助手
    public void daoyouzhushou() {
        startActivity(new Intent(this, DmgdaoyouActivity.class));
    }

    @OnClick(R.id.xiaogushi)   //小故事
    public void xiaogushi() {
        startActivity(new Intent(this, DmggushiActivity.class));
    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
