package com.yuxinhui.text.myapplication.Actiity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.XianHuoHuangJinData;
import com.yuxinhui.text.myapplication.adapter.XianHuoHuangJinAdapter;

import java.util.ArrayList;

/**
 * 包:com.yuxinhui.text.myapplication.Actiity
 * Create By:"于志渊"
 * 22:19
 * 描述:现货黄金详情
 */
public class XianHuoHuangJinActivity extends AppCompatActivity {
    private XianHuoHuangJinAdapter mAdapter;
    private XianHuoHuangJinData mData=new XianHuoHuangJinData();
    private ArrayList<XianHuoHuangJinData> mList=new ArrayList<XianHuoHuangJinData>();
    private ListView xianhuojin_lv;
    private String url="http://pull.api.fxgold.com/realtime/products?codes=OSTWGD,PMHKAUJC,PMHKAUYH,OSCNYAUG,OSCNYAGG,PMAU,PMAG,PMAP,PMPD,PMHKAULD,PMHKAGLD,OSHKG";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xianhuohuangjin);
        initData();
        initView();
    }

    private void initView() {
        xianhuojin_lv= (ListView) findViewById(R.id.xianhuojin_lv);
        mAdapter=new XianHuoHuangJinAdapter(mList,XianHuoHuangJinActivity.this);
        xianhuojin_lv.setDivider(null);
        xianhuojin_lv.setAdapter(mAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog=ProgressDialog.show(this,"现货黄金","加载ing>>>>>>>>");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mData = gson.fromJson(s, XianHuoHuangJinData.class);
                        ArrayList<XianHuoHuangJinData> list = (ArrayList<XianHuoHuangJinData>) mData.getmDatas();
                        mList.addAll(list);
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("现货黄金","加载失败");
                        progressDialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
