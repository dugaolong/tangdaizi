package com.xian.www.tangdaizi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.xian.www.tangdaizi.BaseActivity;
import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by dugaolong on 17/9/13.
 */

public class SetActivity extends BaseActivity {

    @InjectView(R.id.logout)
    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);

        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.logout)   //给 button1 设置一个点击事件
    public void logout() {

//        SPUtil.appclear(mContext);
        startActivity(new Intent(this, LoginAcitvity.class));
        finish();
    }

    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void getIntentData() {

    }

}
