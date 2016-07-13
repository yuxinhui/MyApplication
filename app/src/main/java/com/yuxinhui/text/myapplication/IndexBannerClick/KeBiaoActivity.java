package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
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
import com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoPackage.MyHScrollView;
import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.KeBiaoData;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"10:23"
 * 包名:com.yuxinhui.text.myapplication.IndexBannerClick
 * 描述:课程表显示界面
 */
public class KeBiaoActivity extends Activity{
    //private String url= YuXinHuiApplication.getUrlBoot()+"course/select_app";
    private String url="http://114.55.98.142/course/select_app";
    private ListView mListView1;
    private CurriculumAdapter mCurriculumAdapter;
    private RelativeLayout mHead;
    private KeBiaoData mData=new KeBiaoData();
    private ArrayList<KeBiaoData.DataBean> mDataBeen=new ArrayList<KeBiaoData.DataBean>();

    private ImageView curriculum_return_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);
        mHead= (RelativeLayout) findViewById(R.id.head);
        mHead.setFocusable(true);
        mHead.setBackgroundColor(Color.parseColor("#00ff00"));
        mHead.setClickable(true);
        mHead.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        initData();
        mListView1= (ListView) findViewById(R.id.listView1);
        mListView1.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        mCurriculumAdapter=new CurriculumAdapter(mDataBeen,this);
        mListView1.setAdapter(mCurriculumAdapter);
        initView();
    }

    private void initView() {
        curriculum_return_img= (ImageView) findViewById(R.id.curriculum_return_img);
        curriculum_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(KeBiaoActivity.this, MainActivity.class);
                startActivity(intent);
                finishActivity();
            }
        });

    }

    //获取课表的数据
    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"课程表","努力加载.....");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        /*Log.e("tag",s);*/
                        Gson gson=new Gson();
                        mData=gson.fromJson(s,KeBiaoData.class);
                        ArrayList<KeBiaoData.DataBean> been= (ArrayList<KeBiaoData.DataBean>) mData.getData();
                        mDataBeen.addAll(been);
                        mCurriculumAdapter.notifyDataSetChanged();
                        Log.e("kebiao","成功了吧");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("kebiao","失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }

    private void finishActivity(){
        this.finish();
    }

    //课表适配器
    private class CurriculumAdapter extends BaseAdapter{
        private ArrayList<KeBiaoData.DataBean> mArrayList=new ArrayList<KeBiaoData.DataBean>();
        private LayoutInflater mInflater;

        public CurriculumAdapter(ArrayList<KeBiaoData.DataBean> mArrayList, Context context) {
            super();
            this.mArrayList = mArrayList;
            mInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (mArrayList!=null){
                return mArrayList.size();
            }
            return 0;
        }

        @Override
        public KeBiaoData.DataBean getItem(int position) {
            if (mArrayList!=null){
                return mArrayList.get(position);
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
                synchronized (KeBiaoActivity.this){
                    convertView=mInflater.inflate(R.layout.curriculum_item,null);
                    holder=new viewHolder();
                    MyHScrollView myHScrollView= (MyHScrollView) convertView.findViewById(R.id.horizontalScrollView1);
                    holder.scrollView=myHScrollView;
                    holder.txt1= (TextView) convertView.findViewById(R.id.time_txt);
                    holder.txt2= (TextView) convertView.findViewById(R.id.mon_txt);
                    holder.txt3= (TextView) convertView.findViewById(R.id.tuse_txt);
                    holder.txt4= (TextView) convertView.findViewById(R.id.wed_txt);
                    holder.txt5= (TextView) convertView.findViewById(R.id.thu_txt);
                    holder.txt6= (TextView) convertView.findViewById(R.id.fin_txt);
                    MyHScrollView hScrollView= (MyHScrollView) mHead.findViewById(R.id.horizontalScrollView1);
                    hScrollView.AddOnScrollChangedListener(new OnScrollChangedListenerImp(myHScrollView));
                    convertView.setTag(holder);
                }
            }else {
                holder= (viewHolder) convertView.getTag();
            }
            KeBiaoData.DataBean dataBean=getItem(position);
            holder.txt1.setText(dataBean.getStartTime()+"\n"+"  |"+"\n"+dataBean.getEndTime());
            holder.txt2.setText(dataBean.getMonday());
            holder.txt3.setText(dataBean.getTuesday());
            holder.txt4.setText(dataBean.getWednesday());
            holder.txt5.setText(dataBean.getThursday());
            holder.txt6.setText(dataBean.getFriday());
            return convertView;
        }
        public class viewHolder{
            TextView txt1,txt2,txt3,txt4,txt5,txt6;
            private HorizontalScrollView scrollView;
        }

        private class OnScrollChangedListenerImp implements MyHScrollView.OnScrollChangedListener {
            private MyHScrollView mScrollViewArg;
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
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) mHead.findViewById(R.id.horizontalScrollView1);
            horizontalScrollView.onTouchEvent(event);
            return false;
        }
    }
}
