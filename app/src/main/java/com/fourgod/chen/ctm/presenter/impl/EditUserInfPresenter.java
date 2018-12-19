package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.model.impl.BaseModel;
import com.fourgod.chen.ctm.model.impl.EditUserInfModel;
import com.fourgod.chen.ctm.view.i.IBaseView;

/**
 * Created by Tolean on 2018/12/19.
 */

public class EditUserInfPresenter extends BasePresenter {
    public EditUserInfPresenter(IBaseView view) {
        super(view);
    }

    @Override
    protected BaseModel getModel(Handler handler) {
        return  new EditUserInfModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {

    }
}
