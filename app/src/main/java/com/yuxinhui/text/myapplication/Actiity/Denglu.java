package com.yuxinhui.text.myapplication.Fragment.Actiity;

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
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Denglu extends AppCompatActivity {
    private ImageView denglu_return_img;
    private ImageView denglu_home_img;
    private ImageView denglu_img;
    private EditText denglu_mingzi_text;
    private EditText denglu_mima_text;
    private TextView wangjiMM_text;
    private TextView zhuce_text;
    String  loginId,password,telephone,userName;
    String url = YuXinHuiApplication.getUrlBoot()+"user/login";
    User user;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);
        queue = Volley.newRequestQueue(this);
        //初始化控件
        initView();
        initData();
        setOnClikListener();
    }

    //view控件的监听事件
    private void setOnClikListener() {
        denglu_return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Denglu.this.finish();
            }
        });
        denglu_home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denglu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        zhuce_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denglu.this, Zhuce.class);
                startActivity(intent);
            }
        });
        wangjiMM_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });
        denglu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                if (TextUtils.isEmpty(loginId)) {
                    denglu_mingzi_text.setError("电话或者用户名不能为空");
                    denglu_mingzi_text.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    denglu_mima_text.setError("密码不能为空");
                    denglu_mima_text.requestFocus();
                }
                login(loginId,password);
            }
        });
    }

    private void initData() {
        loginId = denglu_mingzi_text.getText().toString();
        password = denglu_mima_text.getText().toString();
    }

    //初始化控件
    private void initView() {
        denglu_return_img= (ImageView) findViewById(R.id.denglu_return_img);
        denglu_home_img= (ImageView) findViewById(R.id.denglu_home_img);
        denglu_img= (ImageView) findViewById(R.id.denglu_img);
        denglu_mingzi_text= (EditText) findViewById(R.id.denglu_mingzi_text);
        denglu_mima_text= (EditText) findViewById(R.id.denglu_mima_text);
        wangjiMM_text= (TextView) findViewById(R.id.wangjiMM_text);
        zhuce_text= (TextView) findViewById(R.id.zhuce_text);
    }

    //使用volley进行登录操作
    public void login(String nameortele,String password) {
        user = new User();
        if (nameortele.length()==11&&nameortele.startsWith("1")){
            telephone = nameortele;
            user.setTelephone(telephone);
        }else {
            userName = nameortele;
            user.setUsername(userName);
        }
        user.setPassword(password);
        Log.e("TAG", user.toString());
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("TAG",s);
                if(s.contains("ok")){
                    Gson gson = new Gson();
                    Message message = gson.fromJson(s, Message.class);
                    YuXinHuiApplication.getInstace().setUser(message.getUser());
                    YuXinHuiApplication.getInstace().setLogin(true);
                    Intent intent = new Intent(Denglu.this, MainActivity.class);
                    startActivity(intent);
                    DialogUtils.createToasdt(Denglu.this,message.getMessage());
                }else {
                    DialogUtils.createToasdt(Denglu.this,"用户名或者密码错误");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogUtils.createToasdt(Denglu.this,"请检查网络连接是否正确");
                    }
                });
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user",user.toString());
                return params;
            }
        };
        queue.add(request);
    }
}
