package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.entity.MyInfBean;
import com.fourgod.chen.ctm.model.impl.MyResAndReqModel;
import com.fourgod.chen.ctm.view.impl.fragment.MyResAndReqFragment;

import java.util.ArrayList;
import java.util.List;

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

    }

    public void setType(int type){
        model.setType(type);
    }

    public void loadData(){
        List<MyInfBean> data = new ArrayList<>();
        for(int i = 0; i<10; i++){
            data.add(new MyInfBean());
        }
        view.initData(data);
    }
}
