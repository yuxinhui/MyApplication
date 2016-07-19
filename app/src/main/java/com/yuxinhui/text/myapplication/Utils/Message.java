package com.yuxinhui.text.myapplication.Utils;

/**
 * Created by Administrator on 2016/7/4.
 */

public class Message {

    /**
     * message : 登录成功
     * status : ok
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

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String username;
        private String nickname;
        private String password;
        private String gender;
        private int type;
        private String email;
        private String telephone;
        private String qq;
        private String loginIp;
        private String state;
        private long userTime;
        private String rid;
        private String gid;
        private String level;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public long getUserTime() {
            return userTime;
        }

        public void setUserTime(long userTime) {
            this.userTime = userTime;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", username='" + username + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", password='" + password + '\'' +
                    ", gender='" + gender + '\'' +
                    ", type=" + type +
                    ", email='" + email + '\'' +
                    ", telephone='" + telephone + '\'' +
                    ", qq='" + qq + '\'' +
                    ", loginIp='" + loginIp + '\'' +
                    ", state=" + state +
                    ", userTime=" + userTime +
                    ", rid=" + rid +
                    ", gid='" + gid + '\'' +
                    ", level='" + level + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data.toString() +
                '}';
    }

    public User getUser(){
        User user = new User();
        user.setType(getData().getType());
        user.setGid(getData().getGid());
        user.setId(getData().getId());
        user.setGender(getData().getGender());
        user.setLevel(getData().getLevel());
        user.setPassword(getData().getPassword());
        user.setUsername(getData().getUsername());
        user.setTelephone(getData().getTelephone());
        user.setEmail(getData().getEmail());
        user.setRid(getData().getRid());
        user.setState(getData().getState());
        user.setNickname(getData().getNickname());
        user.setQq(getData().getQq());
        return user;
    }
}
