package com.fourgod.chen.ctm.entity;


import java.io.Serializable;

/**
 * Created by laobo on 2018/12/29.
 */

public class UserInfoBean extends BaseBean {

    /**
     * code : 0
     * message : OK
     * data : {"id":10,"username":"laoboji","nickname":"laoboji","telephone":"18681261714","password":"$2a$10$hYgBZKLuABYkJI8TOdASDOyqJ6SP2TaYVdFwQSoHkxBzR2wM1tp5y","headImgUrl":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3815464905,798900466&fm=27&gp=0.jpg","birthday":"2018-12-29","sex":"0","status":"1","createTime":"2018-12-29 06:26:01","updateTime":"2018-12-29 10:35:25","signature":"无","hometown":"无","roleId":1,"college":"无","profession":"无","classes":"无"}
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

    public static class DataBean implements Serializable {
        /**
         * id : 10
         * username : laoboji
         * nickname : laoboji
         * telephone : 18681261714
         * password : $2a$10$hYgBZKLuABYkJI8TOdASDOyqJ6SP2TaYVdFwQSoHkxBzR2wM1tp5y
         * headImgUrl : https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3815464905,798900466&fm=27&gp=0.jpg
         * birthday : 2018-12-29
         * sex : 0
         * status : 1
         * createTime : 2018-12-29 06:26:01
         * updateTime : 2018-12-29 10:35:25
         * signature : 无
         * hometown : 无
         * roleId : 1
         * college : 无
         * profession : 无
         * classes : 无
         */

        private int id;
        private String username;
        private String nickname;
        private String telephone;
        private String password;
        private String headImgUrl;
        private String birthday;
        private String sex;
        private String status;
        private String createTime;
        private String updateTime;
        private String signature;
        private String hometown;
        private int roleId;
        private String college;
        private String profession;
        private String classes;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getHometown() {
            return hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getClasses() {
            return classes;
        }

        public void setClasses(String classes) {
            this.classes = classes;
        }
    }
}
