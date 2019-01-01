package com.fourgod.chen.ctm.entity;

public class ReportBean extends BaseBean {

    /**
     * code : 0
     * data : {"id":0,"informationId":0,"memo":"string","status":"string","userId":0}
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
         * id : 0
         * informationId : 0
         * memo : string
         * status : string
         * userId : 0
         */

        private int id;
        private int informationId;
        private String memo;
        private String status;
        private int userId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getInformationId() {
            return informationId;
        }

        public void setInformationId(int informationId) {
            this.informationId = informationId;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
