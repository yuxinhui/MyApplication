package com.yuxinhui.text.myapplication.Actiity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuxinhui.text.myapplication.R;

/**
 * Created by "于志渊"
 * 时间:"14:24"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:
 */
public class NullActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_null, null);
        return view;
    }
}
