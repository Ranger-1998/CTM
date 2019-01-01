package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.entity.UserInfoBean;
import com.fourgod.chen.ctm.model.impl.AboutMeModel;
import com.fourgod.chen.ctm.model.impl.PersonModel;
import com.fourgod.chen.ctm.view.impl.fragment.AboutMeFragment;

/**
 * Created by laobo on 2018/12/19.
 */

public class AboutMePresenter extends BasePresenter<AboutMeFragment,PersonModel> {
    public AboutMePresenter(AboutMeFragment view) {
        super(view);
    }

    @Override
    protected PersonModel getModel(Handler handler) {
        return new PersonModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        switch (msg.what) {
            case 0:
                view.getUserInfoReturn((UserInfoBean) msg.obj);
                break;
        }
    }

    public void getUserInfo() {
        model.loadMyInfo();
    }
}
