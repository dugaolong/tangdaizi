package com.xian.www.tangdaizi.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.xian.www.tangdaizi.R;



public class MainTab04 extends Fragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.main_tab_04, container, false);
		TextView textView = (TextView) view.findViewById(R.id.title_text);
		final ImageView imageView = (ImageView) view.findViewById(R.id.head);
		textView.setText("个人中心");

		Glide.with(getActivity()).load(R.drawable.aaaabbbbb).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
			@Override
			protected void setResource(Bitmap resource) {
				RoundedBitmapDrawable circularBitmapDrawable =
						RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
				circularBitmapDrawable.setCircular(true);
				imageView.setImageDrawable(circularBitmapDrawable);
			}
		});
		return  view;
	}

}
