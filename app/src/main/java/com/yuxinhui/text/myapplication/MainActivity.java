package com.yuxinhui.text.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuxinhui.text.myapplication.Fragment.HangQingActivity;
import com.yuxinhui.text.myapplication.Fragment.MyActivity;
import com.yuxinhui.text.myapplication.Fragment.ShouYeActivity;
import com.yuxinhui.text.myapplication.Fragment.XueyuanActivity;
import com.yuxinhui.text.myapplication.Fragment.ZhiboActivity;

public class MainActivity extends FragmentActivity implements OnClickListener{
    //fragment对象
    private ShouYeActivity index;
    private ZhiboActivity zhiboActivity;
    private XueyuanActivity xueyuanActivity;
    private MyActivity myActivity;
    private HangQingActivity hangQingActivity;
    private FrameLayout frameLayout;//fragment的容器
    //定义底部导航栏的布局
    private RelativeLayout index_layout;
    private RelativeLayout zhibo_layout;
    private RelativeLayout hangqing_layout;
    private RelativeLayout xueyuan_layout;
    private RelativeLayout my_layout;
    //定义导航栏中的控件
    private ImageView index_image;
    private ImageView zhibo_image;
    private ImageView xueyuan_image;
    private ImageView my_image;
    private ImageView hangqing_image;
    private TextView index_text;
    private TextView zhibo_text;
    private TextView xueyuan_text;
    private TextView my_text;
    private TextView hangqing_txt;
    //fragmentmanager的对象
    FragmentManager fragmentManager;
    //选中变换的颜色
    private int Red = 0xFFED0E0E;
    private int Gray=0xFF9B9999;

    ZhiBoRecceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        IntentFilter filter = new IntentFilter("zhibo");
        mReceiver = new ZhiBoRecceiver();
        registerReceiver(mReceiver,filter);
        initView();
        setChioceItem(0);
    }
    //初始化控件
    public void initView(){
        index_layout=(RelativeLayout)findViewById(R.id.index_layout);
        zhibo_layout=(RelativeLayout)findViewById(R.id.zhibo_layout);
        xueyuan_layout=(RelativeLayout)findViewById(R.id.xueyuan_layout);
        my_layout=(RelativeLayout)findViewById(R.id.my_layout);
        hangqing_layout= (RelativeLayout) findViewById(R.id.hangqing_layout);
        index_image=(ImageView)findViewById(R.id.index_image);
        zhibo_image=(ImageView)findViewById(R.id.zhibo_image);
        xueyuan_image=(ImageView)findViewById(R.id.xueyuan_image);
        my_image=(ImageView)findViewById(R.id.my_image);
        hangqing_image= (ImageView) findViewById(R.id.hangqing_image);
        index_text=(TextView)findViewById(R.id.index_text);
        zhibo_text=(TextView)findViewById(R.id.zhibo_text);
        xueyuan_text=(TextView)findViewById(R.id.xueyuan_text);
        my_text=(TextView)findViewById(R.id.my_text);
        hangqing_txt= (TextView) findViewById(R.id.hangqing_txt);
        index_layout.setOnClickListener(this);
        zhibo_layout.setOnClickListener(this);
        xueyuan_layout.setOnClickListener(this);
        my_layout.setOnClickListener(this);
        hangqing_layout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.index_layout:
                setChioceItem(0);
                break;
            case R.id.zhibo_layout:
                setChioceItem(1);
                break;
            case R.id.xueyuan_layout:
                setChioceItem(2);
                break;
            case R.id.my_layout:
                setChioceItem(3);
                break;
            case R.id.hangqing_layout:
                setChioceItem(4);
                break;
            default:
                break;
        }
    }

    //定义一个选中一个item后的处理
    public void setChioceItem(int chioceItem) {
        //重置选项+隐藏所有Fragment
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        clearColor();
        hideFragments(transaction);
        switch (chioceItem){
            case 0:
                index_text.setTextColor(Red);
                index_image.setImageResource(R.mipmap.iconindex);
                if (index==null){
                    // 如果fg1为空，则创建一个并添加到界面上
                    index = new ShouYeActivity();
                    transaction.add(R.id.frame_layout,index);
                }else {
                    transaction.show(index);
                }
                break;
            case 1:
                zhibo_text.setTextColor(Red);
                zhibo_image.setImageResource(R.mipmap.iconzhibo);
                if (zhiboActivity==null){
                    // 如果fg1为空，则创建一个并添加到界面上
                    zhiboActivity = new ZhiboActivity();
                    transaction.add(R.id.frame_layout,zhiboActivity);
                }else {
                    transaction.show(zhiboActivity);
                }
                break;
            case 2:
                xueyuan_text.setTextColor(Red);
                xueyuan_image.setImageResource(R.mipmap.iconxueyuan);
                if (xueyuanActivity==null){
                    // 如果fg1为空，则创建一个并添加到界面上
                    xueyuanActivity = new XueyuanActivity();
                    transaction.add(R.id.frame_layout,xueyuanActivity);
                }else {
                    transaction.show(xueyuanActivity);
                }
                break;
            case 3:
                my_text.setTextColor(Red);
                my_image.setImageResource(R.mipmap.iconmy);
                if (myActivity==null){
                    // 如果fg1为空，则创建一个并添加到界面上
                    myActivity = new MyActivity();
                    transaction.add(R.id.frame_layout,myActivity);
                }else {
                    transaction.show(myActivity);
                }
                break;
            case 4:
                hangqing_txt.setTextColor(Red);
                hangqing_image.setImageResource(R.mipmap.hangqing_u);
                if (hangQingActivity==null){
                // 如果fg1为空，则创建一个并添加到界面上
                    hangQingActivity=new HangQingActivity();
                    transaction.add(R.id.frame_layout,hangQingActivity);
                }else {
                    transaction.show(hangQingActivity);
                }
                break;
        }
        transaction.commit();
    }
    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction transaction) {
        if (index != null){
            transaction.hide(index);
        }
        if (zhiboActivity != null){
            transaction.hide(zhiboActivity);
        }
        if (xueyuanActivity != null){
            transaction.hide(xueyuanActivity);
        }
        if (myActivity != null){
            transaction.hide(myActivity);
        }
        if (hangQingActivity != null){
            transaction.hide(hangQingActivity);
        }
    }

    //定义一个重置所有选项的方法
    private void clearColor() {
        index_text.setTextColor(Gray);
        index_image.setImageResource(R.mipmap.iconindex02);
        zhibo_text.setTextColor(Gray);
        zhibo_image.setImageResource(R.mipmap.iconzhibo02);
        xueyuan_text.setTextColor(Gray);
        xueyuan_image.setImageResource(R.mipmap.iconxueyuan02);
        my_text.setTextColor(Gray);
        my_image.setImageResource(R.mipmap.iconmy02);
        hangqing_txt.setTextColor(Gray);
        hangqing_image.setImageResource(R.mipmap.hangqingicon);
    }

    class ZhiBoRecceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            setChioceItem(1);
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}