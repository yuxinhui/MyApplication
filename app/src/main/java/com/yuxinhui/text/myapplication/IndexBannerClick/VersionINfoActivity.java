package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.R;

public class VersionINfoActivity extends AppCompatActivity {
    ImageView mReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_info);
        initView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VersionINfoActivity.this.finish();
            }
        });
    }

    private void initView() {
        mReturn = (ImageView) findViewById(R.id.back_version);
    }
}
