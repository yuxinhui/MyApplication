package com.yuxinhui.text.myapplication.Actiity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Denglu extends AppCompatActivity {
    private ImageView denglu_return_img;
    private ImageView denglu_home_img;
    private ImageView denglu_img;
    private EditText denglu_mingzi_text;
    private EditText denglu_mima_text;
    private TextView wangjiMM_text;
    private TextView zhuce_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);
        //初始化控件
        initView();
    }
    //初始化控件
    private void initView() {
        denglu_return_img= (ImageView) findViewById(R.id.denglu_return_img);
        denglu_home_img= (ImageView) findViewById(R.id.denglu_home_img);
        denglu_img= (ImageView) findViewById(R.id.denglu_img);
        denglu_mingzi_text= (EditText) findViewById(R.id.denglu_mingzi_text);
        denglu_mima_text= (EditText) findViewById(R.id.denglu_mima_text);
        wangjiMM_text= (TextView) findViewById(R.id.wangjiMM_text);
        zhuce_text= (TextView) findViewById(R.id.zhuce_text);
    }

    public boolean login() {
        return false;
    }
}
