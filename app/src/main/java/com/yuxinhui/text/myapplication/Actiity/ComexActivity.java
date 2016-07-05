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
import com.yuxinhui.text.myapplication.Utils.ComexData;
import com.yuxinhui.text.myapplication.adapter.ComexAdapter;

import java.util.ArrayList;

/**
 * 包:com.yuxinhui.text.myapplication.Actiity
 * Create By:"于志渊"
 * 时间:22:47
 * 描述:COMEX详情
 */
public class ComexActivity extends AppCompatActivity {
    private ListView comex_lv;
    private String url="http://pull.api.fxgold.com/realtime/products?codes=IXCMGCA0,CMGCG0,CMGCJ0,CMGCK0,CMGCM0,CMGCQ0,CMGCV0,CMGCZ0,IXCMSIA0,CMSIF0,CMSIH0,CMSIJ0,CMSIK0,CMSIM0,CMSIN0,CMSIU0,CMSIZ0,IXNEPAA0,IXNEPAH0,IXNEPAZ0,IXNEPAM0,IXNEPAU0,IXNEPLA0,IXNEPLF0,IXNEPLJ0,IXNEPLN0,IXNEPLV0,IXNEPLJ0";
    private ComexAdapter mAdapter;
    private ComexData mData=new ComexData();
    private ArrayList<ComexData> mList=new ArrayList<ComexData>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comex);
        initData();
        initView();
    }

    private void initView() {
        comex_lv= (ListView) findViewById(R.id.comex_lv);
        mAdapter=new ComexAdapter(mList,ComexActivity.this);
        comex_lv.setDivider(null);
        comex_lv.setAdapter(mAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"COMEX","加载ing.........");
        StringRequest request=new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mData=gson.fromJson(s,ComexData.class);
                        ArrayList<ComexData> list = (ArrayList<ComexData>) mData.getComexDatas();
                        mList.addAll(list);
                        mAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("COMEX","加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
