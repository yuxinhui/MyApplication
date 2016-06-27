package com.yuxinhui.text.myapplication.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"15:33"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:banner轮播适配器
 */
public class BannerGuideAdapter extends PagerAdapter {
    private List<ImageView> mlist=new ArrayList<ImageView>();

    public BannerGuideAdapter(List<ImageView> mlist) {
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mlist.get(position%mlist.size());
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //container.removeView(mlist.get(position%mlist.size()));
    }
}
