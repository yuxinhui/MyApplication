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
import com.yuxinhui.text.myapplication.Utils.TianTongYinData;
import com.yuxinhui.text.myapplication.adapter.TianTongYinAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 包:com.yuxinhui.text.myapplication.Actiity
 * Create By:"于志渊"
 * 时间:23:43
 * 描述:天通银详情
 */
public class TianTongYinActivity extends AppCompatActivity {
    private ListView tiantongyin_lv;
    private String url="http://pull.api.fxgold.com/realtime/products?codes=TJAG,TJMAG,TJAP,TJMAP,TJAG30KG,TJNI,TJMPD,TJPD,TJMNI,TJCU,TJCU1T,TJAL,TJAL1T";
    private TianTongYinAdapter mAdapter;
    private TianTongYinData mData=new TianTongYinData();
    private ArrayList<TianTongYinData> mList=new ArrayList<TianTongYinData>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiantongyin);
        initData();
        initView();
    }

    private void initView() {
        tiantongyin_lv= (ListView) findViewById(R.id.londonjin_lv);
        mAdapter=new TianTongYinAdapter(mList,TianTongYinActivity.this);
        tiantongyin_lv.setDivider(null);
        tiantongyin_lv.setAdapter(mAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"天通银","加载ing.........");
        StringRequest request=new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mData=gson.fromJson(s,TianTongYinData.class);
                        List<TianTongYinData> list = mData.getDatas();
                        mList.addAll(list);
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("天通银","加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
