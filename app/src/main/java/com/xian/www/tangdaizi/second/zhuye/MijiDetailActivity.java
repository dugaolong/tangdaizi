package com.xian.www.tangdaizi.second.zhuye;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/16.
 * 广告
 */

public class MijiDetailActivity extends Activity {

    @InjectView(R.id.image_detail)
    ImageView image_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.miji);

        //using butter knife
        ButterKnife.inject(this);
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
}
