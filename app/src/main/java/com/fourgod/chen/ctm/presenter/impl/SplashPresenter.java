package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.model.impl.SplashModel;
import com.fourgod.chen.ctm.view.impl.activity.SplashActivity;

public class SplashPresenter extends BasePresenter<SplashActivity, SplashModel> {
    public SplashPresenter(SplashActivity view) {
        super(view);
    }

    @Override
    protected SplashModel getModel(Handler handler) {
        return new SplashModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {

    }
}
