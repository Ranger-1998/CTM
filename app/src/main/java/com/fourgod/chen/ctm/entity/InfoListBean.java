package com.fourgod.chen.ctm.entity;

import com.fourgod.chen.ctm.event.BaseBean;

import java.util.List;

public class InfoListBean extends BaseBean {

    /**
     * code : 0
     * message : OK
     * data : {"pageNum":1,"pageSize":8,"size":8,"orderBy":null,"startRow":0,"endRow":7,"total":8,"pages":1,"list":[{"id":13,"title":"数学建模比赛求计算机队友","content":"数学建模比赛求计算机队友","status":"0","type":"0","categoryId":6,"userId":3,"userNickName":"zhc","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:18:56","updateTime":"2018-12-20 08:18:56"},{"id":12,"title":"橘猫求领养","content":"一只82年的橘猫求领养！","picture":"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1329297498,55633568&fm=27&gp=0.jpg","status":"0","type":"0","categoryId":6,"userId":4,"userNickName":"xxx","userHeadUrl":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3815464905,798900466&fm=27&gp=0.jpg","createTime":"2018-12-20 08:18:20","updateTime":"2018-12-20 08:18:20"},{"id":8,"title":"czt","content":"82年的czt","picture":"","status":"0","type":"1","categoryId":4,"userId":3,"userNickName":"zhc","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:15:11","updateTime":"2018-12-20 08:15:11"},{"id":7,"title":"台灯","content":"82年的台灯","status":"0","type":"1","categoryId":3,"userId":5,"userNickName":"xxxx","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:13:47","updateTime":"2018-12-20 08:13:47"},{"id":6,"title":"three body","content":"three body","status":"0","type":"1","categoryId":2,"userId":4,"userNickName":"xxx","userHeadUrl":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3815464905,798900466&fm=27&gp=0.jpg","createTime":"2018-12-20 08:12:43","updateTime":"2018-12-20 08:12:48"},{"id":5,"title":"任天堂港版SWITCH，9.9成新","content":"今年4月份买的上手不超过10小时，塞尔达实体卡","picture":"https://ss1.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/pic/item/37d12f2eb9389b508269787e8f35e5dde7116e0c.jpg|https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1677152873,2590865426&fm=179&app=42&f=PNG?w=121&h=140","status":"0","type":"1","categoryId":1,"userId":6,"userNickName":"xxy","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:10:03","updateTime":"2018-12-20 08:15:52"},{"id":3,"title":"摩托车","content":"82年的摩托车","picture":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1776643686,377305653&fm=58&bpow=1080&bpoh=719","status":"0","type":"1","categoryId":3,"userId":2,"userNickName":"xxy","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-20 08:16:40"},{"id":1,"title":"自行车","content":"自行车","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-08-04 12:42:42","updateTime":"2018-12-20 08:06:49"}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pageNum : 1
         * pageSize : 8
         * size : 8
         * orderBy : null
         * startRow : 0
         * endRow : 7
         * total : 8
         * pages : 1
         * list : [{"id":13,"title":"数学建模比赛求计算机队友","content":"数学建模比赛求计算机队友","status":"0","type":"0","categoryId":6,"userId":3,"userNickName":"zhc","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:18:56","updateTime":"2018-12-20 08:18:56"},{"id":12,"title":"橘猫求领养","content":"一只82年的橘猫求领养！","picture":"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1329297498,55633568&fm=27&gp=0.jpg","status":"0","type":"0","categoryId":6,"userId":4,"userNickName":"xxx","userHeadUrl":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3815464905,798900466&fm=27&gp=0.jpg","createTime":"2018-12-20 08:18:20","updateTime":"2018-12-20 08:18:20"},{"id":8,"title":"czt","content":"82年的czt","picture":"","status":"0","type":"1","categoryId":4,"userId":3,"userNickName":"zhc","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:15:11","updateTime":"2018-12-20 08:15:11"},{"id":7,"title":"台灯","content":"82年的台灯","status":"0","type":"1","categoryId":3,"userId":5,"userNickName":"xxxx","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:13:47","updateTime":"2018-12-20 08:13:47"},{"id":6,"title":"three body","content":"three body","status":"0","type":"1","categoryId":2,"userId":4,"userNickName":"xxx","userHeadUrl":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3815464905,798900466&fm=27&gp=0.jpg","createTime":"2018-12-20 08:12:43","updateTime":"2018-12-20 08:12:48"},{"id":5,"title":"任天堂港版SWITCH，9.9成新","content":"今年4月份买的上手不超过10小时，塞尔达实体卡","picture":"https://ss1.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/pic/item/37d12f2eb9389b508269787e8f35e5dde7116e0c.jpg|https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1677152873,2590865426&fm=179&app=42&f=PNG?w=121&h=140","status":"0","type":"1","categoryId":1,"userId":6,"userNickName":"xxy","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:10:03","updateTime":"2018-12-20 08:15:52"},{"id":3,"title":"摩托车","content":"82年的摩托车","picture":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1776643686,377305653&fm=58&bpow=1080&bpoh=719","status":"0","type":"1","categoryId":3,"userId":2,"userNickName":"xxy","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-20 08:16:40"},{"id":1,"title":"自行车","content":"自行车","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-08-04 12:42:42","updateTime":"2018-12-20 08:06:49"}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 0
         * lastPage : 1
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         */

        private int pageNum;
        private int pageSize;
        private int size;
        private Object orderBy;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private int firstPage;
        private int prePage;
        private int nextPage;
        private int lastPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Object getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(Object orderBy) {
            this.orderBy = orderBy;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * id : 13
             * title : 数学建模比赛求计算机队友
             * content : 数学建模比赛求计算机队友
             * status : 0
             * type : 0
             * categoryId : 6
             * userId : 3
             * userNickName : zhc
             * userHeadUrl : https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg
             * createTime : 2018-12-20 08:18:56
             * updateTime : 2018-12-20 08:18:56
             * picture : https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1329297498,55633568&fm=27&gp=0.jpg
             */

            private int id;
            private String title;
            private String content;
            private String status;
            private String type;
            private int categoryId;
            private int userId;
            private String userNickName;
            private String userHeadUrl;
            private String createTime;
            private String updateTime;
            private String picture;

            public int getId() {
                return id;
            }

            public void setId(int id) {
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserNickName() {
                return userNickName;
            }

            public void setUserNickName(String userNickName) {
                this.userNickName = userNickName;
            }

            public String getUserHeadUrl() {
                return userHeadUrl;
            }

            public void setUserHeadUrl(String userHeadUrl) {
                this.userHeadUrl = userHeadUrl;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }
        }
    }
}
