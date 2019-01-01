package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.view.View;

import com.fourgod.chen.ctm.entity.RegisterBean;
import com.fourgod.chen.ctm.entity.YunxinBean;
import com.fourgod.chen.ctm.model.impl.RegisterModel;
import com.fourgod.chen.ctm.view.impl.activity.RegisterActivity;

/**
 * Created by Tolean on 2018/12/19.
 */

public class RegisterPresenter extends BasePresenter<RegisterActivity,RegisterModel> {
    public RegisterPresenter(RegisterActivity view) {
        super(view);
    }

    @Override
    protected RegisterModel getModel(Handler handler) {
        return new RegisterModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        if(msg.what==1){
            YunxinBean bean = (YunxinBean)msg.obj;
            if(bean.getData()==200){
                //
            }
        }else if(msg.what==2){
            YunxinBean bean = (YunxinBean)msg.obj;
            if(bean.getData()==200){
                view.register(true);
            }else{
                view.register(false);
            }
        }else if(msg.what==3){
            RegisterBean bean = (RegisterBean)msg.obj;
            if(bean.getCode()==200){
                view.registerSuccess();
            }else{
                view.registerFail();
            }
        }
    }
    public void sendCode(ArrayMap<String, String> param){
        model.sendCode(param);
    }

    public void checkCode(ArrayMap<String, String> param){
        model.checkCode(param);
    }
    public void register(ArrayMap<String, String> param){
        model.register(param);
    }
}
