package com.yuxinhui.text.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/2.
 */
public class KaiHu extends AppCompatActivity{
    private ImageView kaihu_return_img;
    private ImageView kaihu_lijikaihu_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaihu);
        kaihu_return_img= (ImageView) findViewById(R.id.kaihu_return_img);
        kaihu_lijikaihu_img= (ImageView) findViewById(R.id.kaihu_lijikaihu_img);
        kaihu_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fanhui = new Intent(KaiHu.this, MainActivity.class);
                startActivity(fanhui);
            }
        });
        kaihu_lijikaihu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lijizhuce = new Intent(KaiHu.this, KaiHuRenZheng.class);
                startActivity(lijizhuce);
            }
        });
    }
}
