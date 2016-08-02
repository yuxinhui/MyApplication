package com.yuxinhui.text.myapplication.Bean;

/**
 * Created by Administrator on 2016/7/26.
 */

public class LevelMessage {

    /**
     * message : 等级图片查找成功！
     * status : ok
     * data : http://192.168.0.105:8080/jmj/upload/4b895a92-664f-44cb-8e46-b51c7f31fdb7.png
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
        return "LevelMessage{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
