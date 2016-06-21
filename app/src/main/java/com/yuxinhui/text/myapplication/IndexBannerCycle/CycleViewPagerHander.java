package com.yuxinhui.text.myapplication.IndexBannerCycle;

import android.content.Context;
import android.os.Handler;


/**
 * Created by "于志渊"
 * 时间:"17:07"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerCycle
 * 描述:为了防止内存泄漏，定义外部类，防止内部类对外部类的引用
 */
public class CycleViewPagerHander extends Handler{
    Context context;

    public CycleViewPagerHander(Context context) {
        this.context = context;
    }

};
