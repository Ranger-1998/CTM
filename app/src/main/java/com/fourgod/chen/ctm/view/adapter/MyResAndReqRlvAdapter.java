package com.fourgod.chen.ctm.view.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fourgod.chen.ctm.entity.MyInfBean;

import java.util.List;

/**
 * Created by laobo on 2018/12/19.
 */

public class MyResAndReqRlvAdapter extends BaseQuickAdapter<MyInfBean,BaseViewHolder> {
    public MyResAndReqRlvAdapter(int layoutResId, @Nullable List<MyInfBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyInfBean item) {

    }
}
