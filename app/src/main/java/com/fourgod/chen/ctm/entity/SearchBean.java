package com.fourgod.chen.ctm.entity;

import java.util.List;

public class SearchBean extends BaseBean {

    /**
     * code : 0
     * data : {"endRow":0,"firstPage":0,"hasNextPage":true,"hasPreviousPage":true,"isFirstPage":true,"isLastPage":true,"lastPage":0,"list":[{"categoryId":0,"content":"string","createTime":{"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0},"endTime":"2018-12-30","id":0,"picture":"string","status":"string","title":"string","type":"string","updateTime":{"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0},"userHeadUrl":"string","userId":0,"userNickName":"string"}],"navigatePages":0,"navigatepageNums":[0],"nextPage":0,"orderBy":"string","pageNum":0,"pageSize":0,"pages":0,"prePage":0,"size":0,"startRow":0,"total":0}
     * message : string
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * endRow : 0
         * firstPage : 0
         * hasNextPage : true
         * hasPreviousPage : true
         * isFirstPage : true
         * isLastPage : true
         * lastPage : 0
         * list : [{"categoryId":0,"content":"string","createTime":{"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0},"endTime":"2018-12-30","id":0,"picture":"string","status":"string","title":"string","type":"string","updateTime":{"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0},"userHeadUrl":"string","userId":0,"userNickName":"string"}]
         * navigatePages : 0
         * navigatepageNums : [0]
         * nextPage : 0
         * orderBy : string
         * pageNum : 0
         * pageSize : 0
         * pages : 0
         * prePage : 0
         * size : 0
         * startRow : 0
         * total : 0
         */

        private int endRow;
        private int firstPage;
        private boolean hasNextPage;
        private boolean hasPreviousPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private int lastPage;
        private int navigatePages;
        private int nextPage;
        private String orderBy;
        private int pageNum;
        private int pageSize;
        private int pages;
        private int prePage;
        private int size;
        private int startRow;
        private int total;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
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

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public String getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(String orderBy) {
            this.orderBy = orderBy;
        }

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

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
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
             * categoryId : 0
             * content : string
             * createTime : {"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0}
             * endTime : 2018-12-30
             * id : 0
             * picture : string
             * status : string
             * title : string
             * type : string
             * updateTime : {"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0}
             * userHeadUrl : string
             * userId : 0
             * userNickName : string
             */

            private int categoryId;
            private String content;
            private CreateTimeBean createTime;
            private String endTime;
            private int id;
            private String picture;
            private String status;
            private String title;
            private String type;
            private UpdateTimeBean updateTime;
            private String userHeadUrl;
            private int userId;
            private String userNickName;

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public CreateTimeBean getCreateTime() {
                return createTime;
            }

            public void setCreateTime(CreateTimeBean createTime) {
                this.createTime = createTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public UpdateTimeBean getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(UpdateTimeBean updateTime) {
                this.updateTime = updateTime;
            }

            public String getUserHeadUrl() {
                return userHeadUrl;
            }

            public void setUserHeadUrl(String userHeadUrl) {
                this.userHeadUrl = userHeadUrl;
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

            public static class CreateTimeBean {
                /**
                 * date : 0
                 * day : 0
                 * hours : 0
                 * minutes : 0
                 * month : 0
                 * nanos : 0
                 * seconds : 0
                 * time : 0
                 * timezoneOffset : 0
                 * year : 0
                 */

                private int date;
                private int day;
                private int hours;
                private int minutes;
                private int month;
                private int nanos;
                private int seconds;
                private int time;
                private int timezoneOffset;
                private int year;

                public int getDate() {
                    return date;
                }

                public void setDate(int date) {
                    this.date = date;
                }

                public int getDay() {
                    return day;
                }

                public void setDay(int day) {
                    this.day = day;
                }

                public int getHours() {
                    return hours;
                }

                public void setHours(int hours) {
                    this.hours = hours;
                }

                public int getMinutes() {
                    return minutes;
                }

                public void setMinutes(int minutes) {
                    this.minutes = minutes;
                }

                public int getMonth() {
                    return month;
                }

                public void setMonth(int month) {
                    this.month = month;
                }

                public int getNanos() {
                    return nanos;
                }

                public void setNanos(int nanos) {
                    this.nanos = nanos;
                }

                public int getSeconds() {
                    return seconds;
                }

                public void setSeconds(int seconds) {
                    this.seconds = seconds;
                }

                public int getTime() {
                    return time;
                }

                public void setTime(int time) {
                    this.time = time;
                }

                public int getTimezoneOffset() {
                    return timezoneOffset;
                }

                public void setTimezoneOffset(int timezoneOffset) {
                    this.timezoneOffset = timezoneOffset;
                }

                public int getYear() {
                    return year;
                }

                public void setYear(int year) {
                    this.year = year;
                }
            }

            public static class UpdateTimeBean {
                /**
                 * date : 0
                 * day : 0
                 * hours : 0
                 * minutes : 0
                 * month : 0
                 * nanos : 0
                 * seconds : 0
                 * time : 0
                 * timezoneOffset : 0
                 * year : 0
                 */

                private int date;
                private int day;
                private int hours;
                private int minutes;
                private int month;
                private int nanos;
                private int seconds;
                private int time;
                private int timezoneOffset;
                private int year;

                public int getDate() {
                    return date;
                }

                public void setDate(int date) {
                    this.date = date;
                }

                public int getDay() {
                    return day;
                }

                public void setDay(int day) {
                    this.day = day;
                }

                public int getHours() {
                    return hours;
                }

                public void setHours(int hours) {
                    this.hours = hours;
                }

                public int getMinutes() {
                    return minutes;
                }

                public void setMinutes(int minutes) {
                    this.minutes = minutes;
                }

                public int getMonth() {
                    return month;
                }

                public void setMonth(int month) {
                    this.month = month;
                }

                public int getNanos() {
                    return nanos;
                }

                public void setNanos(int nanos) {
                    this.nanos = nanos;
                }

                public int getSeconds() {
                    return seconds;
                }

                public void setSeconds(int seconds) {
                    this.seconds = seconds;
                }

                public int getTime() {
                    return time;
                }

                public void setTime(int time) {
                    this.time = time;
                }

                public int getTimezoneOffset() {
                    return timezoneOffset;
                }

                public void setTimezoneOffset(int timezoneOffset) {
                    this.timezoneOffset = timezoneOffset;
                }

                public int getYear() {
                    return year;
                }

                public void setYear(int year) {
                    this.year = year;
                }
            }
        }
    }
}
