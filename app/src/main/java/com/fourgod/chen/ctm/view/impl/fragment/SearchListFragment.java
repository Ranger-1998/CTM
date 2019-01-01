package com.fourgod.chen.ctm.view.impl.fragment;

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
import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.entity.SearchBean;
import com.fourgod.chen.ctm.presenter.impl.SearchListPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchListFragment extends BaseFragment<SearchListPresenter> {
    private String content;
    private int type;
    private View root;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private BaseQuickAdapter adapter;
    private List<InfoListBean.DataBean.ListBean> beanList = new ArrayList<>();
    private int nowPage = 0;
    private int totalPage = 0;

    @Override
    protected SearchListPresenter getPresenter() {
        return new SearchListPresenter(this);
    }

    public static SearchListFragment newInstance(String content, int type) {
        SearchListFragment fragment = new SearchListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type");
            content = bundle.getString("content");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_search_list,
                    container, false);
            initView();
            ArrayMap<String, String> param = new ArrayMap<>();
            param.put("title", content);
            param.put("type",String.valueOf(type));
            presenter.search(param);
        }

        return root;
    }

    private void initView() {
        refreshLayout = root.findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter = null;
                nowPage = 0;
                ArrayMap<String, String> param = new ArrayMap<>();
                param.put("title", content);
                param.put("type",String.valueOf(type));
                presenter.search(param);
            }
        });
        recyclerView = root.findViewById(R.id.rv_search);
        progressBar = root.findViewById(R.id.search_progress);
    }

    private void loadMore() {
        nowPage ++;
        ArrayMap<String, String> param = new ArrayMap<>();
        param.put("title", content);
        param.put("type",String.valueOf(type));
        param.put("pageNum", String.valueOf(nowPage));
        presenter.search(param);
    }


    public void searchReturn(InfoListBean bean) {
        if (refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
        if (adapter == null) {
            totalPage = bean.getData().getPages();
            beanList = bean.getData().getList();
            adapter = new BaseQuickAdapter<InfoListBean.DataBean.ListBean, BaseViewHolder>
                    (R.layout.list_item, beanList) {
                @Override
                protected void convert(BaseViewHolder helper, InfoListBean.DataBean.ListBean item) {
                    helper.setText(R.id.item_title, item.getTitle());
                    helper.setText(R.id.item_content, item.getContent());
                    helper.setText(R.id.item_user_name, item.getUserNickName());
                    helper.setText(R.id.item_push_time, item.getCreateTime());
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
            adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    if (nowPage < totalPage) {
                        loadMore();
                    } else {
                        adapter.loadMoreEnd(true);
                    }
                }
            }, recyclerView);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            progressBar.setVisibility(View.GONE);
            refreshLayout.setVisibility(View.VISIBLE);
        } else {
            if (nowPage <= totalPage) {
                beanList.addAll(bean.getData().getList());
                adapter.notifyDataSetChanged();
            }
        }
    }
}
