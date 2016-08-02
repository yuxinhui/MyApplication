package com.yuxinhui.text.myapplication.Bean;

/**
 * Created by Administrator on 2016/7/27.
 */

public class ShowMessaage {
    String levelUrl;
    String username;
    String time;
    String content;

    public static final int MESSAGE_TYPE_SEND_IMAGE = 3;
    public static final int MESSAGE_TYPE_COUNT = 6;
    private int type;

    public ShowMessaage() {
    }

    public ShowMessaage(int type, String content) {
        this.type = type;
        this.content = content;
    }
    public String getLevelUrl() {
        return levelUrl;
    }

    public void setLevelUrl(String levelUrl) {
        this.levelUrl = levelUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShowMessaage{" +
                "levelUrl='" + levelUrl + '\'' +
                ", username='" + username + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    //获取txt类型的消息对象
    public static ShowMessaage createImageMessage(int type, String imagePath) {
        return new ShowMessaage(type, imagePath);
    }
}
