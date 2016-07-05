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
import com.yuxinhui.text.myapplication.Utils.LondonJinData;
import com.yuxinhui.text.myapplication.adapter.LonDonJinAdapter;

import java.util.ArrayList;

/**
 * 包:com.yuxinhui.text.myapplication.Actiity
 * Create By:"于志渊"
 * 时间:23:27
 * 描述:伦敦金属详情
 */
public class LonDonJinActivity extends AppCompatActivity {
    private ListView londonjin_lv;
    private String url="http://pull.api.fxgold.com/realtime/products?codes=IXLEAHD3M,IXLENID3M,IXLECAD3M,IXLENAD3M,IXLEPBD3M,IXLESND3M,LEAAD3M,LEAHD3M,LECAD3M,IXLEZSD3M,LEMOD3M,LENID3M,LEPBD3M,LECOD3M,LEZSD3M,LESND3M";
    private LonDonJinAdapter mAdapter;
    private LondonJinData mData=new LondonJinData();
    private ArrayList<LondonJinData> mList=new ArrayList<LondonJinData>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_londonmetal);
        initData();
        initView();
    }

    private void initView() {
        londonjin_lv= (ListView) findViewById(R.id.londonjin_lv);
        mAdapter=new LonDonJinAdapter(mList,LonDonJinActivity.this);
        londonjin_lv.setDivider(null);
        londonjin_lv.setAdapter(mAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"伦敦金属","加载ing.........");
        StringRequest request=new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mData=gson.fromJson(s,LondonJinData.class);
                        ArrayList<LondonJinData> list = (ArrayList<LondonJinData>) mData.getDatas();
                        mList.addAll(list);
                        mAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("伦敦金属","加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
