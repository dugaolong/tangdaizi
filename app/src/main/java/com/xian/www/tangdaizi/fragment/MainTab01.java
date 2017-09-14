package com.xian.www.tangdaizi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;

public class MainTab01 extends Fragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.main_tab_01, container, false);
		TextView textView = (TextView) view.findViewById(R.id.title_text);
		textView.setText("首页");
		return  view;
	}

}
