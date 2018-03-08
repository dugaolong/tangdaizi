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

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.dq.www.guangchangan.utils.ToastUtil;

/**
 * Created by dugaolong on 17/11/10.
 */

public class ZsjsActivity08 extends Activity {

    @InjectView(cn.dq.www.guangchangan.R.id.radio01)
    ImageView radio01;
    @InjectView(cn.dq.www.guangchangan.R.id.radio02)
    ImageView radio02;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                radio01.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_no);
                radio02.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_no);
                radio01.setClickable(true);
                radio02.setClickable(true);
            }else if(msg.what==1){
                showNormalDialog();
            }

        }
    };

    private void showNormalDialog(){
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(ZsjsActivity08.this);
        normalDialog.setIcon(cn.dq.www.guangchangan.R.mipmap.logo);
        normalDialog.setMessage("恭喜你，都答对了，敬请期待下一次竞赛吧");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ZsjsActivity08.this.finish();
                    }
                });
        // 显示
        normalDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(cn.dq.www.guangchangan.R.layout.zsjs_08);

        //using butter knife
        ButterKnife.inject(this);
    }


    @OnClick(cn.dq.www.guangchangan.R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio01)   //
    public void radio01() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio01.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_right);
        handler.postDelayed(new Runnable() {
           @Override
            public void run() {
               handler.sendEmptyMessage(1);
            }
        },1000);
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio02.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_wrong);
        ToastUtil.showToast(ZsjsActivity08.this,"再想一想");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000);

    }


}
