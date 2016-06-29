package com.yuxinhui.text.myapplication.Utils;

import android.content.Context;

import java.util.List;

/**
 * 包:com.yuxinhui.text.myapplication.Utils
 * Create By:"于志渊"
 * 时间:23:03
 * 描述:上海金实体类
 */
public class ShangHaiJinData {

    private List<ShangHaiJinData> datas;

    public List<ShangHaiJinData> getDatas() {
        return datas;
    }

    public void setDatas(List<ShangHaiJinData> datas) {
        this.datas = datas;
    }

    /**
     * change : 0.6000061
     * changePercent : 0.0021209123
     * close : 282.9
     * code : SGAu100g
     * high : 283.5
     * low : 282.11
     * name : 黄金100G
     * newPrice : 283.5
     * open : 282.11
     * time : 1467212329000
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
}
