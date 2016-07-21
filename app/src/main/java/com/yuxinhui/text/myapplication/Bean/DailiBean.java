package com.yuxinhui.text.myapplication.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */

public class DailiBean {

    /**
     * message : 成功
     * status : ok
     * data : [{"id":"a489350e-0a99-4fe1-81da-1d73404279b9","agentName":"金马甲","pic":"http://www.jmj9999.com:8080/upload/a489350e-0a99-4fe1-81da-1d73404279b9.png","createTime":1461934985000,"gid":"www.jmj9999.com?gid=a489350e-0a99-4fe1-81da-1d73404279b9","flag":"1","qrcode":"","studioName":"金服财经","code":"jfcj"}]
     */

    private String message;
    private String status;
    /**
     * id : a489350e-0a99-4fe1-81da-1d73404279b9
     * agentName : 金马甲
     * pic : http://www.jmj9999.com:8080/upload/a489350e-0a99-4fe1-81da-1d73404279b9.png
     * createTime : 1461934985000
     * gid : www.jmj9999.com?gid=a489350e-0a99-4fe1-81da-1d73404279b9
     * flag : 1
     * qrcode :
     * studioName : 金服财经
     * code : jfcj
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String agentName;
        private String pic;
        private long createTime;
        private String gid;
        private String flag;
        private String qrcode;
        private String studioName;
        private String code;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public String getStudioName() {
            return studioName;
        }

        public void setStudioName(String studioName) {
            this.studioName = studioName;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
