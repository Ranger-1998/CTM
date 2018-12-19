package com.fourgod.chen.ctm.view.impl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.BasePresenter;
import com.fourgod.chen.ctm.presenter.impl.ResourcesPresenter;
import com.fourgod.chen.ctm.view.i.IBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tolean on 2018/12/18.
 */

public class ResourcesFragment extends BaseFragment<ResourcesPresenter> implements IBaseView{
    private View mRoot;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private String[] mTitles={"电子产品","书籍","生活用品","专业人才","廉价劳动力","二手电脑"};
    private ArrayList<Fragment> mFragments;
    @Override
    protected ResourcesPresenter getPresenter() {
        return new ResourcesPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment_resources, container, false);
            initView();
        }
        return mRoot;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void initView(){
        mSlidingTabLayout = mRoot.findViewById(R.id.resources_tab);
        mViewPager = mRoot.findViewById(R.id.resources_vp);

       mFragments=new ArrayList<Fragment>();
        for(int i=0;i<6;i++){
            mFragments.add(new ListFragment());
        }
        mSlidingTabLayout.setViewPager(mViewPager,mTitles,this.getActivity(),mFragments);
    }
}
