package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.HuiLvData;

import java.util.ArrayList;

/**
 * Created by 徐路路 on 2016/6/21.
 * 这个类是显示汇率页面的ListView的适配器。
 */

public class HuiLvAdapter extends BaseAdapter{
    ArrayList<HuiLvData.DataBean> mList ;
    Context mContext;

    public HuiLvAdapter(ArrayList<HuiLvData.DataBean> list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        if (mList!=null){
            return mList.size();
        }
        return 0;
    }

    @Override
    public HuiLvData.DataBean getItem(int position) {
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
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_huilv,null);
            holder.currency = (TextView) convertView.findViewById(R.id.currency);
            holder.jydanwei = (TextView) convertView.findViewById(R.id.jydanwei);
            holder.cen_price = (TextView) convertView.findViewById(R.id.cen_price);
            holder.buy_price1 = (TextView) convertView.findViewById(R.id.buy_price1);
            holder.buy_price2 = (TextView) convertView.findViewById(R.id.buy_price2);
            holder.sell_price = (TextView) convertView.findViewById(R.id.sell_price);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        HuiLvData.DataBean data =  getItem(position);
        holder.currency.setText(data.getCurrency());
        holder.buy_price1.setText(data.getBuy_price1());
        holder.buy_price2.setText(data.getBuy_price2());
        holder.cen_price.setText(data.getCen_price());
        holder.jydanwei.setText("100");
        holder.sell_price.setText(data.getSell_price());
        return convertView;
    }

    class ViewHolder{
        TextView currency,jydanwei,cen_price,buy_price1,buy_price2,sell_price;
    }
}
