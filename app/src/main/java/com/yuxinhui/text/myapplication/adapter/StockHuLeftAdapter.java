package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.GuPiaoHuData;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"16:06"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:沪股票的详情左侧导航栏适配器
 */
public class StockHuLeftAdapter extends BaseAdapter {
    private List<GuPiaoHuData.DataBean.DataBean1> mList;
    private Context context;

    public StockHuLeftAdapter(List<GuPiaoHuData.DataBean.DataBean1> mList, Context context) {
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
    public GuPiaoHuData.DataBean.DataBean1 getItem(int position) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.stock_left_item,null);
            holder.left_container_textview0= (TextView) convertView.findViewById(R.id.left_container_textview0);
            convertView.setTag(holder);
        }else {
            holder= (viewHolder) convertView.getTag();
        }
        GuPiaoHuData.DataBean.DataBean1 bean1=getItem(position);
        holder.left_container_textview0.setText(bean1.getName());
        return convertView;
    }
    public class viewHolder{
        private TextView left_container_textview0;
    }
}
