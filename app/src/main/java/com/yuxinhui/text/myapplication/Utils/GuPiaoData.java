package com.yuxinhui.text.myapplication.Utils;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"16:54"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:
 */
public class GuPiaoData {

    /**
     * message : 失败
     * status : fail
     * data : [{"title":"金成所致:夏云杰6.30现货黄金现货原油白银杭交沥青操作建议","content":"今日早间开盘后<em>现货黄金<\/em>继续下探,撰稿时段跌幅逾1.9%  <em>原油沥青<\/em>方面,美国能源信息署(EIA)最新报告显示,截至6月24日当周美国原油库存减少... <em>现货白银<\/em>熊猫银币技术分析:  <em>现货白银<\/em>熊猫银币价格在日线图上出现一次有效的冲高并且刷新新高,从当前的波动行情节奏来看,白银价格在日线...","img_width":"","full_title":"金成所致:夏云杰6.30现货黄金现货原油白银杭交沥青操作建议","pdate":"6小时前","src":"环球外汇网","img_length":"","img":"","url":"http://www.cnforex.com/comment/html/2016/6/30/dd5a18760bf349cf8a09eb6947b65af9.html","pdate_src":"2016-06-30 09:51:50"},{"title":"天下亿金:6.29现货黄金白银、原油沥青今日午间操作建议","content":"前值为减少522.4万桶。API<em>原油<\/em>库存公布后,WTI短线快速攀升   因市场避险情绪回落且投资者对<em>黄金<\/em>涨势获利了结,周二<em>现货黄金<\/em>价格回落近1... <em>白银<\/em>价格在日线图上走出比较标准的震荡形态,从当前的波动行情节奏来看,<em>白银<\/em>价格在高位阶段见顶3870附近位置后逐步陷入若震荡,在昨日白...","img_width":"300","full_title":"天下亿金:6.29现货黄金白银、原油沥青今日午间操作建议","pdate":"1天前","src":"第一白银网","img_length":"484","img":"http://p5.qhimg.com/t01d3baf39d3d7641b9.jpg","url":"http://www.silver.org.cn/p/20160629101389.html","pdate_src":"2016-06-29 14:35:00"},{"title":"杨嘉翌:6.29现货原油、沥青、黄金白银早间操作建议","content":"<em>现货白银<\/em>  1小时线上看,布林带开口运行,K线反弹受阻于布林带上轨;短周期MA1、MA2均线金叉拐头向下运行;附图MACD指标运行于0轴上方,... 1.现货<em>黄金<\/em>于1306点位多单进场,止损3个点,目标1312-1315.  2.现货<em>黄金<\/em>于1320点位空单进场,止损3个点,目标1314-1310.  <em>原油<\/em>(<em>沥青<\/em>)  1小时线...","img_width":"300","full_title":"杨嘉翌:6.29现货原油、沥青、黄金白银早间操作建议","pdate":"1天前","src":"环球外汇网","img_length":"500","img":"http://p7.qhimg.com/t01f87a74b9c4242096.jpg","url":"http://www.cnforex.com/comment/html/2016/6/29/d853cababdd26eb67ac624163882eca7.html","pdate_src":"2016-06-29 09:29:40"},{"title":"张发景:午夜金评,现货黄金白银、原油沥青操作策略!","content":"<em>现货黄金白银<\/em>、<em>原油沥青<\/em>操作策略! 【行情回顾】 英国脱欧公投结果公布当日,英镑日内最大波动超过1700点,一度下跌超过10%,跌至1985年以来最低水平。但今日(6月28日)英镑兑美元在英国脱欧后首次上涨,彭博社报道分析称,这是由于投资者对更高收益的资产的兴趣转移,美元和日元...","img_width":"348","full_title":"张发景:午夜金评,现货黄金白银、原油沥青操作策略!","pdate":"1天前","src":"网易","img_length":"500","img":"http://p2.qhimg.com/t018cd1739c076687fa.jpg","url":"http://news.163.com/16/0628/23/BQMD0VRB00014AEE.html","pdate_src":"2016-06-28 21:56:00"}]
     */

    private String message;
    private String status;
    /**
     * title : 金成所致:夏云杰6.30现货黄金现货原油白银杭交沥青操作建议
     * content : 今日早间开盘后<em>现货黄金</em>继续下探,撰稿时段跌幅逾1.9%  <em>原油沥青</em>方面,美国能源信息署(EIA)最新报告显示,截至6月24日当周美国原油库存减少... <em>现货白银</em>熊猫银币技术分析:  <em>现货白银</em>熊猫银币价格在日线图上出现一次有效的冲高并且刷新新高,从当前的波动行情节奏来看,白银价格在日线...
     * img_width :
     * full_title : 金成所致:夏云杰6.30现货黄金现货原油白银杭交沥青操作建议
     * pdate : 6小时前
     * src : 环球外汇网
     * img_length :
     * img :
     * url : http://www.cnforex.com/comment/html/2016/6/30/dd5a18760bf349cf8a09eb6947b65af9.html
     * pdate_src : 2016-06-30 09:51:50
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
