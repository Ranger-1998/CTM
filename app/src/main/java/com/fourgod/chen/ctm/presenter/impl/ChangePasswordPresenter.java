package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.ResolvedBean;
import com.fourgod.chen.ctm.model.impl.ChangePasswordModel;
import com.fourgod.chen.ctm.view.impl.activity.ChangePasswordActivity;

public class ChangePasswordPresenter extends
        BasePresenter<ChangePasswordActivity, ChangePasswordModel>{

    public ChangePasswordPresenter(ChangePasswordActivity view) {
        super(view);
    }

    @Override
    protected ChangePasswordModel getModel(Handler handler) {
        return new ChangePasswordModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        view.changePassReturn((ResolvedBean) msg.obj);
    }

    public void changePassword(String oldPass, String newPass) {
        ArrayMap<String, String> param = new ArrayMap<>();
        param.put("newPassword", newPass);
        param.put("oldPassword", oldPass);
        model.changePassword(param);
    }
}
