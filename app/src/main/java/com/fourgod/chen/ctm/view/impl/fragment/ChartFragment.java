package com.fourgod.chen.ctm.view.impl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.fourgod.chen.ctm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laobo on 2018/12/30.
 */

public class ChartFragment extends Fragment {
    private SlidingTabLayout tabLayout;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private ViewPager viewPager;
    private View mRoot;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment1, container, false);
            initView();
        }
        return mRoot;
    }

    private void initView() {
        viewPager = mRoot.findViewById(R.id.vp);
        tabLayout = mRoot.findViewById(R.id.slTabLayout);

        fragments.add(new RecentContactsFragment());
        fragments.add(new ContactListFragment());
        titles.add("最近会话");
        titles.add("通讯录");

        viewPager.setAdapter(new chatFragmentAdapter(getChildFragmentManager(),titles,fragments));
        tabLayout.setViewPager(viewPager);
    }

    private class chatFragmentAdapter extends FragmentPagerAdapter{
        private List<String> titles;
        private List<Fragment> fragments;
        public chatFragmentAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
            super(fm);
            this.titles =titles;
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}
