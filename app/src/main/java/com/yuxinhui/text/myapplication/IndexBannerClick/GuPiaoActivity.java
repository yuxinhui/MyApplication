package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.Bean.GuPiaoHuData;
import com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoPackage.MyHScrollView;
import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.DialogUtils;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/15.
 */
public class GuPiaoActivity extends Activity{
    private ListView mListView1;
    private GuPiaoAdapter mGuPiaoAdapter;
    private RelativeLayout mHead;
    private LinearLayout main;
    private GuPiaoHuData mDataBean=new GuPiaoHuData();
    private ArrayList<GuPiaoHuData.DataBean.DataBean1> mBeen=new ArrayList<>();
    private String urlGuPiao= YuXinHuiApplication.URL_BOOT+"app/getShareList?name=sh&shpage=1&type=1";

    private ImageView gupiao_return;
    private TextView hugu_txt,shengu_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gupiao_activity);
        mHead= (RelativeLayout) findViewById(R.id.head);
        mHead.setClickable(true);
        mHead.setFocusable(true);
        mHead.setBackgroundColor(Color.parseColor("#FFFFFF"));
        mHead.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        initData();
        mListView1= (ListView) findViewById(R.id.listView1);
        mListView1.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        mGuPiaoAdapter=new GuPiaoAdapter(mBeen,this);
        mListView1.setAdapter(mGuPiaoAdapter);
        initView();
    }

    private void initView() {
        gupiao_return= (ImageView) findViewById(R.id.gupiao_return);
        gupiao_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuPiaoActivity.this, MainActivity.class);
                startActivity(intent);
                finishActivity();
            }
        });
        hugu_txt= (TextView) findViewById(R.id.hugu_txt);
        shengu_txt= (TextView) findViewById(R.id.shengu_txt);
        shengu_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuPiaoActivity.this,ShenGuActivity.class);
                startActivity(intent);
                finishActivity();
            }
        });
    }

    //获取数据
    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"股票界面","努力加载......");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                urlGuPiao,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        mDataBean = gson.fromJson(s, GuPiaoHuData.class);
                        ArrayList<GuPiaoHuData.DataBean.DataBean1> been= (ArrayList<GuPiaoHuData.DataBean.DataBean1>) mDataBean.getData().getData();
                        mBeen.addAll(been);
                        mGuPiaoAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        DialogUtils.createToasdt(GuPiaoActivity.this,"股票界面加载失败，请检查网络连接");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }

    private void finishActivity(){
        this.finish();
    }

    //股票适配器
    private class GuPiaoAdapter extends BaseAdapter{
        ArrayList<GuPiaoHuData.DataBean.DataBean1> beanArrayList=new ArrayList<GuPiaoHuData.DataBean.DataBean1>();
        LayoutInflater mInflater;

        public GuPiaoAdapter(ArrayList<GuPiaoHuData.DataBean.DataBean1> beanArrayList, Context context) {
            super();
            this.beanArrayList = beanArrayList;
            mInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (beanArrayList!=null){
                return beanArrayList.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (beanArrayList!=null){
                return beanArrayList.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            viewHolder holder=null;
            if (convertView==null){
                synchronized (GuPiaoActivity.this){
                    convertView=mInflater.inflate(R.layout.gupiao_item,null);
                    holder=new viewHolder();
                    MyHScrollView myHScrollView= (MyHScrollView) convertView.findViewById(R.id.horizontalScrollView1);
                    holder.scrollView=myHScrollView;
                    holder.txt1= (TextView) convertView.findViewById(R.id.textView1);
                    holder.txt2= (TextView) convertView.findViewById(R.id.textView2);
                    holder.txt3= (TextView) convertView.findViewById(R.id.textView3);
                    holder.txt4= (TextView) convertView.findViewById(R.id.textView4);
                    holder.txt5= (TextView) convertView.findViewById(R.id.textView5);
                    holder.txt6= (TextView) convertView.findViewById(R.id.textView6);
                    holder.txt7= (TextView) convertView.findViewById(R.id.textView7);
                    MyHScrollView headMyHScrollView1= (MyHScrollView) mHead.findViewById(R.id.horizontalScrollView1);
                    headMyHScrollView1.AddOnScrollChangedListener(new OnScrollChangedListenerImp(myHScrollView));
                    convertView.setTag(holder);
                }
            }else {
                holder= (viewHolder) convertView.getTag();
            }
            GuPiaoHuData.DataBean.DataBean1 bean= (GuPiaoHuData.DataBean.DataBean1) getItem(position);
            int bg;
            if(bean.getChangepercent().contains("-")){
                bg = Color.rgb(64, 205, 157);
            }else {
                bg = Color.rgb(247, 90, 88);
            }
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(bg);
            holder.txt3.setBackgroundDrawable(drawable);
            holder.txt3.setTextColor(Color.WHITE);
            holder.txt4.setBackgroundDrawable(drawable);
            holder.txt4.setTextColor(Color.WHITE);
            holder.txt1.setText(bean.getName()+"\n"+bean.getSymbol());
            holder.txt2.setText(bean.getVolume()+"");
            holder.txt3.setText(bean.getPricechange());
            holder.txt4.setText(bean.getChangepercent());
            holder.txt5.setText(bean.getSell());
            holder.txt6.setText(bean.getAmount()+"");
            holder.txt7.setText(bean.getSettlement());
            return convertView;
        }
        public class viewHolder{
            private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;
            private HorizontalScrollView scrollView;
        }

        private class OnScrollChangedListenerImp implements MyHScrollView.OnScrollChangedListener {
            MyHScrollView mScrollViewArg;
            public OnScrollChangedListenerImp(MyHScrollView myHScrollView) {
                mScrollViewArg=myHScrollView;
            }

            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                mScrollViewArg.smoothScrollTo(l,t);
            }
        }
    }

    //触摸监听
    private class ListViewAndHeadViewTouchLinstener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            //当在列头 和 listView控件上touch时，将这个touch的事件分发给 ScrollView
            HorizontalScrollView horizontalScrollView= (HorizontalScrollView) mHead.findViewById(R.id.horizontalScrollView1);
            horizontalScrollView.onTouchEvent(event);
            return false;
        }
    }
}
