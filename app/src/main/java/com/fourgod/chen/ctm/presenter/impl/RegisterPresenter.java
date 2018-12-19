package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

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

    }
}
