package cn.dq.www.guangchangan.second;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.utils.SPUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/11/13.
 */

public class UserInfoAcitvity extends Activity{

    @InjectView(R.id.nicheng)
    TextView nicheng;
    @InjectView(R.id.nianling)
    TextView nianling;
    @InjectView(R.id.xuexiao)
    TextView xuexiao;
    @InjectView(R.id.shouji)
    TextView shouji;
    @InjectView(R.id.mima)
    TextView mima;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        mContext = this;
        //using butter knife
        ButterKnife.inject(this);
        nicheng.setText(SPUtil.appget(UserInfoAcitvity.this,"name","无"));
        nianling.setText(SPUtil.appget(UserInfoAcitvity.this,"age","无"));
        xuexiao.setText(SPUtil.appget(UserInfoAcitvity.this,"school","无"));
        shouji.setText(SPUtil.appget(UserInfoAcitvity.this,"phone","无"));
        mima.setText(SPUtil.appget(UserInfoAcitvity.this,"pass","无"));
    }


    @OnClick(R.id.btn_back_return)   //返回
    public void btn_back_return() {
        finish();
    }



    @Override
    public void onBackPressed() {
        finish();
    }
}
