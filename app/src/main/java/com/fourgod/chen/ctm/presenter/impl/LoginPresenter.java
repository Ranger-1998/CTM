package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.LoginBean;
import com.fourgod.chen.ctm.entity.UserInfoBean;
import com.fourgod.chen.ctm.model.impl.LoginModel;
import com.fourgod.chen.ctm.view.impl.activity.LoginActivity;

/**
 * Created by Tolean on 2018/12/19.
 */

public class LoginPresenter extends BasePresenter<LoginActivity,LoginModel> {
    public LoginPresenter(LoginActivity view) {
        super(view);
    }

    @Override
    protected LoginModel getModel(Handler handler) {
        return new LoginModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        switch (msg.what) {
            case 1:
                LoginBean bean = (LoginBean)(msg.obj);
                view.loginReturn(bean);
        }
    }

    public void login(ArrayMap<String, String> param) {
        model.login(param);
    }

}
