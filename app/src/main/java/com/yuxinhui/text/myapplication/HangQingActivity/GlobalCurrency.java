package com.yuxinhui.text.myapplication.HangQingActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.ComexData;
import com.yuxinhui.text.myapplication.Utils.GlobalCurrencyData;
import com.yuxinhui.text.myapplication.Utils.LondonJinData;
import com.yuxinhui.text.myapplication.Utils.ShangHaiJinData;
import com.yuxinhui.text.myapplication.Utils.TianTongYinData;
import com.yuxinhui.text.myapplication.Utils.XianHuoHuangJinData;
import com.yuxinhui.text.myapplication.adapter.ComexAdapter;
import com.yuxinhui.text.myapplication.adapter.GlobalAdapter;
import com.yuxinhui.text.myapplication.adapter.LonDonJinAdapter;
import com.yuxinhui.text.myapplication.adapter.ShangHaiJinAdapter;
import com.yuxinhui.text.myapplication.adapter.TianTongYinAdapter;
import com.yuxinhui.text.myapplication.adapter.XianHuoHuangJinAdapter;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"17:00"
 * 包名:com.yuxinhui.text.myapplication.HangQingActivity
 * 描述:行情界面的详情
 */
public class GlobalCurrency extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private RadioButton mRadioButton4;
    private RadioButton mRadioButton5;
    private RadioButton mRadioButton6;
    private ListView global_lv,xianhuojin_lv,comex_lv,shanghaijin_lv,londonjin_lv,tiantongyin_lv;
    private float mCurrentCheckedRadioLeft;//当前被选中的RadioButton距离左侧的距离
    private HorizontalScrollView mHorizontalScrollView;//上面的水平滚动控件
    private ViewPager mViewPager;   //下方的可横向拖动的控件
    private ArrayList<View> mViews;//用来存放下方滚动的layout
    private int yellow=0xFFF2D70B;
    private int white=0xFFFFFFFF;
    //各个listview的适配器
    private GlobalAdapter mGlobalAdapter;
    private XianHuoHuangJinAdapter mXianHuoHuangJinAdapter;
    private ComexAdapter mComexAdapter;
    private ShangHaiJinAdapter mShangHaiJinAdapter;
    private LonDonJinAdapter mLonDonJinAdapter;
    private TianTongYinAdapter mTianTongYinAdapter;
    //arraylist<>用来存放实体类
    private ArrayList<GlobalCurrencyData> mGlobalCurrencyDatas=new ArrayList<GlobalCurrencyData>();
    private ArrayList<XianHuoHuangJinData> mXianHuoHuangJinDatas=new ArrayList<XianHuoHuangJinData>();
    private ArrayList<ComexData> mComexDatas=new ArrayList<ComexData>();
    private ArrayList<ShangHaiJinData> mShangHaiJinDatas=new ArrayList<ShangHaiJinData>();
    private ArrayList<LondonJinData> mLondonJinDatas=new ArrayList<LondonJinData>();
    private ArrayList<TianTongYinData> mTianTongYinDatas=new ArrayList<TianTongYinData>();
    //各个url
    private String urlGlobal="http://pull.api.fxgold.com/realtime/products?codes=IXFXEURUSD,IXFXAUDUSD,IXFXGBPCHF,IXFXUSDJPY,IXFXGBPUSD,IXFXUSDCHF,IXFXUSDCAD,IXFXEURGBP,IXFXEURJPY,IXFXEURCHF,IXEAINUDI,IXFXNZDUSD,IXFXAUDJPY,IXFXEURAUD,IXFXUSDHKD,IXFXGBPJPY,IXFXUSDTWD,IXFXEURCAD,IXFXUSDCNY,IXFXAUDNZD,IXFXAUDCNY,IXFXGBPAUD,IXFXAUDCAD,IXFXGBPCHF,IXFXUSDKRW,IXFXGBPCAD";
    private String urlXianHuo="http://pull.api.fxgold.com/realtime/products?codes=OSTWGD,PMHKAUJC,PMHKAUYH,OSCNYAUG,OSCNYAGG,PMAU,PMAG,PMAP,PMPD,PMHKAULD,PMHKAGLD,OSHKG";
    private String urlComex="http://pull.api.fxgold.com/realtime/products?codes=IXCMGCA0,CMGCG0,CMGCJ0,CMGCK0,CMGCM0,CMGCQ0,CMGCV0,CMGCZ0,IXCMSIA0,CMSIF0,CMSIH0,CMSIJ0,CMSIK0,CMSIM0,CMSIN0,CMSIU0,CMSIZ0,IXNEPAA0,IXNEPAH0,IXNEPAZ0,IXNEPAM0,IXNEPAU0,IXNEPLA0,IXNEPLF0,IXNEPLJ0,IXNEPLN0,IXNEPLV0,IXNEPLJ0";
    private String urlShangHai="http://pull.api.fxgold.com/realtime/products?codes=SGAuT+D,SGAgT+D,SGmAuT+D,SGAu100g,SGAu9999,SGiAu9999,SGAu9995,SGiAu100g,SGPT9995";
    private String urlLonDon="http://pull.api.fxgold.com/realtime/products?codes=IXLEAHD3M,IXLENID3M,IXLECAD3M,IXLENAD3M,IXLEPBD3M,IXLESND3M,LEAAD3M,LEAHD3M,LECAD3M,IXLEZSD3M,LEMOD3M,LENID3M,LEPBD3M,LECOD3M,LEZSD3M,LESND3M";
    private String urlTianTong="http://pull.api.fxgold.com/realtime/products?codes=TJAG,TJMAG,TJAP,TJMAP,TJAG30KG,TJNI,TJMPD,TJPD,TJMNI,TJCU,TJCU1T,TJAL,TJAL1T";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangqing_fg);
        //获取数据
        initData();


        iniController();
        iniListener();
        iniVariable();

        mRadioButton1.setChecked(true);
        mViewPager.setCurrentItem(1);
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();
    }

    private void initData() {
        //全球外汇数据
        initGlobalData();
        //现货黄金数据
        initXianHuoJin();
        //COMEX数据
        initComexData();
        //上海金数据
        initShangHaiData();
        //伦敦金属数据
        initLonDonData();
        //天通银数据
        initTianTongData();
    }

    private void initGlobalData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog=ProgressDialog.show(this,"全球外汇","加载中》》》》》》");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                urlGlobal,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        ArrayList<GlobalCurrencyData> datas=gson.fromJson(s,new TypeToken<ArrayList<GlobalCurrencyData>>(){}.getType());
                        mGlobalCurrencyDatas.addAll(datas);
                        mGlobalAdapter.notifyDataSetChanged();
                        Log.e("全球外汇","加载成功");
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(GlobalCurrency.this,"失败。。。",Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
    private void initXianHuoJin(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog=ProgressDialog.show(this,"现货黄金","加载ing>>>>>>>>");
        StringRequest request=new StringRequest(
                Request.Method.GET,
                urlXianHuo,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        ArrayList<XianHuoHuangJinData> datas=gson.fromJson(s,new TypeToken<ArrayList<XianHuoHuangJinData>>(){}.getType());
                        mXianHuoHuangJinDatas.addAll(datas);
                        mXianHuoHuangJinAdapter.notifyDataSetChanged();
                        Log.e("现货黄金","加载成功");
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("现货黄金","加载失败");
                        progressDialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
    private void initComexData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"COMEX","加载ing.........");
        StringRequest request=new StringRequest(Request.Method.GET,
                urlComex,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        ArrayList<ComexData> list=gson.fromJson(s,new TypeToken<ArrayList<ComexData>>(){}.getType());
                        mComexDatas.addAll(list);
                        mComexAdapter.notifyDataSetChanged();
                        Log.e("COMEX","加载成功");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("COMEX","加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
    private void initShangHaiData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"上海金","加载ing.........");
        StringRequest request=new StringRequest(Request.Method.GET,
                urlShangHai,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        ArrayList<ShangHaiJinData> list=gson.fromJson(s,new TypeToken<ArrayList<ShangHaiJinData>>(){}.getType());
                        mShangHaiJinDatas.addAll(list);
                        mShangHaiJinAdapter.notifyDataSetChanged();
                        Log.e("上海金","加载成功");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("上海金","加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
    private void initLonDonData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"伦敦金属","加载ing.........");
        StringRequest request=new StringRequest(Request.Method.GET,
                urlLonDon,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        ArrayList<LondonJinData> list=gson.fromJson(s,new TypeToken<ArrayList<LondonJinData>>(){}.getType());
                        mLondonJinDatas.addAll(list);
                        mLonDonJinAdapter.notifyDataSetChanged();
                        Log.e("伦敦金属","加载成功");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("伦敦金属","加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
    private void initTianTongData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ProgressDialog dialog=ProgressDialog.show(this,"天通银","加载ing.........");
        StringRequest request=new StringRequest(Request.Method.GET,
                urlTianTong,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        ArrayList<TianTongYinData> list=gson.fromJson(s,new TypeToken<ArrayList<TianTongYinData>>(){}.getType());
                        mTianTongYinDatas.addAll(list);
                        mTianTongYinAdapter.notifyDataSetChanged();
                        Log.e("天通银","加载成功");
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("天通银","加载失败");
                        dialog.dismiss();
                    }
                }
        );
        requestQueue.add(request);
    }
    private void iniVariable() {
//         TODO Auto-generated method stub
        mViews = new ArrayList<View>();
        mViews.add(getLayoutInflater().inflate(R.layout.activity_null,null));
        mViews.add(global_lv);
        mViews.add(xianhuojin_lv);
        mViews.add(comex_lv);
        mViews.add(shanghaijin_lv);
        mViews.add(londonjin_lv);
        mViews.add(tiantongyin_lv);
        mViews.add(getLayoutInflater().inflate(R.layout.activity_null,null));

        mViewPager.setAdapter(new MyPagerAdapter());//设置ViewPager的适配器
    }
    /**
     * RadioGroup点击CheckedChanged监听
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        AnimationSet _AnimationSet = new AnimationSet(true);
        TranslateAnimation _TranslateAnimation;
        clearColor();
        Log.i("zj", "checkedid="+checkedId);
        if (checkedId == R.id.radiobt1) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo1), 0f, 0f);
            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton1.setTextColor(yellow);

            mViewPager.setCurrentItem(1);//让下方ViewPager跟随上面的HorizontalScrollView切换
        }else if (checkedId == R.id.radiobt2) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo2), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton2.setTextColor(yellow);

            mViewPager.setCurrentItem(2);
        }else if (checkedId == R.id.radiobt3) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo3), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton3.setTextColor(yellow);

            mViewPager.setCurrentItem(3);
        }else if (checkedId == R.id.radiobt4) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo4), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton4.setTextColor(yellow);

            mViewPager.setCurrentItem(4);
        }else if (checkedId == R.id.radiobt5) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo5), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);
            mRadioButton5.setTextColor(yellow);

            mViewPager.setCurrentItem(5);
        }else if (checkedId == R.id.radiobt6) {
            _TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo6), 0f, 0f);

            _AnimationSet.addAnimation(_TranslateAnimation);
            _AnimationSet.setFillBefore(false);
            _AnimationSet.setFillAfter(true);
            _AnimationSet.setDuration(100);

            //mImageView.bringToFront();
            //mImageView.startAnimation(_AnimationSet);
            mRadioButton6.setTextColor(yellow);
            mViewPager.setCurrentItem(6);
        }

        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();

        Log.i("zj", "getCurrentCheckedRadioLeft="+getCurrentCheckedRadioLeft());
        Log.i("zj", "getDimension="+getResources().getDimension(R.dimen.rdo2));

        mHorizontalScrollView.smoothScrollTo((int)mCurrentCheckedRadioLeft-(int)getResources().getDimension(R.dimen.rdo2), 0);
    }
    //初始化未选中的标签为白色
    private void clearColor(){
        mRadioButton1.setTextColor(white);
        mRadioButton2.setTextColor(white);
        mRadioButton3.setTextColor(white);
        mRadioButton4.setTextColor(white);
        mRadioButton5.setTextColor(white);
        mRadioButton6.setTextColor(white);
    }
    /**
     * 获得当前被选中的RadioButton距离左侧的距离
     */
    private float getCurrentCheckedRadioLeft() {
        // TODO Auto-generated method stub
        if (mRadioButton1.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo1));
            return getResources().getDimension(R.dimen.rdo1);
        }else if (mRadioButton2.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo2));
            return getResources().getDimension(R.dimen.rdo2);
        }else if (mRadioButton3.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo3));
            return getResources().getDimension(R.dimen.rdo3);
        }else if (mRadioButton4.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo4));
            return getResources().getDimension(R.dimen.rdo4);
        }else if (mRadioButton5.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo5));
            return getResources().getDimension(R.dimen.rdo5);
        }else if (mRadioButton6.isChecked()) {
            //Log.i("yuxinhui", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo6));
            return getResources().getDimension(R.dimen.rdo6);
        }
        return 0f;
    }

    private void iniListener() {
        // TODO Auto-generated method stub

        mRadioGroup.setOnCheckedChangeListener(this);


        mViewPager.setOnPageChangeListener(new MyPagerOnPageChangeListener());
    }
    private void iniController() {
        // TODO Auto-generated method stub
        mRadioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        mRadioButton1 = (RadioButton)findViewById(R.id.radiobt1);
        mRadioButton2 = (RadioButton)findViewById(R.id.radiobt2);
        mRadioButton3 = (RadioButton)findViewById(R.id.radiobt3);
        mRadioButton4 = (RadioButton)findViewById(R.id.radiobt4);
        mRadioButton5 = (RadioButton)findViewById(R.id.radiobt5);
        mRadioButton6 = (RadioButton)findViewById(R.id.radiobt6);
        mViewPager = (ViewPager)findViewById(R.id.hangqing_pager);
        global_lv= (ListView) getLayoutInflater().inflate(R.layout.activity_globalcurrency,null).findViewById(R.id.global_lv);
        mGlobalAdapter=new GlobalAdapter(mGlobalCurrencyDatas,GlobalCurrency.this);
        global_lv.setAdapter(mGlobalAdapter);

        xianhuojin_lv= (ListView) getLayoutInflater().inflate(R.layout.activity_xianhuohuangjin, null).findViewById(R.id.xianhuojin_lv);
        mXianHuoHuangJinAdapter=new XianHuoHuangJinAdapter(mXianHuoHuangJinDatas,GlobalCurrency.this);
        xianhuojin_lv.setAdapter(mXianHuoHuangJinAdapter);

        comex_lv= (ListView) getLayoutInflater().inflate(R.layout.activity_comex,null).findViewById(R.id.comex_lv);
        mComexAdapter=new ComexAdapter(mComexDatas,GlobalCurrency.this);
        comex_lv.setAdapter(mComexAdapter);

        shanghaijin_lv= (ListView) getLayoutInflater().inflate(R.layout.activity_shanghaijin,null).findViewById(R.id.shanghaijin_lv);
        mShangHaiJinAdapter=new ShangHaiJinAdapter(mShangHaiJinDatas,GlobalCurrency.this);
        shanghaijin_lv.setAdapter(mShangHaiJinAdapter);

        londonjin_lv= (ListView) getLayoutInflater().inflate(R.layout.activity_londonmetal,null).findViewById(R.id.londonjin_lv);
        mLonDonJinAdapter=new LonDonJinAdapter(mLondonJinDatas,GlobalCurrency.this);
        londonjin_lv.setAdapter(mLonDonJinAdapter);

        tiantongyin_lv= (ListView) getLayoutInflater().inflate(R.layout.activity_tiantongyin,null).findViewById(R.id.tiantongyin_lv);
        mTianTongYinAdapter=new TianTongYinAdapter(mTianTongYinDatas,GlobalCurrency.this);
        tiantongyin_lv.setAdapter(mTianTongYinAdapter);

        mHorizontalScrollView = (HorizontalScrollView)findViewById(R.id.horizontalScrollView);


    }
    /**
     * ViewPager的适配器
     * 下午2:26:57
     */
    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position%mViews.size()));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViews.get(position%mViews.size()));
            return mViews.get(position%mViews.size());
        }


        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
    /**
     * ViewPager的PageChangeListener(页面改变的监听器)
     * 3:14:27
     */
    private class MyPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }
        /**
         * 滑动ViewPager的时候,让上方的HorizontalScrollView自动切换
         */
        @Override
        public void onPageSelected(int position) {
            // TODO Auto-generated method stub
            //Log.i("zj", "position="+position);

            if (position == 0) {
                mViewPager.setCurrentItem(0);
            }else if (position == 1) {
                mRadioButton1.performClick();
            }else if (position == 2) {
                mRadioButton2.performClick();
            }else if (position == 3) {
                mRadioButton3.performClick();
            }else if (position == 4) {
                mRadioButton4.performClick();
            }else if (position == 5) {
                mRadioButton5.performClick();
            }else if (position == 6) {
                mRadioButton6.performClick();
            }else if (position == 7) {
                mViewPager.setCurrentItem(6);
            }
        }

    }
}
