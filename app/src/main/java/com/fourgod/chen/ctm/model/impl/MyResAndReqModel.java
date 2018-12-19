package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;

/**
 * Created by laobo on 2018/12/19.
 */

public class MyResAndReqModel extends BaseModel {
    //资源
    public static final int TYPE_RESOURCE = 0;

    //需求
    public static final int TYPE_REQUIREMENT = 0;


    private int mType;
    public MyResAndReqModel(Handler handler) {
        super(handler);
    }

    public void setType(int type){
        this.mType = type;
    }

}
