package com.xian.www.tangdaizi.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.second.find.FindDetailActivity;
import com.xian.www.tangdaizi.second.find.GgDetailActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 发现
 */
public class MainTab02 extends Fragment
{

//	private RelativeLayout quwei;
//	private RelativeLayout zhishi;
	private Context context;

	@InjectView(R.id.title_text)
	TextView title_text;
	@InjectView(R.id.gggb)
	ImageView gggb;
	@InjectView(R.id.gg)
	FrameLayout gg;
	//上边5个
	@InjectView(R.id.image_shi)
	ImageView image_shi;
	@InjectView(R.id.image_qu)
	ImageView image_qu;
	@InjectView(R.id.image_shii)
	ImageView image_shii;
	@InjectView(R.id.image_yi)
	ImageView image_yi;
	@InjectView(R.id.image_ke)
	ImageView image_ke;
	//中间的ll
	@InjectView(R.id.ll_shi)
	LinearLayout ll_shi;
	@InjectView(R.id.ll_qu)
	LinearLayout ll_qu;
	@InjectView(R.id.ll_shii)
	LinearLayout ll_shii;
	@InjectView(R.id.ll_yi)
	LinearLayout ll_yi;
	@InjectView(R.id.ll_ke)
	LinearLayout ll_ke;
	//中间的20个Imageview
	@InjectView(R.id.shi_chunxiao1)
	ImageView shi_chunxiao1;
	@InjectView(R.id.shi_jiuyuejiu1)
	ImageView shi_jiuyuejiu1;
	@InjectView(R.id.shi_jueju1)
	ImageView shi_jueju1;
	@InjectView(R.id.shi_zengwanlun1)
	ImageView shi_zengwanlun1;
	@InjectView(R.id.qu_cuju1)
	ImageView qu_cuju1;
	@InjectView(R.id.qu_damaqiu1)
	ImageView qu_damaqiu1;
	@InjectView(R.id.qu_douji1)
	ImageView qu_douji1;
	@InjectView(R.id.qu_qiuqian1)
	ImageView qu_qiuqian1;
	@InjectView(R.id.shii_dousha1)
	ImageView shii_dousha1;
	@InjectView(R.id.shii_qingfengfan1)
	ImageView shii_qingfengfan1;
	@InjectView(R.id.shii_su1)
	ImageView shii_su1;
	@InjectView(R.id.shii_yingtao)
	ImageView shii_yingtao;
	@InjectView(R.id.yi_funv1)
	ImageView yi_funv1;
	@InjectView(R.id.yi_gongqing1)
	ImageView yi_gongqing1;
	@InjectView(R.id.yi_junren1)
	ImageView yi_junren1;
	@InjectView(R.id.yi_tianzi1)
	ImageView yi_tianzi1;
	@InjectView(R.id.ke_bishu1)
	ImageView ke_bishu1;
	@InjectView(R.id.ke_cunchushui1)
	ImageView ke_cunchushui1;
	@InjectView(R.id.ke_huobi1)
	ImageView ke_huobi1;
	@InjectView(R.id.ke_kaoli1)
	ImageView ke_kaoli1;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View view = inflater.inflate(R.layout.main_tab_02, container, false);
		//using butter knife
		ButterKnife.inject(this,view);
		context = getActivity();

		title_text.setText("发现");
		return  view;
	}

	@OnClick(R.id.gggb)
	public void gggb() {
		gg.setVisibility(View.INVISIBLE);
	}
	@OnClick(R.id.gg_image)
	public void gg_image() {
		Intent intent = new Intent(getActivity(), GgDetailActivity.class);
		startActivity(intent);
	}
	@OnClick(R.id.image_shi)
	public void image_shi() {
		image_shi.setImageResource(R.drawable.shi2);
		image_qu.setImageResource(R.drawable.qu1);
		image_shii.setImageResource(R.drawable.shii1);
		image_yi.setImageResource(R.drawable.yi1);
		image_ke.setImageResource(R.drawable.ke1);

		ll_shi.setVisibility(View.VISIBLE);
		ll_qu.setVisibility(View.GONE);
		ll_shii.setVisibility(View.GONE);
		ll_yi.setVisibility(View.GONE);
		ll_ke.setVisibility(View.GONE);
	}
	@OnClick(R.id.image_qu)
	public void image_qu() {
		image_shi.setImageResource(R.drawable.shi1);
		image_qu.setImageResource(R.drawable.qu2);
		image_shii.setImageResource(R.drawable.shii1);
		image_yi.setImageResource(R.drawable.yi1);
		image_ke.setImageResource(R.drawable.ke1);

		ll_shi.setVisibility(View.GONE);
		ll_qu.setVisibility(View.VISIBLE);
		ll_shii.setVisibility(View.GONE);
		ll_yi.setVisibility(View.GONE);
		ll_ke.setVisibility(View.GONE);
	}

	@OnClick(R.id.image_shii)
	public void image_shii() {
		image_shi.setImageResource(R.drawable.shi1);
		image_qu.setImageResource(R.drawable.qu1);
		image_shii.setImageResource(R.drawable.shii2);
		image_yi.setImageResource(R.drawable.yi1);
		image_ke.setImageResource(R.drawable.ke1);

		ll_shi.setVisibility(View.GONE);
		ll_qu.setVisibility(View.GONE);
		ll_shii.setVisibility(View.VISIBLE);
		ll_yi.setVisibility(View.GONE);
		ll_ke.setVisibility(View.GONE);
	}
	@OnClick(R.id.image_yi)
	public void image_yi() {
		image_shi.setImageResource(R.drawable.shi1);
		image_qu.setImageResource(R.drawable.qu1);
		image_shii.setImageResource(R.drawable.shii1);
		image_yi.setImageResource(R.drawable.yi2);
		image_ke.setImageResource(R.drawable.ke1);

		ll_shi.setVisibility(View.GONE);
		ll_qu.setVisibility(View.GONE);
		ll_shii.setVisibility(View.GONE);
		ll_yi.setVisibility(View.VISIBLE);
		ll_ke.setVisibility(View.GONE);
	}
	@OnClick(R.id.image_ke)
	public void image_ke() {
		image_shi.setImageResource(R.drawable.shi1);
		image_qu.setImageResource(R.drawable.qu1);
		image_shii.setImageResource(R.drawable.shii1);
		image_yi.setImageResource(R.drawable.yi1);
		image_ke.setImageResource(R.drawable.ke2);

		ll_shi.setVisibility(View.GONE);
		ll_qu.setVisibility(View.GONE);
		ll_shii.setVisibility(View.GONE);
		ll_yi.setVisibility(View.GONE);
		ll_ke.setVisibility(View.VISIBLE);
	}

	@OnClick(R.id.shi_chunxiao1)
	public void shi_chunxiao1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.shi_chunxiao1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.shi_jiuyuejiu1)
	public void shi_jiuyuejiu1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.shi_jiuyuejiu1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.shi_jueju1)
	public void shi_jueju1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.shi_jueju1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.shi_zengwanlun1)
	public void shi_zengwanlun1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.shi_zengwanlun1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	//qu
	@OnClick(R.id.qu_cuju1)
	public void qu_cuju1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.qu_cuju1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.qu_damaqiu1)
	public void qu_damaqiu1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.qu_damaqiu1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.qu_douji1)
	public void qu_douji1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.qu_douji1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.qu_qiuqian1)
	public void qu_qiuqian1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.qu_qiuqian1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	//shii
	@OnClick(R.id.shii_dousha1)
	public void shii_dousha1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.shii_dousha1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.shii_qingfengfan1)
	public void shii_qingfengfan1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.shii_qingfengfan1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.shii_su1)
	public void shii_su1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.shii_su1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.shii_yingtao)
	public void shii_yingtao() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.shii_yingtao);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	//yi
	@OnClick(R.id.yi_funv1)
	public void yi_funv1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.yi_funv1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.yi_gongqing1)
	public void yi_gongqing1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.yi_gongqing1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.yi_junren1)
	public void yi_junren1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.yi_junren1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.yi_tianzi1)
	public void yi_tianzi1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.yi_tianzi1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	//ke
	@OnClick(R.id.ke_bishu1)
	public void ke_bishu1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.ke_bishu1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.ke_cunchushui1)
	public void ke_cunchushui1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.ke_cunchushui1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.ke_huobi1)
	public void ke_huobi1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.ke_huobi1);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	@OnClick(R.id.ke_kaoli1)
	public void ke_kaoli1() {
		Intent intent = new Intent(getActivity(), FindDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("id", R.id.ke_kaoli1);
		intent.putExtras(bundle);
		startActivity(intent);
	}


}
