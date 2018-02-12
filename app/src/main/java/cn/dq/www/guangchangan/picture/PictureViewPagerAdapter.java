package cn.dq.www.guangchangan.picture;

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
import cn.dq.www.guangchangan.R;

import java.util.List;


public class PictureViewPagerAdapter extends PagerAdapter {
	private Activity mContext;
	private LayoutInflater inflater;
	private Handler handler;
	public static int number = 1;
	private List<String> list ;

	public PictureViewPagerAdapter(Activity context, List<String> mlist, Handler handler) {
		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
		this.list = mlist;
		this.handler = handler;
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
		View convertView = inflater.inflate(R.layout.viewpager_image_item,null);
		if(list != null && list.size() > 0 && list.size() > position){
			ImageView icon = (ImageView) convertView.findViewById(R.id.viewpager_image_icon);
			Glide.with(mContext).load(list.get(position)).into(icon);
			String urlPic = list.get(position);
			if(urlPic.contains("drawable/pic01")){
				Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
						.load(R.drawable.pic01)
						.error(R.drawable.camera)
						.into(icon);
			}else if(urlPic.contains("drawable/pic02")){
				Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
						.load(R.drawable.pic02)
						.error(R.drawable.camera)
						.into(icon);
			}else if(urlPic.contains("drawable/pic03")){
				Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
						.load(R.drawable.pic03)
						.error(R.drawable.camera)
						.into(icon);
			}else if(urlPic.contains("drawable/pic04")){
				Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
						.load(R.drawable.pic04)
						.error(R.drawable.camera)
						.into(icon);
			}else {
				Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
						.load(urlPic)
						.error(R.drawable.camera)
						.into(icon);
			}

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
