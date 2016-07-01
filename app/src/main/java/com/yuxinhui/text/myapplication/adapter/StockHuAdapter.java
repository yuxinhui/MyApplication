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
 * 描述:沪股票的详情适配器
 */
public class StockHuAdapter extends BaseAdapter {
    private List<GuPiaoHuData.DataBean.DataBean1> mList;
    private Context context;

    public StockHuAdapter(List<GuPiaoHuData.DataBean.DataBean1> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public GuPiaoHuData.DataBean.DataBean1 getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder=new viewHolder();
        if (convertView==null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.stock_item,null);
        }
        holder.stock_name= (TextView) convertView.findViewById(R.id.stock_name);
        holder.symbol= (TextView) convertView.findViewById(R.id.symbol);
        holder.amount= (TextView) convertView.findViewById(R.id.amount);
        holder.pricechange= (TextView) convertView.findViewById(R.id.pricechange);
        holder.changepercent= (TextView) convertView.findViewById(R.id.changePercent);
        holder.sell= (TextView) convertView.findViewById(R.id.sell);
        holder.volume= (TextView) convertView.findViewById(R.id.volume);
        holder.settlement= (TextView) convertView.findViewById(R.id.settlement);
        GuPiaoHuData.DataBean.DataBean1 bean1 = getItem(position);
        holder.stock_name.setText(bean1.getName());
        holder.symbol.setText(bean1.getSymbol());
        holder.amount.setText(bean1.getAmount());
        holder.pricechange.setText(bean1.getPricechange());
        holder.changepercent.setText(bean1.getChangepercent());
        holder.sell.setText(bean1.getSell());
        holder.volume.setText(bean1.getVolume());
        holder.settlement.setText(bean1.getSettlement());
        return convertView;
    }
    public class viewHolder{
        private TextView stock_name,symbol,amount,pricechange,changepercent,sell,volume,settlement;
    }
}
