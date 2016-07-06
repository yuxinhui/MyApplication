package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.KeBiaoData;
import com.yuxinhui.text.myapplication.adapter.CurriculumAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"10:23"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerClick
 * 描述:课程表显示界面
 */
public class KeBiaoActivity extends Activity{
    private String url="http://114.55.98.142/course/select_app";
    private ListView curriculum_lv;
    private KeBiaoData mData=new KeBiaoData();
    private ArrayList<KeBiaoData.DataBean> mList=new ArrayList<KeBiaoData.DataBean>();
    private CurriculumAdapter mAdapter;
    private ImageView curriculum_return_img;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_curriculum);
        initData();
        initView();
    }

    private void initView() {
        curriculum_return_img= (ImageView) findViewById(R.id.curriculum_return_img);
        curriculum_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(KeBiaoActivity.this, MainActivity.class);
                startActivity(intent);
                finishActivity();
            }
        });
        curriculum_lv= (ListView) findViewById(R.id.curriculum_lv);
        mAdapter=new CurriculumAdapter(mList,KeBiaoActivity.this);
        curriculum_lv.setDivider(null);
        curriculum_lv.setAdapter(mAdapter);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"课程表","努力加载》》》》");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mData = gson.fromJson(s, KeBiaoData.class);
                        ArrayList<KeBiaoData.DataBean> data = (ArrayList<KeBiaoData.DataBean>) mData.getData();
                        mList.addAll(data);
                        mAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("课表","加载成功");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
    private void finishActivity(){
        this.finish();
    }
}
