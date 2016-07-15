package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;

/**
 * Created by Administrator on 2016/6/15.
 */
public class RiLiActivity extends Activity{
    /** Called when the activity is first created. */
    WebView wv;
    ProgressDialog pd;
    Handler handler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rili);
        init();//执行初始化函数
        loadurl(wv,"http://m.jin10.com/rili");
    }

    public void init(){
        // Progress
        pd=new ProgressDialog(RiLiActivity.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("数据载入中，请稍候！");
        // Show/Hide message
        handler=new Handler(){
            public void handleMessage(Message msg)
            {//定义一个Handler，用于处理下载线程与UI间通讯
                if (!Thread.currentThread().isInterrupted())
                {
                    switch (msg.what)
                    {
                        case 0:
                            pd.show();//显示进度对话框
                            break;
                        case 1:
                            pd.hide();//隐藏进度对话框，不可使用dismiss()、cancel(),否则再次调用show()时，显示的对话框小圆圈不会动。
                            break;
                    }
                }
                super.handleMessage(msg);
            }
        };
        // WebView
        wv=(WebView)findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);//可用JS
        wv.setScrollBarStyle(0);//滚动条风格，为0就是不给滚动条留空间，滚动条覆盖在网页上
        wv.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
                loadurl(view,url);//载入网页
                return true;
            }//重写点击动作,用webview载入

        });
        wv.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view,int progress){//载入进度改变而触发
                if(progress==100){
                    handler.sendEmptyMessage(1);//如果全部载入,隐藏进度对话框
                }
                super.onProgressChanged(view, progress);
            }
        });

    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回键
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
            wv.goBack();
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent(RiLiActivity.this, MainActivity.class);
            startActivity(intent);
            RiLiActivity.this.finish();
        	return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void loadurl(final WebView view,final String url){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                view.loadUrl(url);//载入网页
            }
        });
    }
}
