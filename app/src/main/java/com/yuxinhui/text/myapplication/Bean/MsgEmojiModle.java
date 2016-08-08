package com.yuxinhui.text.myapplication.Bean;

/**
 * Created by "于志渊"
 * 时间:"10:36"
 * 包名:com.yuxinhui.text.myapplication.Actiity
 * 描述:表情数据类型
 */
public class MsgEmojiModle {
    private int id;//表情资源图片对应的ID
    private String character;//表情资源对应的文字描述

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
