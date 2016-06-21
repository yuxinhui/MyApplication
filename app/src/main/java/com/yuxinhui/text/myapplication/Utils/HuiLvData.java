package com.yuxinhui.text.myapplication.Utils;

/**
 * Created by Administrator on 2016/6/21.
 * 汇率转换信息的实体类
 * {
 "bank": "中国银行",
 "currency": "美元",
 "cen_price": "656.5600",(中间价)
 "buy_price1": "656.4000",（现汇买入价）
 "buy_price2": "651.1400",（现钞买入价）
 "sell_price": "659.0300",（出售价）
 "currency_code": "USD"
 }
 */

public class HuiLvData {
    private String bank;

    private String currency;

    private String cen_price;

    private String buy_price1;

    private String buy_price2;

    private String sell_price;

    private String currency_code;

    public void setBank(String bank){
        this.bank = bank;
    }
    public String getBank(){
        return this.bank;
    }
    public void setCurrency(String currency){
        this.currency = currency;
    }
    public String getCurrency(){
        return this.currency;
    }
    public void setCen_price(String cen_price){
        this.cen_price = cen_price;
    }
    public String getCen_price(){
        return this.cen_price;
    }
    public void setBuy_price1(String buy_price1){
        this.buy_price1 = buy_price1;
    }
    public String getBuy_price1(){
        return this.buy_price1;
    }
    public void setBuy_price2(String buy_price2){
        this.buy_price2 = buy_price2;
    }
    public String getBuy_price2(){
        return this.buy_price2;
    }
    public void setSell_price(String sell_price){
        this.sell_price = sell_price;
    }
    public String getSell_price(){
        return this.sell_price;
    }
    public void setCurrency_code(String currency_code){
        this.currency_code = currency_code;
    }
    public String getCurrency_code(){
        return this.currency_code;
    }

    @Override
    public String toString() {
        return "HuiLvData{" +
                "bank='" + bank + '\'' +
                ", currency='" + currency + '\'' +
                ", cen_price='" + cen_price + '\'' +
                ", buy_price1='" + buy_price1 + '\'' +
                ", buy_price2='" + buy_price2 + '\'' +
                ", sell_price='" + sell_price + '\'' +
                ", currency_code='" + currency_code + '\'' +
                '}';
    }
}
