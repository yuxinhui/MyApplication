package com.yuxinhui.text.myapplication.Utils;

/**
 * Created by Administrator on 2016/7/4.
 */

public class Message {

    /**
     * message : 推荐码不能为空
     * status : fail
     * data : {"id":"5a6afd31-8cc8-477c-956c-f6d1bfc856af","username":"zsx","nickname":"zsx","password":"e10adc3949ba59abbe56e057f20f883e","gender":"1","type":0,"email":"","telephone":"","qq":"","loginIp":"120.210.165.191","state":null,"userTime":1463227860000,"rid":null,"gid":"a489350e-0a99-4fe1-81da-1d73404279b9","level":"5"}
     */

    private String message;
    private String status;
    /**
     * id : 5a6afd31-8cc8-477c-956c-f6d1bfc856af
     * username : zsx
     * nickname : zsx
     * password : e10adc3949ba59abbe56e057f20f883e
     * gender : 1
     * type : 0
     * email :
     * telephone :
     * qq :
     * loginIp : 120.210.165.191
     * state : null
     * userTime : 1463227860000
     * rid : null
     * gid : a489350e-0a99-4fe1-81da-1d73404279b9
     * level : 5
     */

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
