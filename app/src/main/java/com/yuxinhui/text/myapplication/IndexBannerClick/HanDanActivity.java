package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;

/**
 * Created by Administrator on 2016/6/15.
 */
public class HanDanActivity extends Activity{
    private ImageView handan_return_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handan);
        handan_return_img= (ImageView) findViewById(R.id.handan_return_img);
        handan_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HanDanActivity.this, MainActivity.class);
                startActivity(intent);
                HanDanActivity.this.finish();
            }
        });
    }
}
