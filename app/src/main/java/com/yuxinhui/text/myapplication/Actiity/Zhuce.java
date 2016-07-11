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
import com.yuxinhui.text.myapplication.Utils.DialogUtils;
import com.yuxinhui.text.myapplication.Utils.Message;
import com.yuxinhui.text.myapplication.Utils.SmsMessage;
import com.yuxinhui.text.myapplication.Utils.User;
import com.yuxinhui.text.myapplication.Utils.VerCodeTImer;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Zhuce extends AppCompatActivity {
    private ImageView zhuce_return_img;
    private ImageView zhuce_home_img;
    private ImageView zhuce_img;
    private EditText zhuce_mingzi_text;
    private EditText zhuce_mima_text;
    private EditText zhuce_writeyanzheng_text;
    private TextView metVadateCode;
    String telepone,password,validateCode;
    SmsMessage smsMessage = new SmsMessage();
    Message message;
    User user;
    int time = 60;
    String url = YuXinHuiApplication.getUrlBoot()+"user/register";
    RequestQueue queue;

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
        zhuce_return_img= (ImageView) findViewById(R.id.zhuce_return_img);
        zhuce_home_img= (ImageView) findViewById(R.id.zhuce_home_img);
        zhuce_img= (ImageView) findViewById(R.id.zhuce_img);
        zhuce_mingzi_text= (EditText) findViewById(R.id.et_telephone);
        zhuce_mima_text= (EditText) findViewById(R.id.et_passwrod);
        zhuce_writeyanzheng_text= (EditText) findViewById(R.id.zhuce_writeyanzheng_text);
        metVadateCode = (TextView) findViewById(R.id.tv_validate_code);
    }

    //view控件的监听事件
    private void onClick() {
        metVadateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                if(TextUtils.isEmpty(telepone)){
                    zhuce_mingzi_text.requestFocus();
                    zhuce_mingzi_text.setError("手机号不能为空");
                    return;
                }
                if(telepone.length()!=11||!telepone.startsWith("1")){
                    zhuce_mingzi_text.setError("请输入正确的手机号");
                    zhuce_mingzi_text.requestFocus();
                    return;
                }
                String url_getcode = "http://114.55.98.142/sms/tel_code?telphone="+telepone;
                getVerCode(url_getcode);
                Log.e("TAG", smsMessage.getStatus());
                if("fail".equals(smsMessage.getStatus())){
                    metVadateCode.setText(smsMessage.getMessage());
                    return;
                }
                VerCodeTImer vct = new VerCodeTImer(60000, 1000, metVadateCode);
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
                if(TextUtils.isEmpty(telepone)){
                    zhuce_mingzi_text.requestFocus();
                    zhuce_mingzi_text.setError("手机号不能为空");
                    return;
                }
                if(telepone.length()!=11||!telepone.startsWith("1")){
                    zhuce_mingzi_text.setError("请输入正确的手机号");
                    zhuce_mingzi_text.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    zhuce_mima_text.requestFocus();
                    zhuce_mima_text.setError("密码不能为空");
                    return;
                }
                if (metVadateCode.getText().toString().equals("重新获取验证码")) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            DialogUtils.createToasdt(Zhuce.this,"验证码已经过期，请重新获取");
                        }
                    });
                    return;
                }
                if(TextUtils.isEmpty(validateCode)){
                    zhuce_writeyanzheng_text.requestFocus();
                    zhuce_writeyanzheng_text.setError("验证码不能为空");
                    return;
                }
                register();
                return;
            }
        });
    }

    //注册的volley请求
    public void register(){
        user = YuXinHuiApplication.getInstace().getUser();
        user.setTelephone(telepone);
        user.setPassword(password);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                message = gson.fromJson(s, Message.class);
                if(message.getStatus().equals("success")){
                    Denglu denglu = new Denglu();
                    denglu.login(telepone,password);
                }
                Intent intent = new Intent(Zhuce.this, ZhuCeXiangQing.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogUtils.createToasdt(Zhuce.this,"请检查网络连接是否正确");
                    }
                });
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Gson g = new Gson();
                Map<String, String> params = new HashMap<>();
                params.put("user",g.toJson(user));
                params.put("validateCode", validateCode);
                return params;
            }
        };
        queue.add(request);
    }

    //获取验证码的volley请求
    public void getVerCode(String url_getCode){
        StringRequest requestVerCode = new StringRequest(Request.Method.GET, url_getCode, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("TAG", s);
                Gson gson = new Gson();
                smsMessage = gson.fromJson(s, SmsMessage.class);
                Log.e("TAG", smsMessage.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogUtils.createToasdt(Zhuce.this,"请检查网络连接是否正确");
                    }
                });
            }
        });
        queue.add(requestVerCode);
    }
}
