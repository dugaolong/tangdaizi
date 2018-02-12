package cn.dq.www.guangchangan.picture;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import cn.dq.www.guangchangan.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 图片界面
 */
public class PictureDetailsActivity extends Activity implements OnClickListener {
	private Activity context;
	private Context mContext;
	private Bundle bundle;
	private ImageView back;
	private ViewPager viewpager;
	private RelativeLayout titleLayout; //标题Layout
//	private RelativeLayout contentLayout;//内容Layout
//	private TextView content;
//	private TextView nameDt;
	private PictureViewPagerAdapter adapter;
	private String listStr ;
	private List<String> list;
	private Spanned spanned ;
	private String message = "";
	private int position = 0 ; //前个界面点击图片位置
	private int photosNumber = 0; //图片总数量
	private boolean isDelete = false; //是否有删除图片
	private String urls;

	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			if(titleLayout.getVisibility() == View.VISIBLE){
				titleLayout.setVisibility(View.GONE);
//				contentLayout.setVisibility(View.GONE);
			}else {
				titleLayout.setVisibility(View.VISIBLE);
//				contentLayout.setVisibility(View.VISIBLE);
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.picture_details_activity);

		getBundle();
		initView();
//		setData(position);
		viewpager.setCurrentItem(position);
	}

	@SuppressWarnings("unchecked")
	private void getBundle() {
		bundle = getIntent().getExtras();
		if(bundle != null){
			if(bundle.containsKey("position")) {
				position = bundle.getInt("position")-1;
			}
			if(bundle.containsKey("urls")) {
				urls = (String) bundle.getString("urls");
			}
			
			if(urls != null && (!urls.equals(""))) {
				list = JSON.parseArray(urls, String.class);
			} else {
				list = new ArrayList<String>();
			}
			photosNumber = list.size();
		}
	}
	
	private void initView() {
		context = this;
		mContext = this;
		
		back = (ImageView) findViewById(R.id.details_btn_back);

		back.setOnClickListener(this);

		titleLayout = (RelativeLayout) findViewById(R.id.details_title_layout);
//		contentLayout = (RelativeLayout) findViewById(R.id.details_content_layout);
//		content = (TextView) findViewById(R.id.details_content);
//		nameDt = (TextView) findViewById(R.id.details_parent_name);
		
		viewpager = (ViewPager) findViewById(R.id.details_viewpager);
		adapter = new PictureViewPagerAdapter(context,list,handler);
		viewpager.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int select_position) {
				if(photosNumber > select_position) {
					position = select_position;
//					setData(position);
				}
			}

			@Override
			public void onPageScrollStateChanged(int position) {
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}
		});
	}


	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.details_btn_back){
			if(isDelete) {
				setResult(RESULT_OK);
			}
			finish();
		}
	}

	@Override
	public void onBackPressed() {
		if(isDelete) {
			setResult(RESULT_OK);
		}
		super.onBackPressed();
	}
}

