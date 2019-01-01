package com.fourgod.chen.ctm.entity;

/**
 * Created by laobo on 2019/1/1.
 */

public class ResolvedBean extends BaseBean {

    /**
     * code : 0
     * data : string
     * message : string
     */

    private int code;
    private String data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
