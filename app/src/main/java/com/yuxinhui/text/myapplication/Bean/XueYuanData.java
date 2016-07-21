package com.yuxinhui.text.myapplication.Bean;

import java.util.List;

/**
 * Created by "于志渊"
 * 时间:"9:58"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:
 */
public class XueYuanData {

    /**
     * message : 成功！
     * status : ok
     * data : {"offset":0,"limit":15,"pageNo":1,"pageSize":15,"result":[{"id":"aca9671b-222f-4706-b0dd-f2431bef8db3","title":"EIA公布在即","content":"EIA公布在即","url":"http://114.55.11.183:8080/html/EIAgongbu.mp4","author":"刘老师","time":1466563123000},{"id":"aca9671b-233f-4706-b0dd-f2431bef8db3","title":"MACD指标分析","content":"MACD指标分析","url":"http://114.55.11.183:8080/html/MACDzhibiao.mp4","author":"郭老师","time":1466562798000},{"id":"aca96876-222f-4706-b0dd-f2431bef8db3","title":"K线攻略（上）","content":"专业的老师分析讲解K线","url":"http://114.55.11.183:8080/html/kxian.mp4","author":"汪老师","time":1466562738000},{"id":"aca9671b-222f-4256-b0dd-f2431bef8abr","title":"EIA原油库存大减沥青大涨   趋势回归当下行情强势明显","content":"EIA原油库存大减沥青大涨   趋势回归当下行情强势明显","url":"http://114.55.11.183:8080/html/EIAyuanyou.mp4","author":"朱老师","time":1466562712000},{"id":"aca9671b-222f-4706-b0dd-f2431bef8abr","title":"EIA行情分析与应对策略","content":"EIA行情分析与应对策略","url":"http://114.55.11.183:8080/html/EIAhangqingyingdui.mp4","author":"朱老师","time":1466562347000},{"id":"aca9671b-222f-4706-b0dd-f2431bef8db8","title":"EIA行情分析","content":"EIA行情分析","url":"http://114.55.11.183:8080/html/EIAhangqing.mp4","author":"胡老师","time":1466562242000}],"totalCount":6,"totalPages":1,"first":1}
     */

    private String message;
    private String status;
    /**
     * offset : 0
     * limit : 15
     * pageNo : 1
     * pageSize : 15
     * result : [{"id":"aca9671b-222f-4706-b0dd-f2431bef8db3","title":"EIA公布在即","content":"EIA公布在即","url":"http://114.55.11.183:8080/html/EIAgongbu.mp4","author":"刘老师","time":1466563123000},{"id":"aca9671b-233f-4706-b0dd-f2431bef8db3","title":"MACD指标分析","content":"MACD指标分析","url":"http://114.55.11.183:8080/html/MACDzhibiao.mp4","author":"郭老师","time":1466562798000},{"id":"aca96876-222f-4706-b0dd-f2431bef8db3","title":"K线攻略（上）","content":"专业的老师分析讲解K线","url":"http://114.55.11.183:8080/html/kxian.mp4","author":"汪老师","time":1466562738000},{"id":"aca9671b-222f-4256-b0dd-f2431bef8abr","title":"EIA原油库存大减沥青大涨   趋势回归当下行情强势明显","content":"EIA原油库存大减沥青大涨   趋势回归当下行情强势明显","url":"http://114.55.11.183:8080/html/EIAyuanyou.mp4","author":"朱老师","time":1466562712000},{"id":"aca9671b-222f-4706-b0dd-f2431bef8abr","title":"EIA行情分析与应对策略","content":"EIA行情分析与应对策略","url":"http://114.55.11.183:8080/html/EIAhangqingyingdui.mp4","author":"朱老师","time":1466562347000},{"id":"aca9671b-222f-4706-b0dd-f2431bef8db8","title":"EIA行情分析","content":"EIA行情分析","url":"http://114.55.11.183:8080/html/EIAhangqing.mp4","author":"胡老师","time":1466562242000}]
     * totalCount : 6
     * totalPages : 1
     * first : 1
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
        private int offset;
        private int limit;
        private int pageNo;
        private int pageSize;
        private int totalCount;
        private int totalPages;
        private int first;
        /**
         * id : aca9671b-222f-4706-b0dd-f2431bef8db3
         * title : EIA公布在即
         * content : EIA公布在即
         * url : http://114.55.11.183:8080/html/EIAgongbu.mp4
         * author : 刘老师
         * time : 1466563123000
         */

        private List<ResultBean> result;

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            private String id;
            private String title;
            private String content;
            private String url;
            private String author;
            private long time;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }
        }
    }
}
