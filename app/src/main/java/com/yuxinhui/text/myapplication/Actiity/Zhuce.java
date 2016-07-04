package com.yuxinhui.text.myapplication.Actiity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.gensee.utils.StringUtil;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.MainActivity;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.DialogUtils;
import com.yuxinhui.text.myapplication.Utils.Message;
import com.yuxinhui.text.myapplication.Utils.User;
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
    private ImageView zhuce_getyanzheng_img;
    private EditText zhuce_mingzi_text;
    private EditText zhuce_mima_text;
    private EditText zhuce_writeyanzheng_text;
    private TextView metVadateCode;
    String telepone,password,validateCode;
    User user;
    String url = "http://114.55.98.142/user/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce);
        initView();
        initData();
        onClick();
    }

    private void initData() {
        telepone = zhuce_mingzi_text.getText().toString();
        password = zhuce_mima_text.getText().toString();
        validateCode = zhuce_writeyanzheng_text.getText().toString();
    }

    //初始化控件
    private void initView() {
        zhuce_return_img= (ImageView) findViewById(R.id.zhuce_return_img);
        zhuce_home_img= (ImageView) findViewById(R.id.zhuce_home_img);
        zhuce_img= (ImageView) findViewById(R.id.zhuce_img);
        zhuce_getyanzheng_img= (ImageView) findViewById(R.id.zhuce_getyanzheng_img);
        zhuce_mingzi_text= (EditText) findViewById(R.id.et_telephone);
        zhuce_mima_text= (EditText) findViewById(R.id.et_passwrod);
        zhuce_writeyanzheng_text= (EditText) findViewById(R.id.zhuce_writeyanzheng_text);
        metVadateCode = (TextView) findViewById(R.id.tv_validate_code);
    }
    //图片响应事件
    private void onClick() {
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
                if(telepone==null||telepone.equals("")){
                    zhuce_mingzi_text.setError("手机号不能为空");
                    zhuce_mingzi_text.requestFocus();
                    return;
                }
                if(StringUtil.isEmpty(password)){
                    zhuce_mima_text.setError("密码不能为空");
                    zhuce_mima_text.requestFocus();
                    return;
                }
                if (metVadateCode.getText().toString().equals("重新获取")) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            DialogUtils.createToasdt(Zhuce.this,"验证码已经过期，请重新获取");
                        }
                    });
                    return;
                }
                if(StringUtil.isEmpty(validateCode)){
                    zhuce_writeyanzheng_text.setError("验证码不能为空");
                    zhuce_writeyanzheng_text.requestFocus();
                    return;
                }
                register();
                return;
            }
        });
    }

    public void register(){
        user = YuXinHuiApplication.getInstace().getUser();
        user.setTelephone(telepone);
        user.setPassword(password);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                Message message = gson.fromJson(s, Message.class);
                if(message.getStatus().equals("success")){
                    Denglu denglu = new Denglu();
                    boolean isLogin = denglu.login();
                    if(isLogin){
                        YuXinHuiApplication.getInstace().setUser(message.getUser());
                    }
                    YuXinHuiApplication.getInstace().setLogin(isLogin);
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
}
