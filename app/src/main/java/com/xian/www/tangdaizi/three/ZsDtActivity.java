package com.xian.www.tangdaizi.three;

import android.app.Activity;
import android.os.Bundle;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/20.
 * 知识竞赛 大明宫
 */

public class ZsDtActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_zs_dt);

        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }


}
