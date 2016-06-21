package com.yuxinhui.text.myapplication.YinDaoTu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/7.
 */
public class GuideActivity extends Activity {
    private ViewPager viewPager;
    //分页显示的view数组
    private ArrayList<View> pagerViews;
    private ImageView imageView;
    //小圆点的图片用数组显示
    private ImageView[] imageViews;
    //包裹滑动图片与小圆点的linearlayout
    private ViewGroup viewPics;
    private ViewGroup viewPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将分页显示的view装入数组
        LayoutInflater inflater=getLayoutInflater();
        pagerViews=new ArrayList<View>();
        pagerViews.add(inflater.inflate(R.layout.yindaotu_pager1,null));
        pagerViews.add(inflater.inflate(R.layout.yindaotu_pager2,null));
        pagerViews.add(inflater.inflate(R.layout.yindaotu_pager3,null));
        pagerViews.add(inflater.inflate(R.layout.yindaotu_pager4,null));
        pagerViews.add(inflater.inflate(R.layout.yindaotu_pager5,null));
        //创建imageview数组，其中的大小是要显示图片的数量
        imageViews=new ImageView[pagerViews.size()];
        //从制定的.xml文件中加载视图
        viewPics= (ViewGroup) inflater.inflate(R.layout.activity_guide, null);
        //实例化小圆点的linearlayout和viewgroup
        viewPoints= (ViewGroup) viewPics.findViewById(R.id.guide_viewgroup);
        viewPager= (ViewPager) viewPics.findViewById(R.id.guide_pagers);
        //添加小圆点图片
        for (int i=0;i<pagerViews.size();i++){
            imageView=new ImageView(GuideActivity.this);
            //设置小圆点imageview参数
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20,20));
            imageView.setPadding(20,0,20,0);
            //将小圆点添加到数组中
            imageViews[i]=imageView;
            //默认选中的是第一张图片，此时第一个小圆点是选中状态，其他不是
            if (i==0){
                imageViews[i].setBackgroundResource(R.mipmap.yindao_quan);
            }else {
                imageViews[i].setBackgroundResource(R.mipmap.yindao_quan1);
            }
            //将imageviews小圆点添加到视图组
            viewPoints.addView(imageViews[i]);
        }
        //显示滑动图片的视图
        setContentView(viewPics);
        //设置viewpager的适配器和监听事件
        viewPager.setAdapter(new GuidePagerAdapter());
        viewPager.setOnPageChangeListener(new GuidePageChangeListener());
    }
    private ImageButton.OnClickListener Button_onClickListener=new ImageButton.OnClickListener(){
        @Override
        public void onClick(View v) {
            //设置已经引导
            setGuide();
            //跳转
            Intent mIntent=new Intent();
            mIntent.setClass(GuideActivity.this,MainActivity.class);
            GuideActivity.this.startActivity(mIntent);
            GuideActivity.this.finish();
        }

    };
    private static final String SHAREDPREFERENCES_NAME ="my_pref";
    private static final String KEY_GUIDE_ACTIVITY ="guide_activity";
    private void setGuide() {
        SharedPreferences settings=getSharedPreferences(SHAREDPREFERENCES_NAME,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_GUIDE_ACTIVITY, "false");
        editor.commit();
    }

    class GuidePagerAdapter extends PagerAdapter {
        //销毁position位置的界面
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(pagerViews.get(position));
        }

        @Override
        public void finishUpdate(ViewGroup container) {

        }

        //获取当前窗体界面数
        @Override
        public int getCount() {
            return pagerViews.size();
        }
        //初始化position界面位置
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pagerViews.get(position));
            if (position==4){
                ImageButton btn= (ImageButton) container.findViewById(R.id.guide_close_btn);
                btn.setOnClickListener(Button_onClickListener);
            }
            return pagerViews.get(position);
        }
        //判断是否由对象生成界面
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void startUpdate(ViewGroup container) {
            super.startUpdate(container);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }
    }

    class GuidePageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (int i=0;i<imageViews.length;i++){
                imageViews[position].setBackgroundResource(R.mipmap.yindao_quan);
                //不是当前选中的page，其小圆点设置为未选中的状态
                if (position!=i){
                    imageViews[position].setBackgroundResource(R.mipmap.yindao_quan1);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
