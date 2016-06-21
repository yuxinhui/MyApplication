package com.yuxinhui.text.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Zhuce extends AppCompatActivity {
    private ImageView zhuce_return_img;
    private ImageView zhuce_home_img;
    private ImageView zhuce_img;
    private ImageView zhuce_getyanzheng_img;
    private EditText zhuce_mingzi_text;
    private EditText zhuce_mima_text;
    private EditText zhuce_writeyanzheng_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce);
        initView();
        onClick();
    }
    //初始化控件
    private void initView() {
        zhuce_return_img= (ImageView) findViewById(R.id.zhuce_return_img);
        zhuce_home_img= (ImageView) findViewById(R.id.zhuce_home_img);
        zhuce_img= (ImageView) findViewById(R.id.zhuce_img);
        zhuce_getyanzheng_img= (ImageView) findViewById(R.id.zhuce_getyanzheng_img);
        zhuce_mingzi_text= (EditText) findViewById(R.id.zhuce_mingzi_text);
        zhuce_mima_text= (EditText) findViewById(R.id.zhuce_mima_text);
        zhuce_writeyanzheng_text= (EditText) findViewById(R.id.zhuce_writeyanzheng_text);
    }
    //图片响应事件
    private void onClick() {
        zhuce_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fanhui = new Intent(Zhuce.this, Denglu.class);
                startActivity(fanhui);
                return;
            }
        });
        zhuce_home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shouye = new Intent(Zhuce.this, MainActivity.class);
                startActivity(shouye);
                return;
            }
        });
        zhuce_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(Zhuce.this,Denglu.class);
                startActivity(login);
                return;
            }
        });
    }
}
