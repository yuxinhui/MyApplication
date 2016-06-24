package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import com.yuxinhui.text.myapplication.Utils.TeachData;
import com.yuxinhui.text.myapplication.adapter.TeacherAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"10:47"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerClick
 * 描述:显示老师界面
 */
public class LaoShiActivity extends AppCompatActivity{
    private TeacherAdapter teacherAdapter;
    private List<TeachData.DataBean> mTeachDatas=new ArrayList<TeachData.DataBean>();
    private TeachData teachData;
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
        getJSONByVeolly();
        Log.i("teacher", mTeachDatas.get(1).toString());
    }

    private void initView() {
        teacher_lv= (ListView) findViewById(R.id.teacher_lv);
        teacherAdapter=new TeacherAdapter(mTeachDatas,this);
        teacher_lv.setAdapter(teacherAdapter);
    }

    public void getJSONByVeolly() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog = ProgressDialog.show(this, "老师界面", "加载ing>>>>");
        JsonObjectRequest mJsonObjectRequest=new JsonObjectRequest(
                Request.Method.POST,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        String json = jsonObject.toString();
                        Gson gson=new Gson();
                        teachData=gson.fromJson(json,teachData.getClass());
                        mTeachDatas=teachData.getData();
                        Log.i("teacher","下载成功");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.i("teacher","下载失败哈");
                    }
                }
        );
        requestQueue.add(mJsonObjectRequest);
    }
}
