package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.HotTagBean;
import com.fourgod.chen.ctm.entity.SearchBean;
import com.fourgod.chen.ctm.presenter.impl.SearchPresenter;
import com.fourgod.chen.ctm.utils.ListDataSave;
import com.fourgod.chen.ctm.view.i.ISearchView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity<SearchPresenter> implements ISearchView {

    private ImageView back;
    private EditText editText;
    private ImageView searchButton;
    private LinearLayout cateLinearLayout;
    private TagFlowLayout tagFlowLayout;
    private ListView historyListView;
    private TextView hotTextView;
    private TextView historyTextView;
    private List<String> hotList = new ArrayList<>();
    private List<String> searchHistory = new ArrayList<>();
    ListDataSave save = new ListDataSave(this, "search");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bindView();
    }

    private void bindView() {
        hotTextView = findViewById(R.id.tv_hot);

        searchHistory = save.getDataList("history");
        historyTextView = findViewById(R.id.tv_history);
        historyListView = findViewById(R.id.lv_history);
        if (searchHistory == null || searchHistory.size() == 0) {
            historyTextView.setVisibility(View.GONE);
            historyListView.setVisibility(View.GONE);
        } else {
            historyListView.setAdapter(new BaseAdapter() {

                TextView textView;
                @Override
                public int getCount() {
                    return searchHistory.size();
                }

                @Override
                public Object getItem(int position) {
                    return searchHistory.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    LayoutInflater inflater = SearchActivity.this.getLayoutInflater();
                    View view;
                    if (convertView == null) {
                        view = inflater.inflate(R.layout.item_search_history, null);
                    } else {
                        view = convertView;
                    }
                    textView = view.findViewById(R.id.tv_history_name);
                    textView.setText(searchHistory.get(searchHistory.size() - 1 - position));
                    return view;
                }
            });

        }

        back = findViewById(R.id.search_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editText = findViewById(R.id.edit_content);

        searchButton = findViewById(R.id.search_do);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String con = editText.getText().toString();
                if (searchHistory != null || searchHistory.size() != 0) {
                    if (!searchHistory.contains(con)) {
                        searchHistory.add(con);
                    }
                    else {
                        searchHistory.remove(con);
                        searchHistory.add(con);
                    }
                }
                else {
                    searchHistory.add(con);
                }
                doSearch(con);
            }
        });

        cateLinearLayout = findViewById(R.id.ll_cate);

    }

    @Override
    protected SearchPresenter getPresenter() {
        return new SearchPresenter(this);
    }

    /**
     * 搜索
     * @param content 搜索的内容.
     */
    private void doSearch(String content) {
        ArrayMap<String, String> param = new ArrayMap<>();
        param.put("searchContent", content);
        presenter.doSearch(param);
    }

    /**
     * 获取热门列表的返回
     * @param bean 热门列表对象
     */
    public void getHotListReturn(HotTagBean bean) {
        hotList.clear();
        for (HotTagBean.DataBean.ListBean listBean: bean.getData().getList()) {
            hotList.add(listBean.getHotWord());
        }
        tagFlowLayout = findViewById(R.id.fl_hot);
        final LayoutInflater inflater = LayoutInflater.from(SearchActivity.this);
        tagFlowLayout.setAdapter(new TagAdapter<String>(hotList) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView textView = (TextView) inflater.inflate(R.layout.item_hot_tag,
                        tagFlowLayout, false);
                textView.setText(s);
                return textView;
            }
        });
    }

    public void searchReturn(SearchBean bean) {
        Log.d("cztSearch", "searchReturn: " + bean.getCode());
    }

    @Override
    protected void onDestroy() {
        save.setDataList("history",searchHistory);
        super.onDestroy();
    }
}
