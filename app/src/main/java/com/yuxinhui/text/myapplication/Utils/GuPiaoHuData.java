package com.yuxinhui.text.myapplication.Utils;

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
     * data : {"totalCount":"1114","page":"1","num":"20","data":[{"symbol":"sh600000","name":"浦发银行","trade":"15.660","pricechange":"0.090","changepercent":"0.578","buy":"15.660","sell":"15.680","settlement":"15.570","open":"15.570","high":"15.720","low":"15.540","volume":70608,"amount":110611762,"code":"600000","ticktime":"11:30:00"},{"symbol":"sh600004","name":"白云机场","trade":"12.300","pricechange":"0.040","changepercent":"0.326","buy":"12.300","sell":"12.310","settlement":"12.260","open":"12.270","high":"12.320","low":"12.240","volume":14317,"amount":17582465,"code":"600004","ticktime":"11:30:00"},{"symbol":"sh600005","name":"武钢股份","trade":"2.760","pricechange":"0.000","changepercent":"0.000","buy":"0.000","sell":"0.000","settlement":"2.760","open":"0.000","high":"0.000","low":"0.000","volume":0,"amount":0,"code":"600005","ticktime":"11:30:00"},{"symbol":"sh600006","name":"东风汽车","trade":"8.660","pricechange":"-0.210","changepercent":"-2.368","buy":"8.660","sell":"8.670","settlement":"8.870","open":"8.840","high":"8.920","low":"8.550","volume":208454,"amount":181879881,"code":"600006","ticktime":"11:30:00"},{"symbol":"sh600007","name":"中国国贸","trade":"19.880","pricechange":"-0.320","changepercent":"-1.584","buy":"19.900","sell":"19.920","settlement":"20.200","open":"20.170","high":"20.370","low":"19.880","volume":4888,"amount":9760424,"code":"600007","ticktime":"11:30:00"},{"symbol":"sh600008","name":"首创股份","trade":"3.890","pricechange":"0.000","changepercent":"0.000","buy":"3.890","sell":"3.900","settlement":"3.890","open":"3.890","high":"3.920","low":"3.880","volume":58862,"amount":22953986,"code":"600008","ticktime":"11:30:00"},{"symbol":"sh600009","name":"上海机场","trade":"25.960","pricechange":"-0.090","changepercent":"-0.345","buy":"25.950","sell":"25.960","settlement":"26.050","open":"26.050","high":"26.070","low":"25.930","volume":25434,"amount":66105342,"code":"600009","ticktime":"11:30:00"},{"symbol":"sh600010","name":"包钢股份","trade":"2.840","pricechange":"-0.020","changepercent":"-0.699","buy":"2.840","sell":"2.850","settlement":"2.860","open":"2.860","high":"2.870","low":"2.840","volume":245043,"amount":69989364,"code":"600010","ticktime":"11:30:00"},{"symbol":"sh600011","name":"华能国际","trade":"7.590","pricechange":"0.070","changepercent":"0.931","buy":"7.590","sell":"7.600","settlement":"7.520","open":"7.580","high":"7.600","low":"7.560","volume":39780,"amount":30176491,"code":"600011","ticktime":"11:30:00"},{"symbol":"sh600012","name":"皖通高速","trade":"14.850","pricechange":"0.560","changepercent":"3.919","buy":"14.840","sell":"14.850","settlement":"14.290","open":"14.330","high":"14.970","low":"14.330","volume":106261,"amount":156357631,"code":"600012","ticktime":"11:30:00"},{"symbol":"sh600015","name":"华夏银行","trade":"9.900","pricechange":"0.010","changepercent":"0.101","buy":"9.900","sell":"9.910","settlement":"9.890","open":"9.890","high":"9.940","low":"9.890","volume":110206,"amount":109263604,"code":"600015","ticktime":"11:30:00"},{"symbol":"sh600016","name":"民生银行","trade":"8.930","pricechange":"0.000","changepercent":"0.000","buy":"8.920","sell":"8.930","settlement":"8.930","open":"8.940","high":"8.990","low":"8.910","volume":203311,"amount":181953572,"code":"600016","ticktime":"11:30:00"},{"symbol":"sh600017","name":"日照港","trade":"4.050","pricechange":"0.000","changepercent":"0.000","buy":"4.040","sell":"4.050","settlement":"4.050","open":"4.050","high":"4.060","low":"4.030","volume":63807,"amount":25834774,"code":"600017","ticktime":"11:30:00"},{"symbol":"sh600018","name":"上港集团","trade":"5.090","pricechange":"-0.010","changepercent":"-0.196","buy":"5.080","sell":"5.090","settlement":"5.100","open":"5.100","high":"5.120","low":"5.080","volume":32819,"amount":16727964,"code":"600018","ticktime":"11:30:00"},{"symbol":"sh600019","name":"宝钢股份","trade":"4.900","pricechange":"0.000","changepercent":"0.000","buy":"0.000","sell":"0.000","settlement":"4.900","open":"0.000","high":"0.000","low":"0.000","volume":0,"amount":0,"code":"600019","ticktime":"11:30:00"},{"symbol":"sh600020","name":"中原高速","trade":"4.430","pricechange":"0.010","changepercent":"0.226","buy":"4.430","sell":"4.440","settlement":"4.420","open":"4.420","high":"4.450","low":"4.410","volume":56505,"amount":25053902,"code":"600020","ticktime":"11:30:00"},{"symbol":"sh600021","name":"上海电力","trade":"10.310","pricechange":"0.040","changepercent":"0.389","buy":"10.310","sell":"10.320","settlement":"10.270","open":"10.270","high":"10.370","low":"10.270","volume":22242,"amount":22969380,"code":"600021","ticktime":"11:30:00"},{"symbol":"sh600022","name":"山东钢铁","trade":"2.370","pricechange":"0.000","changepercent":"0.000","buy":"2.360","sell":"2.370","settlement":"2.370","open":"2.360","high":"2.380","low":"2.360","volume":68363,"amount":16189939,"code":"600022","ticktime":"11:30:00"},{"symbol":"sh600023","name":"浙能电力","trade":"5.080","pricechange":"-0.010","changepercent":"-0.196","buy":"5.080","sell":"5.090","settlement":"5.090","open":"5.100","high":"5.100","low":"5.070","volume":64442,"amount":32788023,"code":"600023","ticktime":"11:30:00"},{"symbol":"sh600026","name":"中海发展","trade":"5.920","pricechange":"0.020","changepercent":"0.339","buy":"5.910","sell":"5.920","settlement":"5.900","open":"5.900","high":"5.940","low":"5.890","volume":54214,"amount":32083043,"code":"600026","ticktime":"11:30:00"}]}
     */

    private String message;
    private String status;
    /**
     * totalCount : 1114
     * page : 1
     * num : 20
     * data : [{"symbol":"sh600000","name":"浦发银行","trade":"15.660","pricechange":"0.090","changepercent":"0.578","buy":"15.660","sell":"15.680","settlement":"15.570","open":"15.570","high":"15.720","low":"15.540","volume":70608,"amount":110611762,"code":"600000","ticktime":"11:30:00"},{"symbol":"sh600004","name":"白云机场","trade":"12.300","pricechange":"0.040","changepercent":"0.326","buy":"12.300","sell":"12.310","settlement":"12.260","open":"12.270","high":"12.320","low":"12.240","volume":14317,"amount":17582465,"code":"600004","ticktime":"11:30:00"},{"symbol":"sh600005","name":"武钢股份","trade":"2.760","pricechange":"0.000","changepercent":"0.000","buy":"0.000","sell":"0.000","settlement":"2.760","open":"0.000","high":"0.000","low":"0.000","volume":0,"amount":0,"code":"600005","ticktime":"11:30:00"},{"symbol":"sh600006","name":"东风汽车","trade":"8.660","pricechange":"-0.210","changepercent":"-2.368","buy":"8.660","sell":"8.670","settlement":"8.870","open":"8.840","high":"8.920","low":"8.550","volume":208454,"amount":181879881,"code":"600006","ticktime":"11:30:00"},{"symbol":"sh600007","name":"中国国贸","trade":"19.880","pricechange":"-0.320","changepercent":"-1.584","buy":"19.900","sell":"19.920","settlement":"20.200","open":"20.170","high":"20.370","low":"19.880","volume":4888,"amount":9760424,"code":"600007","ticktime":"11:30:00"},{"symbol":"sh600008","name":"首创股份","trade":"3.890","pricechange":"0.000","changepercent":"0.000","buy":"3.890","sell":"3.900","settlement":"3.890","open":"3.890","high":"3.920","low":"3.880","volume":58862,"amount":22953986,"code":"600008","ticktime":"11:30:00"},{"symbol":"sh600009","name":"上海机场","trade":"25.960","pricechange":"-0.090","changepercent":"-0.345","buy":"25.950","sell":"25.960","settlement":"26.050","open":"26.050","high":"26.070","low":"25.930","volume":25434,"amount":66105342,"code":"600009","ticktime":"11:30:00"},{"symbol":"sh600010","name":"包钢股份","trade":"2.840","pricechange":"-0.020","changepercent":"-0.699","buy":"2.840","sell":"2.850","settlement":"2.860","open":"2.860","high":"2.870","low":"2.840","volume":245043,"amount":69989364,"code":"600010","ticktime":"11:30:00"},{"symbol":"sh600011","name":"华能国际","trade":"7.590","pricechange":"0.070","changepercent":"0.931","buy":"7.590","sell":"7.600","settlement":"7.520","open":"7.580","high":"7.600","low":"7.560","volume":39780,"amount":30176491,"code":"600011","ticktime":"11:30:00"},{"symbol":"sh600012","name":"皖通高速","trade":"14.850","pricechange":"0.560","changepercent":"3.919","buy":"14.840","sell":"14.850","settlement":"14.290","open":"14.330","high":"14.970","low":"14.330","volume":106261,"amount":156357631,"code":"600012","ticktime":"11:30:00"},{"symbol":"sh600015","name":"华夏银行","trade":"9.900","pricechange":"0.010","changepercent":"0.101","buy":"9.900","sell":"9.910","settlement":"9.890","open":"9.890","high":"9.940","low":"9.890","volume":110206,"amount":109263604,"code":"600015","ticktime":"11:30:00"},{"symbol":"sh600016","name":"民生银行","trade":"8.930","pricechange":"0.000","changepercent":"0.000","buy":"8.920","sell":"8.930","settlement":"8.930","open":"8.940","high":"8.990","low":"8.910","volume":203311,"amount":181953572,"code":"600016","ticktime":"11:30:00"},{"symbol":"sh600017","name":"日照港","trade":"4.050","pricechange":"0.000","changepercent":"0.000","buy":"4.040","sell":"4.050","settlement":"4.050","open":"4.050","high":"4.060","low":"4.030","volume":63807,"amount":25834774,"code":"600017","ticktime":"11:30:00"},{"symbol":"sh600018","name":"上港集团","trade":"5.090","pricechange":"-0.010","changepercent":"-0.196","buy":"5.080","sell":"5.090","settlement":"5.100","open":"5.100","high":"5.120","low":"5.080","volume":32819,"amount":16727964,"code":"600018","ticktime":"11:30:00"},{"symbol":"sh600019","name":"宝钢股份","trade":"4.900","pricechange":"0.000","changepercent":"0.000","buy":"0.000","sell":"0.000","settlement":"4.900","open":"0.000","high":"0.000","low":"0.000","volume":0,"amount":0,"code":"600019","ticktime":"11:30:00"},{"symbol":"sh600020","name":"中原高速","trade":"4.430","pricechange":"0.010","changepercent":"0.226","buy":"4.430","sell":"4.440","settlement":"4.420","open":"4.420","high":"4.450","low":"4.410","volume":56505,"amount":25053902,"code":"600020","ticktime":"11:30:00"},{"symbol":"sh600021","name":"上海电力","trade":"10.310","pricechange":"0.040","changepercent":"0.389","buy":"10.310","sell":"10.320","settlement":"10.270","open":"10.270","high":"10.370","low":"10.270","volume":22242,"amount":22969380,"code":"600021","ticktime":"11:30:00"},{"symbol":"sh600022","name":"山东钢铁","trade":"2.370","pricechange":"0.000","changepercent":"0.000","buy":"2.360","sell":"2.370","settlement":"2.370","open":"2.360","high":"2.380","low":"2.360","volume":68363,"amount":16189939,"code":"600022","ticktime":"11:30:00"},{"symbol":"sh600023","name":"浙能电力","trade":"5.080","pricechange":"-0.010","changepercent":"-0.196","buy":"5.080","sell":"5.090","settlement":"5.090","open":"5.100","high":"5.100","low":"5.070","volume":64442,"amount":32788023,"code":"600023","ticktime":"11:30:00"},{"symbol":"sh600026","name":"中海发展","trade":"5.920","pricechange":"0.020","changepercent":"0.339","buy":"5.910","sell":"5.920","settlement":"5.900","open":"5.900","high":"5.940","low":"5.890","volume":54214,"amount":32083043,"code":"600026","ticktime":"11:30:00"}]
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
         * trade : 15.660
         * pricechange : 0.090
         * changepercent : 0.578
         * buy : 15.660
         * sell : 15.680
         * settlement : 15.570
         * open : 15.570
         * high : 15.720
         * low : 15.540
         * volume : 70608
         * amount : 110611762
         * code : 600000
         * ticktime : 11:30:00
         */

        private List<Bean> data;

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

        public List<Bean> getData() {
            return data;
        }

        public void setData(List<Bean> data) {
            this.data = data;
        }

        public static class Bean {
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

            public Bean(String symbol, String name, String trade, String pricechange, String changepercent, String buy, String sell, String settlement, String open, String high, String low, int volume, int amount, String code, String ticktime) {
                this.symbol = symbol;
                this.name = name;
                this.trade = trade;
                this.pricechange = pricechange;
                this.changepercent = changepercent;
                this.buy = buy;
                this.sell = sell;
                this.settlement = settlement;
                this.open = open;
                this.high = high;
                this.low = low;
                this.volume = volume;
                this.amount = amount;
                this.code = code;
                this.ticktime = ticktime;
            }

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
