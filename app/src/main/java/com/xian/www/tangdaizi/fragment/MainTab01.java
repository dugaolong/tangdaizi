package com.xian.www.tangdaizi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.second.DytActivityShipin;
import com.xian.www.tangdaizi.second.HqcActivityShipin;
import com.xian.www.tangdaizi.second.pass.DytActivity01;
import com.xian.www.tangdaizi.second.pass.DytActivity04;
import com.xian.www.tangdaizi.second.pass.HqcActivity01;
import com.xian.www.tangdaizi.second.zhuye.ShipinFourActivity;
import com.xian.www.tangdaizi.second.zhuye.ShipinThreeActivity;
import com.xian.www.tangdaizi.utils.SPUtil;
import com.xian.www.tangdaizi.utils.ScreenUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.xian.www.tangdaizi.utils.SPUtil.appget;

public class MainTab01 extends Fragment {

    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.ll_image)
    LinearLayout relativeLayout;
    @InjectView(R.id.liang1)
    LinearLayout liang1;
    @InjectView(R.id.liang2)
    LinearLayout liang2;
    @InjectView(R.id.liang3)
    LinearLayout liang3;
    @InjectView(R.id.liang4)
    LinearLayout liang4;
    @InjectView(R.id.liang5)
    LinearLayout liang5;
    @InjectView(R.id.liang6)
    LinearLayout liang6;
    @InjectView(R.id.liang7)
    LinearLayout liang7;
    @InjectView(R.id.liang8)
    LinearLayout liang8;
    @InjectView(R.id.liang9)
    LinearLayout liang9;
    @InjectView(R.id.liang10)
    LinearLayout liang10;
    @InjectView(R.id.liang11)
    LinearLayout liang11;
    @InjectView(R.id.liang12)
    LinearLayout liang12;
    @InjectView(R.id.dark1)
    LinearLayout dark1;
    @InjectView(R.id.dark2)
    LinearLayout dark2;
    @InjectView(R.id.dark3)
    LinearLayout dark3;
    @InjectView(R.id.dark4)
    LinearLayout dark4;
    @InjectView(R.id.dark5)
    LinearLayout dark5;
    @InjectView(R.id.dark6)
    LinearLayout dark6;
    @InjectView(R.id.dark7)
    LinearLayout dark7;
    @InjectView(R.id.dark8)
    LinearLayout dark8;
    @InjectView(R.id.dark9)
    LinearLayout dark9;
    @InjectView(R.id.dark10)
    LinearLayout dark10;
    @InjectView(R.id.dark11)
    LinearLayout dark11;
    @InjectView(R.id.dark12)
    LinearLayout dark12;

    private Handler mHandler = new Handler();
    private ScrollView scrollView;

//    String liang1;
//    String liang2;
//    String liang3;
//    String liang4;
//    String liang5;
//    String liang6;
//    String liang7;
//    String liang8;
//    String liang9;
//    String liang10;
//    String liang11;
//    String liang12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_tab_01, container, false);
        //using butter knife
        ButterKnife.inject(this, view);

        title_text.setText("首页");

        scrollView = (ScrollView) view.findViewById(R.id.scrollView);
        int width = ScreenUtils.getScreenWidth(getActivity());
        float height = (float) width / 994 * 2676;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = (int) height;
        relativeLayout.setLayoutParams(layoutParams);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        scrollToBottom(scrollView);
        String liang1 = appget(getActivity(), "liang1", "no");
        String liang2 = appget(getActivity(), "liang2", "no");
        String liang3 = appget(getActivity(), "liang3", "no");
        String liang4 = appget(getActivity(), "liang4", "no");
        String liang5 = appget(getActivity(), "liang5", "no");
        String liang6 = appget(getActivity(), "liang6", "no");
        String liang7 = appget(getActivity(), "liang7", "no");
        String liang8 = appget(getActivity(), "liang8", "no");
        String liang9 = appget(getActivity(), "liang9", "no");
        String liang10 = appget(getActivity(), "liang10", "no");
        String liang11 = appget(getActivity(), "liang11", "no");
        String liang12 = appget(getActivity(), "liang12", "no");
        if (liang1.equals("yes")) {
            this.liang1.setVisibility(View.GONE);
            this.dark1.setVisibility(View.VISIBLE);
        }
        if (liang2.equals("yes")) {
            this.liang2.setVisibility(View.GONE);
            this.dark2.setVisibility(View.VISIBLE);
        }
        if (liang3.equals("yes")) {
            this.liang3.setVisibility(View.GONE);
            this.dark3.setVisibility(View.VISIBLE);
        }
        if (liang4.equals("yes")) {
            this.liang4.setVisibility(View.GONE);
            this.dark4.setVisibility(View.VISIBLE);
        }
        if (liang5.equals("yes")) {
            this.liang5.setVisibility(View.GONE);
            this.dark5.setVisibility(View.VISIBLE);
        }
        if (liang6.equals("yes")) {
            this.liang6.setVisibility(View.GONE);
            this.dark6.setVisibility(View.VISIBLE);
        }
        if (liang7.equals("yes")) {
            this.liang7.setVisibility(View.GONE);
            this.dark7.setVisibility(View.VISIBLE);
        }
        if (liang8.equals("yes")) {
            this.liang8.setVisibility(View.GONE);
            this.dark8.setVisibility(View.VISIBLE);
        }
        if (liang9.equals("yes")) {
            this.liang9.setVisibility(View.GONE);
            this.dark9.setVisibility(View.VISIBLE);
        }
        if (liang10.equals("yes")) {
            this.liang10.setVisibility(View.GONE);
            this.dark10.setVisibility(View.VISIBLE);
        }
        if (liang11.equals("yes")) {
            this.liang11.setVisibility(View.GONE);
            this.dark11.setVisibility(View.VISIBLE);
        }
        if (liang12.equals("yes")) {
            this.liang12.setVisibility(View.GONE);
            this.dark12.setVisibility(View.VISIBLE);
        }
    }

    public void scrollToBottom(final View scroll) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    @OnClick(R.id.liang1)//大雁塔
    public void liang1() {
        Intent intent = new Intent(getActivity(), DytActivityShipin.class);
        startActivity(intent);
        SPUtil.appput(getActivity(), "liang1", "yes");
    }

    @OnClick(R.id.dark1)
    public void dark1() {
        Intent intent = new Intent(getActivity(), DytActivityShipin.class);
        startActivity(intent);
    }

    @OnClick(R.id.liang2)
    public void liang2() {
        if (isCanClick(2)) {
            Intent intent = new Intent(getActivity(), DytActivity01.class);
            startActivity(intent);
        }
    }
    @OnClick(R.id.liang3)
    public void liang3() {
        if (isCanClick(3)) {
            Intent intent = new Intent(getActivity(), DytActivity04.class);
            startActivity(intent);
        }
    }

    @OnClick(R.id.liang4)
    public void liang4() {
        if (isCanClick(4)) {
            Intent intent = new Intent(getActivity(), HqcActivityShipin.class);
            startActivity(intent);
            SPUtil.appput(getActivity(), "liang4", "yes");
        }
    }

    @OnClick(R.id.dark4)
    public void dark4() {
        if (isCanClick(4)) {
            Intent intent = new Intent(getActivity(), HqcActivityShipin.class);
            startActivity(intent);
            SPUtil.appput(getActivity(), "liang4", "yes");
        }
    }
    @OnClick(R.id.liang5)
    public void liang5() {
        if (isCanClick(5)) {
            Intent intent = new Intent(getActivity(), HqcActivity01.class);
            startActivity(intent);
        }
    }
    @OnClick(R.id.liang7)
    public void liang7() {
        if (isCanClick(4)) {
            Intent intent = new Intent(getActivity(), ShipinThreeActivity.class);
            startActivity(intent);
            SPUtil.appput(getActivity(), "liang7", "yes");
        }
    }

    @OnClick(R.id.dark7)
    public void dark7() {
        if (isCanClick(4)) {
            Intent intent = new Intent(getActivity(), ShipinThreeActivity.class);
            startActivity(intent);
            SPUtil.appput(getActivity(), "liang7", "yes");
        }
    }

    @OnClick(R.id.liang10)
    public void liang10() {
        if (isCanClick(4)) {
            Intent intent = new Intent(getActivity(), ShipinFourActivity.class);
            startActivity(intent);
            SPUtil.appput(getActivity(), "liang10", "yes");
        }
    }

    @OnClick(R.id.dark10)
    public void dark10() {
        if (isCanClick(4)) {
            Intent intent = new Intent(getActivity(), ShipinFourActivity.class);
            startActivity(intent);
            SPUtil.appput(getActivity(), "liang10", "yes");
        }
    }

    private boolean isCanClick(int position) {

        String liang1 = appget(getActivity(), "liang1", "no");
        String liang2 = appget(getActivity(), "liang2", "no");
        String liang3 = appget(getActivity(), "liang3", "no");
        String liang4 = appget(getActivity(), "liang4", "no");
        String liang5 = appget(getActivity(), "liang5", "no");
        String liang6 = appget(getActivity(), "liang6", "no");
        String liang7 = appget(getActivity(), "liang7", "no");
        String liang8 = appget(getActivity(), "liang8", "no");
        String liang9 = appget(getActivity(), "liang9", "no");
        String liang10 = appget(getActivity(), "liang10", "no");
        String liang11 = appget(getActivity(), "liang11", "no");
        String liang12 = appget(getActivity(), "liang12", "no");

        switch (position) {
            case 1:
                return true;
            case 2:
                if (liang1.equals("yes"))
                    return true;
            case 3:
                if (liang1.equals("yes") && liang2.equals("yes"))
                    return true;
            case 4:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes"))
                    return true;
            case 5:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes") && liang4.equals("yes"))
                    return true;
            case 6:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes") && liang4.equals("yes")
                        && liang5.equals("yes"))
                    return true;
            case 7:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes") && liang4.equals("yes")
                        && liang5.equals("yes") && liang6.equals("yes"))
                    return true;
            case 8:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes") && liang4.equals("yes")
                        && liang5.equals("yes") && liang6.equals("yes") && liang7.equals("yes"))
                    return true;
            case 9:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes") && liang4.equals("yes")
                        && liang5.equals("yes") && liang6.equals("yes") && liang7.equals("yes")
                        && liang8.equals("yes"))
                    return true;
            case 10:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes") && liang4.equals("yes")
                        && liang5.equals("yes") && liang6.equals("yes") && liang7.equals("yes")
                        && liang8.equals("yes") && liang9.equals("yes"))
                    return true;
            case 11:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes") && liang4.equals("yes")
                        && liang5.equals("yes") && liang6.equals("yes") && liang7.equals("yes")
                        && liang8.equals("yes") && liang9.equals("yes") && liang10.equals("yes"))
                    return true;
            case 12:
                if (liang1.equals("yes") && liang2.equals("yes") && liang3.equals("yes") && liang4.equals("yes")
                        && liang5.equals("yes") && liang6.equals("yes") && liang7.equals("yes")
                        && liang8.equals("yes") && liang9.equals("yes") && liang10.equals("yes")
                        && liang11.equals("yes"))
                    return true;
            default:
                break;
        }
        return false;
    }

}
