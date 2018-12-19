package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.BasePresenter;
import com.fourgod.chen.ctm.view.impl.fragment.BaseFragment;
import com.fourgod.chen.ctm.view.impl.fragment.PersonFragment;
import com.fourgod.chen.ctm.view.impl.fragment.TestFragment1;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laobo on 2018/12/18.
 */

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationViewEx bnve;
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private HomeViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        bnve = findViewById(R.id.bnve);
        viewPager = findViewById(R.id.vp);

        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
    }

    private void initData() {
        BaseFragment resFragment = new TestFragment1();
        Bundle bundle = new Bundle();
        bundle.putString("title", "资源");
        resFragment.setArguments(bundle);

        BaseFragment reqFragment = new TestFragment1();
        bundle = new Bundle();
        bundle.putString("title", "需求");
        reqFragment.setArguments(bundle);

        BaseFragment chatFragment = new TestFragment1();
        bundle = new Bundle();
        bundle.putString("title", "聊天");
        chatFragment.setArguments(bundle);

        BaseFragment personFragment = new PersonFragment();
        personFragment.setArguments(bundle);

        fragments.add(resFragment);
        fragments.add(reqFragment);
        fragments.add(chatFragment);
        fragments.add(personFragment);

        viewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initEvent() {
        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private int prePosition = -1;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = 0;
                switch (menuItem.getItemId()){
                    case R.id.menu_res:
                        id = 0;
                        break;
                    case R.id.menu_req:
                        id = 1;
                        break;
                    case R.id.menu_chat:
                        id = 2;
                        break;
                    case R.id.menu_person:
                        id = 3;
                        break;
                    case R.id.menu_empty:
                        return false;
                }
                if(id != prePosition){
                    prePosition = id;
                    viewPager.setCurrentItem(id,false);
                }
                return true;
            }
        });
    }

    class HomeViewPagerAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragments;
        public HomeViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
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
    }

}
