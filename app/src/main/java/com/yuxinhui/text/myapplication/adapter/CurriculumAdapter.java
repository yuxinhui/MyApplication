package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.KeBiaoData;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"15:54"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:课程表的详情适配器
 */
public class CurriculumAdapter extends BaseAdapter {
    private List<KeBiaoData.DataBean> mList;
    private Context context;

    public CurriculumAdapter(List<KeBiaoData.DataBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (mList!=null){
            return mList.size();
        }
        return 0;
    }

    @Override
    public KeBiaoData.DataBean getItem(int position) {
        if (mList!=null){
            return mList.get(position);
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
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.curriculum_item,null);
            holder.mon= (TextView) convertView.findViewById(R.id.teacher_name_one);
            holder.tues= (TextView) convertView.findViewById(R.id.teacher_name_two);
            holder.wed= (TextView) convertView.findViewById(R.id.teacher_name_three);
            holder.thu= (TextView) convertView.findViewById(R.id.teacher_name_four);
            holder.fri= (TextView) convertView.findViewById(R.id.teacher_name_five);
            convertView.setTag(holder);
        }else {
            holder= (viewHolder) convertView.getTag();
        }
        KeBiaoData.DataBean dataBean=getItem(position);
        holder.mon.setText(dataBean.getMonday());
        holder.tues.setText(dataBean.getTuesday());
        holder.wed.setText(dataBean.getWednesday());
        holder.thu.setText(dataBean.getThursday());
        holder.fri.setText(dataBean.getFriday());
        return convertView;
    }
    public class viewHolder{
        private TextView mon,tues,wed,thu,fri;
    }
}
