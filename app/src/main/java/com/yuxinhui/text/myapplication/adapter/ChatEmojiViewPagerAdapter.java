package com.yuxinhui.text.myapplication.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"11:42"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:
 */
public class ChatEmojiViewPagerAdapter extends PagerAdapter {
    private List<View> pageViews;
    public ChatEmojiViewPagerAdapter(ArrayList<View> pageViews) {
        super();
        this.pageViews = pageViews;
    }

    @Override
    public int getCount() {
        return pageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(pageViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(pageViews.get(position));
        return pageViews.get(position);
    }
}
