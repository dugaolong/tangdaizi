package com.xian.www.tangdaizi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by dugaolong on 17/9/13.
 */

public class HaoyouActivity extends Activity {

    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.btn_back_return)
    TextView btn_back_return;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haoyou);
        //using butter knife
        ButterKnife.inject(this);

        title_text.setText("我的好友");
    }


    @OnClick(R.id.btn_back_return)   //给  设置一个点击事件
    public void btn_back_return() {
        finish();
    }
}
