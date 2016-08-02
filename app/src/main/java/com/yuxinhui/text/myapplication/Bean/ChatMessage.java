package com.yuxinhui.text.myapplication.Bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/26.
 */

public class ChatMessage implements Serializable{

    /**
     * id : af7e0720-1a20-42af-ae7d-36af2b5a80b6
     * sid : 7aecfb0b-610d-49c9-a54a-5178b6b38687
     * sname : 1111
     * tid :
     * tname :
     * content : abcd
     * time : 2016-07-26 15:14:50
     * gid : a489350e-0a99-4fe1-81da-1d73404279b9
     * checked : 1
     */

    private String id;
    private String sid;
    private String sname;
    private String tid;
    private String tname;
    private String content;
    private String time;
    private String gid;
    private String checked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id='" + id + '\'' +
                ", sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", gid='" + gid + '\'' +
                ", checked='" + checked + '\'' +
                '}';
    }
}
