package com.yuxinhui.text.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.HanDanActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.HuiLvActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.KeBiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.KeFuActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.LaoShiActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.WeiPanActivity;
import com.yuxinhui.text.myapplication.KaiHu;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.adapter.ShouyeKuaiXunAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class ShouYeActivity extends Fragment{
    private ImageView kaihu_image;
    private ImageView zhibo1_image;
    private ImageView laoshi_image;
    private ImageView kefu_image;
    private ImageView kechengbiao_image;
    private ImageView handan_image;
    private ImageView weipan_image;
    private ImageView gupiao_image;
    private ImageView huilv_image;
    private Intent mIntent;
    private ListView kuaixun_list;
    private ShouyeKuaiXunAdapter mShouyeKuaiXunAdapter=new ShouyeKuaiXunAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fg, container, false);
        kuaixun_list= (ListView) view.findViewById(R.id.kuaixun_list);
        //初始化控件
        initImage(view);
        imageClick();
        return view;
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
