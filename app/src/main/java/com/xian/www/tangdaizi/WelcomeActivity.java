package com.xian.www.tangdaizi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.EdgeEffectCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.xian.www.tangdaizi.ui.LoginAcitvity;
import com.xian.www.tangdaizi.ui.MainActivity;
import com.xian.www.tangdaizi.utils.SPUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 17/9/19.
 */

public class WelcomeActivity extends Activity {

    private ViewPager mViewPager;
    private List<ImageView> mImages;
    private EdgeEffectCompat leftEdge;
    private EdgeEffectCompat rightEdge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
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
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                //转载高手ViewPager在拖拽到左边和右边的时候，禁止显示黄色或者蓝色的渐变图片的解决方法（以备自己以后查阅）
//                if (leftEdge != null && rightEdge != null) {
//                    leftEdge.finish();
//                    rightEdge.finish();
//                    leftEdge.setSize(0, 0);
//                    rightEdge.setSize(0, 0);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int position) {
                //判断当前页数是否==总页数
                if(rightEdge!=null&&!rightEdge.isFinished()){//到了最后一张并且还继续拖动，出现蓝色限制边条了

                    //如果有以前的数据，清除
                    String nameOld = SPUtil.appget(WelcomeActivity.this, "name", "]]]]]");
                    if(nameOld.equals("]]]]]")){//以前没有注册过
                        startActivity(new Intent(WelcomeActivity.this, LoginAcitvity.class));
                    }else {
                        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    }
                    WelcomeActivity.this.finish();
                }
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
