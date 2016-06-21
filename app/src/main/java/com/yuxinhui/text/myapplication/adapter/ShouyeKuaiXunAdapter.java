package com.yuxinhui.text.myapplication.adapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/6.
 */
public class ShouyeKuaiXunAdapter extends ListActivity {
    private ImageView index_kuaixun_tubiao;
    private TextView kuaixun_clock;
    private TextView kuaixun_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        listAdapter();
    }
    public void listAdapter(){
        setListAdapter(new SimpleAdapter(this, getData("title"), R.layout.index_kuaixun_list_item,
                new String[]{"colock", "content"}, new int[]{R.id.kuaixun_clock, R.id.kuaixun_content}));
    }
    //初始化控件
    private void initView() {
        index_kuaixun_tubiao= (ImageView) findViewById(R.id.index_kuaixun_tubiao);
        kuaixun_clock= (TextView) findViewById(R.id.kuaixun_clock);
        kuaixun_content= (TextView) findViewById(R.id.kuaixun_content);
    }
    //构造SimpleAdapter的第二个参数，类型为List<Map<String,String>>
    private List<Map<String,String>> getData(String title) {
        List<Map<String,String>> listData=new ArrayList<Map<String,String>>();
        for (int i=0;i<=5;i++){
            Map<String, String> map = new HashMap<>();
            map.put("colock", String.valueOf(kuaixun_clock));
            map.put("content",String.valueOf(kuaixun_content));
            listData.add(map);
        }
        return listData;
    }
    //初始颜色
    public void onColor(){
        index_kuaixun_tubiao.setImageResource(R.mipmap.huadongbiao24x64hpx02);
    }
}
