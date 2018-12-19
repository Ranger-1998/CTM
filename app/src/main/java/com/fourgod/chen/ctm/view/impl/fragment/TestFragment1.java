package com.fourgod.chen.ctm.view.impl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.NewsBean;
import com.fourgod.chen.ctm.presenter.impl.TestPresenter;
import com.fourgod.chen.ctm.view.i.IBaseView;

import java.util.List;

public class TestFragment1 extends BaseFragment<TestPresenter> implements IBaseView {

    private View mRoot;
    private TextView tv;
    private String title;

    @Override
    protected TestPresenter getPresenter() {
        return new TestPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment1, container, false);
            tv = mRoot.findViewById(R.id.f_tv);
            //presenter.testModel();
            //tv.setText(title);
        }
        return mRoot;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
    }

    public void test(NewsBean bean) {
        List<NewsBean.ResultBean.DataBean> l = bean.getResult().getData();
        //tv.setText(title + "\n" + l.get(0).getTitle());
    }
}
