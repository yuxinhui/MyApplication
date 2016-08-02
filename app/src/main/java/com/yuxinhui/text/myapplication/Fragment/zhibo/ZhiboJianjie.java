package com.yuxinhui.text.myapplication.Fragment.zhibo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuxinhui.text.myapplication.R;

/**
 * Created by "于志渊"
 * 时间:"10:53"
 * 包名:com.yuxinhui.text.myapplication.Fragment.zhibo
 * 描述:直播简介
 */
public class ZhiboJianjie extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_zhibo_intro,container,false);
    }
}
