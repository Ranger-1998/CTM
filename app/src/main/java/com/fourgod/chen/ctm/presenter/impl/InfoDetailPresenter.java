package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.CollectBean;
import com.fourgod.chen.ctm.entity.ReportBean;
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
        switch (msg.what) {
            case 1:
                view.collectReturn((CollectBean) msg.obj);
                break;
            case 2:
                view.reportReturn((ReportBean) msg.obj);
                break;
        }
    }

    public void collectInfo(ArrayMap<String, String> param) {
        model.collectInfo(param);
    }

    public void reportInfo(ArrayMap<String, String> param) {
        model.reportInfo(param);
    }
}
