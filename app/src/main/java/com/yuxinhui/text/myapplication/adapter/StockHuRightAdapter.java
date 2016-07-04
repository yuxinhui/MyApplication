package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.GuPiaoHuData;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"15:46"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:沪股票的详情右侧导航栏适配器
 */
public class StockHuRightAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GuPiaoHuData.DataBean.Bean> mList;

    public StockHuRightAdapter(Context context, ArrayList<GuPiaoHuData.DataBean.Bean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        if (mList!=null){
            return mList.size();
        }
        return 0;
    }

    @Override
    public GuPiaoHuData.DataBean.Bean getItem(int position) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.stock_right_item,null);
            holder.right_item_textview0= (TextView) convertView.findViewById(R.id.right_item_textview0);
            holder.right_item_textview1= (TextView) convertView.findViewById(R.id.right_item_textview1);
            holder.right_item_textview2= (TextView) convertView.findViewById(R.id.right_item_textview2);
            holder.right_item_textview3= (TextView) convertView.findViewById(R.id.right_item_textview3);
            holder.right_item_textview4= (TextView) convertView.findViewById(R.id.right_item_textview4);
            holder.right_item_textview5= (TextView) convertView.findViewById(R.id.right_item_textview5);
            holder.right_item_textview6= (TextView) convertView.findViewById(R.id.right_item_textview6);
            convertView.setTag(holder);
        }else {
            holder= (viewHolder) convertView.getTag();
        }
        GuPiaoHuData.DataBean.Bean bean1=getItem(position);
        holder.right_item_textview0.setText(bean1.getSymbol());
        holder.right_item_textview1.setText(bean1.getAmount());
        holder.right_item_textview2.setText(bean1.getPricechange());
        holder.right_item_textview3.setText(bean1.getChangepercent());
        holder.right_item_textview4.setText(bean1.getSell());
        holder.right_item_textview5.setText(bean1.getVolume());
        holder.right_item_textview6.setText(bean1.getSettlement());
        return convertView;
    }
    public class viewHolder{
        private TextView right_item_textview0,right_item_textview1,right_item_textview2,right_item_textview3,right_item_textview4,right_item_textview5,right_item_textview6;
    }
}
