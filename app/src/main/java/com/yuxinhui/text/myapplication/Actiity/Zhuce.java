package com.yuxinhui.text.myapplication.Actiity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.DailiBean;
import com.yuxinhui.text.myapplication.Utils.DialogUtils;
import com.yuxinhui.text.myapplication.Utils.Message;
import com.yuxinhui.text.myapplication.Utils.SmsMessage;
import com.yuxinhui.text.myapplication.Utils.User;
import com.yuxinhui.text.myapplication.Utils.VerCodeTImer;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/1.
 * 请求代理商接口 http://192.168.0.107:8080/jmj/agent/findAll
 */
public class Zhuce extends AppCompatActivity {

    private ImageView zhuce_return_img;
    private ImageView zhuce_home_img;
    private ImageView zhuce_img;
    private EditText zhuce_mingzi_text;
    private EditText zhuce_mima_text;
    private EditText zhuce_writeyanzheng_text;
    private TextView metVadateCode;
    private EditText metGid;
    String telepone, password, validateCode;
    SmsMessage smsMessage = new SmsMessage();
    Message message;
    User user;
    String url = YuXinHuiApplication.URL_BOOT + "user/register";
    RequestQueue queue;
    String gid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce);
        queue = Volley.newRequestQueue(this);
        initView();
        initData();
        onClick();
    }

    private void initData() {
        telepone = zhuce_mingzi_text.getText().toString();
        Log.e("TAG", telepone);
        password = zhuce_mima_text.getText().toString();
        Log.e("TAg", password);
        validateCode = zhuce_writeyanzheng_text.getText().toString();
    }

    //初始化控件
    private void initView() {
        zhuce_return_img = (ImageView) findViewById(R.id.zhuce_return_img);
        zhuce_home_img = (ImageView) findViewById(R.id.zhuce_home_img);
        zhuce_img = (ImageView) findViewById(R.id.zhuce_img);
        zhuce_mingzi_text = (EditText) findViewById(R.id.et_telephone);
        zhuce_mima_text = (EditText) findViewById(R.id.et_passwrod);
        zhuce_writeyanzheng_text = (EditText) findViewById(R.id.zhuce_writeyanzheng_text);
        metVadateCode = (TextView) findViewById(R.id.tv_validate_code);
        metGid = (EditText) findViewById(R.id.et_gid);
    }

    //view控件的监听事件
    private void onClick() {
        metVadateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                if (TextUtils.isEmpty(telepone)) {
                    zhuce_mingzi_text.requestFocus();
                    zhuce_mingzi_text.setError("手机号不能为空");
                    return;
                }
                if (telepone.length() != 11 || !telepone.startsWith("1")) {
                    zhuce_mingzi_text.setError("请输入正确的手机号");
                    zhuce_mingzi_text.requestFocus();
                    return;
                }
                String url_getcode = YuXinHuiApplication.URL_BOOT + "user/tel_code?telephone=" + telepone;
                Log.e("TAG", url_getcode);
                getVerCode(url_getcode);
                VerCodeTImer vct = new VerCodeTImer(300000, 1000, metVadateCode);
                vct.start();
            }
        });
        zhuce_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Zhuce.this.finish();
                return;
            }
        });
        zhuce_home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shouye = new Intent(Zhuce.this, MainActivity.class);
                startActivity(shouye);
                return;
            }
        });
        zhuce_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                if (TextUtils.isEmpty(telepone)) {
                    zhuce_mingzi_text.requestFocus();
                    zhuce_mingzi_text.setError("手机号不能为空");
                    return;
                }
                if (telepone.length() != 11 || !telepone.startsWith("1")) {
                    zhuce_mingzi_text.setError("请输入正确的手机号");
                    zhuce_mingzi_text.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    zhuce_mima_text.requestFocus();
                    zhuce_mima_text.setError("密码不能为空");
                    return;
                }
                if (metVadateCode.getText().toString().equals("重新获取验证码")) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            DialogUtils.createToasdt(Zhuce.this, "验证码已经过期，请重新获取");
                        }
                    });
                    return;
                }
                if (TextUtils.isEmpty(validateCode)) {
                    zhuce_writeyanzheng_text.requestFocus();
                    zhuce_writeyanzheng_text.setError("验证码不能为空");
                    return;
                }
                getDaili();
                register();
                return;
            }
        });
    }

    //注册的volley请求
    public void register() {
        user = new User();
        user.setTelephone(telepone);
        user.setPassword(password);
        Log.e("TAG", user.toString());
//        ?telephone=13170015502&password=123456&tel_code=890455&gid=a489350e-0a99-4fe1-81da-1d73404279b9
//        user.setGid("jmj");
        url = url + "?telephone=" + telepone + "&password=" + password + "&tel_code=" + validateCode + "&gid=" + gid;
//        Log.e("TAG", url);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (s != null) {
                    if (s.contains("ok")) {
                        Gson gson = new Gson();
                        Message message = gson.fromJson(s, Message.class);
                        Log.e("TAG", message.toString());
                        YuXinHuiApplication.getInstace().setUser(user);
                        Intent intent = new Intent(Zhuce.this, ZhuCeXiangQing.class);
                        startActivity(intent);
                        DialogUtils.createToasdt(Zhuce.this, message.getMessage());
                    } else {
                        DialogUtils.createToasdt(Zhuce.this, "注册失败");
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                DialogUtils.createToasdt(Zhuce.this, volleyError.getMessage());
            }
        });
        queue.add(request);
    }

    //获取验证码的volley请求
    public void getVerCode(String url_getCode) {
        StringRequest requestVerCode = new StringRequest(Request.Method.GET, url_getCode, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("TAG", s);
                Gson gson = new Gson();
                smsMessage = gson.fromJson(s, SmsMessage.class);
                Log.e("TAG", smsMessage.toString());
                if ("fail".equals(smsMessage.getStatus())) {
                    DialogUtils.createToasdt(Zhuce.this, smsMessage.getMessage());
                    return;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogUtils.createToasdt(Zhuce.this, "请检查网络连接是否正确");
                    }
                });
            }
        });
        queue.add(requestVerCode);
    }

    //下载代理商的数据
    public void getDaili() {
        String url_daili = YuXinHuiApplication.URL_BOOT + "agent/findAll?code=" + metGid.getText().toString();
        Log.e("TAG", url_daili);
        StringRequest request = new StringRequest(Request.Method.GET, url_daili, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                DailiBean dailiBean = gson.fromJson(s, DailiBean.class);
                List<DailiBean.DataBean> data = dailiBean.getData();
                gid = data.get(0).getId();
                Log.e("TAG", gid);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                DialogUtils.createToasdt(Zhuce.this, "请检查网络连接是否正确");
            }
        });
        queue.add(request);
    }
}
