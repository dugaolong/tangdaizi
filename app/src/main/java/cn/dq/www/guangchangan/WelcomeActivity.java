package cn.dq.www.guangchangan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.EdgeEffectCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cn.dq.www.guangchangan.ui.LoginAcitvity;
import cn.dq.www.guangchangan.ui.MainActivity;
import cn.dq.www.guangchangan.utils.SPUtil;

/**
 * Created by dugaolong on 17/9/19.
 */

public class WelcomeActivity extends BaseActivity {

    private ViewPager mViewPager;
    private List<ImageView> mImages;
    private EdgeEffectCompat leftEdge;
    private EdgeEffectCompat rightEdge;
    private ImageView startBtn;

    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void getIntentData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        startBtn = (ImageView) findViewById(R.id.startBtn);
        initViewPager();
        mImages = new ArrayList<>();
        ImageView iv1 = new ImageView(this);
        ImageView iv2 = new ImageView(this);
        ImageView iv3 = new ImageView(this);
        ImageView iv4 = new ImageView(this);
        iv1.setImageResource(R.drawable.g1);
        iv1.setScaleType(ImageView.ScaleType.FIT_XY);
        iv2.setImageResource(R.drawable.g2);
        iv2.setScaleType(ImageView.ScaleType.FIT_XY);
        iv3.setImageResource(R.drawable.g3);
        iv3.setScaleType(ImageView.ScaleType.FIT_XY);
        iv4.setImageResource(R.drawable.g4);
        iv4.setScaleType(ImageView.ScaleType.FIT_XY);
        mImages.add(iv1);
        mImages.add(iv2);
        mImages.add(iv3);
        mImages.add(iv4);


        mViewPager.setAdapter(new PagerAdapter() {
            //获取当前窗体界面数
            @Override
            public int getCount() {
                return mImages.size();
            }

            //判断是否由对象生成界面
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            //返回一个对象，这个对象表明了当前的pageradapter选择哪个对象放在当前的viewpager上；
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv = mImages.get(position);
                container.addView(iv);
                return mImages.get(position);

            }

            //从viewgroup中删除当前当前的view
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImages.get(position));
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                if (position==mImages.size()-1){
                    startBtn.setVisibility(View.VISIBLE);
                    startBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //如果有以前的数据，清除
                            String nameOld = SPUtil.appget(WelcomeActivity.this, "name", "]]]]]");
                            if(nameOld.equals("]]]]]")){//以前没有注册过
                                startActivity(new Intent(WelcomeActivity.this, LoginAcitvity.class));
                            }else {
                                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                            }
                            WelcomeActivity.this.finish();
                        }
                    });
                }else {
                    startBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int position) {
            }
        });
    }
    private void initViewPager() {
        try {
            Field leftEdgeField = mViewPager.getClass().getDeclaredField("mLeftEdge");
            Field rightEdgeField = mViewPager.getClass().getDeclaredField("mRightEdge");
            if (leftEdgeField != null && rightEdgeField != null) {
                leftEdgeField.setAccessible(true);
                rightEdgeField.setAccessible(true);
                leftEdge = (EdgeEffectCompat) leftEdgeField.get(mViewPager);
                rightEdge = (EdgeEffectCompat) rightEdgeField.get(mViewPager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
