package com.yuxinhui.text.myapplication.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yuxinhui.text.myapplication.IndexBannerClick.AboutUsActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.MsgSettingActivity;
import com.yuxinhui.text.myapplication.R;

import java.io.File;

/**
 * Created by Administrator on 2016/5/31.
 * 对于myFragment的编写
 */
public class MyActivity extends Fragment {
    LinearLayout mSetting,mClear,mAboutUs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fg, container,false);
        initView(view);
        setOnClickListener();
        return view;
    }

    private void setOnClickListener() {
        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MsgSettingActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动警告对话框通知是否清除缓存
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("清楚缓存").setMessage("是否确认清楚缓存").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        File dir = getActivity().getCacheDir();
                        if (dir != null&&dir.exists()&&dir.isDirectory()) {
                            for (File item : dir.listFiles()) {
                                item.delete();
                            }
                        }
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });
        mAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutUsActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    private void initView(View view) {
        mSetting = (LinearLayout) view.findViewById(R.id.layout_setting);
        mClear = (LinearLayout) view.findViewById(R.id.layout_clear);
        mAboutUs = (LinearLayout) view.findViewById(R.id.layout_about_us);
    }

}
