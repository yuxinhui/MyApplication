package com.yuxinhui.text.myapplication.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yuxinhui.text.myapplication.HangQingActivity.GlobalCurrency;
import com.yuxinhui.text.myapplication.R;

/**
 * Created by Administrator on 2016/6/12.
 */
public class HangQingActivity extends Fragment{
    private LinearLayout hangqing_ll;
    private Intent mIntent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hangqing_activity, container, false);
        hangqing_ll= (LinearLayout) view.findViewById(R.id.hangqing_ll);
        tizoZhuan();
        return view;
    }
    private void tizoZhuan(){
        mIntent=new Intent(getActivity(), GlobalCurrency.class);
        getActivity().startActivity(mIntent);
    }

}
