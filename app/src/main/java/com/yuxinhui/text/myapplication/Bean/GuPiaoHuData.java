package com.yuxinhui.text.myapplication.Bean;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"11:51"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:沪股票实体类
 */
public class GuPiaoHuData {

    /**
     * message : 成功
     * status : ok
     * data : {"totalCount":"1114","page":"1","num":"20","data":[{"symbol":"sh600000","name":"浦发银行","trade":"15.640","pricechange":"0.210","changepercent":"1.361","buy":"15.630","sell":"15.640","settlement":"15.430","open":"15.480","high":"15.650","low":"15.450","volume":255451,"amount":397267013,"code":"600000","ticktime":"15:00:00"},{"symbol":"sh600004","name":"白云机场","trade":"13.020","pricechange":"0.490","changepercent":"3.911","buy":"12.990","sell":"13.000","settlement":"12.530","open":"12.520","high":"13.120","low":"12.500","volume":209667,"amount":269660084,"code":"600004","ticktime":"15:00:00"},{"symbol":"sh600005","name":"武钢股份","trade":"2.760","pricechange":"0.000","changepercent":"0.000","buy":"0.000","sell":"0.000","settlement":"2.760","open":"0.000","high":"0.000","low":"0.000","volume":0,"amount":0,"code":"600005","ticktime":"15:00:00"},{"symbol":"sh600006","name":"东风汽车","trade":"8.820","pricechange":"-0.030","changepercent":"-0.339","buy":"8.820","sell":"8.830","settlement":"8.850","open":"8.890","high":"8.930","low":"8.450","volume":617338,"amount":536917444,"code":"600006","ticktime":"15:00:00"},{"symbol":"sh600007","name":"中国国贸","trade":"20.380","pricechange":"0.230","changepercent":"1.141","buy":"20.330","sell":"20.400","settlement":"20.150","open":"20.160","high":"20.450","low":"19.910","volume":20915,"amount":42304299,"code":"600007","ticktime":"15:00:00"},{"symbol":"sh600008","name":"首创股份","trade":"4.060","pricechange":"0.060","changepercent":"1.500","buy":"4.060","sell":"4.070","settlement":"4.000","open":"3.990","high":"4.070","low":"3.960","volume":394219,"amount":158796560,"code":"600008","ticktime":"15:00:00"},{"symbol":"sh600009","name":"上海机场","trade":"27.330","pricechange":"0.890","changepercent":"3.366","buy":"27.330","sell":"27.340","settlement":"26.440","open":"26.570","high":"27.650","low":"26.400","volume":194133,"amount":523304744,"code":"600009","ticktime":"15:00:00"},{"symbol":"sh600010","name":"包钢股份","trade":"3.020","pricechange":"0.060","changepercent":"2.027","buy":"3.020","sell":"3.030","settlement":"2.960","open":"2.940","high":"3.030","low":"2.940","volume":2333298,"amount":699698573,"code":"600010","ticktime":"15:00:00"},{"symbol":"sh600011","name":"华能国际","trade":"7.200","pricechange":"0.110","changepercent":"1.551","buy":"7.200","sell":"7.210","settlement":"7.090","open":"7.090","high":"7.210","low":"7.060","volume":164453,"amount":117300602,"code":"600011","ticktime":"15:00:00"},{"symbol":"sh600012","name":"皖通高速","trade":"14.990","pricechange":"0.160","changepercent":"1.079","buy":"14.970","sell":"14.990","settlement":"14.830","open":"15.000","high":"15.040","low":"14.660","volume":44681,"amount":66408693,"code":"600012","ticktime":"15:00:00"},{"symbol":"sh600015","name":"华夏银行","trade":"9.750","pricechange":"0.090","changepercent":"0.932","buy":"9.750","sell":"9.760","settlement":"9.660","open":"9.660","high":"9.760","low":"9.600","volume":384595,"amount":372529918,"code":"600015","ticktime":"15:00:00"},{"symbol":"sh600016","name":"民生银行","trade":"9.130","pricechange":"0.140","changepercent":"1.557","buy":"9.130","sell":"9.140","settlement":"8.990","open":"9.010","high":"9.150","low":"8.990","volume":846107,"amount":768638267,"code":"600016","ticktime":"15:00:00"},{"symbol":"sh600017","name":"日照港","trade":"4.280","pricechange":"0.010","changepercent":"0.234","buy":"4.280","sell":"4.290","settlement":"4.270","open":"4.250","high":"4.300","low":"4.190","volume":462507,"amount":196747858,"code":"600017","ticktime":"15:00:00"},{"symbol":"sh600018","name":"上港集团","trade":"5.310","pricechange":"0.070","changepercent":"1.336","buy":"5.300","sell":"5.310","settlement":"5.240","open":"5.260","high":"5.320","low":"5.160","volume":276688,"amount":145470946,"code":"600018","ticktime":"15:00:00"},{"symbol":"sh600019","name":"宝钢股份","trade":"4.900","pricechange":"0.000","changepercent":"0.000","buy":"0.000","sell":"0.000","settlement":"4.900","open":"0.000","high":"0.000","low":"0.000","volume":0,"amount":0,"code":"600019","ticktime":"15:00:00"},{"symbol":"sh600020","name":"中原高速","trade":"4.580","pricechange":"0.090","changepercent":"2.004","buy":"4.580","sell":"4.590","settlement":"4.490","open":"4.500","high":"4.590","low":"4.480","volume":263743,"amount":119699511,"code":"600020","ticktime":"15:00:00"},{"symbol":"sh600021","name":"上海电力","trade":"11.020","pricechange":"0.270","changepercent":"2.512","buy":"11.020","sell":"11.030","settlement":"10.750","open":"10.740","high":"11.030","low":"10.590","volume":200260,"amount":217024871,"code":"600021","ticktime":"15:00:00"},{"symbol":"sh600022","name":"山东钢铁","trade":"2.510","pricechange":"0.080","changepercent":"3.292","buy":"2.500","sell":"2.510","settlement":"2.430","open":"2.430","high":"2.520","low":"2.430","volume":681214,"amount":169698937,"code":"600022","ticktime":"15:00:00"},{"symbol":"sh600023","name":"浙能电力","trade":"5.230","pricechange":"0.080","changepercent":"1.553","buy":"5.220","sell":"5.230","settlement":"5.150","open":"5.150","high":"5.230","low":"5.140","volume":475823,"amount":247399905,"code":"600023","ticktime":"15:00:00"},{"symbol":"sh600026","name":"中海发展","trade":"6.320","pricechange":"0.210","changepercent":"3.437","buy":"6.330","sell":"6.340","settlement":"6.110","open":"6.100","high":"6.340","low":"6.090","volume":442669,"amount":275393276,"code":"600026","ticktime":"15:00:00"}]}
     */

    private String message;
    private String status;
    /**
     * totalCount : 1114
     * page : 1
     * num : 20
     * data : [{"symbol":"sh600000","name":"浦发银行","trade":"15.640","pricechange":"0.210","changepercent":"1.361","buy":"15.630","sell":"15.640","settlement":"15.430","open":"15.480","high":"15.650","low":"15.450","volume":255451,"amount":397267013,"code":"600000","ticktime":"15:00:00"},{"symbol":"sh600004","name":"白云机场","trade":"13.020","pricechange":"0.490","changepercent":"3.911","buy":"12.990","sell":"13.000","settlement":"12.530","open":"12.520","high":"13.120","low":"12.500","volume":209667,"amount":269660084,"code":"600004","ticktime":"15:00:00"},{"symbol":"sh600005","name":"武钢股份","trade":"2.760","pricechange":"0.000","changepercent":"0.000","buy":"0.000","sell":"0.000","settlement":"2.760","open":"0.000","high":"0.000","low":"0.000","volume":0,"amount":0,"code":"600005","ticktime":"15:00:00"},{"symbol":"sh600006","name":"东风汽车","trade":"8.820","pricechange":"-0.030","changepercent":"-0.339","buy":"8.820","sell":"8.830","settlement":"8.850","open":"8.890","high":"8.930","low":"8.450","volume":617338,"amount":536917444,"code":"600006","ticktime":"15:00:00"},{"symbol":"sh600007","name":"中国国贸","trade":"20.380","pricechange":"0.230","changepercent":"1.141","buy":"20.330","sell":"20.400","settlement":"20.150","open":"20.160","high":"20.450","low":"19.910","volume":20915,"amount":42304299,"code":"600007","ticktime":"15:00:00"},{"symbol":"sh600008","name":"首创股份","trade":"4.060","pricechange":"0.060","changepercent":"1.500","buy":"4.060","sell":"4.070","settlement":"4.000","open":"3.990","high":"4.070","low":"3.960","volume":394219,"amount":158796560,"code":"600008","ticktime":"15:00:00"},{"symbol":"sh600009","name":"上海机场","trade":"27.330","pricechange":"0.890","changepercent":"3.366","buy":"27.330","sell":"27.340","settlement":"26.440","open":"26.570","high":"27.650","low":"26.400","volume":194133,"amount":523304744,"code":"600009","ticktime":"15:00:00"},{"symbol":"sh600010","name":"包钢股份","trade":"3.020","pricechange":"0.060","changepercent":"2.027","buy":"3.020","sell":"3.030","settlement":"2.960","open":"2.940","high":"3.030","low":"2.940","volume":2333298,"amount":699698573,"code":"600010","ticktime":"15:00:00"},{"symbol":"sh600011","name":"华能国际","trade":"7.200","pricechange":"0.110","changepercent":"1.551","buy":"7.200","sell":"7.210","settlement":"7.090","open":"7.090","high":"7.210","low":"7.060","volume":164453,"amount":117300602,"code":"600011","ticktime":"15:00:00"},{"symbol":"sh600012","name":"皖通高速","trade":"14.990","pricechange":"0.160","changepercent":"1.079","buy":"14.970","sell":"14.990","settlement":"14.830","open":"15.000","high":"15.040","low":"14.660","volume":44681,"amount":66408693,"code":"600012","ticktime":"15:00:00"},{"symbol":"sh600015","name":"华夏银行","trade":"9.750","pricechange":"0.090","changepercent":"0.932","buy":"9.750","sell":"9.760","settlement":"9.660","open":"9.660","high":"9.760","low":"9.600","volume":384595,"amount":372529918,"code":"600015","ticktime":"15:00:00"},{"symbol":"sh600016","name":"民生银行","trade":"9.130","pricechange":"0.140","changepercent":"1.557","buy":"9.130","sell":"9.140","settlement":"8.990","open":"9.010","high":"9.150","low":"8.990","volume":846107,"amount":768638267,"code":"600016","ticktime":"15:00:00"},{"symbol":"sh600017","name":"日照港","trade":"4.280","pricechange":"0.010","changepercent":"0.234","buy":"4.280","sell":"4.290","settlement":"4.270","open":"4.250","high":"4.300","low":"4.190","volume":462507,"amount":196747858,"code":"600017","ticktime":"15:00:00"},{"symbol":"sh600018","name":"上港集团","trade":"5.310","pricechange":"0.070","changepercent":"1.336","buy":"5.300","sell":"5.310","settlement":"5.240","open":"5.260","high":"5.320","low":"5.160","volume":276688,"amount":145470946,"code":"600018","ticktime":"15:00:00"},{"symbol":"sh600019","name":"宝钢股份","trade":"4.900","pricechange":"0.000","changepercent":"0.000","buy":"0.000","sell":"0.000","settlement":"4.900","open":"0.000","high":"0.000","low":"0.000","volume":0,"amount":0,"code":"600019","ticktime":"15:00:00"},{"symbol":"sh600020","name":"中原高速","trade":"4.580","pricechange":"0.090","changepercent":"2.004","buy":"4.580","sell":"4.590","settlement":"4.490","open":"4.500","high":"4.590","low":"4.480","volume":263743,"amount":119699511,"code":"600020","ticktime":"15:00:00"},{"symbol":"sh600021","name":"上海电力","trade":"11.020","pricechange":"0.270","changepercent":"2.512","buy":"11.020","sell":"11.030","settlement":"10.750","open":"10.740","high":"11.030","low":"10.590","volume":200260,"amount":217024871,"code":"600021","ticktime":"15:00:00"},{"symbol":"sh600022","name":"山东钢铁","trade":"2.510","pricechange":"0.080","changepercent":"3.292","buy":"2.500","sell":"2.510","settlement":"2.430","open":"2.430","high":"2.520","low":"2.430","volume":681214,"amount":169698937,"code":"600022","ticktime":"15:00:00"},{"symbol":"sh600023","name":"浙能电力","trade":"5.230","pricechange":"0.080","changepercent":"1.553","buy":"5.220","sell":"5.230","settlement":"5.150","open":"5.150","high":"5.230","low":"5.140","volume":475823,"amount":247399905,"code":"600023","ticktime":"15:00:00"},{"symbol":"sh600026","name":"中海发展","trade":"6.320","pricechange":"0.210","changepercent":"3.437","buy":"6.330","sell":"6.340","settlement":"6.110","open":"6.100","high":"6.340","low":"6.090","volume":442669,"amount":275393276,"code":"600026","ticktime":"15:00:00"}]
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
        private String totalCount;
        private String page;
        private String num;
        /**
         * symbol : sh600000
         * name : 浦发银行
         * trade : 15.640
         * pricechange : 0.210
         * changepercent : 1.361
         * buy : 15.630
         * sell : 15.640
         * settlement : 15.430
         * open : 15.480
         * high : 15.650
         * low : 15.450
         * volume : 255451
         * amount : 397267013
         * code : 600000
         * ticktime : 15:00:00
         */

        private List<DataBean1> data;

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<DataBean1> getData() {
            return data;
        }

        public void setData(List<DataBean1> data) {
            this.data = data;
        }

        public static class DataBean1 {
            private String symbol;
            private String name;
            private String trade;
            private String pricechange;
            private String changepercent;
            private String buy;
            private String sell;
            private String settlement;
            private String open;
            private String high;
            private String low;
            private int volume;
            private int amount;
            private String code;
            private String ticktime;

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTrade() {
                return trade;
            }

            public void setTrade(String trade) {
                this.trade = trade;
            }

            public String getPricechange() {
                return pricechange;
            }

            public void setPricechange(String pricechange) {
                this.pricechange = pricechange;
            }

            public String getChangepercent() {
                return changepercent;
            }

            public void setChangepercent(String changepercent) {
                this.changepercent = changepercent;
            }

            public String getBuy() {
                return buy;
            }

            public void setBuy(String buy) {
                this.buy = buy;
            }

            public String getSell() {
                return sell;
            }

            public void setSell(String sell) {
                this.sell = sell;
            }

            public String getSettlement() {
                return settlement;
            }

            public void setSettlement(String settlement) {
                this.settlement = settlement;
            }

            public String getOpen() {
                return open;
            }

            public void setOpen(String open) {
                this.open = open;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public int getVolume() {
                return volume;
            }

            public void setVolume(int volume) {
                this.volume = volume;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTicktime() {
                return ticktime;
            }

            public void setTicktime(String ticktime) {
                this.ticktime = ticktime;
            }
        }
    }
}
