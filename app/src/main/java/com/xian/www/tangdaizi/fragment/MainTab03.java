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
import com.xian.www.tangdaizi.second.gongyi.GyActivity;

public class MainTab03 extends Fragment implements View.OnClickListener
{

	private RelativeLayout gongyi;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.main_tab_03, container, false);
		TextView textView = (TextView) view.findViewById(R.id.title_text);
		textView.setText("公益");
		gongyi= (RelativeLayout) view.findViewById(R.id.gongyi);
		gongyi.setOnClickListener(this);
		return  view;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
			case R.id.gongyi:
				Intent intent = new Intent(getActivity(), GyActivity.class);
				getActivity().startActivity(intent);
				break;
		}
	}

}
