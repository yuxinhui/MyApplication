package com.yuxinhui.text.myapplication.Utils;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"15:51"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:
 */
public class IndexKuaiXunData {

    /**
     * message : 失败
     * status : fail
     * data : [{"title":"大庆论金:6.22现货黄金白银原油沥青交易思路及策略","content":"22<em>现货黄金白银原油沥青<\/em>交易思路及策略   本周市场也将围绕英国脱欧的消息面进行波动。而退欧遇阻之后目前留欧的支持率下降很可能会导致整个局面的改变。   --基本面   昨日德拉基和耶伦相继讲话,其中两人的表述都很相近,收线是肯定了美国以及欧元区的现行经济政策,特别是耶伦...","img_width":"206","full_title":"大庆论金:6.22现货黄金白银原油沥青交易思路及策略","pdate":"5小时前","src":"汇金网","img_length":"398","img":"http://p8.qhimg.com/t0173ee92fd874cdcf0.jpg","url":"http://news.gold678.com/C/20160622/201606221025482290.shtml","pdate_src":"2016-06-22 10:25:48"},{"title":"颜沐羽:郭歆芮6.22现货黄金白银、原油沥青日内操作建议","content":"郭歆芮6.22早评!<em>现货黄金白银<\/em>、<em>原油沥青<\/em>日内操作建议及走势分析  摘要:市场的焦点依然是本周英国的脱欧公投,最新的民调显示留欧阵营略胜一筹,市场的避险情绪有所缓解,全球股市大幅攀升,投资者回补此前的英镑空头和美元多头,美元因此承压。接下来市场关注周二美联储主席耶伦...","img_width":"355","full_title":"颜沐羽:郭歆芮6.22现货黄金白银、原油沥青日内操作建议","pdate":"7小时前","src":"环球外汇网","img_length":"600","img":"http://p2.qhimg.com/t01376c6ad2ddcfe3d8.jpg","url":"http://www.cnforex.com/comment/html/2016/6/22/2532ef0214d7a8b0fa16c313f434494d.html","pdate_src":"2016-06-22 08:42:56"},{"title":"6.21现货黄金白银原油沥青晚间行情分析及操作建议","content":"三、李多颖:<em>现货黄金白银原油沥青<\/em>技术面分析及晚间操作建议  <em>现货黄金<\/em>:周二国际<em>现货黄金<\/em>早盘时段小幅冲高后回落,触及日内高点1294美元一线;亚欧盘时段金价维持震荡下行,目前金价交投于1280上方;技术面日线上看,金价近几日行情维持宽幅震荡,目前金价呈现一个倒垂形态;金价下...","img_width":"","full_title":"6.21现货黄金白银原油沥青晚间行情分析及操作建议","pdate":"18小时前","src":"环球外汇网","img_length":"","img":"","url":"http://www.cnforex.com/comment/html/2016/6/21/6d7817edf30add81bda3c5ee319e32e9.html","pdate_src":"2016-06-21 21:17:21"},{"title":"张发景:6月21日现货黄金白银、原油沥青操作建议!","content":"张发景:6月21日<em>现货黄金白银<\/em>、<em>原油沥青<\/em>操作建议! 【行情回顾】 英国近期经济数据表现强劲,显示脱欧公投带来的不确定性,抑制不了其经济动力,一旦雨过天青,更强的经济动能, 再度炽热的升息预期,加上美国经济及升息前景的疑惑,可为英镑带来较预期强的回升动力。高盛预期留欧将会...","img_width":"326","full_title":"张发景:6月21日现货黄金白银、原油沥青操作建议!","pdate":"1天前","src":"网易","img_length":"493","img":"http://p5.qhimg.com/t01e3db679b4d20d3da.jpg","url":"http://news.163.com/16/0621/10/BQ2VDQJQ00014AEE.html","pdate_src":"2016-06-21 07:24:00"}]
     */

    private String message;
    private String status;
    /**
     * title : 大庆论金:6.22现货黄金白银原油沥青交易思路及策略
     * content : 22<em>现货黄金白银原油沥青</em>交易思路及策略   本周市场也将围绕英国脱欧的消息面进行波动。而退欧遇阻之后目前留欧的支持率下降很可能会导致整个局面的改变。   --基本面   昨日德拉基和耶伦相继讲话,其中两人的表述都很相近,收线是肯定了美国以及欧元区的现行经济政策,特别是耶伦...
     * img_width : 206
     * full_title : 大庆论金:6.22现货黄金白银原油沥青交易思路及策略
     * pdate : 5小时前
     * src : 汇金网
     * img_length : 398
     * img : http://p8.qhimg.com/t0173ee92fd874cdcf0.jpg
     * url : http://news.gold678.com/C/20160622/201606221025482290.shtml
     * pdate_src : 2016-06-22 10:25:48
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
        return "IndexKuaiXunData{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public class DataBean {
        private String title;
        private String content;
        private String img_width;
        private String full_title;
        private String pdate;
        private String src;
        private String img_length;
        private String img;
        private String url;
        private String pdate_src;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg_width() {
            return img_width;
        }

        public void setImg_width(String img_width) {
            this.img_width = img_width;
        }

        public String getFull_title() {
            return full_title;
        }

        public void setFull_title(String full_title) {
            this.full_title = full_title;
        }

        public String getPdate() {
            return pdate;
        }

        public void setPdate(String pdate) {
            this.pdate = pdate;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getImg_length() {
            return img_length;
        }

        public void setImg_length(String img_length) {
            this.img_length = img_length;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPdate_src() {
            return pdate_src;
        }

        public void setPdate_src(String pdate_src) {
            this.pdate_src = pdate_src;
        }
    }
}
