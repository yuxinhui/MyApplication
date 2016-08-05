package com.yuxinhui.text.myapplication.Fragment.zhibo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gensee.utils.StringUtil;
import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.Bean.ChatMessage;
import com.yuxinhui.text.myapplication.Bean.LevelMessage;
import com.yuxinhui.text.myapplication.Bean.ShowMessaage;
import com.yuxinhui.text.myapplication.Bean.User;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.DialogUtils;
import com.yuxinhui.text.myapplication.Utils.NetUtil;
import com.yuxinhui.text.myapplication.Utils.ParseEmojiMsgUtil;
import com.yuxinhui.text.myapplication.Utils.RequestManager;
import com.yuxinhui.text.myapplication.Utils.SelectFaceHelper;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;
import com.yuxinhui.text.myapplication.adapter.ChatAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by "于志渊"
 * 时间:"10:52"
 * 包名:com.yuxinhui.text.myapplication.Fragment.zhibo
 * 描述:直播聊天界面
 */
public class ZhiboChat extends Fragment {
    private ListView listView;
    private ImageView iv_select_pic,mivEmoji;
    private EditText medChat;
    private Button mbtnSend;
    private ArrayList<ShowMessaage> mList=new ArrayList<>();
    private ChatAdapter mAdapter;
    private String content;
    private MsgBroadcastReciever mReciever;

    private SelectFaceHelper mFaceHelper;
    private View addFaceToolView;
    private boolean isVisbilityFace;
    // 从图库选择图片
    public static final int REQUEST_CODE_LOCAL = 2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_zhibo_chat,container,false);
        initView(view);
        IntentFilter filter=new IntentFilter("chat_msg");
        mReciever=new MsgBroadcastReciever();
        getActivity().registerReceiver(mReciever,filter);
        setListener();
        return view;
    }

    private void setListener() {
        iv_select_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageFromLocal();
            }
        });
        mbtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content = medChat.getText().toString();
                if(StringUtil.isEmpty(content)){
                    DialogUtils.createToasdt(getActivity(),"请输入正确的内容");
                    return;
                }
                ShowMessaage message = new ShowMessaage();
                String msgStr = ParseEmojiMsgUtil.convertToMsg(medChat.getText(), getActivity());// 这里不要直接用medChat.getText().toString();
                message.setContent(msgStr);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
                Date curdate = new Date(System.currentTimeMillis());
                String time = format.format(curdate);
                message.setTime(time);
                message.setUsername(YuXinHuiApplication.getInstace().getUser().getNickname());
                getLevelUrl(YuXinHuiApplication.getInstace().getUser().getId(),message);
                medChat.setText(null);
                sendMessage(msgStr);
            }
        });
        mivEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null == mFaceHelper) {
                    mFaceHelper = new SelectFaceHelper(getActivity(), addFaceToolView);
                    mFaceHelper.setFaceOpreateListener(new SelectFaceHelper.OnFaceOprateListener() {
                        @Override
                        public void onFaceSelected(SpannableString spanEmojiStr) {
                            if (null != spanEmojiStr) {
                                medChat.append(spanEmojiStr);
                            }
                        }
                        @Override
                        public void onFaceDeleted() {
                            int selection = medChat.getSelectionStart();
                            String text = medChat.getText().toString();
                            if (selection > 0) {
                                String text2 = text.substring(selection - 1);
                                if ("]".equals(text2)) {
                                    int start = text.lastIndexOf("[");
                                    int end = selection;
                                    medChat.getText().delete(start, end);
                                    return;
                                }
                                medChat.getText().delete(selection - 1, selection);
                            }
                        }
                    });
                }
                if (isVisbilityFace) {
                    isVisbilityFace = false;
                    addFaceToolView.setVisibility(View.GONE);
                } else {
                    isVisbilityFace = true;
                    addFaceToolView.setVisibility(View.VISIBLE);
                    hideInputManager(getActivity());
                }
            }
        });
    }
    // 隐藏软键盘
    public void hideInputManager(Context ct) {
        try {
            ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(((Activity) ct)
                    .getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            Log.e("TAG", "hideInputManager Catch error,skip it!", e);
        }
    }
    public void onBackPressed() {
        if (isVisbilityFace) {// 好吧,隐藏表情菜单再退出
            isVisbilityFace = false;
            addFaceToolView.setVisibility(View.GONE);
            return;
        }
    }
    private void initView(final View view) {
        listView = (ListView) view.findViewById(R.id.zhibo_chat_lv);
        mivEmoji = (ImageView) view.findViewById(R.id.iv_select_emoji);
        iv_select_pic= (ImageView) view.findViewById(R.id.iv_select_pic);
        medChat = (EditText) view.findViewById(R.id.et_chat);
        mbtnSend = (Button) view.findViewById(R.id.btn_send);
        RequestManager.init(getActivity());
        mAdapter=new ChatAdapter(getContext(),getActivity(),mList);
        listView.setAdapter(mAdapter);
        addFaceToolView = (View) view.findViewById(R.id.add_tool);
        medChat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isVisbilityFace = false;
                addFaceToolView.setVisibility(View.GONE);
                return false;
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode == REQUEST_CODE_LOCAL && data != null) {
                // 选完图片后隐藏选择布局
                Uri uri = data.getData();
                String[] proj = { MediaStore.Images.Media.DATA };
                Cursor actualimagecursor = getActivity().getContentResolver().query(uri, proj, null, null, null);
                int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                actualimagecursor.moveToFirst();
                final String img_path = actualimagecursor.getString(actual_image_column_index);
                Log.e("IMG", img_path);
                ShowMessaage messaage = new ShowMessaage();
                messaage.setType(ShowMessaage.MESSAGE_TYPE_SEND_IMAGE);
                messaage.setContent(img_path);
                messaage.setUsername(YuXinHuiApplication.getInstace().getUser().getNickname());
                getLevelUrl(YuXinHuiApplication.getInstace().getUser().getId(),messaage);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
                messaage.setTime(format.format(new Date(System.currentTimeMillis())));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            NetUtil.uploadAvatar(getActivity(),img_path);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }
    //从图库获取图片
    public void selectImageFromLocal(){
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
        } else {
            intent = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        startActivityForResult(intent, REQUEST_CODE_LOCAL);
    }
    @Override
    public void onDestroy() {
        getActivity().unregisterReceiver(mReciever);
        super.onDestroy();
    }
    //往服务器发送文字信息
    private void sendMessage(String msg) {
        User user = YuXinHuiApplication.getInstace().getUser();
        String url = YuXinHuiApplication.URL_BOOT +"msg/app_toReview?sid="+user.getId()+"&sname="+user.getNickname()+"&stype="+user.getType()+"&content="+msg+"&gid="+ user.getGid()+"&checked=0";
        Log.e("TAG", url);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("发送消息","失败");
            }
        });
        queue.add(request);
    }
    private class MsgBroadcastReciever extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            ChatMessage chatMessage = (ChatMessage) extras.getSerializable("chatMessage");
            ShowMessaage showMessage = new ShowMessaage();
            showMessage.setUsername(chatMessage.getSname());
            showMessage.setContent(chatMessage.getContent());
            showMessage.setTime(chatMessage.getTime());
            if (chatMessage.getContent().contains(YuXinHuiApplication.URL_BOOT)){
                showMessage.setType(ShowMessaage.MESSAGE_TYPE_SEND_IMAGE);
            }
            getLevelUrl(chatMessage.getSid(),showMessage);
        }
    }
    //获取用户等级
    public void getLevelUrl(String sid,final ShowMessaage message){
        String url = YuXinHuiApplication.URL_BOOT+"app_dispLevel?id="+sid;
        Log.e("level", url);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson g = new Gson();
                LevelMessage levelMessage = g.fromJson(s, LevelMessage.class);
                message.setLevelUrl(YuXinHuiApplication.URL_BOOT +levelMessage.getData());
                mList.add(message);
                mAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                DialogUtils.createToasdt(getActivity(),"请检查网络是否正确");
            }
        });
        queue.add(request);
    }
}