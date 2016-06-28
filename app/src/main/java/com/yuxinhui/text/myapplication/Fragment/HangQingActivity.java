package com.yuxinhui.text.myapplication.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.yuxinhui.text.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/12.
 */
public class HangQingActivity extends Fragment implements OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private RadioButton mRadioButton4;
    private RadioButton mRadioButton5;
    private RadioButton mRadioButton6;
    private ImageView mImageView;
    private float mCurrentCheckedRadioLeft;//当前被选中的RadioButton距离左侧的距离
    private HorizontalScrollView mHorizontalScrollView;//上面的水平滚动控件
    private ViewPager mViewPager;   //下方的可横向拖动的控件
    private ArrayList<View> mViews;//用来存放下方滚动的layout
    private float currentCheckedRadioLeft;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hangqing_fg, container, false);
        iniVariable(savedInstanceState);
        iniListener();
        return view;
    }

    private void iniListener() {
        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.setOnPageChangeListener(new MyPagerOnPageChangeListener());
    }

    private void iniVariable(Bundle savedInstanceState) {
        mViews=new ArrayList<View>();
        mViews.add(getLayoutInflater(savedInstanceState).inflate(R.layout.activity_firstnull,null));
        mViews.add(getLayoutInflater(savedInstanceState).inflate(R.layout.activity_globalcurrency,null));
        mViews.add(getLayoutInflater(savedInstanceState).inflate(R.layout.activity_xianhuohuangjin,null));
        mViews.add(getLayoutInflater(savedInstanceState).inflate(R.layout.activity_comex,null));
        mViews.add(getLayoutInflater(savedInstanceState).inflate(R.layout.activity_shanghaijin,null));
        mViews.add(getLayoutInflater(savedInstanceState).inflate(R.layout.activity_londonmetal,null));
        mViews.add(getLayoutInflater(savedInstanceState).inflate(R.layout.activity_tiantongyin,null));
        mViews.add(getLayoutInflater(savedInstanceState).inflate(R.layout.activity_firstnull,null));
        mViewPager.setAdapter(new MyPagerAdapter());//设置ViewPager的适配器
    }

    /**
     * RadioGroup点击CheckedChanged监听
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        AnimationSet _AnimationSet = new AnimationSet(true);
        TranslateAnimation _TranslateAnimation;
        if (checkedId == R.id.radiobt1) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo1), 0f, 0f);
            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mImageView.startAnimation(_AnimationSet);//开始上面红色横条图片的动画切换
            mViewPager.setCurrentItem(1);//让下方ViewPager跟随上面的HorizontalScrollView切换
        } else if (checkedId == R.id.radiobt2) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo2), 0f, 0f);
            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mImageView.startAnimation(_AnimationSet);
            mViewPager.setCurrentItem(2);
        } else if (checkedId == R.id.radiobt3) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo3), 0f, 0f);
            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mImageView.startAnimation(_AnimationSet);
            mViewPager.setCurrentItem(3);
        } else if (checkedId == R.id.radiobt4) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo4), 0f, 0f);
            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mImageView.startAnimation(_AnimationSet);
            mViewPager.setCurrentItem(4);
        } else if (checkedId == R.id.radiobt5) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo5), 0f, 0f);
            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mImageView.startAnimation(_AnimationSet);
            mViewPager.setCurrentItem(5);
        } else if (checkedId == R.id.radiobt6) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo6), 0f, 0f);
            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mImageView.startAnimation(_AnimationSet);
            mViewPager.setCurrentItem(6);
        }
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();
        mHorizontalScrollView.smoothScrollTo((int)mCurrentCheckedRadioLeft-(int)getResources().getDimension(R.dimen.rdo2),0);
    }

    /**获得当前被选中的RadioButton距离左侧的距离 */
    public float getCurrentCheckedRadioLeft() {
        if (mRadioButton1.isChecked()){
            return getResources().getDimension(R.dimen.rdo1);
        }else if (mRadioButton2.isChecked()){
            return getResources().getDimension(R.dimen.rdo2);
        }else if (mRadioButton3.isChecked()){
            return getResources().getDimension(R.dimen.rdo3);
        }else if (mRadioButton4.isChecked()){
            return getResources().getDimension(R.dimen.rdo4);
        }else if (mRadioButton5.isChecked()){
            return getResources().getDimension(R.dimen.rdo5);
        }else if (mRadioButton6.isChecked()){
            return getResources().getDimension(R.dimen.rdo6);
        }
        return 0f;
    }

    /**ViewPager的适配器 */
    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }

    /**ViewPager的PageChangeListener(页面改变的监听器) */
    private class MyPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**滑动ViewPager的时候,让上方的HorizontalScrollView自动切换 */
        @Override
        public void onPageSelected(int position) {
            if (position==0){
                mViewPager.setCurrentItem(1);
            }else if (position==1){
                mRadioButton1.performClick();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
