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
import com.xian.www.tangdaizi.second.ZhishiActivity;

/**
 * 活动
 */
public class MainTab02 extends Fragment implements View.OnClickListener
{

	private RelativeLayout quwei;
	private RelativeLayout zhishi;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.main_tab_02, container, false);
		TextView textView = (TextView) view.findViewById(R.id.title_text);
		textView.setText("活动");
		quwei = (RelativeLayout) view.findViewById(R.id.quwei);
		zhishi= (RelativeLayout) view.findViewById(R.id.zhishi);
		quwei.setOnClickListener(this);
		zhishi.setOnClickListener(this);
		return  view;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(getActivity(), ZhishiActivity.class);
		Bundle bundle = new Bundle();
		switch (v.getId()) {
			case R.id.quwei:

				bundle.putString("from", "趣味闯关");
				intent.putExtras(bundle);
				getActivity().startActivity(intent);
				break;
			case R.id.zhishi:
				bundle.putString("from", "知识竞赛");
				intent.putExtras(bundle);
				getActivity().startActivity(intent);
				break;
		}
	}
}
