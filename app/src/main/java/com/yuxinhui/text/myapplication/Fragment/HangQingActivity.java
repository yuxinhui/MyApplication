package com.yuxinhui.text.myapplication.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yuxinhui.text.myapplication.Actiity.CmoexActivity;
import com.yuxinhui.text.myapplication.Actiity.GlobalActivity;
import com.yuxinhui.text.myapplication.Actiity.LonDonActivity;
import com.yuxinhui.text.myapplication.Actiity.NullActivity;
import com.yuxinhui.text.myapplication.Actiity.ShanghaiActivity;
import com.yuxinhui.text.myapplication.Actiity.TianYinActivity;
import com.yuxinhui.text.myapplication.Actiity.XianHuoActivity;
import com.yuxinhui.text.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"17:00"
 * 包名:com.yuxinhui.text.myapplication.Fragment
 * 描述:行情界面的详情
 */
public class HangQingActivity extends Fragment implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1,mRadioButton2,mRadioButton3,mRadioButton4,mRadioButton5,mRadioButton6;
    private float mCurrentCheckedRadioLeft;//当前被选中的RadioButton距离左侧的距离
    private HorizontalScrollView mHorizontalScrollView;//上面的水平滚动控件
    private ViewPager mViewPager;   //下方的可横向拖动的控件
    private ArrayList<Fragment> mViews;//用来存放下方滚动的layout
    private int yellow = 0xFFF2D70B;
    private int white = 0xFFFFFFFF;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hangqing_fg, container, false);
        iniController(view);
        iniListener();
        iniVariable();
        mRadioButton1.setChecked(true);
        mViewPager.setCurrentItem(1);
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();
        return view;
    }

    private void iniVariable() {
        mViews = new ArrayList<Fragment>();
        mViews.add(new NullActivity());
        mViews.add(new GlobalActivity());
        mViews.add(new XianHuoActivity());
        mViews.add(new CmoexActivity());
        mViews.add(new ShanghaiActivity());
        mViews.add(new LonDonActivity());
        mViews.add(new TianYinActivity());
        mViews.add(new NullActivity());
        mViewPager.setAdapter(new MyPagerAdapter(getFragmentManager(),mViews));//设置ViewPager的适配器
    }

    private void iniListener() {
        mRadioGroup.setOnCheckedChangeListener(this);

        mViewPager.setOnPageChangeListener(new MyPagerOnPageChangeListener());
    }

    private void iniController(View view) {
        mRadioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        mRadioButton1 = (RadioButton) view.findViewById(R.id.radiobt1);
        mRadioButton2 = (RadioButton) view.findViewById(R.id.radiobt2);
        mRadioButton3 = (RadioButton) view.findViewById(R.id.radiobt3);
        mRadioButton4 = (RadioButton) view.findViewById(R.id.radiobt4);
        mRadioButton5 = (RadioButton) view.findViewById(R.id.radiobt5);
        mRadioButton6 = (RadioButton) view.findViewById(R.id.radiobt6);
        mViewPager = (ViewPager) view.findViewById(R.id.hangqing_pager);

        mHorizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontalScrollView);
    }

    //RadioGroup点击CheckedChanged监听
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        AnimationSet _AnimationSet = new AnimationSet(true);
        TranslateAnimation _TranslateAnimation;
        clearColor();
        if (checkedId == R.id.radiobt1) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo1), 0f, 0f);
            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton1.setTextColor(yellow);

            mViewPager.setCurrentItem(1);//让下方ViewPager跟随上面的HorizontalScrollView切换
        } else if (checkedId == R.id.radiobt2) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo2), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton2.setTextColor(yellow);

            mViewPager.setCurrentItem(2);
        } else if (checkedId == R.id.radiobt3) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo3), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton3.setTextColor(yellow);

            mViewPager.setCurrentItem(3);
        } else if (checkedId == R.id.radiobt4) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo4), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton4.setTextColor(yellow);

            mViewPager.setCurrentItem(4);
        } else if (checkedId == R.id.radiobt5) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo5), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton5.setTextColor(yellow);

            mViewPager.setCurrentItem(5);
        } else if (checkedId == R.id.radiobt6) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo6), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);

            //mImageView.bringToFront();
            //mImageView.startAnimation(_AnimationSet);
            mRadioButton6.setTextColor(yellow);
            mViewPager.setCurrentItem(6);
        }

        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();


        mHorizontalScrollView.smoothScrollTo((int) mCurrentCheckedRadioLeft - (int) getResources().getDimension(R.dimen.rdo2), 0);
    }
    //初始化未选中的标签为白色
    private void clearColor() {
        mRadioButton1.setTextColor(white);
        mRadioButton2.setTextColor(white);
        mRadioButton3.setTextColor(white);
        mRadioButton4.setTextColor(white);
        mRadioButton5.setTextColor(white);
        mRadioButton6.setTextColor(white);
    }
    //获得当前被选中的RadioButton距离左侧的距离
    private float getCurrentCheckedRadioLeft() {
        if (mRadioButton1.isChecked()) {
            return getResources().getDimension(R.dimen.rdo1);
        } else if (mRadioButton2.isChecked()) {
            return getResources().getDimension(R.dimen.rdo2);
        } else if (mRadioButton3.isChecked()) {
            return getResources().getDimension(R.dimen.rdo3);
        } else if (mRadioButton4.isChecked()) {
            return getResources().getDimension(R.dimen.rdo4);
        } else if (mRadioButton5.isChecked()) {
            return getResources().getDimension(R.dimen.rdo5);
        } else if (mRadioButton6.isChecked()) {
            return getResources().getDimension(R.dimen.rdo6);
        }
        return 0f;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //ViewPager的PageChangeListener(页面改变的监听器)
    private class MyPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        //滑动ViewPager的时候,让上方的HorizontalScrollView自动切换
        @Override
        public void onPageSelected(int position) {
            if (position == 0) {
                mViewPager.setCurrentItem(1);
            } else if (position == 1) {
                mRadioButton1.performClick();
            } else if (position == 2) {
                mRadioButton2.performClick();
            } else if (position == 3) {
                mRadioButton3.performClick();
            } else if (position == 4) {
                mRadioButton4.performClick();
            } else if (position == 5) {
                mRadioButton5.performClick();
            } else if (position == 6) {
                mRadioButton6.performClick();
            } else if (position == 7) {
                mViewPager.setCurrentItem(6);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    //ViewPager的适配器
    private class MyPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> listfragment;
        public MyPagerAdapter(FragmentManager fm, List<Fragment> listfragment) {
            super(fm);
            this.listfragment = listfragment;
        }
        @Override
        public Fragment getItem(int position) {
            return listfragment.get(position);
        }

        @Override
        public int getCount() {
            return listfragment.size();
        }
    }
}
