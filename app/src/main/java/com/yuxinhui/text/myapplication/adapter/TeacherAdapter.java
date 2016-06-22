package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.TeachData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"10:47"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:这个类是显示老师页面的ListView的适配器。
 */
public class TeacherAdapter extends BaseAdapter {
    private List<TeachData.DataBean> mTeacherList=new ArrayList<TeachData.DataBean>();
    private Context mContext;

    public TeacherAdapter(List<TeachData.DataBean> mTeacherList, Context mContext) {
        this.mTeacherList = mTeacherList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mTeacherList.size();
    }

    @Override
    public Object getItem(int position) {
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
        viewHodle.teacher_head= (ImageView) convertView.findViewById(R.id.teacher_head);
        viewHodle.teacher_name= (TextView) convertView.findViewById(R.id.teacher_name);
        viewHodle.teacher_context= (TextView) convertView.findViewById(R.id.teacher_context);
        TeachData.DataBean teachData= (TeachData.DataBean) getItem(position);
        //viewHodle.teacher_head.setImageTintList(teachData.getPic());
        viewHodle.teacher_name.setText(teachData.getAnalystName());
        viewHodle.teacher_context.setText(teachData.getContent());
        return convertView;
    }
    /**存放控件*/
    public final class ViewHodle{
        public ImageView teacher_head;
        public TextView teacher_name,teacher_context;
    }
}
