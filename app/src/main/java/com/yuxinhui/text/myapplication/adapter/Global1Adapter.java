/*
package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.GlobalCurrencyData;

import java.util.ArrayList;

*/
/**
 * Created by "于志渊"
 * 时间:"16:01"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:
 *//*

public class Global1Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<GlobalCurrencyData.dataBean> mList;
    private recyclerHolder recyclerHolder;

    public Global1Adapter(Context context, ArrayList<GlobalCurrencyData.dataBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view=inflater.inflate(R.layout.hangqing_item,null);
        RecyclerView.ViewHolder holder=new recyclerHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        recyclerHolder= (Global1Adapter.recyclerHolder) holder;
        GlobalCurrencyData.dataBean bean=getItem(position);
        recyclerHolder.name.setText(bean.getName());
        recyclerHolder.newPrice.setText(bean.getNewPrice()+"");
        recyclerHolder.changePercent.setText(bean.getChangePercent()+"");
        recyclerHolder.time.setText(bean.getTime()+"");
        recyclerHolder.low.setText(bean.getLow()+"");
        recyclerHolder.high.setText(bean.getHigh()+"");
    }
    public GlobalCurrencyData.dataBean getItem(int position){
        return mList.get(position);
    }

    @Override
    public int getItemCount() {
        if (mList!=null){
            return mList.size();
        }
        return 0;
    }
    public class recyclerHolder extends RecyclerView.ViewHolder{
        private TextView name,newPrice,changePercent,time,low,high;
        public recyclerHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            newPrice= (TextView) itemView.findViewById(R.id.newPrice);
            changePercent= (TextView) itemView.findViewById(R.id.changePercent);
            time= (TextView) itemView.findViewById(R.id.time);
            low= (TextView) itemView.findViewById(R.id.low);
            high= (TextView) itemView.findViewById(R.id.high);
        }
    }
}
*/
