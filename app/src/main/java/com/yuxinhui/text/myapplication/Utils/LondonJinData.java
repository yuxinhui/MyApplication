package com.yuxinhui.text.myapplication.Utils;

import java.util.List;

/**
 * 包:com.yuxinhui.text.myapplication.Utils
 * Create By:"于志渊"
 * 时间:23:20
 * 描述:伦敦金属实体类
 */
public class LondonJinData {
    private List<LondonJinData> datas;

    public List<LondonJinData> getDatas() {
        return datas;
    }

    public void setDatas(List<LondonJinData> datas) {
        this.datas = datas;
    }

    /**
     * change : 7.5
     * changePercent : 0.00460688
     * close : 1628.0
     * code : IXLEAHD3M
     * high : 1636.0
     * low : 1618.0
     * name : LME铝03
     * newPrice : 1635.5
     * open : 1628.0
     * time : 1467213625000
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
