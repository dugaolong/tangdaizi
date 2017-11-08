package com.xian.www.tangdaizi.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
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
import com.xian.www.tangdaizi.second.hd.HdPictureActivity;
import com.xian.www.tangdaizi.second.hd.HdShipinActivity;

import java.util.List;

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
//		MediaPlayer  player;
//		try {
//			AssetManager assetManager = getActivity().getAssets();
//			AssetFileDescriptor afd = assetManager.openFd("hd_shipin.mp4");
//			player = new MediaPlayer();
//			player.setDataSource(afd.getFileDescriptor(),
//					afd.getStartOffset(), afd.getLength());
//			player.setLooping(true);//循环播放
//			player.prepare();
//			player.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Intent intent=new Intent();
//		intent.setAction(Intent.ACTION_VIEW);	//意图是打开文件
//		Uri data=Uri.parse("file:///android_asset/hd_shipin.mp4");	//要打开的文件路径和文件名
////		Uri data=Uri.parse("android.resource://" + getActivity().getPackageName() + "/" +R.raw.hd_shipin);	//要打开的文件路径和文件名
//		intent.setDataAndType(data, "video/*");	//打开文件的格式
//		startActivity(intent);
		Intent intent = new Intent(getActivity(), HdShipinActivity.class);
		startActivity(intent);
	}
	@OnClick(R.id.xiangce)
	public void xiangce() {
		Intent intent = new Intent(getActivity(), HdPictureActivity.class);
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

	private boolean hasBrowser(Context context){
		PackageManager pm = context.getPackageManager();
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_BROWSABLE);
		intent.setData(Uri.parse("http://"));

		List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.GET_INTENT_FILTERS);
		final int size = (list == null) ? 0 : list.size();
		return size > 0;
	}

}
