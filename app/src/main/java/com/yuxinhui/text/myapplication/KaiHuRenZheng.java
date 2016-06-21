package com.yuxinhui.text.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/2.
 */
public class KaiHuRenZheng extends AppCompatActivity {
    private ImageView kaihurenzheng_return_img;
    private Button kaihurenzheng_wancheng_button;
    private EditText kaihurenzheng_shuru_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaihurenzheng);
        initView();
        onClick();
    }
    //点击事件响应
    private void onClick() {
        kaihurenzheng_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fanhui = new Intent(KaiHuRenZheng.this, KaiHu.class);
                startActivity(fanhui);
            }
        });
        kaihurenzheng_wancheng_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wancheng = new Intent(KaiHuRenZheng.this, Zhuce.class);
                startActivity(wancheng);
            }
        });
    }
    //初始化控件
    private void initView() {
        kaihurenzheng_return_img= (ImageView) findViewById(R.id.kaihurenzheng_return_img);
        kaihurenzheng_wancheng_button= (Button) findViewById(R.id.kaihurenzheng_wancheng_button);
        kaihurenzheng_shuru_txt= (EditText) findViewById(R.id.kaihurenzheng_shuru_txt);
    }
}
