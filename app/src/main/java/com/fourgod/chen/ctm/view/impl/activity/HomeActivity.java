package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.LoginBean;
import com.fourgod.chen.ctm.presenter.impl.BasePresenter;
import com.fourgod.chen.ctm.view.impl.fragment.BaseFragment;
import com.fourgod.chen.ctm.view.impl.fragment.ChartFragment;
import com.fourgod.chen.ctm.view.impl.fragment.PersonFragment;
import com.fourgod.chen.ctm.view.impl.fragment.ResourcesFragment;
import com.fourgod.chen.ctm.view.impl.fragment.TestFragment1;
import com.fourgod.chen.ctm.view.widget.MoreWindow;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.netease.nim.uikit.business.recent.RecentContactsFragment;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laobo on 2018/12/18.
 */

public class HomeActivity extends BaseActivity {
    private BottomNavigationViewEx bnve;
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private HomeViewPagerAdapter viewPagerAdapter;
    private MoreWindow moreWindow;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
        initEvent();
        //doIMLogin();
    }
    private void doIMLogin() {
        SharedPreferences preferences = getSharedPreferences("token",
                Context.MODE_PRIVATE);
        String token = preferences.getString("token", "");
        String accid = preferences.getString("accid", "");
        LoginInfo info = new LoginInfo(accid,token);
        RequestCallback<LoginInfo> callback =
                new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo param) {

                    }

                    @Override
                    public void onFailed(int code) {
                    }

                    @Override
                    public void onException(Throwable exception) {
                    }
                    // 可以在此保存LoginInfo到本地，下次启动APP做自动登录用
                };
        NIMClient.getService(AuthService.class).login(info)
                .setCallback(callback);
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    private void initView() {
        floatingActionButton = findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoreWindow();
            }
        });
        bnve = findViewById(R.id.bnve);
        viewPager = findViewById(R.id.vp);

        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
    }

    private void initData() {
        BaseFragment resFragment = new ResourcesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "1");
        resFragment.setArguments(bundle);

        BaseFragment reqFragment = new ResourcesFragment();
        bundle = new Bundle();
        bundle.putString("type", "0");
        reqFragment.setArguments(bundle);

        ChartFragment chatFragment = new ChartFragment();
//        RecentContactsFragment chatFragment = new RecentContactsFragment();

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

    private void showMoreWindow() {
        if (null == moreWindow) {
            moreWindow = new MoreWindow(this);
            moreWindow.init(findViewById(R.id.rel_home));
        }

        moreWindow.showMoreWindow(findViewById(R.id.rel_home));
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
