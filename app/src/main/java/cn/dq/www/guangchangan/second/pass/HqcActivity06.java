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
import android.widget.TextView;

import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.utils.SPUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/11/10.
 */

public class HqcActivity06 extends Activity implements View.OnClickListener {


    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.radio01)
    ImageView radio01;
    @InjectView(R.id.radio02)
    ImageView radio02;
    @InjectView(R.id.radio03)
    ImageView radio03;

    private Handler handler;
    private ImageView queding;
    private ImageView queding_failed;
    private PopupWindow popWnd;
    private String complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.hqc_pass_06);

        //using butter knife
        ButterKnife.inject(this);
        complete = SPUtil.appget(this, "liang6", "no");
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
        radio03.setClickable(false);
        radio01.setImageResource(R.drawable.radio_wrong);
        showPupop(false);
    }


    @OnClick(R.id.radio02)   //
    public void radio02() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio02.setImageResource(R.drawable.radio_right);
        String hqc_test_four = SPUtil.appget(getApplicationContext(), "hqc_test_four", "wrong");
        String hqc_test_five = SPUtil.appget(getApplicationContext(), "hqc_test_five", "wrong");
        if (hqc_test_four.equals("right") && hqc_test_five.equals("right"))
            showPupop(true);
        else
            showPupop(false);
    }
    @OnClick(R.id.radio03)   //
    public void radio03() {
        radio01.setClickable(false);
        radio02.setClickable(false);
        radio03.setClickable(false);
        radio03.setImageResource(R.drawable.radio_wrong);
        showPupop(false);
    }

    private void showPupop(final boolean tag) {
        View contentView = null;
        if (tag) {
            if(complete.equals("no")){

                contentView = LayoutInflater.from(HqcActivity06.this).inflate(R.layout.popuplayout, null);
                queding = (ImageView) contentView.findViewById(R.id.queding);
                queding.setOnClickListener(this);
            }else{

                contentView = LayoutInflater.from(HqcActivity06.this).inflate(R.layout.popuplayout_half, null);
                queding = (ImageView) contentView.findViewById(R.id.queding);
                queding.setOnClickListener(this);
            }
        } else {
            contentView = LayoutInflater.from(HqcActivity06.this).inflate(R.layout.popuplayout_failed, null);
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
        if (tag) {
            popWnd.dismiss();
            SPUtil.appput(getApplicationContext(), "liang6", "yes");
            finish();
        } else {
            popWnd.dismiss();
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
