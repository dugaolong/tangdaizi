package cn.dq.www.guangchangan.second.zhishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.dq.www.guangchangan.utils.ToastUtil;

/**
 * Created by dugaolong on 17/11/10.
 */

public class ZsjsActivity01 extends Activity {


    @InjectView(cn.dq.www.guangchangan.R.id.radio01)
    ImageView radio01;
    @InjectView(cn.dq.www.guangchangan.R.id.radio02)
    ImageView radio02;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(cn.dq.www.guangchangan.R.layout.zsjs_01);

        //using butter knife
        ButterKnife.inject(this);

        handler  = new Handler(){
            @Override
            public void handleMessage(Message msg) {
//            super.handleMessage(msg);
                if(msg.what==0){
                    radio01.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_no);
                    radio02.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_no);
                    radio01.setClickable(true);
                    radio02.setClickable(true);
                }
            }
        };
    }


    @OnClick(cn.dq.www.guangchangan.R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio01)   //
    public void radio01() {
        radio01.setClickable(false);
        radio02.setClickable(false);
//        SPUtil.appput(getApplicationContext(), "zsjs_one", "wrong");
        radio01.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_wrong);
        ToastUtil.showToast(ZsjsActivity01.this,"再想一想");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
//        SPUtil.appput(getApplicationContext(), "zsjs_one", "right");
        radio02.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_right);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ZsjsActivity01.this,ZsjsActivity02.class));
                overridePendingTransition(cn.dq.www.guangchangan.R.anim.slide_in_right, cn.dq.www.guangchangan.R.anim.slide_out_left);
                finish();
            }
        },1000);

    }

}
