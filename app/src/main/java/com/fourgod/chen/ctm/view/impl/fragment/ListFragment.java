package com.fourgod.chen.ctm.view.impl.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Visibility;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.InfBean;
import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.presenter.impl.ListPresenter;
import com.fourgod.chen.ctm.utils.DimenUtils;
import com.fourgod.chen.ctm.view.i.IBaseView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tolean on 2018/12/19.
 */

public class ListFragment extends BaseFragment<ListPresenter> implements IBaseView{
    private Banner mBanner;
    private RecyclerView mRecyclerView;
    private View mRoot;
    private List<InfoListBean.DataBean.ListBean> mBeans;
    private List<String> mImgUrls;
    private BaseQuickAdapter mAdapter;
    @Override
    protected ListPresenter getPresenter() {
        return new ListPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment_list, container, false);
        }
        return mRoot;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayMap<String, String> p = new ArrayMap<>();
        presenter.getInfoList(p);
    }

    private void initView(){
        mRecyclerView = mRoot.findViewById(R.id.list_RecView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mAdapter=new BaseQuickAdapter<InfoListBean.DataBean.ListBean, BaseViewHolder>
                (R.layout.list_item,mBeans) {
            @Override
            protected void convert(BaseViewHolder helper, InfoListBean.DataBean.ListBean item) {
                //TODO 绑定数据
                helper.setText(R.id.item_title, item.getTitle());
                helper.setText(R.id.item_content, item.getContent());
                helper.setText(R.id.item_user_name, item.getUserNickName());
                helper.setText(R.id.item_push_time, item.getCreateTime());
                String[] imgs;
                if (item.getPicture() != null
                        && (imgs = item.getPicture().split("\\|")).length>0) {
                        Glide.with(ListFragment.this.getActivity()).load(imgs[0])
                                .into((ImageView) helper.getView(R.id.item_pic));
                }else{
                    helper.getView(R.id.item_pic).setVisibility(View.GONE);
                }

            }
        };

        mBanner=new Banner(this.getContext());
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        //mImgUrls=new ArrayList<>();
        //mImgUrls.add("http://lyonz.cn/static/images/albums/fulls/1527556881809.jpg");
        //mBanner.setImages(mImgUrls);
        List<Integer> images=new ArrayList<>();
        images.add(R.mipmap.person_bg);
        images.add(R.mipmap.person_bg);
        mBanner.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400));
        mBanner.setImages(images);
        mAdapter.setHeaderView(mBanner);
        mRecyclerView.setAdapter(mAdapter);
        mBanner.start();
    }

    public void showInfoList(InfoListBean bean) {
        mBeans = bean.getData().getList();
        initView();
    }
}
