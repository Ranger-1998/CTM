package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.HotTagBean;
import com.fourgod.chen.ctm.entity.SearchBean;
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
        switch (msg.what) {
            case 1:
                view.getHotListReturn((HotTagBean) msg.obj);
            case 2:
                view.searchReturn((SearchBean) msg.obj);
        }
    }
    public void getHotTags(ArrayMap<String, String> param) {
        model.hotList(param);
    }

    public void doSearch(ArrayMap<String, String> param) {
        model.doSearch(param);
    }
}
