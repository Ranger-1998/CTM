package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.InfoDetailPresenter;

/**
 * Created by laobo on 2018/12/19.
 */

public class InfoDetailActivity extends BaseActivity<InfoDetailPresenter> {
    private Toolbar toolBar;
    @Override
    protected InfoDetailPresenter getPresenter() {
        return new InfoDetailPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    private void initView() {
        toolBar = findViewById(R.id.toolbar);

        setSupportActionBar(toolBar);
    }
}
