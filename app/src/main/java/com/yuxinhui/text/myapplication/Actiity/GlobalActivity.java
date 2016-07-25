package com.yuxinhui.text.myapplication.Actiity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuxinhui.text.myapplication.Bean.GlobalCurrencyData;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.adapter.GlobalAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"14:03"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:
 */
public class GlobalActivity extends Fragment {
    private ListView global_lv;
    private String urlGlobal="http://pull.api.fxgold.com/realtime/products?codes=IXFXEURUSD,IXFXAUDUSD,IXFXGBPCHF,IXFXUSDJPY,IXFXGBPUSD,IXFXUSDCHF,IXFXUSDCAD,IXFXEURGBP,IXFXEURJPY,IXFXEURCHF,IXEAINUDI,IXFXNZDUSD,IXFXAUDJPY,IXFXEURAUD,IXFXUSDHKD,IXFXGBPJPY,IXFXUSDTWD,IXFXEURCAD,IXFXUSDCNY,IXFXAUDNZD,IXFXAUDCNY,IXFXGBPAUD,IXFXAUDCAD,IXFXGBPCHF,IXFXUSDKRW,IXFXGBPCAD";
    private GlobalAdapter mGlobalAdapter;
    private ArrayList<GlobalCurrencyData> mGlobalCurrencyDatas=new ArrayList<GlobalCurrencyData>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_globalcurrency, null);
        initGlobalData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        global_lv= (ListView) view.findViewById(R.id.global_lv);
        mGlobalAdapter=new GlobalAdapter(mGlobalCurrencyDatas,getActivity());
        global_lv.setAdapter(mGlobalAdapter);
    }

    private void initGlobalData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request=new StringRequest(
                Request.Method.GET,
                urlGlobal,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        ArrayList<GlobalCurrencyData> datas=gson.fromJson(s,new TypeToken<ArrayList<GlobalCurrencyData>>(){}.getType());
                        mGlobalAdapter.initList(datas);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getActivity(),"全球外汇加载失败",Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(request);
    }
}
