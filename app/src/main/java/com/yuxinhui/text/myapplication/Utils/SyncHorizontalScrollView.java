package com.yuxinhui.text.myapplication.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by "于志渊"
 * 时间:"11:40"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:这个类也是从网上找的参考
 */
public class SyncHorizontalScrollView extends HorizontalScrollView {
    private View mView;
    public SyncHorizontalScrollView(Context context) {
        super(context);
    }

    public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //设置控件滚动监听，得到滚动的距离，然后让传进来的view也设置相同的滚动具体
        if (mView!=null){
            mView.scrollTo(l,t);
        }
    }

    /**
     * 设置与它联动的view
     * */
    public void setScrollView(View view){
        this.mView=view;
    }
}
