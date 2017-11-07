package com.xian.www.tangdaizi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.second.find.Gg2DetailActivity;
import com.xian.www.tangdaizi.second.find.QianxunDetailActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainTab03 extends Fragment
{

	@InjectView(R.id.title_text)
	TextView title_text;
	@InjectView(R.id.shipin)
	ImageView shipin;
	@InjectView(R.id.xiangce)
	ImageView xiangce;
	@InjectView(R.id.qianxun)
	ImageView qianxun;
	@InjectView(R.id.zhishi)
	ImageView zhishi;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.main_tab_03, container, false);
		//using butter knife
		ButterKnife.inject(this,view);

		title_text.setText("活动");
		return  view;
	}
	@OnClick(R.id.shipin)
	public void shipin() {
		Intent intent = new Intent(getActivity(), Gg2DetailActivity.class);
		startActivity(intent);
	}
	@OnClick(R.id.xiangce)
	public void xiangce() {
		Intent intent = new Intent(getActivity(), Gg2DetailActivity.class);
		startActivity(intent);
	}
	@OnClick(R.id.qianxun)
	public void qianxun() {
		Intent intent = new Intent(getActivity(), QianxunDetailActivity.class);
		startActivity(intent);
	}
	@OnClick(R.id.zhishi)
	public void zhishi() {
		Intent intent = new Intent(getActivity(), Gg2DetailActivity.class);
		startActivity(intent);
	}



}
