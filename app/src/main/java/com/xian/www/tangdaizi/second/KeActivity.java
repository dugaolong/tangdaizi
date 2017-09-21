package com.xian.www.tangdaizi.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/20.
 */

public class KeActivity extends Activity {

    @InjectView(R.id.sec_back)
    ImageView sec_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sec_ke);

        //using butter knife
        ButterKnife.inject(this);
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

}
