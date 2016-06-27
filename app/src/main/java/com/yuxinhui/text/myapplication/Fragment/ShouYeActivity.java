package com.yuxinhui.text.myapplication.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.Actiity.KaiHu;
import com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.HanDanActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.HuiLvActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.KeBiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.KeFuActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.LaoShiActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.WeiPanActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.ZhiboActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.IndexKuaiXunData;
import com.yuxinhui.text.myapplication.adapter.ShouyeKuaiXunAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"10:47"
 * 包名:com.yuxinhui.text.myapplication.Fragment
 * 描述:显示首页界面
 */
public class ShouYeActivity extends Fragment{
    private ImageView kaihu_image,zhibo1_image,laoshi_image,kefu_image,kechengbiao_image,handan_image,weipan_image,gupiao_image,huilv_image;
    private Intent mIntent;
    private ListView kuaixun_list;
    private ArrayList<IndexKuaiXunData.DataBean> mDataList=new ArrayList<IndexKuaiXunData.DataBean>();
    private IndexKuaiXunData indexKuaiXunData;
    private String url="http://114.55.98.142/app/news/";
    private ShouyeKuaiXunAdapter mIndexKuaiXunAdapter;
    private ArrayList<ImageView> list=new ArrayList<ImageView>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fg, container, false);
        //初始化控件
        initImage(view);
        imageClick();
        initData();
        initView(view);
        return view;
    }

    private void initData() {
//        Log.e("indexKuaiXun",mDataList.get(1).toString());
        indexKuaiXunData = new IndexKuaiXunData();
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "快讯界面", "加载ing......");
        StringRequest mJsonObjectRequest=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson = new Gson();
                        indexKuaiXunData = gson.fromJson(s, IndexKuaiXunData.class);
                        mDataList.addAll(indexKuaiXunData.getData());
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getActivity(), "下载失败,请检查网络连接", Toast.LENGTH_LONG);
                        Log.i("indexkuaixun","下载失败哈");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(mJsonObjectRequest);
    }

    private void initView(View view) {
        kuaixun_list= (ListView) view.findViewById(R.id.kuaixun_list);
        mIndexKuaiXunAdapter=new ShouyeKuaiXunAdapter(mDataList,getContext());
        kuaixun_list.setAdapter(mIndexKuaiXunAdapter);

    }

    /**导航图片点击*/
    private void imageClick() {
        kaihu_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent=new Intent(getActivity(), KaiHu.class);
                        startActivity(mIntent);
                    }
                }.run();
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
        weipan_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        mIntent=new Intent(getActivity(), WeiPanActivity.class);
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
        weipan_image= (ImageView) view.findViewById(R.id.weipan_image);
        gupiao_image= (ImageView) view.findViewById(R.id.gupiao_image);
        huilv_image= (ImageView) view.findViewById(R.id.huilv_image);
    }

}
