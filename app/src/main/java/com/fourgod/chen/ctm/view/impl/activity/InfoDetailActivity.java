package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

import com.bumptech.glide.Glide;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.CollectBean;
import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.entity.ReportBean;
import com.fourgod.chen.ctm.presenter.impl.InfoDetailPresenter;
import com.fourgod.chen.ctm.utils.DimenUtils;
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.friend.constant.VerifyType;
import com.netease.nimlib.sdk.friend.model.AddFriendData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by laobo on 2018/12/19.
 */

public class InfoDetailActivity extends BaseActivity<InfoDetailPresenter> implements View.OnClickListener {
    private ImageView backButton;
    private ImageView moreButton;
    private ImageView collectButton;
    private CircleImageView userHead;
    private TextView userName;
    private TextView publishTime;
    private TextView infoContent;
    private RecyclerView infoImages;
    private FloatingActionButton actionButton;
    private InfoListBean.DataBean.ListBean bean;
    private List<String> pictureUrls = new ArrayList<>();
    private PopupWindow popupWindow;
    private FloatingActionButton chatBtn;
    private LinearLayout addFriendBtn;

    @Override
    protected InfoDetailPresenter getPresenter() {
        return new InfoDetailPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null) {
            bean = ((InfoListBean.DataBean.ListBean) getIntent().
                    getSerializableExtra("infoDetail"));
        }
        setContentView(R.layout.activity_detail);
        initView();

    }

    private void initView() {
        backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoDetailActivity.this.finish();
            }
        });

        collectButton = findViewById(R.id.btn_collect);
        collectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectInfo();
            }
        });

        moreButton = findViewById(R.id.btn_more);
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });

        actionButton = findViewById(R.id.fab);
        userHead = findViewById(R.id.img_head);
        userName = findViewById(R.id.tv_name);
        publishTime = findViewById(R.id.tv_time);
        infoContent = findViewById(R.id.tv_detail_content);
        infoImages = findViewById(R.id.rl_detail_images);
        chatBtn = findViewById(R.id.fab_chat);
        addFriendBtn = findViewById(R.id.btn_add);

        chatBtn.setOnClickListener(this);
        addFriendBtn.setOnClickListener(this);

        if (bean != null) {
            Glide.with(this).load(bean.getUserHeadUrl()).into(userHead);

            if (bean.getUserNickName() != null && !bean.getUserNickName().equals("")) {
                userName.setText(bean.getUserNickName());
            } else {
                userName.setText(bean.getUserId());
            }

            if (bean.getUpdateTime() != null && !bean.getUpdateTime().equals("")) {
                publishTime.setText(bean.getUpdateTime());
            } else {
                publishTime.setText(bean.getCreateTime());
            }

            infoContent.setText(bean.getContent());
            if (bean.getPicture() != null && !bean.getPicture().equals("")) {
                dealPictureUrls(bean.getPicture());
                DetailImageAdapter adapter = new DetailImageAdapter();
                infoImages.setAdapter(adapter);
                infoImages.setLayoutManager(new GridLayoutManager(InfoDetailActivity.this,
                        3));
            }
        }

        if(NIMClient.getService(FriendService.class).isMyFriend(String.valueOf(bean.getUserId()))){
            addFriendBtn.setBackgroundResource(R.drawable.shape_btn_solved);
        }

    }

    private void dealPictureUrls(String urls) {
        String[] u = urls.split("\\|");
        pictureUrls.addAll(Arrays.asList(u));
    }

    public void collectReturn(CollectBean bean) {
        if (bean.getCode() == 0) {
            collectButton.setBackgroundResource(R.drawable.ic_star_yellow_24dp);
        }
    }

    private void showPopupWindow() {
        View view = LayoutInflater.from(InfoDetailActivity.this).
                inflate(R.layout.pop_report, null, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportInfo();
                popupWindow.dismiss();
                Toast.makeText(InfoDetailActivity.this, "举报成功",
                        Toast.LENGTH_SHORT).show();
            }
        });
        popupWindow = new PopupWindow(view);
        popupWindow.setWidth(DimenUtils.dip2px(this, 80));
        popupWindow.setHeight(DimenUtils.dip2px(this, 24));
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        popupWindow.showAsDropDown(moreButton, -100, 0);
    }

    private void collectInfo() {
        ArrayMap<String, String> param = new ArrayMap<>();
        param.put("informationId", String.valueOf(bean.getId()));
        presenter.collectInfo(param);
    }

    private void reportInfo() {
        ArrayMap<String, String> param = new ArrayMap<>();
        param.put("informationId", String.valueOf(bean.getId()));
        presenter.reportInfo(param);
    }

    public void reportReturn(ReportBean bean) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_chat:
                //跳转聊天
                NimUIKit.startP2PSession(this, String.valueOf(bean.getUserId()));
                break;
            case R.id.btn_add:
                //添加好友
                NIMClient.getService(FriendService.class)
                        .addFriend(new AddFriendData(String.valueOf(bean.getUserId()), VerifyType.DIRECT_ADD))
                        .setCallback(new RequestCallback<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(InfoDetailActivity.this
                                        ,"添加好友成功！",Toast.LENGTH_SHORT).show();
                                addFriendBtn.setBackgroundResource(R.drawable.shape_btn_solved);
                            }

                            @Override
                            public void onFailed(int i) {
                                Toast.makeText(InfoDetailActivity.this
                                        ,"添加好友失败！",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onException(Throwable throwable) {
                                Toast.makeText(InfoDetailActivity.this
                                        ,"添加好友失败！",Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
        }
    }

    class DetailImageAdapter extends RecyclerView.Adapter<DetailImageAdapter.DetailImageHolder> {
        @NonNull
        @Override
        public DetailImageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_detail_image, viewGroup, false);
            return new DetailImageHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DetailImageHolder detailImageHolder, final int i) {
            Glide.with(InfoDetailActivity.this)
                    .load(pictureUrls.get(i)).into(detailImageHolder.imageView);
            detailImageHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(InfoDetailActivity.this,
                            ImageViewActivity.class);
                    intent.putExtra("imageUrl", pictureUrls.get(i));
                    InfoDetailActivity.this.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return pictureUrls.size();
        }

        class DetailImageHolder extends RecyclerView.ViewHolder{
            ImageView imageView;

            public DetailImageHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.iv_detail);
            }
        }
    }
}
