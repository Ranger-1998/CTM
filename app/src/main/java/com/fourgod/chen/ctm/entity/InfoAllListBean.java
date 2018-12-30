package com.fourgod.chen.ctm.entity;


import java.util.List;

/**
 * Created by laobo on 2018/12/29.
 */

public class InfoAllListBean extends BaseBean {

    /**
     * code : 0
     * message : OK
     * data : [{"id":1,"title":"自行车","content":"自行车","status":"0","type":"1","categoryId":3,"userId":10,"createTime":"2018-08-04 12:42:42","updateTime":"2018-12-29 07:32:55"},{"id":5,"title":"任天堂港版SWITCH，9.9成新","content":"今年4月份买的上手不超过10小时，塞尔达实体卡","picture":"https://nmbimg.fastmirror.org/thumb/2018-07-25/5b57d24a7e28f.jpg|https://nmbimg.fastmirror.org/thumb/2018-09-27/5bac5ffd3572c.jpg","status":"0","type":"1","categoryId":1,"userId":10,"createTime":"2018-12-20 08:10:03","updateTime":"2018-12-29 07:30:50"},{"id":7,"title":"台灯","content":"82年的台灯","status":"1","type":"1","categoryId":3,"userId":10,"createTime":"2018-12-20 08:13:47","updateTime":"2018-12-29 08:44:14"}]
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

    public static class DataBean {
        /**
         * id : 1
         * title : 自行车
         * content : 自行车
         * status : 0
         * type : 1
         * categoryId : 3
         * userId : 10
         * createTime : 2018-08-04 12:42:42
         * updateTime : 2018-12-29 07:32:55
         * picture : https://nmbimg.fastmirror.org/thumb/2018-07-25/5b57d24a7e28f.jpg|https://nmbimg.fastmirror.org/thumb/2018-09-27/5bac5ffd3572c.jpg
         */

        private int id;
        private String title;
        private String content;
        private String status;
        private String type;
        private int categoryId;
        private int userId;
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
