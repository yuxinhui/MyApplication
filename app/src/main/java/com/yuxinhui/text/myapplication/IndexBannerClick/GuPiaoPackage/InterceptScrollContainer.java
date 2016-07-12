package com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoPackage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by "于志渊"
 * 时间:"9:40"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoPackage
 * 描述:一个视图容器控件；阻止 拦截 ontouch事件传递给其子控件
 */
public class InterceptScrollContainer extends LinearLayout{
    public InterceptScrollContainer(Context context) {
        super(context);
    }

    public InterceptScrollContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("gupiao","ScrollContainer onInterceptTouchEvent");
        return true;
    }
}
