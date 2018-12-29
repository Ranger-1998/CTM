package com.fourgod.chen.ctm.entity;

import com.fourgod.chen.ctm.event.BaseEvent;

public class LoginBean extends BaseEvent {

    /**
     * code : 0
     * data : {"loginTime":1546065837570,"token":"5f48393e-0587-4a3d-8660-d35f759dc5bd"}
     * message : OK
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
         * loginTime : 1546065837570
         * token : 5f48393e-0587-4a3d-8660-d35f759dc5bd
         */

        private long loginTime;
        private String token;

        public long getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(long loginTime) {
            this.loginTime = loginTime;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
