package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.CategoryListBean;
import com.fourgod.chen.ctm.entity.ImageResultBean;
import com.fourgod.chen.ctm.entity.PushBean;
import com.fourgod.chen.ctm.model.impl.PublishModel;
import com.fourgod.chen.ctm.view.impl.activity.PublishActivity;

import java.util.List;

import javax.crypto.MacSpi;

public class PublishPresenter extends BasePresenter<PublishActivity, PublishModel> {

    public PublishPresenter(PublishActivity view) {
        super(view);
    }

    @Override
    protected PublishModel getModel(Handler handler) {
        return new PublishModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        switch (msg.what) {
            case 1:
                view.publishReturn((PushBean) msg.obj);
                break;
            case 2:
                view.getCateListReturn((CategoryListBean) msg.obj);
                break;
            case 3:
                view.imageUploadComplete((ImageResultBean) msg.obj);
                break;
                default:break;
        }
    }

    public void uploadImage(List<String> files) {
        model.uploadImage(files);
    }

    public void publish(ArrayMap<String, String> param) {
        model.publish(param);
    }

    public void getCateList(ArrayMap<String, String> param) {
        model.getCateList(param);
    }

}
