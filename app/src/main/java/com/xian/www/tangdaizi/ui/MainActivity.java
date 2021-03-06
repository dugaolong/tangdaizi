package com.xian.www.tangdaizi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.fragment.MainTab01;
import com.xian.www.tangdaizi.fragment.MainTab02;
import com.xian.www.tangdaizi.fragment.MainTab03;
import com.xian.www.tangdaizi.fragment.MainTab04;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragmentsHome = new ArrayList<Fragment>();
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    private final String TAG = "MainActivity";
    /**
     * 底部四个按钮
     */
    private LinearLayout mTabBtnZhuye;
    private LinearLayout mTabBtnFind;
    private LinearLayout mTabBtnHuodong;
    private LinearLayout mTabBtnGeren;
    private FloatingActionButton fab;

    /**
     * 四个fragment
     */
    MainTab01 tab01;
    MainTab02 tab02;
    MainTab03 tab03;
    MainTab04 tab04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        initView();
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }

            @Override
            public int getItemPosition(Object object) {
                return PagerAdapter.POSITION_NONE;
            }

        };

        mViewPager.setAdapter(mAdapter);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int currentIndex;

            @Override
            public void onPageSelected(int position) {
                resetTabBtn();
                switch (position) {
                    case 0:
                        ((ImageButton) mTabBtnZhuye.findViewById(R.id.btn_tab_bottom_weixin))
                                .setImageResource(R.drawable.zhuye2);
                        break;
                    case 1:
                        ((ImageButton) mTabBtnFind.findViewById(R.id.btn_tab_bottom_friend))
                                .setImageResource(R.drawable.find2);
                        break;
                    case 2:
                        ((ImageButton) mTabBtnHuodong.findViewById(R.id.btn_tab_bottom_contact))
                                .setImageResource(R.drawable.huodong2);
                        break;
                    case 3:
                        ((ImageButton) mTabBtnGeren.findViewById(R.id.btn_tab_bottom_setting))
                                .setImageResource(R.drawable.geren2);
                        break;
                }

                currentIndex = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    protected void resetTabBtn() {
        ((ImageButton) mTabBtnZhuye.findViewById(R.id.btn_tab_bottom_weixin))
                .setImageResource(R.drawable.zhuye1);
        ((ImageButton) mTabBtnFind.findViewById(R.id.btn_tab_bottom_friend))
                .setImageResource(R.drawable.find1);
        ((ImageButton) mTabBtnHuodong.findViewById(R.id.btn_tab_bottom_contact))
                .setImageResource(R.drawable.huodong1);
        ((ImageButton) mTabBtnGeren.findViewById(R.id.btn_tab_bottom_setting))
                .setImageResource(R.drawable.geren1);
    }

    private void initView() {

        mTabBtnZhuye = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        mTabBtnFind = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        mTabBtnHuodong = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
        mTabBtnGeren = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);

        mTabBtnZhuye.setOnClickListener(this);
        mTabBtnFind.setOnClickListener(this);
        mTabBtnHuodong.setOnClickListener(this);
        mTabBtnGeren.setOnClickListener(this);
        tab01 = new MainTab01();
        tab02 = new MainTab02();
        tab03 = new MainTab03();
        tab04 = new MainTab04();
        mFragments.add(tab01);
        mFragments.add(tab02);
        mFragments.add(tab03);
        mFragments.add(tab04);

        mFragmentsHome.add(tab01);
        mFragmentsHome.add(tab02);
        mFragmentsHome.add(tab03);
        mFragmentsHome.add(tab04);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_bottom_weixin:
                ((ImageButton) mTabBtnZhuye.findViewById(R.id.btn_tab_bottom_weixin))
                        .setImageResource(R.drawable.zhuye2);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.id_tab_bottom_friend:
                ((ImageButton) mTabBtnFind.findViewById(R.id.btn_tab_bottom_friend))
                        .setImageResource(R.drawable.find2);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.id_tab_bottom_contact:
                ((ImageButton) mTabBtnHuodong.findViewById(R.id.btn_tab_bottom_contact))
                        .setImageResource(R.drawable.huodong2);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.id_tab_bottom_setting:
                ((ImageButton) mTabBtnGeren.findViewById(R.id.btn_tab_bottom_setting))
                        .setImageResource(R.drawable.geren2);
                mViewPager.setCurrentItem(3);
                break;
            case R.id.fab:
                Intent intent = new Intent(this, RankingActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }



}
