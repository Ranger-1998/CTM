package com.fourgod.chen.ctm.view.impl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fourgod.chen.ctm.R;
import com.netease.nim.uikit.business.recent.RecentContactsFragment;
import com.netease.nim.uikit.common.activity.UI;

/**
 * Created by laobo on 2018/12/30.
 */

public class ChartFragment extends Fragment {

    private View mRoot;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment1, container, false);
        }
        return mRoot;
    }

}
