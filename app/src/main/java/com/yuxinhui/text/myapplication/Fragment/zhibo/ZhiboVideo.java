package com.yuxinhui.text.myapplication.Fragment.zhibo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.Bean.ZhiboVideoData;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"10:54"
 * 包名:com.yuxinhui.text.myapplication.Fragment.zhibo
 * 描述:直播在线人数
 */
public class ZhiboVideo extends Fragment {
    private ListView zhibo_video_lv;
    private ZhiboVideoData videoData=new ZhiboVideoData();
    private ArrayList<ZhiboVideoData.DataBean> mArrayList=new ArrayList<>();
    private ZhiboVideoAdapter videoAdapter;
    private String videoUrl= YuXinHuiApplication.URL_BOOT+"app_online?gid="+YuXinHuiApplication.getInstace().getUser().getId();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_zhibo_video,container,false);
        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        zhibo_video_lv= (ListView) view.findViewById(R.id.zhibo_video_lv);
        videoAdapter=new ZhiboVideoAdapter(mArrayList,getActivity());
        zhibo_video_lv.setDivider(null);
        zhibo_video_lv.setAdapter(videoAdapter);
    }

    private void initData() {
        RequestQueue requestQueue=Volley.newRequestQueue(getActivity());
        StringRequest request=new StringRequest(
                Request.Method.GET,
                videoUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.e("url",videoUrl);
                        Gson gson=new Gson();
                        videoData=gson.fromJson(s,ZhiboVideoData.class);
                        ArrayList<ZhiboVideoData.DataBean> been= (ArrayList<ZhiboVideoData.DataBean>) videoData.getData();
                        mArrayList.clear();
                        mArrayList.addAll(been);
                        videoAdapter.notifyDataSetChanged();
                        Log.e("video","成功");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("video","失败");
                    }
                }
        );
        requestQueue.add(request);
    }

    //在线人数适配器
    public class ZhiboVideoAdapter extends BaseAdapter{
        private ArrayList<ZhiboVideoData.DataBean> arrayList=new ArrayList<ZhiboVideoData.DataBean>();
        private LayoutInflater inflater;
        public ZhiboVideoAdapter(ArrayList<ZhiboVideoData.DataBean> arrayList, Context context) {
            super();
            this.arrayList = arrayList;
            inflater=LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            if (arrayList!=null){
                return arrayList.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (arrayList!=null){
                return arrayList.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            viewHolder holder;
            if (convertView==null){
                holder=new viewHolder();
                convertView=inflater.inflate(R.layout.zhibo_video_item,null);
                holder.nickname= (TextView) convertView.findViewById(R.id.nickname);
                holder.zhibo_video_gender= (ImageView) convertView.findViewById(R.id.zhibo_video_gender);
                convertView.setTag(holder);
            }else {
                holder= (viewHolder) convertView.getTag();
            }
            ZhiboVideoData.DataBean dataBean= (ZhiboVideoData.DataBean) getItem(position);
            holder.nickname.setText(dataBean.getNickname());
            String s=dataBean.getGender();
            if (s.equals("1")){
                holder.zhibo_video_gender.setImageResource(R.mipmap.zhibo_video_man);
            }else if (s.equals("0")){
                holder.zhibo_video_gender.setImageResource(R.mipmap.zhibo_video_woman);
            }
            return convertView;
        }
        class viewHolder{
            private TextView nickname;
            private ImageView zhibo_video_gender;
        }
    }
}
