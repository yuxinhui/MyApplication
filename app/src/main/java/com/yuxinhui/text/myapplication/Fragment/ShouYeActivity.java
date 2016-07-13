package com.yuxinhui.text.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.yuxinhui.text.myapplication.Actiity.KaiHu;
import com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.HanDanActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.HuiLvActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.KeBiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.KeFuActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.LaoShiActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.RiLiActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.ZhiboActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.IndexKuaiXunData;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;
import com.yuxinhui.text.myapplication.adapter.ShouyeKuaiXunAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"10:47"
 * 包名:com.yuxinhui.text.myapplication.Fragment
 * 描述:显示首页界面
 */
public class ShouYeActivity extends Fragment{
    private ImageView kaihu_image,zhibo1_image,laoshi_image,kefu_image,kechengbiao_image,handan_image,rili_image,gupiao_image,huilv_image;
    private Intent mIntent;
    //快讯一系列控件
    private ListView kuaixun_list;
    private ArrayList<IndexKuaiXunData.DataBean> mDataList=new ArrayList<IndexKuaiXunData.DataBean>();
    private IndexKuaiXunData indexKuaiXunData;
    private String url= YuXinHuiApplication.getUrlBoot()+"app/news/";
    private ShouyeKuaiXunAdapter mIndexKuaiXunAdapter;
    //导航banner
    private int[] imageIds;
    private LinearLayout main_ll_dots;
    private ViewPager main_vp;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            main_vp.setCurrentItem(main_vp.getCurrentItem()+1,true);
            handler.sendEmptyMessageDelayed(0,5000);
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fg, container, false);
        //初始化控件
        initImage(view);
        imageClick();
        /*initData();
        initView(view);*/
        imageIds=new int[]{R.mipmap.banner,R.mipmap.banner02,R.mipmap.banner03};
        main_ll_dots= (LinearLayout) view.findViewById(R.id.main_ll_dots);
        initDot();
        main_vp= (ViewPager) view.findViewById(R.id.main_vp);
        main_vp.setAdapter(new MyPagerAdapter());
        main_vp.setCurrentItem(imageIds.length*10000);
        updateDescAndDot();
        handler.sendEmptyMessageDelayed(0,5000);
        main_vp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        handler.removeCallbacksAndMessages(null);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        handler.sendEmptyMessageDelayed(0,5000);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler.sendEmptyMessageDelayed(0,5000);
                        break;
                }
                return false;
            }
        });
        main_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateDescAndDot();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
    /**
     * 根据当前page来显示不同的文字和点
     * */
    private void updateDescAndDot() {
        int currentPage=main_vp.getCurrentItem()%imageIds.length;
        //更新点
        //遍历所有的点，当点的位置和currentPage相当的时候，则设置为可用，否则是禁用
        for (int i=0;i<main_ll_dots.getChildCount();i++){
            main_ll_dots.getChildAt(i).setEnabled(i==currentPage);
        }
    }

    //动态加点
    private void initDot() {
        for (int i=0;i<imageIds.length;i++){
            View view=new View(getActivity());
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(20,20);
            params.leftMargin=(i==0?0:20);//给除了第一个点之外的点都加上marginLeft
            view.setLayoutParams(params);//设置宽高
            view.setBackgroundResource(R.drawable.selector_dot);
            main_ll_dots.addView(view);
        }
    }

    //快讯数据
    /*private void initData() {
//        Log.e("indexKuaiXun",mDataList.get(1).toString());
        indexKuaiXunData = new IndexKuaiXunData();
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        final ProgressDialog dialog = ProgressDialog.show(getActivity(), "快讯界面", "加载ing......");
        StringRequest mJsonObjectRequest=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson = new Gson();
                        indexKuaiXunData = gson.fromJson(s,IndexKuaiXunData.class);
                        ArrayList<IndexKuaiXunData.DataBean> list = (ArrayList<IndexKuaiXunData.DataBean>) indexKuaiXunData.getData();
                        mDataList.addAll(list);
                        mIndexKuaiXunAdapter.notifyDataSetChanged();
                        Log.e("快讯","加载成功");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getActivity(), "下载失败,请检查网络连接", Toast.LENGTH_LONG);
                        Log.e("indexkuaixun","下载失败哈");
                        dialog.dismiss();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("title","大庆论金:6.22现货黄金白银原油沥青交易思路及策略");
                return map;
            }
        };
        requestQueue.add(mJsonObjectRequest);
    }*/

    /*private void initView(View view) {
        kuaixun_list= (ListView) view.findViewById(R.id.kuaixun_list);
        mIndexKuaiXunAdapter=new ShouyeKuaiXunAdapter(mDataList,getActivity());
        kuaixun_list.setAdapter(mIndexKuaiXunAdapter);

    }*/

    /**导航图片点击*/
    private void imageClick() {
        kaihu_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        mIntent=new Intent(getActivity(), KaiHu.class);
                        getActivity().startActivity(mIntent);

            }
        });
        zhibo1_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new Runnable() {
                   @Override
                   public void run() {
                       mIntent=new Intent(getActivity(), ZhiboActivity.class);
                       startActivity(mIntent);
                   }
               }.run();
            }
        });
        laoshi_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent=new Intent(getActivity(), LaoShiActivity.class);
                        startActivity(mIntent);
                    }
                }.run();
            }
        });
        kefu_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent=new Intent(getActivity(), KeFuActivity.class);
                        startActivity(mIntent);
                    }
                }.run();
            }
        });
        kechengbiao_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent = new Intent(getActivity(), KeBiaoActivity.class);
                        startActivity(mIntent);
                    }
                }.run();
            }
        });
        handan_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent=new Intent(getActivity(), HanDanActivity.class);
                        startActivity(mIntent);
                    }
                }.run();
            }
        });
        rili_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent=new Intent(getActivity(), RiLiActivity.class);
                        startActivity(mIntent);
                    }
                }.run();
            }
        });
        gupiao_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent=new Intent(getActivity(), GuPiaoActivity.class);
                        startActivity(mIntent);
                    }
                }.run();
            }
        });
        huilv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent=new Intent(getActivity(), HuiLvActivity.class);
                        startActivity(mIntent);
                    }
                }.run();
            }
        });
    }

    /**实例化图片控件*/
    private void initImage(View view) {
        kaihu_image= (ImageView) view.findViewById(R.id.kaihu_image);
        zhibo1_image= (ImageView) view.findViewById(R.id.zhibo1_image);
        laoshi_image= (ImageView) view.findViewById(R.id.laoshi_image);
        kefu_image= (ImageView) view.findViewById(R.id.kefu_image);
        kechengbiao_image= (ImageView) view.findViewById(R.id.kechengbiao_image);
        handan_image= (ImageView) view.findViewById(R.id.handan_image);
        rili_image= (ImageView) view.findViewById(R.id.rili_image);
        gupiao_image= (ImageView) view.findViewById(R.id.gupiao_image);
        huilv_image= (ImageView) view.findViewById(R.id.huilv_image);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    private class MyPagerAdapter extends PagerAdapter {
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
            Log.e("current position =====", position + "");
            ImageView imageView=new ImageView(getActivity());
            imageView.setImageResource(imageIds[position%imageIds.length]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
