package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.BasePresenter;
import com.fourgod.chen.ctm.presenter.impl.RegisterPresenter;

/**
 * Created by Tolean on 2018/12/18.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> {
    @Override
    protected RegisterPresenter getPresenter() {
        return new RegisterPresenter(this);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
