package com.yuxinhui.text.myapplication.YinDaoTu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.yuxinhui.text.myapplication.Actiity.SplashActivity;

/**
 * Created by Administrator on 2016/6/7.
 */
public class YinDaoTuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean mFirst = isFirstEnter(YinDaoTuActivity.this, YinDaoTuActivity.this.getClass().getName());
        if (mFirst){
            handler.sendEmptyMessageAtTime(SWITCH_GUIDEACTIVITY,3000);
        }else {
            handler.sendEmptyMessageAtTime(SWITCH_MAINACTIVITY,3000);
        }
    }
    // 判断应用是否初次加载，读取SharedPreferences中的guide_activity字段
    private static final String SHAREDPREFERENCES_NAME="my_pref";
    private static final String KEY_GUIDE_ACTIVITY ="guide_activity";
    private boolean isFirstEnter(Context context,String classname){
        if (context==null || classname==null || "".equalsIgnoreCase(classname)){
            return false;
        }
        String mResultStr = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_WORLD_READABLE).getString(KEY_GUIDE_ACTIVITY, "");
        if (mResultStr.equalsIgnoreCase("false")){
            return false;
        }else {
            return true;
        }
    }
    //Handler:跳转至不同页面
    public static final int SWITCH_MAINACTIVITY = 1000;
    public static final int SWITCH_GUIDEACTIVITY = 1001;
    public Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SWITCH_MAINACTIVITY:
                    Intent intent=new Intent();
                    intent.setClass(YinDaoTuActivity.this,SplashActivity.class);
                    YinDaoTuActivity.this.startActivity(intent);
                    YinDaoTuActivity.this.finish();
                    break;
                case SWITCH_GUIDEACTIVITY:
                    intent=new Intent();
                    intent.setClass(YinDaoTuActivity.this,GuideActivity.class);
                    YinDaoTuActivity.this.startActivity(intent);
                    YinDaoTuActivity.this.finish();
                    break;
            }
            super.handleMessage(msg);
        }
    };
}
