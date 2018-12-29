package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.SearchPresenter;
import com.fourgod.chen.ctm.utils.ListDataSave;
import com.fourgod.chen.ctm.view.i.ISearchView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchActivity extends BaseActivity<SearchPresenter> implements ISearchView {

    private ImageView back;
    private EditText editText;
    private ImageView doSearch;
    private LinearLayout cateLinearLayout;
    private TagFlowLayout tagFlowLayout;
    private ListView historyListView;
    private TextView hotTextView;
    private TextView historyTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bindView();
    }

    private void bindView() {
        hotTextView = findViewById(R.id.tv_hot);
        historyTextView = findViewById(R.id.tv_history);
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

        List<String> data = Arrays.asList("自行车", "电脑", "电风扇", "PS4", "山地自行车"
                , "电风扇", "PS4", "山地自行车", "电风扇", "PS4", "山地自行车","电风扇",
                "PS4", "山地自行车");


        final LayoutInflater inflater = LayoutInflater.from(SearchActivity.this);
        tagFlowLayout = findViewById(R.id.fl_hot);
        tagFlowLayout.setAdapter(new TagAdapter<String>(data) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView textView = (TextView) inflater.inflate(R.layout.item_hot_tag,
                        tagFlowLayout, false);
                textView.setText(s);
                return textView;
            }
        });
        historyListView = findViewById(R.id.lv_history);
    }

    @Override
    protected SearchPresenter getPresenter() {
        return new SearchPresenter(this);
    }
}
