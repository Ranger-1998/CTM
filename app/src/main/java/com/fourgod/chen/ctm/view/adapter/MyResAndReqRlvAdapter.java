package com.fourgod.chen.ctm.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.InfoAllListBean;
import com.fourgod.chen.ctm.entity.MyInfBean;
import com.fourgod.chen.ctm.presenter.impl.MyResAndReqPresenter;
import com.fourgod.chen.ctm.view.impl.fragment.ListFragment;

import java.util.List;

/**
 * Created by laobo on 2018/12/19.
 */

public class MyResAndReqRlvAdapter extends BaseQuickAdapter<InfoAllListBean.DataBean,BaseViewHolder> {
    private Context context;
    private MyResAndReqPresenter presenter;
    public MyResAndReqRlvAdapter(int layoutResId, @Nullable List<InfoAllListBean.DataBean> data
            ,MyResAndReqPresenter presenter, Context context) {
        super(layoutResId, data);
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    protected void convert(final BaseViewHolder helper, InfoAllListBean.DataBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setText(R.id.tv_time, "发布于 " + item.getCreateTime());
        String[] imgs;
        if (item.getPicture() != null
                && (imgs = item.getPicture().split("\\|")).length>0) {
            Glide.with(context).load(imgs[0])
                    .into((ImageView) helper.getView(R.id.img_pic));
        }else{
            helper.getView(R.id.img_pic).setVisibility(View.GONE);
        }
        if(item.getStatus().equals("1")){
            helper.setBackgroundRes(R.id.btn_solve,R.drawable.shape_btn_solved);
        }
        helper.setOnItemClickListener(R.id.btn_solve, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
