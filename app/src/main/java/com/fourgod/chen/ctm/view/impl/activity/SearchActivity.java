package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.flyco.tablayout.SlidingTabLayout;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.HotTagBean;
import com.fourgod.chen.ctm.entity.SearchBean;
import com.fourgod.chen.ctm.presenter.impl.SearchPresenter;
import com.fourgod.chen.ctm.utils.ListDataSave;
import com.fourgod.chen.ctm.view.adapter.TabLayoutAdapter;
import com.fourgod.chen.ctm.view.i.ISearchView;
import com.fourgod.chen.ctm.view.impl.fragment.SearchListFragment;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchActivity extends BaseActivity<SearchPresenter> implements ISearchView {

    private ImageView back;
    private EditText editText;
    private ImageView searchButton;
    private LinearLayout cateLinearLayout;
    private TagFlowLayout tagFlowLayout;
    private RecyclerView historyRecyclerView;
    private TextView hotTextView;
    private LinearLayout historyText;
    private List<String> hotList = new ArrayList<>();
    private List<String> searchHistory = new ArrayList<>();
    ListDataSave save;
    private RelativeLayout searchRoot;
    private LinearLayout searchListRoot;

    private ViewPager searchPager;
    private SlidingTabLayout tabLayout;

    private boolean isSearchShow = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        save = new ListDataSave(this, "search");
        getHotTags();
        bindView();
    }

    private void bindView() {
        hotTextView = findViewById(R.id.tv_hot);

        searchRoot = findViewById(R.id.rl_search);
        searchListRoot = findViewById(R.id.ll_search);

        searchHistory = save.getDataList("history");
        historyText = findViewById(R.id.tv_history);
        historyRecyclerView = findViewById(R.id.lv_history);
        if (searchHistory == null || searchHistory.size() == 0) {
            historyText.setVisibility(View.GONE);
            historyRecyclerView.setVisibility(View.GONE);
        } else {
            HistoryAdapter adapter = new HistoryAdapter();
            historyRecyclerView.setAdapter(adapter);
            historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        back = findViewById(R.id.search_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editText = findViewById(R.id.edit_content);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSearchShow) {
                    showSearch();
                    isSearchShow = true;
                }
            }
        });

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
                isSearchShow = false;
                showSearchDetail(con);
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
     * 热门标签获取.
     */
    private void getHotTags() {
        ArrayMap<String, String> param = new ArrayMap<>();
        presenter.getHotTags(param);
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

    @Override
    protected void onPause() {
        save.setDataList("history",searchHistory);
        super.onPause();
    }

    class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {

        @NonNull
        @Override
        public HistoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.item_search_history, viewGroup, false);
            return new HistoryHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull HistoryHolder historyHolder, final int i) {
            historyHolder.historyText.setText(searchHistory.get(searchHistory.size() - 1 - i));
            historyHolder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchHistory.remove(searchHistory.get(i));
                    update(i);
                }
            });
            historyHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showSearchDetail(searchHistory.get(i));
                    String t = searchHistory.get(i);
                    searchHistory.remove(searchHistory.get(i));
                    searchHistory.add(t);
                }
            });
        }

        private void update(int position) {
            notifyItemRemoved(position);
        }

        @Override
        public int getItemCount() {
            return searchHistory.size();
        }

        class HistoryHolder extends RecyclerView.ViewHolder{
            TextView historyText;
            ImageView delete;
            public HistoryHolder(@NonNull View itemView) {
                super(itemView);
                historyText = itemView.findViewById(R.id.tv_history_name);
                delete = itemView.findViewById(R.id.iv_history_delete);
            }
        }
    }

    public void showSearch() {
        searchRoot.setVisibility(View.VISIBLE);
        searchListRoot.setVisibility(View.GONE);
    }

    public void showSearchDetail(String content) {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SearchListFragment.newInstance(content, 0));
        fragments.add(SearchListFragment.newInstance(content, 1));
        List<String> titles = Arrays.asList("资源", "需求");

        searchRoot.setVisibility(View.GONE);
        searchListRoot.setVisibility(View.VISIBLE);
        searchPager = findViewById(R.id.vp_search);
        tabLayout = findViewById(R.id.search_tab);

        TabLayoutAdapter adapter = new TabLayoutAdapter(getSupportFragmentManager(),
                fragments, titles);
        searchPager.setAdapter(adapter);
        tabLayout.setViewPager(searchPager);
    }
}
