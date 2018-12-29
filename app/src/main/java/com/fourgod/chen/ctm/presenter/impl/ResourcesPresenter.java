package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.CategoryListBean;
import com.fourgod.chen.ctm.model.impl.ResourcesModel;
import com.fourgod.chen.ctm.view.impl.fragment.ResourcesFragment;

/**
 * Created by Tolean on 2018/12/19.
 */

public class ResourcesPresenter extends BasePresenter<ResourcesFragment,ResourcesModel> {
    public ResourcesPresenter(ResourcesFragment view) {
        super(view);
    }

    @Override
    protected ResourcesModel getModel(Handler handler) {
        return new ResourcesModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        CategoryListBean bean=(CategoryListBean)msg.obj;
        view.setCategorys(bean);
    }

    public void getCategoryList(ArrayMap<String, String> param){
        model.getCategoryList(param);
    }
}
