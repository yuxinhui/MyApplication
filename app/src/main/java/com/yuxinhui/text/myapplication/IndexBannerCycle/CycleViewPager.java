package com.yuxinhui.text.myapplication.IndexBannerCycle;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yuxinhui.text.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"16:59"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerCycle
 * 描述:实现可循环，可轮播的viewpager
 */
public class CycleViewPager extends Fragment implements ViewPager.OnPageChangeListener{
    private List<ImageView> imageViews = new ArrayList<ImageView>();
    private ImageView[] indicators;
    private FrameLayout viewPagerFragmentLayout;
    private LinearLayout indicatorLayout; // 指示器
    private BaseViewPager viewPager;
    private BaseViewPager parentViewPager;
    private ViewPagerAdapter adapter;
    private CycleViewPagerHander handler;
    private int time = 3000; // 默认轮播时间
    private int currentPosition = 0; // 轮播当前位置
    private boolean isScrolling = false; // 滚动框是否滚动着
    private boolean isCycle = false; // 是否循环
    private boolean isWheel = false; // 是否轮播
    private long releaseTime = 0; // 手指松开、页面不滚动时间，防止手机松开后短时间进行切换
    private int WHEEL = 100; // 转动
    private int WHEEL_WAIT = 101; // 等待

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.indexcycle_viewpager_contet, null);
        viewPager= (BaseViewPager) view.findViewById(R.id.viewPager);
        indicatorLayout= (LinearLayout) view.findViewById(R.id.layout_viewpager_indicator);
        viewPagerFragmentLayout= (FrameLayout) view.findViewById(R.id.layout_viewager_content);
        handler=new CycleViewPagerHander(getActivity()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==WHEEL&&imageViews.size()!=0){
                    if (!isScrolling){
                        int max = imageViews.size() + 1;
                        int position = (currentPosition + 1) % (imageViews.size());
                        viewPager.setCurrentItem(position,true);
                        if (position==max){//最后一页时返回第一页
                            viewPager.setCurrentItem(1,false);
                        }
                    }
                    releaseTime=System.currentTimeMillis();
                    handler.removeCallbacks(runnable);
                    handler.postDelayed(runnable,time);
                    return;
                }
                if (msg.what==WHEEL_WAIT&&imageViews.size()!=0){
                    handler.removeCallbacks(runnable);
                    handler.postDelayed(runnable,time);
                }
            }
        };
        return view;
    }
    public void setData(List<ImageView> views){
        setData(views);
    }
    /**初始化viewpager
     * views 要显示的views
     * showPosotion 默认显示位置*/
    public void setData(List<ImageView> views,int showPosotion){
        this.imageViews.clear();
        if (views.size()==0){
            viewPagerFragmentLayout.setVisibility(View.GONE);
            return;
        }
        for (ImageView item:views){
            this.imageViews.add(item);
        }
        int ivSize=views.size();
        // 设置指示器
        indicators=new ImageView[ivSize];
        if (isCycle){
            indicators=new ImageView[ivSize-2];
            indicatorLayout.removeAllViews();
        }
        for (int i=0;i<indicators.length;i++){
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.indexcycle_viewpager_indication, null);
            indicators[i]= (ImageView) view.findViewById(R.id.image_indicator);
            indicatorLayout.addView(view);
        }
    }
    /**是否处于轮播状态*/
    public boolean isWheel(){
        return isWheel;
    }
    final Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if (getActivity()!=null&&!getActivity().isFinishing()&&isWheel){
                long now = System.currentTimeMillis();
                //检测上一次滑动时间与本次之间是否有触击(手滑动)操作，有的话等待下次轮播
                if (now-releaseTime>time-300){
                    handler.sendEmptyMessage(WHEEL);
                }else {
                    handler.sendEmptyMessage(WHEEL_WAIT);
                }
            }
        }
    };

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class ViewPagerAdapter {
    }

}
