package com.yuxinhui.text.myapplication.Actiity;

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
import com.yuxinhui.text.myapplication.Bean.ComexData;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.adapter.ComexAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"14:49"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:
 */
public class CmoexActivity extends Fragment {
    private ListView comex_lv;
    private ComexAdapter mComexAdapter;
    private ArrayList<ComexData> mComexDatas = new ArrayList<ComexData>();
    private String urlComex = "http://pull.api.fxgold.com/realtime/products?codes=IXCMGCA0,CMGCG0,CMGCJ0,CMGCK0,CMGCM0,CMGCQ0,CMGCV0,CMGCZ0,IXCMSIA0,CMSIF0,CMSIH0,CMSIJ0,CMSIK0,CMSIM0,CMSIN0,CMSIU0,CMSIZ0,IXNEPAA0,IXNEPAH0,IXNEPAZ0,IXNEPAM0,IXNEPAU0,IXNEPLA0,IXNEPLF0,IXNEPLJ0,IXNEPLN0,IXNEPLV0,IXNEPLJ0";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_comex, null);
        initComexData();
        initView(view);
        return view;
    }
    private void initView(View view) {
        comex_lv= (ListView) view.findViewById(R.id.comex_lv);
        mComexAdapter=new ComexAdapter(mComexDatas,getActivity());
        comex_lv.setAdapter(mComexAdapter);
    }
    private void initComexData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET,
                urlComex,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson = new Gson();
                        ArrayList<ComexData> list = gson.fromJson(s, new TypeToken<ArrayList<ComexData>>() {
                        }.getType());
                        mComexAdapter.initList(list);
                        Log.e("COMEX", "加载成功");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("COMEX", "加载失败");
                    }
                }
        );
        requestQueue.add(request);
    }


}
