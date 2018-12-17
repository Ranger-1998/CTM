package com.fourgod.chen.ctm.view.impl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.NewsBean;
import com.fourgod.chen.ctm.presenter.impl.TestPresenter;
import com.fourgod.chen.ctm.view.impl.activity.BaseActivity;
import com.fourgod.chen.ctm.view.impl.fragment.TestFragment1;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager =findViewById(R.id.vp_test);
        TestFragment1 t1 = new TestFragment1();
        fragments.add(t1);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
    }

    class PageAdapter extends FragmentPagerAdapter{

        public PageAdapter(FragmentManager fm) {
            super(fm);
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
