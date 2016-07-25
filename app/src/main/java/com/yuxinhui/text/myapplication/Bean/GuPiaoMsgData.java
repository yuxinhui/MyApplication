package com.yuxinhui.text.myapplication.Bean;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"14:38"
 * 包名:com.yuxinhui.text.myapplication.Bean
 * 描述:股票数据详情实体类
 */
public class GuPiaoMsgData {
    @Override
    public String toString() {
        return "GuPiaoMsgData{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data.toString() +
                '}';
    }

    /**
     * message : 成功
     * status : ok
     * data : [{"data":{"buyFive":"47600","buyFivePri":"10.870","buyFour":"94300","buyFourPri":"10.880","buyOne":"49000","buyOnePri":"10.910","buyThree":"41600","buyThreePri":"10.890","buyTwo":"53032","buyTwoPri":"10.900","competitivePri":"10.910","date":"2016-07-22","gid":"sh600021","increPer":"-1.89","increase":"-0.210","name":"上海电力","nowPri":"10.910","reservePri":"10.920","sellFive":"3200","sellFivePri":"10.960","sellFour":"33800","sellFourPri":"10.950","sellOne":"27361","sellOnePri":"10.920","sellThree":"77600","sellThreePri":"10.940","sellTwo":"55800","sellTwoPri":"10.930","time":"15:00:00","todayMax":"11.170","todayMin":"10.870","todayStartPri":"11.130","traAmount":"130150060.000","traNumber":"118380","yestodEndPri":"11.120"},"dapandata":{"dot":"10.910","name":"上海电力","nowPic":"-0.210","rate":"-1.89","traAmount":"13015","traNumber":"118380"},"gopicture":{"minurl":"http://image.sinajs.cn/newchart/min/n/sh600021.gif","dayurl":"http://image.sinajs.cn/newchart/daily/n/sh600021.gif","weekurl":"http://image.sinajs.cn/newchart/weekly/n/sh600021.gif","monthurl":"http://image.sinajs.cn/newchart/monthly/n/sh600021.gif"}}]
     */

    private String message;
    private String status;
    /**
     * data : {"buyFive":"47600","buyFivePri":"10.870","buyFour":"94300","buyFourPri":"10.880","buyOne":"49000","buyOnePri":"10.910","buyThree":"41600","buyThreePri":"10.890","buyTwo":"53032","buyTwoPri":"10.900","competitivePri":"10.910","date":"2016-07-22","gid":"sh600021","increPer":"-1.89","increase":"-0.210","name":"上海电力","nowPri":"10.910","reservePri":"10.920","sellFive":"3200","sellFivePri":"10.960","sellFour":"33800","sellFourPri":"10.950","sellOne":"27361","sellOnePri":"10.920","sellThree":"77600","sellThreePri":"10.940","sellTwo":"55800","sellTwoPri":"10.930","time":"15:00:00","todayMax":"11.170","todayMin":"10.870","todayStartPri":"11.130","traAmount":"130150060.000","traNumber":"118380","yestodEndPri":"11.120"}
     * dapandata : {"dot":"10.910","name":"上海电力","nowPic":"-0.210","rate":"-1.89","traAmount":"13015","traNumber":"118380"}
     * gopicture : {"minurl":"http://image.sinajs.cn/newchart/min/n/sh600021.gif","dayurl":"http://image.sinajs.cn/newchart/daily/n/sh600021.gif","weekurl":"http://image.sinajs.cn/newchart/weekly/n/sh600021.gif","monthurl":"http://image.sinajs.cn/newchart/monthly/n/sh600021.gif"}
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "data=" + data.toString() +
                    ", dapandata=" + dapandata +
                    ", gopicture=" + gopicture +
                    '}';
        }

        /**
         * buyFive : 47600
         * buyFivePri : 10.870
         * buyFour : 94300
         * buyFourPri : 10.880
         * buyOne : 49000
         * buyOnePri : 10.910
         * buyThree : 41600
         * buyThreePri : 10.890
         * buyTwo : 53032
         * buyTwoPri : 10.900
         * competitivePri : 10.910
         * date : 2016-07-22
         * gid : sh600021
         * increPer : -1.89
         * increase : -0.210
         * name : 上海电力
         * nowPri : 10.910
         * reservePri : 10.920
         * sellFive : 3200
         * sellFivePri : 10.960
         * sellFour : 33800
         * sellFourPri : 10.950
         * sellOne : 27361
         * sellOnePri : 10.920
         * sellThree : 77600
         * sellThreePri : 10.940
         * sellTwo : 55800
         * sellTwoPri : 10.930
         * time : 15:00:00
         * todayMax : 11.170
         * todayMin : 10.870
         * todayStartPri : 11.130
         * traAmount : 130150060.000
         * traNumber : 118380
         * yestodEndPri : 11.120
         */

        private DataBean1 data;
        /**
         * dot : 10.910
         * name : 上海电力
         * nowPic : -0.210
         * rate : -1.89
         * traAmount : 13015
         * traNumber : 118380
         */

        private DapandataBean dapandata;
        /**
         * minurl : http://image.sinajs.cn/newchart/min/n/sh600021.gif
         * dayurl : http://image.sinajs.cn/newchart/daily/n/sh600021.gif
         * weekurl : http://image.sinajs.cn/newchart/weekly/n/sh600021.gif
         * monthurl : http://image.sinajs.cn/newchart/monthly/n/sh600021.gif
         */

        private GopictureBean gopicture;

        public DataBean1 getData() {
            return data;
        }

        public void setData(DataBean1 data) {
            this.data = data;
        }

        public DapandataBean getDapandata() {
            return dapandata;
        }

        public void setDapandata(DapandataBean dapandata) {
            this.dapandata = dapandata;
        }

        public GopictureBean getGopicture() {
            return gopicture;
        }

        public void setGopicture(GopictureBean gopicture) {
            this.gopicture = gopicture;
        }

        public static class DataBean1 {
            @Override
            public String toString() {
                return "DataBean1{" +
                        "buyFive='" + buyFive + '\'' +
                        ", buyFivePri='" + buyFivePri + '\'' +
                        ", buyFour='" + buyFour + '\'' +
                        ", buyFourPri='" + buyFourPri + '\'' +
                        ", buyOne='" + buyOne + '\'' +
                        ", buyOnePri='" + buyOnePri + '\'' +
                        ", buyThree='" + buyThree + '\'' +
                        ", buyThreePri='" + buyThreePri + '\'' +
                        ", buyTwo='" + buyTwo + '\'' +
                        ", buyTwoPri='" + buyTwoPri + '\'' +
                        ", competitivePri='" + competitivePri + '\'' +
                        ", date='" + date + '\'' +
                        ", gid='" + gid + '\'' +
                        ", increPer='" + increPer + '\'' +
                        ", increase='" + increase + '\'' +
                        ", name='" + name + '\'' +
                        ", nowPri='" + nowPri + '\'' +
                        ", reservePri='" + reservePri + '\'' +
                        ", sellFive='" + sellFive + '\'' +
                        ", sellFivePri='" + sellFivePri + '\'' +
                        ", sellFour='" + sellFour + '\'' +
                        ", sellFourPri='" + sellFourPri + '\'' +
                        ", sellOne='" + sellOne + '\'' +
                        ", sellOnePri='" + sellOnePri + '\'' +
                        ", sellThree='" + sellThree + '\'' +
                        ", sellThreePri='" + sellThreePri + '\'' +
                        ", sellTwo='" + sellTwo + '\'' +
                        ", sellTwoPri='" + sellTwoPri + '\'' +
                        ", time='" + time + '\'' +
                        ", todayMax='" + todayMax + '\'' +
                        ", todayMin='" + todayMin + '\'' +
                        ", todayStartPri='" + todayStartPri + '\'' +
                        ", traAmount='" + traAmount + '\'' +
                        ", traNumber='" + traNumber + '\'' +
                        ", yestodEndPri='" + yestodEndPri + '\'' +
                        '}';
            }

            private String buyFive;
            private String buyFivePri;
            private String buyFour;
            private String buyFourPri;
            private String buyOne;
            private String buyOnePri;
            private String buyThree;
            private String buyThreePri;
            private String buyTwo;
            private String buyTwoPri;
            private String competitivePri;
            private String date;
            private String gid;
            private String increPer;
            private String increase;
            private String name;
            private String nowPri;
            private String reservePri;
            private String sellFive;
            private String sellFivePri;
            private String sellFour;
            private String sellFourPri;
            private String sellOne;
            private String sellOnePri;
            private String sellThree;
            private String sellThreePri;
            private String sellTwo;
            private String sellTwoPri;
            private String time;
            private String todayMax;
            private String todayMin;
            private String todayStartPri;
            private String traAmount;
            private String traNumber;
            private String yestodEndPri;

            public String getBuyFive() {
                return buyFive;
            }

            public void setBuyFive(String buyFive) {
                this.buyFive = buyFive;
            }

            public String getBuyFivePri() {
                return buyFivePri;
            }

            public void setBuyFivePri(String buyFivePri) {
                this.buyFivePri = buyFivePri;
            }

            public String getBuyFour() {
                return buyFour;
            }

            public void setBuyFour(String buyFour) {
                this.buyFour = buyFour;
            }

            public String getBuyFourPri() {
                return buyFourPri;
            }

            public void setBuyFourPri(String buyFourPri) {
                this.buyFourPri = buyFourPri;
            }

            public String getBuyOne() {
                return buyOne;
            }

            public void setBuyOne(String buyOne) {
                this.buyOne = buyOne;
            }

            public String getBuyOnePri() {
                return buyOnePri;
            }

            public void setBuyOnePri(String buyOnePri) {
                this.buyOnePri = buyOnePri;
            }

            public String getBuyThree() {
                return buyThree;
            }

            public void setBuyThree(String buyThree) {
                this.buyThree = buyThree;
            }

            public String getBuyThreePri() {
                return buyThreePri;
            }

            public void setBuyThreePri(String buyThreePri) {
                this.buyThreePri = buyThreePri;
            }

            public String getBuyTwo() {
                return buyTwo;
            }

            public void setBuyTwo(String buyTwo) {
                this.buyTwo = buyTwo;
            }

            public String getBuyTwoPri() {
                return buyTwoPri;
            }

            public void setBuyTwoPri(String buyTwoPri) {
                this.buyTwoPri = buyTwoPri;
            }

            public String getCompetitivePri() {
                return competitivePri;
            }

            public void setCompetitivePri(String competitivePri) {
                this.competitivePri = competitivePri;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getGid() {
                return gid;
            }

            public void setGid(String gid) {
                this.gid = gid;
            }

            public String getIncrePer() {
                return increPer;
            }

            public void setIncrePer(String increPer) {
                this.increPer = increPer;
            }

            public String getIncrease() {
                return increase;
            }

            public void setIncrease(String increase) {
                this.increase = increase;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNowPri() {
                return nowPri;
            }

            public void setNowPri(String nowPri) {
                this.nowPri = nowPri;
            }

            public String getReservePri() {
                return reservePri;
            }

            public void setReservePri(String reservePri) {
                this.reservePri = reservePri;
            }

            public String getSellFive() {
                return sellFive;
            }

            public void setSellFive(String sellFive) {
                this.sellFive = sellFive;
            }

            public String getSellFivePri() {
                return sellFivePri;
            }

            public void setSellFivePri(String sellFivePri) {
                this.sellFivePri = sellFivePri;
            }

            public String getSellFour() {
                return sellFour;
            }

            public void setSellFour(String sellFour) {
                this.sellFour = sellFour;
            }

            public String getSellFourPri() {
                return sellFourPri;
            }

            public void setSellFourPri(String sellFourPri) {
                this.sellFourPri = sellFourPri;
            }

            public String getSellOne() {
                return sellOne;
            }

            public void setSellOne(String sellOne) {
                this.sellOne = sellOne;
            }

            public String getSellOnePri() {
                return sellOnePri;
            }

            public void setSellOnePri(String sellOnePri) {
                this.sellOnePri = sellOnePri;
            }

            public String getSellThree() {
                return sellThree;
            }

            public void setSellThree(String sellThree) {
                this.sellThree = sellThree;
            }

            public String getSellThreePri() {
                return sellThreePri;
            }

            public void setSellThreePri(String sellThreePri) {
                this.sellThreePri = sellThreePri;
            }

            public String getSellTwo() {
                return sellTwo;
            }

            public void setSellTwo(String sellTwo) {
                this.sellTwo = sellTwo;
            }

            public String getSellTwoPri() {
                return sellTwoPri;
            }

            public void setSellTwoPri(String sellTwoPri) {
                this.sellTwoPri = sellTwoPri;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTodayMax() {
                return todayMax;
            }

            public void setTodayMax(String todayMax) {
                this.todayMax = todayMax;
            }

            public String getTodayMin() {
                return todayMin;
            }

            public void setTodayMin(String todayMin) {
                this.todayMin = todayMin;
            }

            public String getTodayStartPri() {
                return todayStartPri;
            }

            public void setTodayStartPri(String todayStartPri) {
                this.todayStartPri = todayStartPri;
            }

            public String getTraAmount() {
                return traAmount;
            }

            public void setTraAmount(String traAmount) {
                this.traAmount = traAmount;
            }

            public String getTraNumber() {
                return traNumber;
            }

            public void setTraNumber(String traNumber) {
                this.traNumber = traNumber;
            }

            public String getYestodEndPri() {
                return yestodEndPri;
            }

            public void setYestodEndPri(String yestodEndPri) {
                this.yestodEndPri = yestodEndPri;
            }
        }

        public static class DapandataBean {
            private String dot;
            private String name;
            private String nowPic;
            private String rate;
            private String traAmount;
            private String traNumber;

            public String getDot() {
                return dot;
            }

            public void setDot(String dot) {
                this.dot = dot;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNowPic() {
                return nowPic;
            }

            public void setNowPic(String nowPic) {
                this.nowPic = nowPic;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getTraAmount() {
                return traAmount;
            }

            public void setTraAmount(String traAmount) {
                this.traAmount = traAmount;
            }

            public String getTraNumber() {
                return traNumber;
            }

            public void setTraNumber(String traNumber) {
                this.traNumber = traNumber;
            }
        }

        public static class GopictureBean {
            private String minurl;
            private String dayurl;
            private String weekurl;
            private String monthurl;

            public String getMinurl() {
                return minurl;
            }

            public void setMinurl(String minurl) {
                this.minurl = minurl;
            }

            public String getDayurl() {
                return dayurl;
            }

            public void setDayurl(String dayurl) {
                this.dayurl = dayurl;
            }

            public String getWeekurl() {
                return weekurl;
            }

            public void setWeekurl(String weekurl) {
                this.weekurl = weekurl;
            }

            public String getMonthurl() {
                return monthurl;
            }

            public void setMonthurl(String monthurl) {
                this.monthurl = monthurl;
            }
        }
    }
}
