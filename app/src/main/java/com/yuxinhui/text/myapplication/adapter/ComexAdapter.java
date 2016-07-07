package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.ComexData;

import java.util.List;

/**
 * 包:com.yuxinhui.text.myapplication.adapter
 * Create By:"于志渊"
 * 时间:22:40
 * 描述:在行情界面显示comex的适配器
 */
public class ComexAdapter extends BaseAdapter {
    private List<ComexData> datas;
    private Context context;

    public ComexAdapter(List<ComexData> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (datas!=null){
            return datas.size();
        }
        return 0;
    }

    @Override
    public ComexData getItem(int position) {
        if (datas!=null){
            return datas.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHodle holder;
        if (convertView==null){
            holder=new viewHodle();
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.hangqing_item,null);
            holder.name= (TextView) convertView.findViewById(R.id.name);
            holder.newPrice= (TextView) convertView.findViewById(R.id.newPrice);
            holder.changePercent= (TextView) convertView.findViewById(R.id.changePercent);
            holder.time= (TextView) convertView.findViewById(R.id.uptime);
            holder.low= (TextView) convertView.findViewById(R.id.low);
            holder.high= (TextView) convertView.findViewById(R.id.high);
            convertView.setTag(holder);
        }else {
            holder= (viewHodle) convertView.getTag();
        }
        ComexData data = getItem(position);
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
