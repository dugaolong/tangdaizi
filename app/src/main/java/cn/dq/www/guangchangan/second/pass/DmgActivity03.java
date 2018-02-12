package cn.dq.www.guangchangan.second.pass;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.PopupWindow;

import cn.dq.www.guangchangan.utils.SPUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/11/10.
 */

public class DmgActivity03 extends Activity implements View.OnClickListener{

    @InjectView(cn.dq.www.guangchangan.R.id.radio01)
    ImageView radio01;
    @InjectView(cn.dq.www.guangchangan.R.id.radio02)
    ImageView radio02;
    @InjectView(cn.dq.www.guangchangan.R.id.radio03)
    ImageView radio03;

    private Handler handler;
    private ImageView queding;
    private ImageView queding_failed;
    private PopupWindow popWnd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(cn.dq.www.guangchangan.R.layout.dmg_pass_03);

        //using butter knife
        ButterKnife.inject(this);

        handler = new Handler();
    }


    @OnClick(cn.dq.www.guangchangan.R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio01)   //
    public void radio01() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio01.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_wrong);
        showPupop(false);
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio02.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_right);
        String dmg_test_one = SPUtil.appget(getApplicationContext(), "dmg_test_one", "wrong");
        String dmg_test_two = SPUtil.appget(getApplicationContext(), "dmg_test_two", "wrong");
        if(dmg_test_one.equals("right")&&dmg_test_two.equals("right"))
            showPupop(true);
        else
            showPupop(false);
    }
    @OnClick(cn.dq.www.guangchangan.R.id.radio03)   //
    public void radio03() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio03.setImageResource(cn.dq.www.guangchangan.R.drawable.radio_wrong);
        showPupop(false);
    }

    private void showPupop(final boolean tag) {
        View contentView = null;
        if(tag){
            contentView  = LayoutInflater.from(DmgActivity03.this).inflate(cn.dq.www.guangchangan.R.layout.popuplayout_half, null);
            queding = (ImageView) contentView.findViewById(cn.dq.www.guangchangan.R.id.queding);
            queding.setOnClickListener(this);
        }else {
            contentView  = LayoutInflater.from(DmgActivity03.this).inflate(cn.dq.www.guangchangan.R.layout.popuplayout_failed, null);
            queding_failed = (ImageView) contentView.findViewById(cn.dq.www.guangchangan.R.id.queding_failed);
            queding_failed.setOnClickListener(this);
        }
        popWnd = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT, true);
        popWnd.setContentView(contentView);
        popWnd.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popWnd.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

        popWnd.showAtLocation(contentView, Gravity.CENTER, 0, 0);
        popWnd.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                closePupop(tag);
            }
        });
    }
    private void closePupop(boolean tag) {
        if(tag){
            popWnd.dismiss();
            SPUtil.appput(getApplicationContext(), "liang11", "yes");
            finish();
        }else {
            popWnd.dismiss();
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case cn.dq.www.guangchangan.R.id.queding:
                closePupop(true);
                break;
            case cn.dq.www.guangchangan.R.id.queding_failed:
                closePupop(false);
                break;
            default:
                break;
        }
    }

}
