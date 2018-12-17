package com.fourgod.chen.ctm.view.impl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fourgod.chen.ctm.presenter.impl.BasePresenter;
import com.fourgod.chen.ctm.view.i.IBaseView;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    protected P presenter;

    @Override
    public boolean isFinish() {
        return isRemoving();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = getPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 获取Presenter，类型应和Fragment的泛型一致
     *
     * @return Presenter
     */
    protected abstract P getPresenter();
}
