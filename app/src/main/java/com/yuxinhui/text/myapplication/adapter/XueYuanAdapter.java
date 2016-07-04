package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.XueYuanData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"10:02"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:学院界面的适配器
 */
public class XueYuanAdapter extends BaseAdapter {
    private List<XueYuanData.DataBean.ResultBean> mList=new ArrayList<XueYuanData.DataBean.ResultBean>();
    private Context context;

    public XueYuanAdapter(List<XueYuanData.DataBean.ResultBean> mList, Context context) {
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
    public XueYuanData.DataBean.ResultBean getItem(int position) {
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
            convertView= inflater.inflate(R.layout.xueyuan_item, null);
            holder.xueyuan_title= (TextView) convertView.findViewById(R.id.xueyuan_title);
            holder.bofang= (TextView) convertView.findViewById(R.id.bofang);
            holder.author= (TextView) convertView.findViewById(R.id.author);
            holder.content= (TextView) convertView.findViewById(R.id.content);
            holder.xueyuan_time= (TextView) convertView.findViewById(R.id.xueyuan_time);
            convertView.setTag(holder);
        }else {
            holder= (viewHolder) convertView.getTag();
        }
        XueYuanData.DataBean.ResultBean bean = getItem(position);
        holder.bofang.setText(bean.getUrl());
        holder.xueyuan_title.setText(bean.getTitle());
        holder.content.setText(bean.getContent());
        holder.author.setText(bean.getAuthor());
        holder.xueyuan_time.setText(bean.getTime()+"");
        return convertView;
    }
    public class viewHolder{
        private TextView bofang,xueyuan_title,content,author,xueyuan_time;
    }
}
