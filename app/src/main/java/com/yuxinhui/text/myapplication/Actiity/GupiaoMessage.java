package com.yuxinhui.text.myapplication.Actiity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.Bean.GuPiaoMsgData;
import com.yuxinhui.text.myapplication.IndexBannerClick.GuPiaoActivity;
import com.yuxinhui.text.myapplication.IndexBannerClick.ShenGuActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import java.text.DecimalFormat;

/**
 * Created by "于志渊"
 * 时间:"17:24"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:股票详情页
 */
public class GupiaoMessage extends AppCompatActivity{
    private ImageView message_return;
    //股票走势图的导航
    private TextView fenshi_tv,day_tv,week_tv,mouth_tv;
    private String fenshi_sr,day_sr,week_sr,mouth_sr,text;
    private WebView gupiaomsg_wv;
    private String urlGuPiaoMsg= YuXinHuiApplication.URL_BOOT+"app/share?code=";
    GuPiaoMsgData guPiaoMsgData=new GuPiaoMsgData();
    String symbl;
    viewHolder holder=new viewHolder();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gupiaomsg_item);
        Intent intent = getIntent();
        symbl = intent.getStringExtra("Symbol");
        initData();
        gupiaomsg_wv= (WebView) findViewById(R.id.gupiaomsg_wv);
        initView();
    }
    //获取文字数据
    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.GET, urlGuPiaoMsg+symbl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        guPiaoMsgData=gson.fromJson(s,GuPiaoMsgData.class);
                        holder.name.setText(guPiaoMsgData.getData().get(0).getData().getName());
                        holder.name_gid.setText(guPiaoMsgData.getData().get(0).getData().getGid());
                        holder.gupiaomsg_dot.setText(guPiaoMsgData.getData().get(0).getData().getNowPri());
                        holder.gupiaomsg_rate.setText(guPiaoMsgData.getData().get(0).getData().getIncrePer());
                        holder.gupiaomsg_newpic.setText(guPiaoMsgData.getData().get(0).getData().getIncrease());
                        holder.gupiaomsg_date.setText(guPiaoMsgData.getData().get(0).getData().getDate());
                        holder.gupiaomsg_time.setText(guPiaoMsgData.getData().get(0).getData().getTime());
                        holder.today_atrt_pri.setText(guPiaoMsgData.getData().get(0).getData().getTodayStartPri());
                        holder.yestod_end_pri.setText(guPiaoMsgData.getData().get(0).getData().getYestodEndPri());
                        holder.today_min.setText(guPiaoMsgData.getData().get(0).getData().getTodayMin());
                        holder.today_max.setText(guPiaoMsgData.getData().get(0).getData().getTodayMax());
                        holder.tranumber.setText(guPiaoMsgData.getData().get(0).getData().getTraNumber());
                        double traAmount= Double.parseDouble(guPiaoMsgData.getData().get(0).getData().getTraAmount())/100000000;
                        DecimalFormat df=new DecimalFormat("#0.0000");
                        holder.traamount.setText(df.format(traAmount)+"亿");
                        holder.competitivepri.setText(guPiaoMsgData.getData().get(0).getData().getCompetitivePri());
                        holder.reservepri.setText(guPiaoMsgData.getData().get(0).getData().getReservePri());
                        holder.increper.setText(guPiaoMsgData.getData().get(0).getData().getIncrePer());
                        holder.increase.setText(guPiaoMsgData.getData().get(0).getData().getIncrease());
                        fenshi_sr=guPiaoMsgData.getData().get(0).getGopicture().getMinurl();
                        firstMinurl();
                        day_sr=guPiaoMsgData.getData().get(0).getGopicture().getDayurl();
                        week_sr=guPiaoMsgData.getData().get(0).getGopicture().getWeekurl();
                        mouth_sr=guPiaoMsgData.getData().get(0).getGopicture().getMonthurl();
                        Log.e("股票详情","额就瞅瞅成功没");
                    }
                    private void firstMinurl() {
                        gupiaomsg_wv.loadUrl(fenshi_sr);
                        gupiaomsg_wv.setScrollBarStyle(0);
                        gupiaomsg_wv.setWebViewClient(new WebViewClient(){
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                return super.shouldOverrideUrlLoading(view, url);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("股票详情","失败噻");
            }
        });
        requestQueue.add(request);
    }

    private void initView() {
        message_return= (ImageView) findViewById(R.id.message_return);
        message_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (symbl.contains("sh")){
                    Intent intent=new Intent(GupiaoMessage.this, GuPiaoActivity.class);
                    startActivity(intent);
                    GupiaoMessage.this.finish();
                }
                if (symbl.contains("sz")){
                    Intent intent=new Intent(GupiaoMessage.this, ShenGuActivity.class);
                    startActivity(intent);
                    GupiaoMessage.this.finish();
                }
            }
        });

        holder.name= (TextView) findViewById(R.id.name);
        holder.name_gid= (TextView)findViewById(R.id.name_gid);
        holder.gupiaomsg_dot= (TextView) findViewById(R.id.gupiaomsg_dot);
        holder.gupiaomsg_rate= (TextView) findViewById(R.id.gupiaomsg_rate);
        holder.gupiaomsg_newpic= (TextView) findViewById(R.id.gupiaomsg_newpic);
        holder.gupiaomsg_date= (TextView) findViewById(R.id.gupiaomsg_date);
        holder.gupiaomsg_time= (TextView) findViewById(R.id.gupiaomsg_time);
        holder.today_atrt_pri= (TextView) findViewById(R.id.today_atrt_pri);
        holder.yestod_end_pri= (TextView) findViewById(R.id.yestod_end_pri);
        holder.today_min= (TextView) findViewById(R.id.today_min);
        holder.today_max= (TextView) findViewById(R.id.today_max);
        holder.tranumber= (TextView) findViewById(R.id.tranumber);
        holder.traamount= (TextView) findViewById(R.id.traamount);
        holder.competitivepri= (TextView) findViewById(R.id.competitivepri);
        holder.reservepri= (TextView) findViewById(R.id.reservepri);
        holder.increper= (TextView) findViewById(R.id.increper);
        holder.increase= (TextView) findViewById(R.id.increase);
        //股票走势图控件

        fenshi_tv= (TextView) findViewById(R.id.fenshi_tv);
        fenshi_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearColor();
                setChioceItem(0);
            }
        });
        day_tv= (TextView) findViewById(R.id.day_tv);
        day_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearColor();
                setChioceItem(1);
            }
        });
        week_tv= (TextView) findViewById(R.id.week_tv);
        week_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearColor();
                setChioceItem(2);
            }
        });
        mouth_tv= (TextView) findViewById(R.id.mouth_tv);
        mouth_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearColor();
                setChioceItem(3);
            }
        });
    }
    class viewHolder{
        TextView name,name_gid,gupiaomsg_dot,gupiaomsg_rate,gupiaomsg_newpic,gupiaomsg_date,gupiaomsg_time,today_atrt_pri,yestod_end_pri,today_min,today_max,tranumber,traamount,competitivepri,reservepri,increper,increase;
    }

    public void setChioceItem(int chioceItem) {
        switch (chioceItem){
            case 0:
                fenshi_tv.setTextColor(Color.RED);
                gupiaomsg_wv.loadUrl(fenshi_sr);
                gupiaomsg_wv.setScrollBarStyle(0);
                gupiaomsg_wv.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                });
                break;
            case 1:
                day_tv.setTextColor(Color.RED);
                gupiaomsg_wv.loadUrl(day_sr);
                gupiaomsg_wv.setScrollBarStyle(0);
                gupiaomsg_wv.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                });
                break;
            case 2:
                week_tv.setTextColor(Color.RED);
                gupiaomsg_wv.loadUrl(week_sr);
                gupiaomsg_wv.setScrollBarStyle(0);
                gupiaomsg_wv.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                });
                break;
            case 3:
                mouth_tv.setTextColor(Color.RED);
                gupiaomsg_wv.loadUrl(mouth_sr);
                gupiaomsg_wv.setScrollBarStyle(0);
                gupiaomsg_wv.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                });
                break;
            default:
                break;
        }
    }
    //初始化刚开始的颜色
    public void clearColor(){
        fenshi_tv.setTextColor(Color.DKGRAY);
        day_tv.setTextColor(Color.DKGRAY);
        week_tv.setTextColor(Color.DKGRAY);
        mouth_tv.setTextColor(Color.DKGRAY);
    }
}
