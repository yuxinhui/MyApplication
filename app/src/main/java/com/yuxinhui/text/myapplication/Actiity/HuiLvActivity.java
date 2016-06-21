package com.yuxinhui.text.myapplication.Actiity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.HuiLv;
import com.yuxinhui.text.myapplication.Utils.HuiLvData;
import com.yuxinhui.text.myapplication.adapter.HuiLvAdapter;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * create by "徐路路"
 * 主要用于显示汇率页面
 */
public class HuiLvActivity extends AppCompatActivity {
    HuiLvAdapter mAdapter;
    HuiLv mHuiLv;
    ArrayList<HuiLvData> mList;
    ListView mData;
    String url = "http://cer.nineton.cn/get_bank_rate/BC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huilv);
        InitDate();
        InitView();
    }

    private void InitDate() {
        getJSONByVolley();
        Log.i("main",mList.get(1).toString());
    }

    private void InitView() {
        mData = (ListView) findViewById(R.id.data);
        mAdapter = new HuiLvAdapter(mList,this);
        mData.setAdapter(mAdapter);
    }

    /**
     * 有错误，需要修改。下载下来的数据为空。回去查阅资料后修改。
     */
    private void getJSONByVolley() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog = ProgressDialog.show(this, "加载汇率", "加载中...");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String json = response.toString();
                        Gson gson  = new Gson();
                        mHuiLv = gson.fromJson(json,HuiLv.class);
                        mList = mHuiLv.getData();
                        Log.i("main","下载成功");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError arg0) {
                        Log.i("main","下载失败");
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }


}
