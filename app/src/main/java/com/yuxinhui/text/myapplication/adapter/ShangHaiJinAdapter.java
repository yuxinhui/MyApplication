package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.Bean.ShangHaiJinData;
import com.yuxinhui.text.myapplication.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public void initList(ArrayList<ShangHaiJinData> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    @Override
    public ShangHaiJinData getItem(int position) {
        if (list!=null){
            return list.get(position);
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
        ShangHaiJinData data = getItem(position);
        /*try {
            holder.name.setText(new String(data.getName().getBytes("ISO-8859-1"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        holder.name.setText(data.getName());
        holder.newPrice.setText(data.getNewPrice()+"");
        double v = data.getChangePercent() * 100;
        int textColor;
        if(v<0){
            textColor = Color.rgb(64, 205, 157);
        }else {
            textColor = Color.rgb(247, 90, 88);
        }
        holder.changePercent.setTextColor(textColor);
        holder.newPrice.setTextColor(textColor);
        DecimalFormat df=new DecimalFormat("#0.00");
        holder.changePercent.setText(df.format(v)+"%");
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        String format = sdf.format(new Date(data.getTime()));
        holder.time.setText(format);
        holder.low.setText(data.getLow()+"");
        holder.high.setText(data.getHigh()+"");
        return convertView;
    }
    private class viewHodle{
        private TextView name,newPrice,changePercent,time,low,high;
    }
}
