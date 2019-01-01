package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.InfoAllListBean;
import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.entity.ResolvedBean;
import com.fourgod.chen.ctm.model.impl.MyResAndReqModel;
import com.fourgod.chen.ctm.view.impl.fragment.MyResAndReqFragment;

/**
 * Created by laobo on 2018/12/19.
 */

public class MyResAndReqPresenter extends BasePresenter<MyResAndReqFragment,MyResAndReqModel> {
    public MyResAndReqPresenter(MyResAndReqFragment view) {
        super(view);
    }

    @Override
    protected MyResAndReqModel getModel(Handler handler) {
        return new MyResAndReqModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        if(msg.what == 0) {
            InfoAllListBean bean = (InfoAllListBean) (msg.obj);
            view.initData(bean.getData(),getType()==model.TYPE_COLLECTION);
        }else if(msg.what == 1){
            ResolvedBean bean = (ResolvedBean) (msg.obj);
            view.resolvedBean(bean);
        } else if (msg.what == 2) {
            ResolvedBean bean = (ResolvedBean) (msg.obj);
            view.deleteReturn(bean);
        }
    }

    public void setType(String type){
        model.setType(type);
    }

    public String getType(){
        return model.getType();
    }

    public void loadData(){
        if(model.getType()==model.TYPE_COLLECTION){
            ArrayMap<String,String> param = new ArrayMap<>();
            model.getMyCollections(param);
        }else{
            ArrayMap<String,String> param = new ArrayMap<>();
            param.put("type",model.getType());
            model.getMyInfoList(param);
        }
    }

    public void solveInfo(String id) {
        model.resolve(id);
    }

    public void deleteInfo(String id) {
        model.deleteInfo(id);
    }
}
