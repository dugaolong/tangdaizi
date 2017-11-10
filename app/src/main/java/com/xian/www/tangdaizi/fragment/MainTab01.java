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
import com.xian.www.tangdaizi.second.zhuye.ShipinOneActivity;
import com.xian.www.tangdaizi.utils.SPUtil;
import com.xian.www.tangdaizi.utils.ScreenUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainTab01 extends Fragment
{

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
	private ScrollView scrollView ;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.main_tab_01, container, false);
		//using butter knife
		ButterKnife.inject(this,view);

		title_text.setText("首页");

		scrollView = (ScrollView) view.findViewById(R.id.scrollView);
		int width = ScreenUtils.getScreenWidth(getActivity());
		float height = (float) width / 994 * 2676;
		ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
		layoutParams.height = (int) height;
		relativeLayout.setLayoutParams(layoutParams);
		return  view;
	}

	@Override
	public void onResume() {
		super.onResume();
		scrollToBottom(scrollView);
		String liang1 = SPUtil.appget(getActivity(),"liang1","no");
		String liang2 = SPUtil.appget(getActivity(),"liang2","no");
		String liang3 = SPUtil.appget(getActivity(),"liang3","no");
		String liang4 = SPUtil.appget(getActivity(),"liang4","no");
		String liang5 = SPUtil.appget(getActivity(),"liang5","no");
		String liang6 = SPUtil.appget(getActivity(),"liang6","no");
		String liang7 = SPUtil.appget(getActivity(),"liang7","no");
		String liang8 = SPUtil.appget(getActivity(),"liang8","no");
		String liang9 = SPUtil.appget(getActivity(),"liang9","no");
		String liang10 = SPUtil.appget(getActivity(),"liang10","no");
		String liang11 = SPUtil.appget(getActivity(),"liang11","no");
		String liang12 = SPUtil.appget(getActivity(),"liang12","no");
		if(liang1.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang2.equals("yes")){
			this.liang2.setVisibility(View.GONE);
			this.dark2.setVisibility(View.VISIBLE);
		}
		if(liang3.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang4.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang5.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang6.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang7.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang8.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang9.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang10.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang11.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
		}
		if(liang12.equals("yes")){
			this.liang1.setVisibility(View.GONE);
			this.dark1.setVisibility(View.VISIBLE);
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
	@OnClick(R.id.liang1)
	public void liang1() {
		Intent intent = new Intent(getActivity(), ShipinOneActivity.class);
		startActivity(intent);
		SPUtil.appput(getActivity(),"liang1","yes");
	}


}
