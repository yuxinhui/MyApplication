package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.HuiLvData;
import com.yuxinhui.text.myapplication.adapter.HuiLvAdapter;


import java.util.ArrayList;

/**
 * create by "徐路路"
 * 主要用于显示汇率页面（Adapter有问题）
 */
public class HuiLvActivity extends AppCompatActivity {
    private ImageView mImageView;
    HuiLvAdapter mAdapter;
    HuiLvData mHuiLv;
    ArrayList<HuiLvData.DataBean> mList;
    ListView mData;
    String url = "http://cer.nineton.cn/get_bank_rate/BC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huilv);
        mHuiLv = new HuiLvData();
        mList = new ArrayList<>();
        InitDate();
        InitView();
    }

    private void InitDate() {
        getJSONByVolley();
//        Log.e("TAG", mList.get(1).toString());
    }

    private void InitView() {
        mImageView = (ImageView) findViewById(R.id.huilv_return_img);
        mData = (ListView) findViewById(R.id.data);
        mAdapter = new HuiLvAdapter(mList,this);
        mData.setAdapter(mAdapter);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HuiLvActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 下载有关汇率的数据
     */
    private void getJSONByVolley() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog = ProgressDialog.show(this, "加载汇率", "加载中...");


        StringRequest jsonObjectRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Log.e("TAG", response);
                        Gson gson  = new Gson();
                        mHuiLv = gson.fromJson(response,HuiLvData.class);
//                        Log.e("TAG",mHuiLv.toString());
                        ArrayList<HuiLvData.DataBean> list  = (ArrayList<HuiLvData.DataBean>) mHuiLv.getData();
//                        Log.e("TAG", list.get(1).toString());
                        mList.addAll(list);
//                        for(HuiLvData.DataBean db:mList){
//                            Log.e("TAG", db.toString());
//                        }
//                        Log.e("TAG","下载成功");
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError arg0) {
//                        Log.e("TAG","下载失败");
                        Toast.makeText(HuiLvActivity.this,"下载失败",Toast.LENGTH_LONG).show();//需要其他内容代替。暂由Toast显示。
                        progressDialog.dismiss();
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }


}
