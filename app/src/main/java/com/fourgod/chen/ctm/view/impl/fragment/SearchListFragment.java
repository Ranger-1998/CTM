package com.fourgod.chen.ctm.view.impl.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.CategoryListBean;
import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.entity.SearchBean;
import com.fourgod.chen.ctm.presenter.impl.ListPresenter;
import com.fourgod.chen.ctm.presenter.impl.SearchListPresenter;
import com.fourgod.chen.ctm.presenter.impl.SearchPresenter;
import com.fourgod.chen.ctm.view.impl.activity.InfoDetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class SearchListFragment extends BaseFragment<SearchListPresenter> {
    private RecyclerView mRecyclerView;
    private View mRoot;
    private List<InfoListBean.DataBean.ListBean> mBeans;
    private List<String> mImgUrls;
    private BaseQuickAdapter mAdapter;
    private SmartRefreshLayout mRefreshLayout;
    private int CurrentPageNum;
    private String type;
    private String keyWord;

    @Override
    protected SearchListPresenter getPresenter() {
        return new SearchListPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment_search_list, container, false);
            initView();
            CurrentPageNum=1;
            presenter.search(keyWord,type,CurrentPageNum++);
        }
        return mRoot;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getString("type");
        keyWord = getArguments().getString("keyWord");
    }

    private void initView(){
        mRecyclerView = mRoot.findViewById(R.id.list_RecView);
        mRefreshLayout=mRoot.findViewById(R.id.list_refreshLayout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRefreshLayout.setEnableRefresh(false);
        //加载更多
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.search(keyWord,type,CurrentPageNum++);
                mAdapter.notifyDataSetChanged();
                refreshLayout.finishLoadMore();
            }
        });
    }

    public void showInfoList(InfoListBean bean) {
        if(mBeans == null){
            mBeans = new ArrayList<>();
        }
        mBeans.clear();
        mBeans.addAll(bean.getData().getList());
        if(mAdapter == null){
            mAdapter = new BaseQuickAdapter<InfoListBean.DataBean.ListBean, BaseViewHolder>
                    (R.layout.list_item,mBeans) {
                @Override
                protected void convert(BaseViewHolder helper, InfoListBean.DataBean.ListBean item) {
                    //TODO 绑定数据
                    helper.setText(R.id.item_title, item.getTitle());
                    helper.setText(R.id.item_content, item.getContent());
                    helper.setText(R.id.item_user_name, item.getUserNickName());
                    helper.setText(R.id.item_push_time, item.getCreateTime());
                    Glide.with(SearchListFragment.this.getActivity()).load(item.getUserHeadUrl())
                            .into((ImageView)helper.getView(R.id.item_user_head));
                    String[] imgs;
                    if (item.getPicture() != null
                            && (imgs = item.getPicture().split("\\|")).length>0) {
                        Glide.with(SearchListFragment.this.getActivity()).load(imgs[0])
                                .into((ImageView) helper.getView(R.id.item_pic));
                    }else{
                        helper.getView(R.id.item_pic).setVisibility(View.GONE);
                    }

                }
            };
            mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (getActivity() != null) {
                        Intent intent = new Intent(getActivity(), InfoDetailActivity.class);
                        intent.putExtra("infoDetail",
                                ((InfoListBean.DataBean.ListBean) adapter.getData().get(position)));
                        getActivity().startActivity(intent);
                    }
                }
            });
            mRecyclerView.setAdapter(mAdapter);
        }
        mAdapter.notifyDataSetChanged();
    }
    public void addInfmations(InfoListBean bean){
        mBeans.addAll(bean.getData().getList());
        if(bean.getData().getPageNum()==bean.getData().getPages()){
            mRefreshLayout.setEnableLoadMore(false);
        }
        mAdapter.notifyDataSetChanged();
    }
}
