package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.model.impl.ListModel;
import com.fourgod.chen.ctm.view.impl.fragment.ListFragment;

/**
 * Created by Tolean on 2018/12/19.
 */

public class ListPresenter extends BasePresenter<ListFragment,ListModel> {
    public ListPresenter(ListFragment view) {
        super(view);
    }

    @Override
    protected ListModel getModel(Handler handler) {
        return new ListModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        InfoListBean bean = (InfoListBean)(msg.obj);
        if(bean.getData().getPageNum()==1)
            view.showInfoList(bean);
        else
            view.addInfmations(bean);
    }

    public void getInfoList(ArrayMap<String, String> param) {
        model.getInfoList(param);
    }
}
