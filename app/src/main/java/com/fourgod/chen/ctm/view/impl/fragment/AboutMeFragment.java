package com.fourgod.chen.ctm.view.impl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.AboutMePresenter;

/**
 * Created by laobo on 2018/12/19.
 */

public class AboutMeFragment extends BaseFragment<AboutMePresenter> {
    private View mRoot;
    @Override
    protected AboutMePresenter getPresenter() {
        return new AboutMePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment_about_me, container, false);
            initView();
        }
        return mRoot;
    }

    private void initView() {

    }
}
