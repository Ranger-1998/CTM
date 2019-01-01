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
     * data : [{"id":3,"title":"摩托车","content":"82年的摩托车","picture":"https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png","status":"0","type":"1","categoryId":3,"userId":19,"createTime":"2018-12-20 08:06:46","updateTime":"2019-01-01 08:07:01","endTime":"2018-07-01"}]
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
         * id : 3
         * title : 摩托车
         * content : 82年的摩托车
         * picture : https://nmbimg.fastmirror.org/thumb/2018-09-26/5bab612f4f646.png
         * status : 0
         * type : 1
         * categoryId : 3
         * userId : 19
         * createTime : 2018-12-20 08:06:46
         * updateTime : 2019-01-01 08:07:01
         * endTime : 2018-07-01
         */

        private int id;
        private String title;
        private String content;
        private String picture;
        private String status;
        private String type;
        private int categoryId;
        private int userId;
        private String createTime;
        private String updateTime;
        private String endTime;

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
    }
}
