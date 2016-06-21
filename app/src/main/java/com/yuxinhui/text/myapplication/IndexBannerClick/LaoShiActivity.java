package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.adapter.TeacherItemAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/14.
 */
public class LaoShiActivity extends AppCompatActivity{
    private Context context;
    private ListView teacher_lv;
    private ArrayList<HashMap<String,Object>> listItem;//定义一个动态数组
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_teacher);
        teacher_lv= (ListView) findViewById(R.id.teacher_lv);
        TeacherItemAdapter mTeacherItemAdapter=new TeacherItemAdapter(context);
        teacher_lv.setAdapter(mTeacherItemAdapter);
        teacher_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("TeacherAdapter","您点击了第"+position+"项目");
            }
        });
    }
}
