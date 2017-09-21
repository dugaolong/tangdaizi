package com.xian.www.tangdaizi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.second.DaminggongActivity;
import com.xian.www.tangdaizi.second.DatangActivity;
import com.xian.www.tangdaizi.second.DytActivity;
import com.xian.www.tangdaizi.second.ShiActivity;
import com.xian.www.tangdaizi.second.XiActivity;

public class MainTab01 extends Fragment implements View.OnClickListener
{

	/**
	 * 底部四个按钮
	 */
	private RelativeLayout daminggong;
	private RelativeLayout shi;
	private RelativeLayout xi;
	private RelativeLayout datang;
	private RelativeLayout dayanta;
	private RelativeLayout yi;
	private RelativeLayout ke;
	private RelativeLayout huaqingchi;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.main_tab_01, container, false);
		TextView textView = (TextView) view.findViewById(R.id.title_text);
		textView.setText("首页");
		daminggong = (RelativeLayout) view.findViewById(R.id.daminggong);
		shi= (RelativeLayout) view.findViewById(R.id.shi);
		xi = (RelativeLayout) view.findViewById(R.id.xi);
		datang = (RelativeLayout) view.findViewById(R.id.datang);
		dayanta = (RelativeLayout) view.findViewById(R.id.dayanta);
		yi = (RelativeLayout) view.findViewById(R.id.yi);
		ke = (RelativeLayout) view.findViewById(R.id.ke);
		huaqingchi = (RelativeLayout) view.findViewById(R.id.huaqingchi);
		daminggong.setOnClickListener(this);
		shi.setOnClickListener(this);
		xi.setOnClickListener(this);
		datang.setOnClickListener(this);
		dayanta.setOnClickListener(this);
		yi.setOnClickListener(this);
		ke.setOnClickListener(this);
		huaqingchi.setOnClickListener(this);
		return  view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.daminggong:
				getActivity().startActivity(new Intent(getActivity(), DaminggongActivity.class));
				break;
			case R.id.shi:
				getActivity().startActivity(new Intent(getActivity(), ShiActivity.class));
				break;
			case R.id.xi:
				getActivity().startActivity(new Intent(getActivity(), XiActivity.class));
				break;
			case R.id.datang:
				getActivity().startActivity(new Intent(getActivity(), DatangActivity.class));
				break;
			case R.id.dayanta:
				getActivity().startActivity(new Intent(getActivity(), DytActivity.class));
				break;
		}
	}
}
