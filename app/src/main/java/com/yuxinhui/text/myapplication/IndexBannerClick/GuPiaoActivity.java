package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
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
import com.yuxinhui.text.myapplication.Utils.GuPiaoHuData;
import com.yuxinhui.text.myapplication.adapter.StockHuAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/15.
 */
public class GuPiaoActivity extends Activity{
    private StockHuAdapter mHuAdapter;
    private GuPiaoHuData.DataBean dataBean1=new GuPiaoHuData.DataBean();
    private ArrayList<GuPiaoHuData.DataBean.DataBean1> mBean1ArrayList=new ArrayList<GuPiaoHuData.DataBean.DataBean1>();
    private String url="http://114.55.98.142/app/getShareList?name=sh&shpage=1&type=1";
    private ListView stock_lv;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.gupiao_activity);
        initData();
        initView();
    }

    private void initView() {
        stock_lv= (ListView) findViewById(R.id.stock_lv);
        mHuAdapter=new StockHuAdapter(mBean1ArrayList,GuPiaoActivity.this);
        stock_lv.setDivider(null);
        stock_lv.setAdapter(mHuAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(GuPiaoActivity.this);
        final ProgressDialog progressDialog=ProgressDialog.show(GuPiaoActivity.this,"沪股界面","正在走心加载ing");
        StringRequest request=new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        dataBean1=gson.fromJson(s,GuPiaoHuData.DataBean.class);
                        ArrayList<GuPiaoHuData.DataBean.DataBean1> data = (ArrayList<GuPiaoHuData.DataBean.DataBean1>) dataBean1.getData();
                        mBean1ArrayList.addAll(data);
                        Log.e("沪股","消息加载成功");
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("沪股","失败ing");
                        progressDialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
