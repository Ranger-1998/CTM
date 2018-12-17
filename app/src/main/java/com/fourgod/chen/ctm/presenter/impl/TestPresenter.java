package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.event.NewsEvent;
import com.fourgod.chen.ctm.model.impl.TestModel;
import com.fourgod.chen.ctm.view.impl.fragment.TestFragment1;

public class TestPresenter extends BasePresenter<TestFragment1, TestModel> {

    public TestPresenter(TestFragment1 view) {
        super(view);
    }

    @Override
    protected TestModel getModel(Handler handler) {
        return new TestModel(handler);
    }

    @Override
    protected void eventReceive(Message msg) {
        view.test(((NewsEvent) msg.obj).getNewsBean());
    }

    public void testModel() {
        model.test("top");
    }
}
