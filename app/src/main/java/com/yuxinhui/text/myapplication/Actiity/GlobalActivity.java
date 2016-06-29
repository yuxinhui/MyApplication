package com.yuxinhui.text.myapplication.Actiity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.GlobalCurrencyData;
import com.yuxinhui.text.myapplication.adapter.GlobalAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"16:34"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:全球外汇详情
 */
public class GlobalActivity extends AppCompatActivity {
    private GlobalAdapter mGlobalAdapter;
    private GlobalCurrencyData mCurrencyData=new GlobalCurrencyData();
    private ArrayList<GlobalCurrencyData> mArrayList=new ArrayList<GlobalCurrencyData>();
    private ListView global_lv;
    private String url="http://pull.api.fxgold.com/realtime/products?codes=IXFXEURUSD,IXFXAUDUSD,IXFXGBPCHF,IXFXUSDJPY,IXFXGBPUSD,IXFXUSDCHF,IXFXUSDCAD,IXFXEURGBP,IXFXEURJPY,IXFXEURCHF,IXEAINUDI,IXFXNZDUSD,IXFXAUDJPY,IXFXEURAUD,IXFXUSDHKD,IXFXGBPJPY,IXFXUSDTWD,IXFXEURCAD,IXFXUSDCNY,IXFXAUDNZD,IXFXAUDCNY,IXFXGBPAUD,IXFXAUDCAD,IXFXGBPCHF,IXFXUSDKRW,IXFXGBPCAD";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_globalcurrency);
        initData();
        initView();
    }
    private void initView() {
        global_lv= (ListView) findViewById(R.id.global_lv);
        mGlobalAdapter=new GlobalAdapter(mArrayList,GlobalActivity.this);
        global_lv.setDivider(null);
        global_lv.setAdapter(mGlobalAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog=ProgressDialog.show(this,"全球外汇","加载中》》》》》》");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mCurrencyData = gson.fromJson(s, GlobalCurrencyData.class);
                        List<GlobalCurrencyData> list = mCurrencyData.getDatas();
                        mArrayList.addAll(list);

                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(GlobalActivity.this,"失败。。。",Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }
        );
        Log.e("全球外汇",mArrayList.get(1).toString());
        requestQueue.add(request);
    }
}
