package com.fourgod.chen.ctm.model.impl;

import com.fourgod.chen.ctm.entity.BaseBean;
import com.fourgod.chen.ctm.model.i.IBaseModel;

import android.os.Handler;
import android.os.Message;

/**
 * description Model 的父类
 * *
 * Created by czt
 * on 2018/12/17.
 */
public class BaseModel implements IBaseModel {
    private Handler handler;

    BaseModel(Handler handler) {
        this.handler = handler;
    }

    /**
     * 这个方法给主线程发送消息
     * 这个方法必须同步,在通常情况下,Activity对应的Model只有一个,所以也只有一个postEvent方法,但是可能会有
     * 多个线程同时调用这个方法给主线程发送消息,为了避免数据出现错乱,这个方法必须保持同步
     *
     * @param event 这个对象包含了message所需的what和obj
     */
    synchronized void postEvent(BaseBean event) {
        if (handler != null) {
            Message message = handler.obtainMessage();
            message.what = event.getWhat();
            message.obj = event;
            handler.sendMessage(message);
        }
    }

    /**
     * 释放持有的Handler,在activity onDestroy之后,通过presenter调用
     */
    public void onDestroy() {
        handler = null;
    }
}