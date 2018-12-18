package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.SearchPresenter;
import com.fourgod.chen.ctm.view.i.ISearchView;
import com.zhy.view.flowlayout.TagFlowLayout;

public class SearchActivity extends BaseActivity<SearchPresenter> implements ISearchView {

    private ImageView back;
    private EditText editText;
    private ImageView doSearch;
    private LinearLayout cateLinearLayout;
    private TagFlowLayout tagFlowLayout;
    private ListView historyListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bindView();
    }

    private void bindView() {
        back = findViewById(R.id.search_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        editText = findViewById(R.id.edit_content);
        doSearch = findViewById(R.id.search_do);
        cateLinearLayout = findViewById(R.id.ll_cate);
        tagFlowLayout = findViewById(R.id.fl_hot);
        historyListView = findViewById(R.id.lv_history);
    }

    @Override
    protected SearchPresenter getPresenter() {
        return new SearchPresenter(this);
    }
}
