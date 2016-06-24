package com.yuxinhui.text.myapplication.Utils;

import java.util.List;

/**
 * Created by Administrator on 2016/6/23.
 */

public class HuiLvData {

    /**
     * status : 1
     * date : 2016-06-23
     * data : [{"bank":"中国银行","currency":"美元","cen_price":"656.5800","buy_price1":"656.1500","buy_price2":"650.8900","sell_price":"658.7800","currency_code":"USD"},{"bank":"中国银行","currency":"日元","cen_price":"6.2700","buy_price1":"6.2604","buy_price2":"6.0672","sell_price":"6.3044","currency_code":"JPY"},{"bank":"中国银行","currency":"欧元","cen_price":"744.4700","buy_price1":"742.7400","buy_price2":"719.8200","sell_price":"747.9600","currency_code":"EUR"},{"bank":"中国银行","currency":"英镑","cen_price":"972.4200","buy_price1":"969.1000","buy_price2":"939.1900","sell_price":"975.9000","currency_code":"GBP"},{"bank":"中国银行","currency":"澳大利亚元","cen_price":"493.7100","buy_price1":"492.7400","buy_price2":"477.5300","sell_price":"496.2000","currency_code":"AUD"},{"bank":"中国银行","currency":"加拿大元","cen_price":"512.6700","buy_price1":"511.2600","buy_price2":"495.4700","sell_price":"515.3600","currency_code":"CAD"},{"bank":"中国银行","currency":"瑞士法郎","cen_price":"684.4500","buy_price1":"683.0100","buy_price2":"661.9300","sell_price":"687.8100","currency_code":"CHF"},{"bank":"中国银行","currency":"港币","cen_price":"84.6400","buy_price1":"84.5800","buy_price2":"83.9000","sell_price":"84.9000","currency_code":"HKD"},{"bank":"中国银行","currency":"新台币","cen_price":"20.4800","buy_price1":"--","buy_price2":"19.7600","sell_price":"21.1800","currency_code":"TWD"},{"bank":"中国银行","currency":"韩元","cen_price":"0.5716","buy_price1":"0.5682","buy_price2":"0.5477","sell_price":"0.5942","currency_code":"KRW"},{"bank":"中国银行","currency":"泰国铢","cen_price":"18.7000","buy_price1":"18.6200","buy_price2":"18.0400","sell_price":"19.3400","currency_code":"THB"},{"bank":"中国银行","currency":"澳门元","cen_price":"82.3000","buy_price1":"82.1800","buy_price2":"79.4200","sell_price":"85.1400","currency_code":"MOP"},{"bank":"中国银行","currency":"林吉特","cen_price":"163.5200","buy_price1":"163.7800","buy_price2":"--","sell_price":"--","currency_code":"MYR"},{"bank":"中国银行","currency":"卢布","cen_price":"10.1900","buy_price1":"10.1500","buy_price2":"9.5300","sell_price":"10.2300","currency_code":"RUB"},{"bank":"中国银行","currency":"南非兰特","cen_price":"45.0300","buy_price1":"44.9700","buy_price2":"41.5100","sell_price":"48.7300","currency_code":"ZAR"},{"bank":"中国银行","currency":"新西兰元","cen_price":"470.7500","buy_price1":"470.1400","buy_price2":"455.6300","sell_price":"476.2700","currency_code":"NZD"},{"bank":"中国银行","currency":"菲律宾比索","cen_price":"14.1300","buy_price1":"14.0700","buy_price2":"13.6400","sell_price":"14.6200","currency_code":"PHP"},{"bank":"中国银行","currency":"新加坡元","cen_price":"491.2200","buy_price1":"489.4600","buy_price2":"474.3600","sell_price":"492.9000","currency_code":"SGD"},{"bank":"中国银行","currency":"瑞典克朗","cen_price":"79.9500","buy_price1":"79.6700","buy_price2":"77.2100","sell_price":"80.3100","currency_code":"SEK"},{"bank":"中国银行","currency":"丹麦克朗","cen_price":"100.1600","buy_price1":"99.8100","buy_price2":"96.7300","sell_price":"100.6100","currency_code":"DKK"},{"bank":"中国银行","currency":"挪威克朗","cen_price":"79.7300","buy_price1":"79.4200","buy_price2":"76.9700","sell_price":"80.0600","currency_code":"NOK"},{"bank":"中国银行","currency":"阿联酋迪拉姆","cen_price":"179.0400","buy_price1":"--","buy_price2":"172.7400","sell_price":"185.2700","currency_code":"AED"},{"bank":"中国银行","currency":"印度卢比","cen_price":"9.7508","buy_price1":"--","buy_price2":"9.1624","sell_price":"10.3320","currency_code":"INR"}]
     */

    private int status;
    private String date;
    /**
     * bank : 中国银行
     * currency : 美元
     * cen_price : 656.5800
     * buy_price1 : 656.1500
     * buy_price2 : 650.8900
     * sell_price : 658.7800
     * currency_code : USD
     */

    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String bank;
        private String currency;
        private String cen_price;
        private String buy_price1;
        private String buy_price2;
        private String sell_price;
        private String currency_code;

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCen_price() {
            return cen_price;
        }

        public void setCen_price(String cen_price) {
            this.cen_price = cen_price;
        }

        public String getBuy_price1() {
            return buy_price1;
        }

        public void setBuy_price1(String buy_price1) {
            this.buy_price1 = buy_price1;
        }

        public String getBuy_price2() {
            return buy_price2;
        }

        public void setBuy_price2(String buy_price2) {
            this.buy_price2 = buy_price2;
        }

        public String getSell_price() {
            return sell_price;
        }

        public void setSell_price(String sell_price) {
            this.sell_price = sell_price;
        }

        public String getCurrency_code() {
            return currency_code;
        }

        public void setCurrency_code(String currency_code) {
            this.currency_code = currency_code;
        }

        @Override
        public String toString() {
            return "DataBean{" +
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

    @Override
    public String toString() {
        return "HuiLvData{" +
                "status=" + status +
                ", date='" + date + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
