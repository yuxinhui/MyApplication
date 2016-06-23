package com.yuxinhui.text.myapplication.Utils;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"10:23"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:课程表实体类
 */
public class KeBiaoData {

    /**
     * message : 成功
     * status : ok
     * data : [{"id":"26215fc3-b25c-42a8-92c7-312563f595ff","startTime":"09:00","endTime":"10:00","monday":"郭老师","tuesday":"郭老师","wednesday":"郭老师","thursday":"郭老师","friday":"郭老师","saturday":null,"weekend":null,"gid":null},{"id":"ed780c7c-87d4-429f-b212-09231c757a7d","startTime":"10:00","endTime":"11:00","monday":"胡老师","tuesday":"胡老师","wednesday":"胡老师","thursday":"胡老师","friday":"胡老师","saturday":null,"weekend":null,"gid":null},{"id":"be3df47e-40dd-455e-8021-c3a4317db2df","startTime":"11:00","endTime":"12:00","monday":"郭老师","tuesday":"刘老师","wednesday":"刘老师","thursday":"刘老师","friday":"刘老师","saturday":null,"weekend":null,"gid":null},{"id":"b79b12d3-68bd-472e-8b7c-ee26704a7c3d","startTime":"12:00","endTime":"13:00","monday":"朱老师","tuesday":"朱老师","wednesday":"朱老师","thursday":"朱老师","friday":"朱老师","saturday":null,"weekend":null,"gid":null},{"id":"aa31a978-4f86-47d1-8ad7-95b906de9894","startTime":"13:00","endTime":"14:00","monday":"刘老师","tuesday":"郭老师","wednesday":"郭老师","thursday":"郭老师","friday":"郭老师","saturday":null,"weekend":null,"gid":null},{"id":"1bf6814a-8a30-43d1-8266-1e5b044cdf80","startTime":"14:00","endTime":"15:00","monday":"胡老师","tuesday":"胡老师","wednesday":"胡老师","thursday":"胡老师","friday":"胡老师","saturday":null,"weekend":null,"gid":null},{"id":"a7887388-3c36-4252-bd11-25f49b0e25d0","startTime":"15:00","endTime":"16:00","monday":"刘老师","tuesday":"刘老师","wednesday":"刘老师","thursday":"刘老师","friday":"刘老师","saturday":null,"weekend":null,"gid":null},{"id":"115eb9cc-4fc1-4ba0-8920-7047cf1c5e3c","startTime":"16:00","endTime":"17:00","monday":"朱老师","tuesday":"朱老师","wednesday":"朱老师","thursday":"朱老师","friday":"朱老师","saturday":null,"weekend":null,"gid":null},{"id":"9646445a-d127-4a67-84ff-f6dda4bb820f","startTime":"17:00","endTime":"18;00","monday":"刘老师","tuesday":"汪老师","wednesday":"陈老师","thursday":"胡老师","friday":"郭老师","saturday":null,"weekend":null,"gid":null},{"id":"b7b6881a-625d-47a3-9ec6-0cb95a630965","startTime":"18:00","endTime":"19:00","monday":"桂老师","tuesday":"桂老师","wednesday":"桂老师","thursday":"桂老师","friday":"桂老师","saturday":null,"weekend":null,"gid":null},{"id":"6093cbbe-f845-4cc8-a1fb-00765bfe6310","startTime":"19:00","endTime":"20:00","monday":"汪老师","tuesday":"汪老师","wednesday":"汪老师","thursday":"汪老师","friday":"汪老师","saturday":null,"weekend":null,"gid":null},{"id":"413d62b1-aa53-4f95-aabe-2af1879b8416","startTime":"20:00","endTime":"21:00","monday":"陈老师","tuesday":"陈老师","wednesday":"陈老师","thursday":"陈老师","friday":"陈老师","saturday":null,"weekend":null,"gid":null},{"id":"6b8a9e8a-6b64-4fac-a8d0-1668251e68cf","startTime":"21:00","endTime":"22:00","monday":"桂老师","tuesday":"桂老师","wednesday":"桂老师","thursday":"桂老师","friday":"桂老师","saturday":null,"weekend":null,"gid":null},{"id":"bef766fd-6ac7-4679-b963-976db5edfc2a","startTime":"22:00","endTime":"23:00","monday":"汪老师","tuesday":"汪老师","wednesday":"汪老师","thursday":"汪老师","friday":"汪老师","saturday":null,"weekend":null,"gid":null},{"id":"0b5b7998-41ba-469b-bbf0-891353799094","startTime":"23:00","endTime":"24:00","monday":"陈老师","tuesday":"陈老师","wednesday":"陈老师","thursday":"陈老师","friday":"陈老师","saturday":null,"weekend":null,"gid":null}]
     */

    private String message;
    private String status;
    /**
     * id : 26215fc3-b25c-42a8-92c7-312563f595ff
     * startTime : 09:00
     * endTime : 10:00
     * monday : 郭老师
     * tuesday : 郭老师
     * wednesday : 郭老师
     * thursday : 郭老师
     * friday : 郭老师
     * saturday : null
     * weekend : null
     * gid : null
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

    @Override
    public String toString() {
        return "KeBiaoData{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public class DataBean {
        private String id;
        private String startTime;
        private String endTime;
        private String monday;
        private String tuesday;
        private String wednesday;
        private String thursday;
        private String friday;
        private Object saturday;
        private Object weekend;
        private Object gid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getMonday() {
            return monday;
        }

        public void setMonday(String monday) {
            this.monday = monday;
        }

        public String getTuesday() {
            return tuesday;
        }

        public void setTuesday(String tuesday) {
            this.tuesday = tuesday;
        }

        public String getWednesday() {
            return wednesday;
        }

        public void setWednesday(String wednesday) {
            this.wednesday = wednesday;
        }

        public String getThursday() {
            return thursday;
        }

        public void setThursday(String thursday) {
            this.thursday = thursday;
        }

        public String getFriday() {
            return friday;
        }

        public void setFriday(String friday) {
            this.friday = friday;
        }

        public Object getSaturday() {
            return saturday;
        }

        public void setSaturday(Object saturday) {
            this.saturday = saturday;
        }

        public Object getWeekend() {
            return weekend;
        }

        public void setWeekend(Object weekend) {
            this.weekend = weekend;
        }

        public Object getGid() {
            return gid;
        }

        public void setGid(Object gid) {
            this.gid = gid;
        }
    }
}
