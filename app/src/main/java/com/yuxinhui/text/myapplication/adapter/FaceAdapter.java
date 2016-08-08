package com.yuxinhui.text.myapplication.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Bean.MsgEmojiModle;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"10:42"
 * 包名:com.yuxinhui.text.myapplication.adapter
 * 描述:emoji适配器
 */
public class FaceAdapter extends BaseAdapter {
    private List<MsgEmojiModle> data;
    private LayoutInflater inflater;
    private int size=0;

    public FaceAdapter(Context context, List<MsgEmojiModle> list) {
        this.data = list;
        this.inflater = LayoutInflater.from(context);
        this.size = list.size();
    }
    @Override
    public int getCount() {
        return this.size;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=new ViewHolder();
        MsgEmojiModle emoji=data.get(position);
        if (convertView==null){
            convertView=inflater.inflate(R.layout.face_item,null);
            holder.iv_face= (ImageView) convertView.findViewById(R.id.face_iv);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        if (emoji.getId() == R.drawable.face_delete_select){
            convertView.setBackgroundDrawable(null);
            holder.iv_face.setImageResource(emoji.getId());
        }else if(TextUtils.isEmpty(emoji.getCharacter())) {
            convertView.setBackgroundDrawable(null);
            holder.iv_face.setImageDrawable(null);
        }else {
            holder.iv_face.setTag(emoji);
            holder.iv_face.setImageResource(emoji.getId());
        }
        return convertView;
    }
    class ViewHolder {
        ImageView iv_face;
    }
}
