package com.xian.www.tangdaizi.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.three.ZsDmgActivity;
import com.xian.www.tangdaizi.three.ZsDtActivity;
import com.xian.www.tangdaizi.three.ZsDytActivity;
import com.xian.www.tangdaizi.three.ZsHqcActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/22.
 */

public class ZhishiActivity extends Activity {

    @InjectView(R.id.daminggong)
    CardView daminggong;
    @InjectView(R.id.datang)
    CardView datang;
    @InjectView(R.id.dayanta)
    CardView dayanta;
    @InjectView(R.id.huaqingchi)
    CardView huaqingchi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhishi);
        TextView textView = (TextView) findViewById(R.id.title_text);
        Intent intent = getIntent();
        String from = intent.getStringExtra("from");
        textView.setText(from);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.daminggong)
    public void daminggong() {
        startActivity(new Intent(this, ZsDmgActivity.class));
    }
    @OnClick(R.id.datang)
    public void datang() {
        startActivity(new Intent(this, ZsDtActivity.class));
    }
    @OnClick(R.id.dayanta)
    public void dayanta() {
        startActivity(new Intent(this, ZsDytActivity.class));
    }

    @OnClick(R.id.huaqingchi)
    public void huaqingchi() {
        startActivity(new Intent(this, ZsHqcActivity.class));
    }


}
