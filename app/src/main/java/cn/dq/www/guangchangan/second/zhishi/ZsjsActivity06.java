package cn.dq.www.guangchangan.second.zhishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import cn.dq.www.guangchangan.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/11/10.
 */

public class ZsjsActivity06 extends Activity {

    @InjectView(R.id.radio01)
    ImageView radio01;
    @InjectView(R.id.radio02)
    ImageView radio02;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            radio01.setImageResource(R.drawable.radio_no);
            radio02.setImageResource(R.drawable.radio_no);
            radio01.setClickable(true);
            radio02.setClickable(true);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zsjs_06);

        //using butter knife
        ButterKnife.inject(this);
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
    @OnClick(R.id.radio01)   //
    public void radio01() {
        radio01.setClickable(false);
        radio02.setClickable(false);
//        SPUtil.appput(getApplicationContext(), "zsjs_one", "wrong");
        radio01.setImageResource(R.drawable.radio_right);
//        radio01.setImageResource(R.drawable.radio_wrong);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ZsjsActivity06.this,ZsjsActivity07.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        },1000);
    }
    @OnClick(R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
//        SPUtil.appput(getApplicationContext(), "zsjs_one", "right");
        radio02.setImageResource(R.drawable.radio_wrong);
//        radio02.setImageResource(R.drawable.radio_right);
        Toast.makeText(ZsjsActivity06.this,"再想一想",Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);

    }


}
