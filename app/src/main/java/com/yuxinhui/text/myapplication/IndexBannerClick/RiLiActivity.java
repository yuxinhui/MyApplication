package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;

/**
 * Created by Administrator on 2016/6/15.
 */
public class RiLiActivity extends Activity {
    WebView wv;
    ProgressDialog pd;
    Handler handler;
    ImageView rili_return_img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rili);
        init();//执行初始化函数
        loadurl(wv, "http://m.jin10.com/rili");
        //file:///android_asset/www/xueyuan.html
        rili_return_img= (ImageView) findViewById(R.id.rili_return_img);
        rili_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RiLiActivity.this,MainActivity.class);
                startActivity(intent);
                RiLiActivity.this.finish();
            }
        });
    }

    public void init() {
        // Progress
        pd = new ProgressDialog(RiLiActivity.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("数据载入中，请稍候！");
        // Show/Hide message
        handler = new Handler() {
            public void handleMessage(Message msg) {//定义一个Handler，用于处理下载线程与UI间通讯
                if (!Thread.currentThread().isInterrupted()) {
                    switch (msg.what) {
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
        wv = (WebView) findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);//可用JS
        wv.setScrollBarStyle(0);//滚动条风格，为0就是不给滚动条留空间，滚动条覆盖在网页上
        wv.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
                loadurl(view, url);//载入网页
                return true;
            }//重写点击动作,用webview载入



            @Override
            public void onPageFinished(WebView view, String url) {
                if (url != null && url.contains("http://m.jin10.com/rili")) {
                    String fun = "javascript:function getClass(parent,sClass)\n" +
                            "        {\n" +
                            "            var aEle=parent.getElementsByTagName('div');\n" +
                            "            var aResult=[];\n" +
                            "            var i=0;\n" +
                            "            for(i<0;i<aEle.length;i++)\n" +
                            "            {\n" +
                            "                if(aEle[i].className==sClass)\n" +
                            "                {\n" +
                            "                    aResult.push(aEle[i]);\n" +
                            "                }\n" +
                            "            };\n" +
                            "            return aResult;\n" +
                            "        }";
                    view.loadUrl(fun);
                    String fun1="javascript:function hideOther()\n" +
                            "        {\n" +
                            "            getClass(document,'dlappbox fixfixed')[0].style.display='none';\n" +
                            "            getClass(document,'dlapp')[0].style.display='none';\n" +
                            "            getClass(document,'dlappinner')[0].style.display='none';\n" +
                            "            getClass(document,'apptitle')[0].style.display='none';\n" +
                            "            getClass(document,'appabout')[0].style.display='none';\n" +
                            "            getClass(document,'appopen')[0].style.display='none';\n" +
                            "            getClass(document,'')[0].style.display='none';\n" +
                            "            document.getElementById('applepop').style.display='none';\n" +
                            "            document.getElementById('androdpop').style.display='none';\n" +
                            "        }";
                    view.loadUrl(fun1);
                    view.loadUrl("javascript:hideOther();");

                    String fun3="javascript:function hideOther1(){\n" +
                            "            document.getElementsByTagName('footer')[0].style.display='none';\n" +
                            "            getClass(document,'  icon time')[0].style.display='none';\n" +
                            "            getClass(document,' icon news ')[0].style.display='none';\n" +
                            "            getClass(document,' icon video ')[0].style.display='none';\n" +
                            "            getClass(document,' icon market ')[0].style.display='none';\n" +
                            "            getClass(document,' icon calender ')[0].style.display='none';\n" +
                            "            getClass(document,' icon live')[0].style.display='none';\n" +
                            "        }";
                    view.loadUrl(fun3);
                    view.loadUrl("javascript:hideOther1();");
                }
                super.onPageFinished(view, url);
            }
        });
        wv.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {//载入进度改变而触发
                if (progress == 100) {
                    handler.sendEmptyMessage(1);//如果全部载入,隐藏进度对话框
                }
                super.onProgressChanged(view, progress);
            }
        });
        ;

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回键
        /*if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
            wv.goBack();
            return true;
        } else */if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(RiLiActivity.this, MainActivity.class);
            startActivity(intent);
            RiLiActivity.this.finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void loadurl(final WebView view, final String url) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                view.loadUrl(url);//载入网页
            }
        });
    }
}
