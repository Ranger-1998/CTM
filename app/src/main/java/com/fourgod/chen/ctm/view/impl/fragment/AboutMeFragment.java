package com.fourgod.chen.ctm.view.impl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.UserInfoBean;
import com.fourgod.chen.ctm.model.impl.MyResAndReqModel;
import com.fourgod.chen.ctm.presenter.impl.AboutMePresenter;

/**
 * Created by laobo on 2018/12/19.
 */

public class AboutMeFragment extends BaseFragment<AboutMePresenter> {
    private View mRoot;

    private TextView userAccount;
    private TextView userNikeName;
    private TextView userSign;
    private TextView userAuthWay;
    private TextView userPhone;
    private TextView userAddress;

    @Override
    protected AboutMePresenter getPresenter() {
        return new AboutMePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment_about_me, container, false);
            initView();
        }
        presenter.getUserInfo();
        return mRoot;
    }

    private void initView() {
        userAccount = mRoot.findViewById(R.id.user_account);
        userNikeName = mRoot.findViewById(R.id.user_nike_name);
        userSign = mRoot.findViewById(R.id.user_sign);
        userAuthWay = mRoot.findViewById(R.id.user_auth_phone);
        userPhone = mRoot.findViewById(R.id.user_phone_number);
        userAddress = mRoot.findViewById(R.id.user_address);
    }

    public void getUserInfoReturn(UserInfoBean bean) {
        if (bean != null && bean.getCode() == 0) {
            userAccount.setText("用户名:   " + bean.getData().getUsername());
            userNikeName.setText("昵称:   " + bean.getData().getNickname());
            userSign.setText("签名:   " + bean.getData().getSignature());
            userAuthWay.setText("电话:   " + bean.getData().getTelephone());
            userPhone.setText("电话:   " + bean.getData().getTelephone());
            userAddress.setText("家乡:   " + bean.getData().getHometown());
        }
    }


}
