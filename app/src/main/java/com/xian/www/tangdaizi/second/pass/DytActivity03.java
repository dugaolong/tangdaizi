package com.xian.www.tangdaizi.second.pass;

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
import android.widget.TextView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.utils.SPUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.xian.www.tangdaizi.utils.SPUtil.appget;

/**
 * Created by dugaolong on 17/11/10.
 */

public class DytActivity03 extends Activity implements View.OnClickListener {


    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.radio01)
    ImageView radio01;
    @InjectView(R.id.radio02)
    ImageView radio02;

    private Handler handler;
    private ImageView queding;
    private ImageView queding_failed;
    private PopupWindow popWnd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dyt_pass_03);

        //using butter knife
        ButterKnife.inject(this);

        handler = new Handler();
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

    @OnClick(R.id.radio01)   //
    public void radio01() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio01.setImageResource(R.drawable.radio_wrong);
        showPupop(false);
    }


    @OnClick(R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        String dyt_test_one = appget(getApplicationContext(), "dyt_test_one", "wrong");
        String dyt_test_two = SPUtil.appget(getApplicationContext(), "dyt_test_two", "wrong");
        radio02.setImageResource(R.drawable.radio_right);
        if(dyt_test_one.equals("right")&&dyt_test_two.equals("right"))
            showPupop(true);
        else
            showPupop(false);
    }

    private void showPupop(final boolean tag) {
        View contentView = null;
        if(tag){
            contentView  = LayoutInflater.from(DytActivity03.this).inflate(R.layout.popuplayout_half, null);
            queding = (ImageView) contentView.findViewById(R.id.queding);
            queding.setOnClickListener(this);
        }else {
            contentView  = LayoutInflater.from(DytActivity03.this).inflate(R.layout.popuplayout_failed, null);
            queding_failed = (ImageView) contentView.findViewById(R.id.queding_failed);
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
            SPUtil.appput(getApplicationContext(), "liang2", "yes");
            finish();
        }else {
            popWnd.dismiss();
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.queding:
                closePupop(true);
                break;
            case R.id.queding_failed:
                closePupop(false);
                break;
            default:
                break;
        }
    }

}
