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
import com.yuxinhui.text.myapplication.Utils.ShangHaiJinData;
import com.yuxinhui.text.myapplication.adapter.ShangHaiJinAdapter;

import java.util.ArrayList;

/**
 * 包:com.yuxinhui.text.myapplication.Actiity
 * Create By:"于志渊"
 * 时间:23:11
 * 描述:上海金详情
 */
public class ShangHaiJinActivity extends AppCompatActivity {
    private ListView shanghaijin_lv;
    private String url="http://pull.api.fxgold.com/realtime/products?codes=SGAuT+D,SGAgT+D,SGmAuT+D,SGAu100g,SGAu9999,SGiAu9999,SGAu9995,SGiAu100g,SGPT9995";
    private ShangHaiJinAdapter mAdapter;
    private ShangHaiJinData mData=new ShangHaiJinData();
    private ArrayList<ShangHaiJinData.Data> mList=new ArrayList<ShangHaiJinData.Data>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shanghaijin);
        initData();
        initView();
    }

    private void initView() {
        shanghaijin_lv= (ListView) findViewById(R.id.comex_lv);
        mAdapter=new ShangHaiJinAdapter(mList,ShangHaiJinActivity.this);
        shanghaijin_lv.setDivider(null);
        shanghaijin_lv.setAdapter(mAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"上海金","加载ing.........");
        StringRequest request=new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mData=gson.fromJson(s,ShangHaiJinData.class);
                        ArrayList<ShangHaiJinData.Data> list = (ArrayList<ShangHaiJinData.Data>) mData.getDatas();
                        mList.addAll(list);
                        mAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("上海金","加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
