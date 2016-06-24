package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.yuxinhui.text.myapplication.R;

/**
 * Created by "于志渊"
 * 时间:"10:23"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerClick
 * 描述:课程表显示界面
 */
public class KeBiaoActivity extends Activity{
    private String url="http://114.55.98.142/course/select_app";
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_curriculum);
    }
}
