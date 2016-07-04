package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.IndexKuaiXunData;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"10:47"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:这个类是显示首页快讯页面的ListView的适配器
 */
public class ShouyeKuaiXunAdapter extends BaseAdapter {
    private ArrayList<IndexKuaiXunData.DataBean> mDataBeen=new ArrayList<IndexKuaiXunData.DataBean>();
    private IndexKuaiXunData.DataBean dataBean;
    private Context context;

    public ShouyeKuaiXunAdapter(ArrayList<IndexKuaiXunData.DataBean> mDataBeen, Context context) {
        this.mDataBeen = mDataBeen;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (mDataBeen!=null){
            return mDataBeen.size();
        }
        return 0;
    }

    @Override
    public IndexKuaiXunData.DataBean getItem(int position) {
        if (mDataBeen!=null){
            return mDataBeen.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodle viewHodle;
        if (convertView==null){
            viewHodle=new ViewHodle();
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.index_kuaixun_item,null);
            viewHodle.kuaixun_clock= (TextView) convertView.findViewById(R.id.kuaixun_clock);
            viewHodle.kuaixun_title= (TextView) convertView.findViewById(R.id.kuaixun_title);
            convertView.setTag(viewHodle);
        }else {
            viewHodle= (ViewHodle) convertView.getTag();
        }
        dataBean= getItem(position);
        viewHodle.kuaixun_clock.setText(dataBean.getPdate_src());
        viewHodle.kuaixun_title.setText(dataBean.getTitle());
        return convertView;
    }

    private class ViewHodle {
        private TextView kuaixun_clock,kuaixun_title;
    }

    //初始颜色
    /*public void onColor(){
        index_kuaixun_tubiao.setImageResource(R.mipmap.huadongbiao24x64hpx02);
    }*/
}
