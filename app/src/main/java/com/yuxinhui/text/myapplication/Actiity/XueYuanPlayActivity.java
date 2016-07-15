package com.yuxinhui.text.myapplication.Actiity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.XueYuanData;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"10:14"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:学院item点击播放
 */
public class XueYuanPlayActivity extends AppCompatActivity {
    private VideoView mVideoView;
    private XueYuanData mXueYuanData=new XueYuanData();
    private String urlXueYuan= "http://114.55.98.142/video/selectVideo?pageNo=1";
    private Uri uri=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xueyuan_play);
        initUrl();
        mVideoView= (VideoView) findViewById(R.id.xueyuan_video);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setVideoURI(uri);
        mVideoView.start();
        mVideoView.requestFocus();
    }

    private void initUrl() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.GET, urlXueYuan,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mXueYuanData=gson.fromJson(s,XueYuanData.class);
                        List<XueYuanData.DataBean.ResultBean> result = mXueYuanData.getData().getResult();
                        String s1 = result.get(3).toString();
                        Log.e("huai",s1);
                        uri=Uri.parse(s1);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(request);
    }
}
