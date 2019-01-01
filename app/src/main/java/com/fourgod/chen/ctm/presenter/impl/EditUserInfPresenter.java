package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.ImageUploadBean;
import com.fourgod.chen.ctm.entity.RegisterBean;
import com.fourgod.chen.ctm.model.impl.BaseModel;
import com.fourgod.chen.ctm.model.impl.EditUserInfModel;
import com.fourgod.chen.ctm.view.i.IBaseView;
import com.fourgod.chen.ctm.view.impl.activity.EditUserInfActivity;

/**
 * Created by Tolean on 2018/12/19.
 */

public class EditUserInfPresenter extends BasePresenter<EditUserInfActivity,EditUserInfModel> {
    public EditUserInfPresenter(EditUserInfActivity view) {
        super(view);
    }

    @Override
    protected EditUserInfModel getModel(Handler handler) {
        return  new EditUserInfModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        if(msg.what==1){
            RegisterBean bean = (RegisterBean)msg.obj;
            if (bean.getCode()==0){
                view.updateSuccess(bean);
            }else{
                view.updateFail();
            }
        }else if(msg.what==2){
            ImageUploadBean bean=(ImageUploadBean)msg.obj;
            if(bean.getCode()==0){
                view.uploadPortraitSuccess(bean.getMessage());
            }else{
                view.updateFail();
            }
        }
    }

    public void updateInfo(ArrayMap<String, String> p){
        model.updateInfo(p);
    }
    public void uploadPortrait(String url){
        model.uploadPortrait(url);
    }
}
