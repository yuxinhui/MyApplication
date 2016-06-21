package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/17.
 */
public class TeacherItemAdapter extends BaseAdapter {
    /**添加一个活的数据的方法*/
    private ArrayList<HashMap<String,Object>> getDate(){
        ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String, Object>>();
        for (int i=0;i<listItem.size();i++){
            HashMap<String,Object> map=new HashMap<String, Object>();
            map.put("teacher_name","这是第"+i+"行老师");
            map.put("teacher_context","这是第"+i+"老师的特点");
            listItem.add(map);
        }
        return listItem;
    }
    private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局
    public TeacherItemAdapter(Context context){
        this.mInflater= LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return getDate().size();
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
        ViewHodle viewHodle;
        //观察convertView随ListView滚动情况
        Log.v("Teacher", "getView " + position + " " + convertView);
        if (convertView==null){
            convertView=mInflater.inflate(R.layout.teacher_item,null);
            viewHodle=new ViewHodle();
            //得到各个控件对象
            viewHodle.teacher_head=(ImageView) convertView.findViewById(R.id.teacher_head);
            viewHodle.teacher_name= (TextView) convertView.findViewById(R.id.teacher_name);
            viewHodle.teacher_context= (TextView) convertView.findViewById(R.id.teacher_context);
            convertView.setTag(viewHodle);
        }else {
            //取出ViewHolder对象
            viewHodle= (ViewHodle) convertView.getTag();
        }
        /*设置TextView显示的内容，即我们存放在动态数组中的数据*/
        viewHodle.teacher_name.setText(getDate().get(position).get("teacher_name").toString());
        viewHodle.teacher_context.setText(getDate().get(position).get("teacher_context").toString());
        return convertView;
    }
    /**存放控件*/
    public final class ViewHodle{
        public ImageView teacher_head;
        public TextView teacher_name;
        public TextView teacher_context;
    }
}
