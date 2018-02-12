package cn.dq.www.guangchangan.second.gongyi;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class GyPictureViewPagerAdapter extends PagerAdapter {
	private Activity mContext;
	private LayoutInflater inflater;
	private Handler handler;
	public static int number = 1;
	private List<Integer> list = new ArrayList<>();

	public GyPictureViewPagerAdapter(Activity context, List<String> mlist, Handler handler) {
		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
//		this.list = mlist;
		this.handler = handler;
		list.add(cn.dq.www.guangchangan.R.drawable.gy_one);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_two);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_three);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_four);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_five);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_six);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_seven);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_eight);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_nine);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_ten);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_eleven);
		list.add(cn.dq.www.guangchangan.R.drawable.gy_twelve);
	}

	@Override
	public int getCount() {
		if(list.size() != 0) {
			return list.size();
		} else {
			return Integer.MAX_VALUE;
		}
	}
	
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup view, final int position) {
		View convertView = inflater.inflate(cn.dq.www.guangchangan.R.layout.viewpager_image_item,null);
		if(list != null && list.size() > 0 && list.size() > position){
			ImageView icon = (ImageView) convertView.findViewById(cn.dq.www.guangchangan.R.id.viewpager_image_icon);
			Glide.with(mContext).load(list.get(position)).into(icon);
			icon.setScaleType(ScaleType.FIT_CENTER);
			((ViewPager) view).addView(convertView, 0);
			
			icon.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					handler.sendEmptyMessage(1);
				}
			});
		}
		return convertView;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

}
