package com.yuxinhui.text.myapplication.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.yuxinhui.text.myapplication.Bean.ChatMessage;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/26.
 */

public class ExampleClient extends WebSocketClient {
    Context context;

    public ExampleClient(URI serverURI, Context context) {
        super(serverURI);
        this.context = context;
    }

    public ExampleClient(URI serverUri, Draft draft,Context context) {
        super(serverUri, draft);
        this.context = context;
    }

    public ExampleClient(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders, int connectTimeout,Context context) {
        super(serverUri, protocolDraft, httpHeaders, connectTimeout);
        this.context = context;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        DialogUtils.createToasdt(context,"opened");
    }

    @Override
    public void onMessage(String s) {
        Log.e("TAG", s);
        Gson gson = new Gson();
        ChatMessage chatMessage = gson.fromJson(s, ChatMessage.class);
        if(!chatMessage.getSid().equals(YuXinHuiApplication.getInstace().getUser().getId())){
            Bundle bundle = new Bundle();
            bundle.putSerializable("chatMessage",chatMessage);
            Intent intent = new Intent("chat_msg");
            intent.putExtras(bundle);
            context.sendBroadcast(intent);
        }
    }

    @Override
    public void onMessage(ByteBuffer bytes) {
        Log.e("Receive:", "数据信息已接收到");
        DialogUtils.createAlertDialog(context,"接收到服务端信息","是否显示",null);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        Log.e("Close","close connect");
    }

    @Override
    public void onError(Exception e) {
        Log.e("TAG", e.getMessage());
    }

}
