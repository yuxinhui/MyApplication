package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.GuPiaoHuData;
import com.yuxinhui.text.myapplication.Utils.SyncHorizontalScrollView;
import com.yuxinhui.text.myapplication.adapter.StockHuLeftAdapter;
import com.yuxinhui.text.myapplication.adapter.StockHuRightAdapter;
import com.yuxinhui.text.myapplication.tool.StockUtilTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/15.
 */
public class GuPiaoActivity extends Activity{
    private StockHuLeftAdapter mHuLeftAdapter;
    private StockHuRightAdapter mHuRightAdapter;
    private GuPiaoHuData.DataBean dataBean1=new GuPiaoHuData.DataBean();
    private ArrayList<GuPiaoHuData.DataBean.DataBean1> mBean1ArrayList=new ArrayList<GuPiaoHuData.DataBean.DataBean1>();
    private String url="http://114.55.98.142/app/getShareList?name=sh&shpage=1&type=1";
    private LinearLayout leftContainerView;
    private ListView leftListView;
    private List<String> leftlList;
    private LinearLayout rightContainerView;
    private ListView rightListView;
    private SyncHorizontalScrollView titleHorsv;
    private SyncHorizontalScrollView contentHorsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gupiao_activity);
        initLeftData();
        initView();
        //设置两个水平控件的联动
        titleHorsv.setScrollView(contentHorsv);
        contentHorsv.setScrollView(titleHorsv);
        //添加左侧内容数据
        mHuLeftAdapter=new StockHuLeftAdapter(mBean1ArrayList,this);
        leftListView.setDivider(null);
        leftListView.setAdapter(mHuLeftAdapter);
        //添加右侧内容数据
        mHuRightAdapter=new StockHuRightAdapter(this,mBean1ArrayList);
        rightListView.setDivider(null);
        rightListView.setAdapter(mHuRightAdapter);
        StockUtilTools.setListViewHeightBasedOnChildren(rightListView);
    }



    private void initLeftData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"沪股","加载ing");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        dataBean1 = gson.fromJson(s, GuPiaoHuData.DataBean.class);
                        ArrayList<GuPiaoHuData.DataBean.DataBean1> data = (ArrayList<GuPiaoHuData.DataBean.DataBean1>) dataBean1.getData();
                        mBean1ArrayList.addAll(data);
                        Log.e("沪股","加载成功");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("沪股","加载失败");
                        dialog.dismiss();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("name","浦发银行");
                return map;
            }
        };
        requestQueue.add(request);
        mBean1ArrayList.clear();
    }

    private void initView() {
        leftContainerView= (LinearLayout) findViewById(R.id.left_container);
        leftListView= (ListView) findViewById(R.id.left_container_listview);
        rightContainerView= (LinearLayout) findViewById(R.id.right_container);
        rightListView= (ListView) findViewById(R.id.right_container_listview);
        titleHorsv= (SyncHorizontalScrollView) findViewById(R.id.title_horsv);
        contentHorsv= (SyncHorizontalScrollView) findViewById(R.id.content_horsv);
    }
}
