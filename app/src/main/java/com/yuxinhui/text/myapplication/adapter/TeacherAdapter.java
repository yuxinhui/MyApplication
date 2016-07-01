package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.TeachData;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"10:47"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:这个类是显示老师页面的ListView的适配器。
 */
public class TeacherAdapter extends BaseAdapter {
    private ArrayList<TeachData.DataBean> mTeacherList=new ArrayList<TeachData.DataBean>();
    private Context mContext;

    public TeacherAdapter(ArrayList<TeachData.DataBean> mTeacherList, Context mContext) {
        this.mTeacherList = mTeacherList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mTeacherList.size();
    }

    @Override
    public TeachData.DataBean getItem(int position) {
        return mTeacherList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodle viewHodle;
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(mContext);
            convertView=inflater.inflate(R.layout.teacher_item,null);
        }
        viewHodle=new ViewHodle();
        viewHodle.teacher_context= (TextView) convertView.findViewById(R.id.teacher_context);
        TeachData.DataBean teachData= getItem(position);
//        viewHodle.teacher_head.
        viewHodle.teacher_context.setText(teachData.getContent());
        return convertView;
    }
    /**存放控件*/
    public class ViewHodle{
        public TextView teacher_context;
    }
}
