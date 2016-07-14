package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.LondonJinData;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 包:com.yuxinhui.text.myapplication.adapter
 * Create By:"于志渊"
 * 时间:23:22
 * 描述:在行情界面显示伦敦金属的适配器
 */
public class LonDonJinAdapter extends BaseAdapter {
    private List<LondonJinData> mList;
    private Context context;

    public LonDonJinAdapter(List<LondonJinData> mList, Context context) {
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
    public LondonJinData getItem(int position) {
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
        LondonJinData data = getItem(position);
        holder.name.setText(data.getName());
        holder.newPrice.setText(data.getNewPrice()+"");
        double v = data.getChangePercent() * 100;
        DecimalFormat df=new DecimalFormat("#0.00");
        holder.changePercent.setText(df.format(v)+"%");
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        String format = sdf.format(new Date(data.getTime()));
        holder.time.setText(format);
        holder.low.setText(data.getLow()+"");
        holder.high.setText(data.getHigh()+"");
        return convertView;
    }
    private class viewHolder{
        private TextView name,newPrice,changePercent,time,low,high;
    }
}
