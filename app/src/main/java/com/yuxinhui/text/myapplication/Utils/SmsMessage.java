package com.yuxinhui.text.myapplication.Utils;

/**
 * Created by Administrator on 2016/7/5.
 */

public class SmsMessage {

    /**
     * message : 短信发送失败，请稍后再试！
     * status : fail
     * data : 676660
     */

    private String message;
    private String status;
    private String data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SmsMessage{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
