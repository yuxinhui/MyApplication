package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.os.Bundle;

import com.yuxinhui.text.myapplication.R;

/**
 * Created by Administrator on 2016/6/15.
 */
public class GuPiaoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gupiao_activity);

    }

    private void finishActivity(){
        this.finish();
    }
}
