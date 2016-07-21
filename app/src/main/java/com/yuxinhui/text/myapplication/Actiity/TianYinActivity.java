package com.yuxinhui.text.myapplication.Actiity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.yuxinhui.text.myapplication.Bean.TianTongYinData;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.DialogUtils;
import com.yuxinhui.text.myapplication.adapter.TianTongYinAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"15:30"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:
 */
public class TianYinActivity extends Fragment {
    private ListView tiantongyin_lv;
    private TianTongYinAdapter mTianTongYinAdapter;
    private ArrayList<TianTongYinData> mTianTongYinDatas = new ArrayList<TianTongYinData>();
    private String urlTianTong = "http://pull.api.fxgold.com/realtime/products?codes=TJAG,TJMAG,TJAP,TJMAP,TJAG30KG,TJNI,TJMPD,TJPD,TJMNI,TJCU,TJCU1T,TJAL,TJAL1T";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tiantongyin, null);
        initView(view);
        initTianTongData();
        return view;
    }
    private void initView(View view) {
        tiantongyin_lv= (ListView) view.findViewById(R.id.tiantongyin_lv);
        mTianTongYinAdapter=new TianTongYinAdapter(mTianTongYinDatas,getActivity());
        tiantongyin_lv.setAdapter(mTianTongYinAdapter);
    }
    private void initTianTongData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        final ProgressDialog dialog = ProgressDialog.show(getActivity(), "天通银", "加载ing.........");
        StringRequest request = new StringRequest(Request.Method.GET,
                urlTianTong,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson = new Gson();
                        ArrayList<TianTongYinData> list = gson.fromJson(s, new TypeToken<ArrayList<TianTongYinData>>() {
                        }.getType());
                        mTianTongYinAdapter.initList(list);
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        DialogUtils.createToasdt(getActivity(),"天通银加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
