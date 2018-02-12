package cn.dq.www.guangchangan.second.zhishi;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
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

public class ZsjsHighActivity08 extends Activity {

    @InjectView(R.id.radio01)
    ImageView radio01;
    @InjectView(R.id.radio02)
    ImageView radio02;
    @InjectView(R.id.radio03)
    ImageView radio03;
    @InjectView(R.id.radio04)
    ImageView radio04;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zsjs_high_08);

        //using butter knife
        ButterKnife.inject(this);

        handler  = new Handler(){
            @Override
            public void handleMessage(Message msg) {
//            super.handleMessage(msg);
                if(msg.what==0){
                    radio01.setImageResource(R.drawable.radio_no);
                    radio02.setImageResource(R.drawable.radio_no);
                    radio03.setImageResource(R.drawable.radio_no);
                    radio04.setImageResource(R.drawable.radio_no);
                    radio01.setClickable(true);
                    radio02.setClickable(true);
                    radio03.setClickable(true);
                    radio04.setClickable(true);
                }else if(msg.what==1){
                    showNormalDialog();
                }
            }
        };
    }
    private void showNormalDialog(){
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(ZsjsHighActivity08.this);
        normalDialog.setIcon(R.mipmap.logo);
        normalDialog.setMessage("恭喜你，都答对了，敬请期待下一次竞赛吧");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ZsjsHighActivity08.this.finish();
                    }
                });
        // 显示
        normalDialog.show();
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
    @OnClick(R.id.radio01)   //
    public void radio01() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio04.setClickable(false);
        radio01.setImageResource(R.drawable.radio_wrong);
        Toast.makeText(getApplicationContext(),"再想一想",Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);
    }
    @OnClick(R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio04.setClickable(false);
        radio02.setImageResource(R.drawable.radio_right);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        },1000);
    }

    @OnClick(R.id.radio03)   //
    public void radio03() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio04.setClickable(false);
        radio03.setImageResource(R.drawable.radio_wrong);
        Toast.makeText(getApplicationContext(),"再想一想",Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);
    }

    @OnClick(R.id.radio04)   //
    public void radio04() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio04.setClickable(false);
        radio04.setImageResource(R.drawable.radio_wrong);
        Toast.makeText(getApplicationContext(),"再想一想",Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);
    }
}
