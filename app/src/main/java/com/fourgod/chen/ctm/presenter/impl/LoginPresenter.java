package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

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

    }
}
