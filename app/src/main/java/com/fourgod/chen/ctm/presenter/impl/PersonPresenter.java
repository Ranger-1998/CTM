package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.model.impl.PersonModel;
import com.fourgod.chen.ctm.view.impl.fragment.PersonFragment;

/**
 * Created by laobo on 2018/12/18.
 */

public class PersonPresenter extends BasePresenter<PersonFragment,PersonModel> {
    public PersonPresenter(PersonFragment view) {
        super(view);
    }

    @Override
    protected PersonModel getModel(Handler handler) {
        return new PersonModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {

    }
}
