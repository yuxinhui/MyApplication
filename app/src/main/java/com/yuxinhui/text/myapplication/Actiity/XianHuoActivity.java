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
import com.yuxinhui.text.myapplication.Bean.XianHuoHuangJinData;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.DialogUtils;
import com.yuxinhui.text.myapplication.adapter.XianHuoHuangJinAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"14:42"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:
 */
public class XianHuoActivity extends Fragment{
    private ListView xianhuojin_lv;
    private String urlXianHuo = "http://pull.api.fxgold.com/realtime/products?codes=OSTWGD,PMHKAUJC,PMHKAUYH,OSCNYAUG,OSCNYAGG,PMAU,PMAG,PMAP,PMPD,PMHKAULD,PMHKAGLD,OSHKG";
    private XianHuoHuangJinAdapter mXianHuoHuangJinAdapter;
    private ArrayList<XianHuoHuangJinData> mXianHuoHuangJinDatas = new ArrayList<XianHuoHuangJinData>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_xianhuohuangjin, null);
        initXianHuoJin();
        initView(view);
        return view;
    }

    private void initView(View view) {
        xianhuojin_lv= (ListView) view.findViewById(R.id.xianhuojin_lv);
        mXianHuoHuangJinAdapter=new XianHuoHuangJinAdapter(mXianHuoHuangJinDatas,getActivity());
        xianhuojin_lv.setAdapter(mXianHuoHuangJinAdapter);
    }
    private void initXianHuoJin() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "现货黄金", "加载ing>>>>>>>>");
        StringRequest request = new StringRequest(
                Request.Method.GET,
                urlXianHuo,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson = new Gson();
                        ArrayList<XianHuoHuangJinData> datas = gson.fromJson(s, new TypeToken<ArrayList<XianHuoHuangJinData>>() {
                        }.getType());
                        mXianHuoHuangJinAdapter.initList(datas);
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        DialogUtils.createToasdt(getActivity(),"现货黄金加载失败");
                        progressDialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
}
