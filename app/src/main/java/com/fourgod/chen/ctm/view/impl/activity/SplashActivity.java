package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.network.NetworkManager;
import com.fourgod.chen.ctm.presenter.impl.SplashPresenter;
import com.netease.nim.uikit.api.NimUIKit;

public class SplashActivity extends BaseActivity<SplashPresenter> {
    private String token;
    private String accid;

    @Override
    protected SplashPresenter getPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getTokenAndAccId();
        RelativeLayout relativeLayout = findViewById(R.id.rl_splash);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(2000);
        relativeLayout.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (token == null || token.equals("")) {
                    Intent intent = new Intent(SplashActivity.this,
                            LoginActivity.class);
                    SplashActivity.this.startActivity(intent);
                } else {
                    NetworkManager.getInstance().setToken(token);
                    NimUIKit.setAccount(accid);
                    Intent intent = new Intent(SplashActivity.this,
                            HomeActivity.class);
                    SplashActivity.this.startActivity(intent);
                }
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void getTokenAndAccId() {
        SharedPreferences preferences = getSharedPreferences("token",
                Context.MODE_PRIVATE);
        token = preferences.getString("token", "");
        accid = preferences.getString("accid", "");
    }
}
