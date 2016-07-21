package com.yuxinhui.text.myapplication.Bean;

/**
 * Created by "于志渊"
 * 时间:"11:17"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:全球外汇实体类
 */
public class GlobalCurrencyData {

    /**
     * change : 0.003000021
     * changePercent : 0.0027235777
     * close : 1.1015
     * code : IXFXEURUSD
     * high : 1.1058
     * low : 1.1007
     * name : 欧元美元
     * newPrice : 1.1045
     * open : 1.1022
     * time : 1467083415000
     */

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

        @Override
        public String toString() {
            return "GlobalCurrencyData{" +
                    "change=" + change +
                    ", changePercent=" + changePercent +
                    ", close=" + close +
                    ", code='" + code + '\'' +
                    ", high=" + high +
                    ", low=" + low +
                    ", name='" + name + '\'' +
                    ", newPrice=" + newPrice +
                    ", open=" + open +
                    ", time=" + time +
                    '}';
        }

}
