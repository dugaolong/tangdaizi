package com.xian.www.tangdaizi.three;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/20.
 * 导游助手
 */

public class HqcdaoyouActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.three_hqc_daoyou);

        //using butter knife
        ButterKnife.inject(this);


    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

}