package com.yuxinhui.text.myapplication.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuxinhui.text.myapplication.R;

/**
 * Created by Administrator on 2016/6/12.
 */
public class HangQingActivity extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hangqing_fg, container, false);
        return view;
    }
}
