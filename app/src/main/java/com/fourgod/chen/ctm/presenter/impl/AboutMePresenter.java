package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.model.impl.AboutMeModel;
import com.fourgod.chen.ctm.view.impl.fragment.AboutMeFragment;

/**
 * Created by laobo on 2018/12/19.
 */

public class AboutMePresenter extends BasePresenter<AboutMeFragment,AboutMeModel> {
    public AboutMePresenter(AboutMeFragment view) {
        super(view);
    }

    @Override
    protected AboutMeModel getModel(Handler handler) {
        return new AboutMeModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {

    }
}
