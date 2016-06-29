package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.ShangHaiJinData;

import java.util.List;

/**
 * 包:com.yuxinhui.text.myapplication.adapter
 * Create By:"于志渊"
 * 时间:23:06
 * 描述:在行情界面显示上海金的适配器
 */
public class ShangHaiJinAdapter extends BaseAdapter {
    private List<ShangHaiJinData> list;
    private Context context;

    public ShangHaiJinAdapter(List<ShangHaiJinData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ShangHaiJinData getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHodle holder=new viewHodle();
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.hangqing_item,null);
        }
        holder.name= (TextView) convertView.findViewById(R.id.name);
        holder.newPrice= (TextView) convertView.findViewById(R.id.newPrice);
        holder.changePercent= (TextView) convertView.findViewById(R.id.changePercent);
        holder.time= (TextView) convertView.findViewById(R.id.uptime);
        holder.low= (TextView) convertView.findViewById(R.id.low);
        holder.high= (TextView) convertView.findViewById(R.id.high);
        ShangHaiJinData data = getItem(position);
        holder.name.setText(data.getName());
        holder.newPrice.setText(data.getNewPrice()+"");
        holder.changePercent.setText(data.getChangePercent()+"");
        holder.time.setText(data.getTime()+"");
        holder.low.setText(data.getLow()+"");
        holder.high.setText(data.getHigh()+"");
        return convertView;
    }
    private class viewHodle{
        private TextView name,newPrice,changePercent,time,low,high;
    }
}