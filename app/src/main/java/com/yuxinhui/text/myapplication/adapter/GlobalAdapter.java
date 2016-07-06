package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.GlobalCurrencyData;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"15:49"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:在行情界面显示全球外汇的适配器
 */
public class GlobalAdapter extends BaseAdapter {
    private ArrayList<GlobalCurrencyData> mList=new ArrayList<GlobalCurrencyData>();
    private Context context;

    public GlobalAdapter(ArrayList<GlobalCurrencyData> mList, Context context) {
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
    public GlobalCurrencyData getItem(int position) {
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
            holder= (viewHolder) convertView.getTag();
        }
        GlobalCurrencyData data=getItem(position);
        holder.name.setText(data.getName());
        holder.newPrice.setText(data.getNewPrice()+" ");
        holder.changePercent.setText(data.getChangePercent()+" ");
        holder.time.setText(data.getTime()+" ");
        holder.low.setText(data.getLow()+" ");
        holder.high.setText(data.getHigh()+" ");
        return convertView;
    }
    public class viewHolder{
        private TextView name,newPrice,changePercent,time,low,high;
    }
}
