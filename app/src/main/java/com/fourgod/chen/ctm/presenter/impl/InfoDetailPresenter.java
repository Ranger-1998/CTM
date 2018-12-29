package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.model.impl.InfDetailModel;
import com.fourgod.chen.ctm.view.impl.activity.InfoDetailActivity;

/**
 * Created by laobo on 2018/12/19.
 */

public class InfoDetailPresenter extends BasePresenter<InfoDetailActivity,InfDetailModel>{
    public InfoDetailPresenter(InfoDetailActivity view) {
        super(view);
    }

    @Override
    protected InfDetailModel getModel(Handler handler) {
        return new InfDetailModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {

    }
}
