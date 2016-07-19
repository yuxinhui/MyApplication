package com.yuxinhui.text.myapplication.Actiity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;

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
                finishActivity();
            }
        });
        kaihu_lijikaihu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lijizhuce = new Intent(KaiHu.this, Zhuce.class);
                startActivity(lijizhuce);
                finishActivity();
            }
        });
    }
    private void finishActivity(){
        this.finish();
    }
}
