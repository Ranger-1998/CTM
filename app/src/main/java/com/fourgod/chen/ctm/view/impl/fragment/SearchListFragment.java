package com.fourgod.chen.ctm.view.impl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
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
import com.fourgod.chen.ctm.entity.SearchBean;
import com.fourgod.chen.ctm.presenter.impl.SearchListPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class SearchListFragment extends BaseFragment<SearchListPresenter> {
    private String content;
    private int type;
    private View root;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private BaseQuickAdapter adapter;

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
        ArrayMap<String, String> param = new ArrayMap<>();
        param.put("searchContent", content);
        param.put("type",String.valueOf(type));
        presenter.search(param);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_search_list,
                    container, false);
        }
        initView();
        return root;
    }

    private void initView() {
        refreshLayout = root.findViewById(R.id.refresh);
        recyclerView = root.findViewById(R.id.rv_search);
        progressBar = root.findViewById(R.id.search_progress);
    }


    public void searchReturn(SearchBean bean) {
        adapter = new BaseQuickAdapter<SearchBean.DataBean.ListBean, BaseViewHolder>
                (R.layout.list_item, bean.getData().getList()) {
            @Override
            protected void convert(BaseViewHolder helper, SearchBean.DataBean.ListBean item) {
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
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar.setVisibility(View.GONE);
        refreshLayout.setVisibility(View.VISIBLE);
    }
}
