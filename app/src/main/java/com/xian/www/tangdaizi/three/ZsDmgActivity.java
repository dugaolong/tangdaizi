package com.xian.www.tangdaizi.three;

import android.app.Activity;
import android.os.Bundle;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;

/**
 * Created by dugaolong on 17/9/20.
 * 知识竞赛 大明宫
 */

public class ZsDmgActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_zs_dmg);

        //using butter knife
        ButterKnife.inject(this);

    }



}
