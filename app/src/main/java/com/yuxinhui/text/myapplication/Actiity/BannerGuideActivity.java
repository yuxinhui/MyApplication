package com.yuxinhui.text.myapplication.Actiity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.adapter.BannerGuideAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"17:46"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:banner图片轮播详情
 */
public class BannerGuideActivity extends AppCompatActivity {
    // 声明控件
    private ViewPager mViewPager;
    private List<ImageView> mlist;
    private LinearLayout mLinearLayout;
    // 广告图素材
    private int[] bannerImages={R.mipmap.banner,R.mipmap.banner02,R.mipmap.banner03};
    // ViewPager适配器与监听器
    private BannerGuideAdapter mAdapter;
    private BannerListener bannerListener;
    // 圆圈标志位
    private int pointIndex = 0;
    // 线程标志
    private boolean isStop = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bannerguide);
        initView();
        initData();
        initAction();
        // 开启新线程，2秒一次更新Banner
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStop){
                    SystemClock.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                        }
                    });
                }
            }
        }).start();
    }

    /**初始化控件*/
    private void initAction() {
        bannerListener=new BannerListener();
        mViewPager.setOnPageChangeListener(bannerListener);
        //取中间数来作为起始位置
        int index = (Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2 % mlist.size());
        //用来出发监听器
        mViewPager.setCurrentItem(index);
        mLinearLayout.getChildAt(pointIndex).setEnabled(true);
    }

    /**初始化控件*/
    private void initData() {
        mlist=new ArrayList<ImageView>();
        View view;
        LinearLayout.LayoutParams params;
        for (int i=0;i<bannerImages.length;i++){
            ImageView imageView=new ImageView(BannerGuideActivity.this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            imageView.setBackgroundResource(bannerImages[i]);
            mlist.add(imageView);
            // 设置圆圈点
            view=new View(BannerGuideActivity.this);
            params=new LinearLayout.LayoutParams(5,5);
            params.leftMargin=10;
            view.setBackgroundResource(R.drawable.enabledot);
            view.setLayoutParams(params);
            view.setEnabled(false);
            mLinearLayout.addView(view);
        }
        mAdapter=new BannerGuideAdapter(mlist);
        mViewPager.setAdapter(mAdapter);
    }

    /**初始化View操作*/
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mLinearLayout = (LinearLayout) findViewById(R.id.points);
    }

    class BannerListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int newPositiion=position%bannerImages.length;
            mLinearLayout.getChildAt(newPositiion).setEnabled(true);
            mLinearLayout.getChildAt(pointIndex).setEnabled(false);
            //更新标志位
            position=newPositiion;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    protected void onDestroy() {
        isStop=true;
        super.onDestroy();
    }
}
