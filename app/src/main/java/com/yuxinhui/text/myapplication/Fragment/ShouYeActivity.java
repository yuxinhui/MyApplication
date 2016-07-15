package com.yuxinhui.text.myapplication.Fragment;

import android.content.Intent;
import android.net.Uri;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yuxinhui.text.myapplication.Actiity.Denglu;
import com.yuxinhui.text.myapplication.Actiity.KaiHu;
import com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.HanDanActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.HuiLvActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.KeBiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.LaoShiActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.RiLiActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.ZhiboActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

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
    private WebView kuaixun_wv;

    //导航banner
    private int[] imageIds;
    private LinearLayout main_ll_dots;
    private ViewPager main_vp;
    private String qq;
    RequestQueue requestQueue;

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
        requestQueue = Volley.newRequestQueue(getActivity());
        //初始化控件
        initImage(view);
        imageClick();
        initView(view);

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
    private void initView(View view) {
        kuaixun_wv= (WebView) view.findViewById(R.id.kuaixun_wv);
        kuaixun_wv.loadUrl("http://www.niubo.tv/cjsj_nb.php");
        kuaixun_wv.getSettings().setJavaScriptEnabled(true);
        kuaixun_wv.setScrollBarStyle(0);
        kuaixun_wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }//重写点击动作,用webview载入
        });
    }

    /**导航图片点击*/
    private void imageClick() {
        kaihu_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KaiHu.class);
                getActivity().startActivity(intent);
            }
        });
        zhibo1_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent=new Intent(getActivity(), ZhiboActivity.class);
                getActivity().startActivity(mIntent);
            }
        });
        laoshi_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent=new Intent(getActivity(), LaoShiActivity.class);
                getActivity().startActivity(mIntent);
            }
        });
        kefu_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (YuXinHuiApplication.getInstace().isLogin()) {
                    //getQQ();
//                    Log.e("TAG", qq);
                    String url = "mqqwpa://im/chat?chat_type=wpa&uin="+qq;
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } else {
                    Intent intent = new Intent(getActivity(), Denglu.class);
                    getActivity().startActivity(intent);
                }
            }
        });
        kechengbiao_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(getActivity(), KeBiaoActivity.class);
                getActivity().startActivity(mIntent);
            }
        });
        handan_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent=new Intent(getActivity(), HanDanActivity.class);
                getActivity().startActivity(mIntent);
            }
        });
        rili_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent=new Intent(getActivity(), RiLiActivity.class);
                getActivity().startActivity(mIntent);
            }
        });
        gupiao_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent=new Intent(getActivity(), GuPiaoActivity.class);
                getActivity().startActivity(mIntent);
            }
        });
        huilv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent=new Intent(getActivity(), HuiLvActivity.class);
                getActivity().startActivity(mIntent);
            }
        });
    }

    /*private void getQQ() {
//        http://114.55.98.142/app/getQQ?gid=%@
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = YuXinHuiApplication.URL_BOOT+"app/getQQ?gid="+YuXinHuiApplication.getInstace().getUser().getGid();
        Log.e("TAG", url);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                QQBean qqBean = gson.fromJson(s, QQBean.class);
                Log.e("TAG", qqBean.toString());
                if(qqBean.getStatus().equals("ok")){
                    qq = qqBean.getData().getQq();
                    Log.e("TAG", qq);
                }
                DialogUtils.createToasdt(getActivity(),"获取"+qqBean.getMessage());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                DialogUtils.createToasdt(getActivity(),volleyError.getMessage());
            }
        });
        queue.add(request);
    }*/

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
