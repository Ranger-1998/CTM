package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

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

    }
}
