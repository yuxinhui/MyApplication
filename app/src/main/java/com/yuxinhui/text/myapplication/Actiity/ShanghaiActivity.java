package com.yuxinhui.text.myapplication.Actiity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.ShangHaiJinData;
import com.yuxinhui.text.myapplication.adapter.ShangHaiJinAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"14:55"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:
 */
public class ShanghaiActivity extends Fragment {
    private ListView shanghaijin_lv;
    private ShangHaiJinAdapter mShangHaiJinAdapter;
    private ArrayList<ShangHaiJinData> mShangHaiJinDatas = new ArrayList<ShangHaiJinData>();
    private String urlShangHai = "http://pull.api.fxgold.com/realtime/products?codes=SGAuT+D,SGAgT+D,SGmAuT+D,SGAu100g,SGAu9999,SGiAu9999,SGAu9995,SGiAu100g,SGPT9995";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shanghaijin, null);
        initView(view);
        initShangHaiData();
        return view;
    }
    private void initView(View view) {
        shanghaijin_lv= (ListView) view.findViewById(R.id.shanghaijin_lv);
        mShangHaiJinAdapter=new ShangHaiJinAdapter(mShangHaiJinDatas,getActivity());
        shanghaijin_lv.setAdapter(mShangHaiJinAdapter);
    }
    private void initShangHaiData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        final ProgressDialog dialog = ProgressDialog.show(getActivity(), "上海金", "加载ing.........");
        StringRequest request = new StringRequest(Request.Method.GET,
                urlShangHai,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson = new Gson();
                        ArrayList<ShangHaiJinData> list = gson.fromJson(s, new TypeToken<ArrayList<ShangHaiJinData>>() {
                        }.getType());
                        mShangHaiJinDatas.addAll(list);
                        mShangHaiJinAdapter.notifyDataSetChanged();
                        Log.e("上海金", "加载成功");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("上海金", "加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
