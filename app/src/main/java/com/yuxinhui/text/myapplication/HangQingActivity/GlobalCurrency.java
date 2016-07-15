package com.yuxinhui.text.myapplication.HangQingActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
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
import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"17:00"
 * 包名:com.yuxinhui.text.myapplication.HangQingActivity
 * 描述:行情界面的详情
 */
public class GlobalCurrency extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private RadioButton mRadioButton4;
    private RadioButton mRadioButton5;
    private RadioButton mRadioButton6;
    private float mCurrentCheckedRadioLeft;//当前被选中的RadioButton距离左侧的距离
    private HorizontalScrollView mHorizontalScrollView;//上面的水平滚动控件
    private ViewPager mViewPager;   //下方的可横向拖动的控件
    private ArrayList<Fragment> mViews;//用来存放下方滚动的layout
    private int yellow = 0xFFF2D70B;
    private int white = 0xFFFFFFFF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangqing_fg);
        iniController();
        iniListener();
        iniVariable();
        mRadioButton1.setChecked(true);
        mViewPager.setCurrentItem(1);
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();
    }

    private void iniVariable() {
//         TODO Auto-generated method stub
        mViews = new ArrayList<Fragment>();
        mViews.add(new NullActivity());
        mViews.add(new GlobalActivity());
        mViews.add(new XianHuoActivity());
        mViews.add(new CmoexActivity());
        mViews.add(new ShanghaiActivity());
        mViews.add(new LonDonActivity());
        mViews.add(new TianYinActivity());
        mViews.add(new NullActivity());
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mViews));//设置ViewPager的适配器
    }

    /**
     * RadioGroup点击CheckedChanged监听
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        AnimationSet _AnimationSet = new AnimationSet(true);
        TranslateAnimation _TranslateAnimation;
        clearColor();
        Log.i("zj", "checkedid=" + checkedId);
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

        Log.i("zj", "getCurrentCheckedRadioLeft=" + getCurrentCheckedRadioLeft());
        Log.i("zj", "getDimension=" + getResources().getDimension(R.dimen.rdo2));

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

    /**
     * 获得当前被选中的RadioButton距离左侧的距离
     */
    private float getCurrentCheckedRadioLeft() {
        // TODO Auto-generated method stub
        if (mRadioButton1.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo1));
            return getResources().getDimension(R.dimen.rdo1);
        } else if (mRadioButton2.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo2));
            return getResources().getDimension(R.dimen.rdo2);
        } else if (mRadioButton3.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo3));
            return getResources().getDimension(R.dimen.rdo3);
        } else if (mRadioButton4.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo4));
            return getResources().getDimension(R.dimen.rdo4);
        } else if (mRadioButton5.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo5));
            return getResources().getDimension(R.dimen.rdo5);
        } else if (mRadioButton6.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo6));
            return getResources().getDimension(R.dimen.rdo6);
        }
        return 0f;
    }

    private void iniListener() {
        // TODO Auto-generated method stub

        mRadioGroup.setOnCheckedChangeListener(this);


        mViewPager.setOnPageChangeListener(new MyPagerOnPageChangeListener());
    }

    private void iniController() {
        // TODO Auto-generated method stub
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mRadioButton1 = (RadioButton) findViewById(R.id.radiobt1);
        mRadioButton2 = (RadioButton) findViewById(R.id.radiobt2);
        mRadioButton3 = (RadioButton) findViewById(R.id.radiobt3);
        mRadioButton4 = (RadioButton) findViewById(R.id.radiobt4);
        mRadioButton5 = (RadioButton) findViewById(R.id.radiobt5);
        mRadioButton6 = (RadioButton) findViewById(R.id.radiobt6);
        mViewPager = (ViewPager) findViewById(R.id.hangqing_pager);

        mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
    }
    /**
     * ViewPager的适配器
     * 下午2:26:57
     */
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent(GlobalCurrency.this, MainActivity.class);
            startActivity(intent);
            GlobalCurrency.this.finish();
            return false;
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * ViewPager的PageChangeListener(页面改变的监听器)
     * 3:14:27
     */
    private class MyPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub
        }
        /**
         * 滑动ViewPager的时候,让上方的HorizontalScrollView自动切换
         */
        @Override
        public void onPageSelected(int position) {
            // TODO Auto-generated method stub
            //Log.i("zj", "position="+position);
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
    }
}
