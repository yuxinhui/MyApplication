package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.Bean.GlobalCurrencyData;
import com.yuxinhui.text.myapplication.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    public void initList(ArrayList<GlobalCurrencyData> list){
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
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
        double v =data.getChangePercent() * 100;
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
        long time = data.getTime();
        Date date=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        String format = sdf.format(date);
        holder.time.setText(format);
        holder.low.setText(data.getLow()+" ");
        holder.high.setText(data.getHigh()+" ");
        return convertView;
    }
    public class viewHolder{
        private TextView name,newPrice,changePercent,time,low,high;
    }
}
