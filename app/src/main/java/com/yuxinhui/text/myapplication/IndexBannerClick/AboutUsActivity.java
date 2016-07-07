package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.yuxinhui.text.myapplication.R;

public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView mReturn;
    LinearLayout mVersion,mAdvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        initView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        mReturn.setOnClickListener(this);
        mVersion.setOnClickListener(this);
        mAdvice.setOnClickListener(this);
    }

    private void initView() {
        mReturn = (ImageView) findViewById(R.id.about_us_back);
        mVersion = (LinearLayout) findViewById(R.id.layout_version);
        mAdvice = (LinearLayout) findViewById(R.id.layout_advice);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.about_us_back:
                this.finish();
                break;
            case R.id.layout_version:
                intent = new Intent(this, VersionINfoActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_advice:
                intent = new Intent(this, AdviceCommitActivity.class);
                startActivity(intent);
                break;
        }
    }
}
