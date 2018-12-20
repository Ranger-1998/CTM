package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.model.impl.SetModel;
import com.fourgod.chen.ctm.view.impl.activity.SetActivity;

/**
 * Created by Tolean on 2018/12/20.
 */

public class SetPresenter extends BasePresenter<SetActivity,SetModel> {
    public SetPresenter(SetActivity view) {
        super(view);
    }

    @Override
    protected SetModel getModel(Handler handler) {
        return new SetModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {

    }
}
