package com.yuxinhui.text.myapplication.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.XueYuanData;
import com.yuxinhui.text.myapplication.adapter.XueYuanAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/31.
 */
public class XueyuanActivity extends Fragment {
    private ListView xueyuan_lv;
    private XueYuanData.DataBean mData=new XueYuanData.DataBean();
    private XueYuanAdapter mAdapter;
    private ArrayList<XueYuanData.DataBean.ResultBean> mList=new ArrayList<XueYuanData.DataBean.ResultBean>();
    private String url="http://114.55.98.142/video/selectVideo?pageNo=1";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xueyuan_fg, container,false);
        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        xueyuan_lv= (ListView) view.findViewById(R.id.xueyuan_lv);
        mAdapter=new XueYuanAdapter(mList,getActivity());
        xueyuan_lv.setDivider(null);
        xueyuan_lv.setAdapter(mAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        final ProgressDialog dialog=ProgressDialog.show(getActivity(),"学院界面","加载ing.......");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mData=gson.fromJson(s,XueYuanData.DataBean.class);
                        ArrayList<XueYuanData.DataBean.ResultBean> list = (ArrayList<XueYuanData.DataBean.ResultBean>) mData.getResult();
                        mList.addAll(list);
                        Log.e("学院","我说成功您信吗");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("学院","加载失败");
                        dialog.dismiss();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("title","EIA公布在即");
                return map;
            }
        };
        requestQueue.add(request);
    }
    private void finishActivity(){
        this.finishActivity();
    }
}
