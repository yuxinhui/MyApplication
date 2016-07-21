package com.yuxinhui.text.myapplication.Bean;

/**
 * Created by Administrator on 2016/7/12.
 */

public class QQBean {

    /**
     * message : 成功！
     * status : ok
     * data : {"id":"f94ef28b-3ed7-47a2-a322-d6400f2d0f1a","qq":"284304421","qqType":0,"gid":"a489350e-0a99-4fe1-81da-1d73404279b9"}
     */

    private String message;
    private String status;
    /**
     * id : f94ef28b-3ed7-47a2-a322-d6400f2d0f1a
     * qq : 284304421
     * qqType : 0
     * gid : a489350e-0a99-4fe1-81da-1d73404279b9
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
        private String qq;
        private int qqType;
        private String gid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public int getQqType() {
            return qqType;
        }

        public void setQqType(int qqType) {
            this.qqType = qqType;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", qq='" + qq + '\'' +
                    ", qqType=" + qqType +
                    ", gid='" + gid + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "QQBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
