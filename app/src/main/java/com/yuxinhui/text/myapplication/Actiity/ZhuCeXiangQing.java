package com.yuxinhui.text.myapplication.Actiity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.yuxinhui.text.myapplication.Utils.User;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/2.
 * 提交个人信息的类
 */
public class ZhuCeXiangQing extends AppCompatActivity {
    Zhuce zhuce;
    EditText metUserName,metNick,metQQ,metSex,metFactor;
    TextView mtvCommit;
    ImageView mivReturn;
    User user;
    String url =YuXinHuiApplication.getUrlBoot()+ "user/perfectInfo";
    String nick,userName,QQ, gendar,telephone;
    Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhucexiangqing);
        zhuce = new Zhuce();
        zhuce.finish();
        telephone = YuXinHuiApplication.getInstace().getUser().getTelephone();
        initView();
        initData();
        setOnClickListener();
    }

    //将数据封装到User类中
    private void initData() {
        nick = metNick.getText().toString();
        userName = metUserName.getText().toString();
        QQ = metQQ.getText().toString();
        gendar = metSex.getText().toString();
    }

    private void setOnClickListener() {
        mivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZhuCeXiangQing.this.finish();
            }
        });
        mtvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                if(TextUtils.isEmpty(nick)){
                    metNick.requestFocus();
                    metNick.setError("昵称不能为空");
                    return;
                }
                if(TextUtils.isEmpty(userName)){
                    metUserName.requestFocus();
                    metUserName.setError("用户名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(QQ)) {
                    metQQ.requestFocus();
                    metQQ.setError("QQ不能为空");
                    return;
                }
                if(TextUtils.isEmpty(gendar)){
                    gendar="男";
                }
                user = new User();
                user.setNickname(nick);
                user.setUsername(userName);
                user.setQq(QQ);
                user.setGender(gendar);
                user.setTelephone(telephone);
                updateData();
            }
        });
    }

    public void showTip(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ZhuCeXiangQing.this,"上传失败请检查网络设置",Toast.LENGTH_LONG).show();
            }
        });
    }

    //发送Post请求去完善个人信息
    private void updateData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                message = gson.fromJson(s, Message.class);
                if(message.getStatus()!="fail"){
                    YuXinHuiApplication.getInstace().setUser(message.getUser());
                }else {
                    DialogUtils.createToasdt(ZhuCeXiangQing.this,message.getMessage());
                }
                Intent intent = new Intent(ZhuCeXiangQing.this, MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                showTip();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Gson gson = new Gson();
                String s = gson.toJson(user);
                Map<String, String> params = new HashMap<>();
                params.put("user",s);
                return params;
            }
        };
        queue.add(request);
    }

    private void initView() {
        mivReturn = (ImageView) findViewById(R.id.zhucexiangqing_return_img);
        metUserName = (EditText) findViewById(R.id.et_username);
        metNick = (EditText) findViewById(R.id.et_nick);
        metQQ = (EditText) findViewById(R.id.et_qq);
        metSex = (EditText) findViewById(R.id.et_sex);
        mtvCommit = (TextView) findViewById(R.id.userinfo_commit);
    }

}
