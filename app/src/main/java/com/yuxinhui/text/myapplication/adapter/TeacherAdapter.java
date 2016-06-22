package com.yuxinhui.text.myapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by "于志渊"
 * 时间:"10:47"
 * 包名:com.yuxinhui.text.myapplication
 * 描述:这个类是显示老师页面的ListView的适配器。
 */
public class TeacherAdapter extends BaseAdapter {


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return convertView;
    }
    /**存放控件*/
    public final class ViewHodle{
        public ImageView teacher_head;
        public TextView teacher_name;
        public TextView teacher_context;
    }
}
