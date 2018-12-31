package com.fourgod.chen.ctm.entity;

import java.util.List;

public class SearchBean extends BaseBean {


    /**
     * code : 0
     * message : OK
     * data : {"pageNum":1,"pageSize":10,"size":10,"orderBy":null,"startRow":1,"endRow":10,"total":13,"pages":2,"list":[{"id":3,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":20,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":28,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":36,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":44,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":52,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":60,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":68,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":76,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":84,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]}
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
         * pageSize : 10
         * size : 10
         * orderBy : null
         * startRow : 1
         * endRow : 10
         * total : 13
         * pages : 2
         * list : [{"id":3,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":20,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":28,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":36,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":44,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":52,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":60,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":68,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":76,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"},{"id":84,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":1,"userNickName":"admin","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-20 08:06:46","updateTime":"2018-12-29 03:57:51"}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
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
             * id : 3
             * title : 摩托车
             * content : 82年的摩托车
             * picture : https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png
             * status : 0
             * type : 1
             * categoryId : 3
             * userId : 1
             * userNickName : admin
             * userHeadUrl : https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg
             * createTime : 2018-12-20 08:06:46
             * updateTime : 2018-12-29 03:57:51
             */

            private int id;
            private String title;
            private String content;
            private String picture;
            private String status;
            private String type;
            private int categoryId;
            private int userId;
            private String userNickName;
            private String userHeadUrl;
            private String createTime;
            private String updateTime;

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

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
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
        }
    }
}
