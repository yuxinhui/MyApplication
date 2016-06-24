package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import com.yuxinhui.text.myapplication.Utils.TeachData;
import com.yuxinhui.text.myapplication.adapter.TeacherAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"10:47"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerClick
 * 描述:显示老师界面
 */
public class LaoShiActivity extends AppCompatActivity{
    private ImageView teacher_return_img;
    private TeacherAdapter teacherAdapter;
    private ArrayList<TeachData.DataBean> mTeachDatas=new ArrayList<TeachData.DataBean>();
    private TeachData teachData=new TeachData();
    private ListView teacher_lv;
    private String url="http://114.55.98.142/analyst/select_app";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        initData();
        initView();
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog = ProgressDialog.show(this, "老师界面", "加载ing>>>>");
        StringRequest mJsonObjectRequest=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        teachData = gson.fromJson(s, TeachData.class);
                        ArrayList<TeachData.DataBean> list= (ArrayList<TeachData.DataBean>) teachData.getData();
                        mTeachDatas.addAll(list);
                        Log.i("laoshi","加载消息成功");
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.i("laoshi","失败喽，小伙子");
                        progressDialog.dismiss();
                    }
                });
        requestQueue.add(mJsonObjectRequest);
    }

    private void initView() {
        teacher_return_img= (ImageView) findViewById(R.id.teacher_return_img);
        teacher_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent=new Intent(LaoShiActivity.this, MainActivity.class);
                startActivity(mIntent);
            }
        });
        teacher_lv= (ListView) findViewById(R.id.teacher_lv);
        teacherAdapter=new TeacherAdapter(mTeachDatas,this);
        teacher_lv.setAdapter(teacherAdapter);
    }
}
