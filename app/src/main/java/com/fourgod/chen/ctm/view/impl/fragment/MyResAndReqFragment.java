package com.fourgod.chen.ctm.view.impl.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.InfoAllListBean;
import com.fourgod.chen.ctm.model.impl.MyResAndReqModel;
import com.fourgod.chen.ctm.presenter.impl.MyResAndReqPresenter;
import com.fourgod.chen.ctm.view.adapter.MyResAndReqRlvAdapter;
import com.fourgod.chen.ctm.view.impl.activity.PublishActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laobo on 2018/12/19.
 */

public class MyResAndReqFragment extends BaseFragment<MyResAndReqPresenter> {
    private static final String TAG = "Lao";
    private View mRoot;
    private RecyclerView recyclerView;
    private MyResAndReqRlvAdapter rlvAdapter;
    private List<InfoAllListBean.DataBean> myInfList = new ArrayList<>();

    @Override
    protected MyResAndReqPresenter getPresenter() {
        return new MyResAndReqPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment_my_res_and_req, container, false);
            initView();
        }
        return mRoot;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置fragment类型，需求或资源
        Bundle bundle = getArguments();
        if(bundle != null){
            presenter.setType(bundle.getString("type", MyResAndReqModel.TYPE_RESOURCE));
        }else{
            presenter.setType(MyResAndReqModel.TYPE_RESOURCE);
        }
    }

    private void initView() {
        recyclerView = mRoot.findViewById(R.id.rlv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.loadData();
    }

    public void initData(List<InfoAllListBean.DataBean> data){
        myInfList.clear();
        myInfList.addAll(data);
        final Context context = getActivity();
        if(rlvAdapter == null){
            rlvAdapter = new MyResAndReqRlvAdapter(R.layout.item_my_res_and_req, myInfList,getActivity());
            rlvAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                    if (context != null) {
                        Vibrator vibrator = (Vibrator)context
                                .getSystemService(context.VIBRATOR_SERVICE);
                        vibrator.vibrate(500);
                        Intent intent = new Intent(context, PublishActivity.class);
                        intent.putExtra("isEdit", true);
                        intent.putExtra("bean",
                                ((InfoAllListBean.DataBean) adapter.getData().get(position)));
                        intent.putExtra("type", String.valueOf(presenter.getType()));
                        startActivity(intent);
                    }
                    return false;
                }
            });
            recyclerView.setAdapter(rlvAdapter);
        }
        rlvAdapter.notifyDataSetChanged();
    }

//    public void addData(List<InfoListBean.DataBean.ListBean> data){
//        myInfList.addAll(data);
//        rlvAdapter.notifyDataSetChanged();
//    }
}
