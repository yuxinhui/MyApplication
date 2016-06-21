package com.yuxinhui.text.myapplication.IndexBannerCycle;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by "于志渊"
 * 时间:"17:11"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerCycle
 * 描述:自定义高度的viewpapger
 */
public class BaseViewPager extends ViewPager{
    private boolean scrollable=true;
    public BaseViewPager(Context context) {
        super(context);
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    /*设置viewpager是否可以滚动*/
    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (scrollable){
            return super.onInterceptTouchEvent(ev);
        }
        else {
            return false;
        }
    }
}
