package com.yuxinhui.text.myapplication.Utils;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
public class ComexData {
    private List<Data> comexDatas;

    public List<Data> getComexDatas() {
        return comexDatas;
    }

    public void setComexDatas(List<Data> comexDatas) {
        this.comexDatas = comexDatas;
    }

    /**
     * change : 5.199951
     * changePercent : 0.0039456342
     * close : 1317.9
     * code : IXCMGCA0
     * high : 1327.0
     * low : 1313.3
     * name : 美黄金连续
     * newPrice : 1323.1
     * open : 1313.8
     * time : 1467208123000
     */
    public static class Data{
        private double change;
        private double changePercent;
        private double close;
        private String code;
        private double high;
        private double low;
        private String name;
        private double newPrice;
        private double open;
        private long time;

        public double getChange() {
            return change;
        }

        public void setChange(double change) {
            this.change = change;
        }

        public double getChangePercent() {
            return changePercent;
        }

        public void setChangePercent(double changePercent) {
            this.changePercent = changePercent;
        }

        public double getClose() {
            return close;
        }

        public void setClose(double close) {
            this.close = close;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public double getHigh() {
            return high;
        }

        public void setHigh(double high) {
            this.high = high;
        }

        public double getLow() {
            return low;
        }

        public void setLow(double low) {
            this.low = low;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getNewPrice() {
            return newPrice;
        }

        public void setNewPrice(double newPrice) {
            this.newPrice = newPrice;
        }

        public double getOpen() {
            return open;
        }

        public void setOpen(double open) {
            this.open = open;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }
}
