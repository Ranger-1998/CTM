package com.fourgod.chen.ctm.entity;


import java.io.Serializable;
import java.util.List;

/**
 * Created by laobo on 2018/12/29.
 */

public class InfoAllListBean extends BaseBean {

    /**
     * code : 0
     * message : OK
     * data : [{"id":132,"title":"cztcztctzctz","content":"cxzcszcszcxcszcsz","status":"1","type":"0","categoryId":8,"userId":28,"userNickName":"cztcztczt","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2019-01-01 09:07:11","updateTime":"2019-01-01 14:04:02","endTime":"2020-01-01"},{"id":132,"title":"cztcztctzctz","content":"cxzcszcszcxcszcsz","status":"1","type":"0","categoryId":8,"userId":28,"userNickName":"cztcztczt","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2019-01-01 09:07:11","updateTime":"2019-01-01 14:04:02","endTime":"2020-01-01"},{"id":132,"title":"cztcztctzctz","content":"cxzcszcszcxcszcsz","status":"1","type":"0","categoryId":8,"userId":28,"userNickName":"cztcztczt","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2019-01-01 09:07:11","updateTime":"2019-01-01 14:04:02","endTime":"2020-01-01"},{"id":132,"title":"cztcztctzctz","content":"cxzcszcszcxcszcsz","status":"1","type":"0","categoryId":8,"userId":28,"userNickName":"cztcztczt","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2019-01-01 09:07:11","updateTime":"2019-01-01 14:04:02","endTime":"2020-01-01"},{"id":115,"title":"zzp","content":"82年的zzp","picture":"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1329297498,55633568&fm=27&gp=0.jpg","status":"0","type":"1","categoryId":4,"userId":3,"userNickName":"zhc","userHeadUrl":"https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg","createTime":"2018-12-31 08:15:11","updateTime":"2018-12-30 09:35:27"}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 132
         * title : cztcztctzctz
         * content : cxzcszcszcxcszcsz
         * status : 1
         * type : 0
         * categoryId : 8
         * userId : 28
         * userNickName : cztcztczt
         * userHeadUrl : https://free.modao.cc/uploads3/images/1975/19758300/raw_1525486953.jpeg
         * createTime : 2019-01-01 09:07:11
         * updateTime : 2019-01-01 14:04:02
         * endTime : 2020-01-01
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
        private String endTime;
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

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
