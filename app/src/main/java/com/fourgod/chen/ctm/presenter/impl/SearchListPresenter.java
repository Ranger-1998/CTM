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
        InfoListBean bean = (InfoListBean)(msg.obj);
        if(bean.getData().getPageNum()==1)
            view.showInfoList(bean);
        else
            view.addInfmations(bean);
    }

    public void search(String keyWord, String type, int page) {
        ArrayMap<String,String> param = new ArrayMap<>();
        param.put("type",type);
        param.put("searchContent",keyWord);
        param.put("pageNum",String.valueOf(page));
        model.search(param);
    }
}
