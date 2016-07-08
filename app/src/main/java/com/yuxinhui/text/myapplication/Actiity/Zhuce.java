package com.yuxinhui.text.myapplication.Fragment.Actiity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gensee.utils.StringUtil;
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
import com.yuxinhui.text.myapplication.adapter.DailiAdapter;

import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/1.
 *请求代理商接口 http://192.168.0.107:8080/jmj/agent/findAll
 */
public class Zhuce extends AppCompatActivity {
    DailiAdapter adapter;
    ListView mlistView;
    ArrayList<DailiBean.DataBean> list;

    private ImageView zhuce_return_img;
    private ImageView zhuce_home_img;
    private ImageView zhuce_img;
    private EditText zhuce_mingzi_text;
    private EditText zhuce_mima_text;
    private EditText zhuce_writeyanzheng_text;
    private TextView metVadateCode;
    private EditText metGid;
    String telepone,password,validateCode;
    SmsMessage smsMessage = new SmsMessage();
    Message message;
    User user;
    String url = "192.168.0.33/user/register";
    RequestQueue queue;
    String gid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce);
        queue = Volley.newRequestQueue(this);
        list = new ArrayList<>();
        getDaili();
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
        metGid = (EditText) findViewById(R.id.et_gid);
        mlistView = (ListView) findViewById(R.id.daili_list);
        adapter = new DailiAdapter(list, this);
        mlistView.setAdapter(adapter);
    }

    //view控件的监听事件
    private void onClick() {
        metGid.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    mlistView.setVisibility(View.VISIBLE);
                }else{
                    mlistView.setVisibility(View.GONE);
                }
            }
        });
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                metGid.setText(list.get(position).getAgentName());
                gid = list.get(position).getId();
                mlistView.setVisibility(View.GONE);
            }
        });
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
                String url_getcode = "http://114.55.98.142/sms/tel_code?telephone="+telepone;
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
        Log.e("TAG", gid);
        user = YuXinHuiApplication.getInstace().getUser();
        user.setTelephone(telepone);
        user.setPassword(password);
//        user.setGid("jmj");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("TAG", String.valueOf(jsonObject));
                Gson gson = new Gson();
                Message message = gson.fromJson(String.valueOf(jsonObject), Message.class);
                if(!message.getStatus().equals("fail")){
                    YuXinHuiApplication.getInstace().setUser(user);
                    Intent intent = new Intent(Zhuce.this, ZhuCeXiangQing.class);
                    startActivity(intent);
                }
                DialogUtils.createToasdt(Zhuce.this,message.getMessage());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                DialogUtils.createToasdt(Zhuce.this,"请检查网络连接是否正确");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Gson g = new Gson();
                Map<String, String> params = new HashMap<>();
                params.put("user", user.toString());
                params.put("tel_code", validateCode);
                params.put("gid",gid);
                Log.e("TAG", params.toString());
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
                if("fail".equals(smsMessage.getStatus())){
                    DialogUtils.createToasdt(Zhuce.this,smsMessage.getMessage());
                    return;
                }
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

    //下载代理商的数据
    public void getDaili(){
        String url_daili = "http://114.55.98.142/agent/findAll?code=jfcj";
        StringRequest request = new StringRequest(Request.Method.GET, url_daili, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                DailiBean dailiBean = gson.fromJson(s, DailiBean.class);
                ArrayList<DailiBean.DataBean> l = (ArrayList<DailiBean.DataBean>) dailiBean.getData();
                list.addAll(l);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                DialogUtils.createToasdt(Zhuce.this,"请检查网络连接是否正确");
            }
        });
        queue.add(request);
    }
}
