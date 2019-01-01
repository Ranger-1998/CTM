package com.fourgod.chen.ctm.entity;

public class PushBean extends BaseBean {

    /**
     * code : 0
     * data : {"categoryId":0,"content":"string","createTime":"string","endTime":"2018-12-31","id":0,"picture":"string","status":"string","title":"string","type":"string","updateTime":"string","userHeadUrl":"string","userId":0,"userNickName":"string"}
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
         * categoryId : 0
         * content : string
         * createTime : string
         * endTime : 2018-12-31
         * id : 0
         * picture : string
         * status : string
         * title : string
         * type : string
         * updateTime : string
         * userHeadUrl : string
         * userId : 0
         * userNickName : string
         */

        private int categoryId;
        private String content;
        private String createTime;
        private String endTime;
        private int id;
        private String picture;
        private String status;
        private String title;
        private String type;
        private String updateTime;
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

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
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

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
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
    }
}
