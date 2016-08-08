package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.yuxinhui.text.myapplication.Bean.TeachData;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.RequestManager;

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
        if (mTeacherList!=null){
            return mTeacherList.size();
        }
        return 0;
    }

    @Override
    public TeachData.DataBean getItem(int position) {
        if (mTeacherList!=null){
            return mTeacherList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHodle viewHodle;
        if (convertView==null){
            viewHodle=new ViewHodle();
            LayoutInflater inflater=LayoutInflater.from(mContext);
            convertView=inflater.inflate(R.layout.teacher_item,null);
            viewHodle.teacher_context= (TextView) convertView.findViewById(R.id.teacher_context);
            viewHodle.teacher_name= (TextView) convertView.findViewById(R.id.teacher_name);
            viewHodle.teacher_head= (NetworkImageView) convertView.findViewById(R.id.teacher_head);
            convertView.setTag(viewHodle);
        }else {
            viewHodle= (ViewHodle) convertView.getTag();
        }
        final TeachData.DataBean teachData= getItem(position);
        viewHodle.teacher_name.setText(teachData.getAnalystName());
        viewHodle.teacher_context.setText(teachData.getContent());
        RequestManager.init(mContext);
        viewHodle.teacher_head.setImageUrl(teachData.getPic(), RequestManager.getImageLoader());
        return convertView;
    }
    /**存放控件*/
    public class ViewHodle{
        public TextView teacher_context,teacher_name;
        NetworkImageView teacher_head;
    }
}
