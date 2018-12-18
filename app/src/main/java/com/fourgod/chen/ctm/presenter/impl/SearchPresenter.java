package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.model.impl.SearchModel;
import com.fourgod.chen.ctm.view.impl.activity.SearchActivity;

public class SearchPresenter extends BasePresenter<SearchActivity, SearchModel> {
    public SearchPresenter(SearchActivity view) {
        super(view);
    }

    @Override
    protected SearchModel getModel(Handler handler) {
        return new SearchModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {

    }
}
