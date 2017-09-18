package com.xian.www.tangdaizi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;

/**
 * Created by dugaolong on 17/9/18.
 */

public class RegisteActivity extends Activity {

    @InjectView(R.id.name_et)
    TextView name_et;
    @InjectView(R.id.et_new_password)
    TextView et_new_password;
    @InjectView(R.id.et_reapet_password)
    TextView et_reapet_password;
    @InjectView(R.id.registe_submit_btn)
    TextView registe_submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registe);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.registe_submit_btn)   //qq登录
    public void registe_submit_btn() {
        String name = name_et.getText().toString();
        String pass = et_new_password.getText().toString();
        String pass_re = et_reapet_password.getText().toString();

        if(isEmpty(name)){
            Toast.makeText(this,"请输入用户名",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(pass)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(pass_re)){
            Toast.makeText(this,"请输入确认密码",Toast.LENGTH_LONG).show();
            return;
        }
        if(!pass.equals(pass_re)){
            Toast.makeText(this,"两次密码不一致",Toast.LENGTH_LONG).show();
            return;
        }

        startActivity(new Intent(this, MainActivity.class));
    }


}
