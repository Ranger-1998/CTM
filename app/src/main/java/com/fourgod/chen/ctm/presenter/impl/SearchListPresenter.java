package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.entity.SearchBean;
import com.fourgod.chen.ctm.model.impl.SearchListModel;
import com.fourgod.chen.ctm.view.impl.fragment.SearchListFragment;

public class SearchListPresenter extends BasePresenter<SearchListFragment, SearchListModel>{
    public SearchListPresenter(SearchListFragment view) {
        super(view);
    }

    @Override
    protected SearchListModel getModel(Handler handler) {
        return new SearchListModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        view.searchReturn((InfoListBean) msg.obj);
    }

    public void search(ArrayMap<String, String> param) {
        model.search(param);
    }
}
