package com.xian.www.tangdaizi.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by dugaolong on 17/9/13.
 */

public class LoginAcitvity extends AppCompatActivity {

    @InjectView(R.id.no_account)
    TextView no_account;
    SpannableString msp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        setContentView(R.layout.login);
        //using butter knife
        ButterKnife.inject(this);

        //创建一个 SpannableString对象
        msp = new SpannableString("没有账号？注册一个");
        msp.setSpan(new ForegroundColorSpan(Color.parseColor("#97D0F8")), 5, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //设置前景色为洋红色
        no_account.setText(msp);
    }


}
