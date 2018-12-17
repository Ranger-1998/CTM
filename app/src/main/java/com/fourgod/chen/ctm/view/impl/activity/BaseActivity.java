package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fourgod.chen.ctm.presenter.impl.BasePresenter;
import com.fourgod.chen.ctm.view.i.IBaseView;

/**
 * description View 的父类.
 * *
 * Created by czt
 * on 2018/12/17.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements IBaseView {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //设置为强制竖屏
        presenter = getPresenter();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.onDestroy();
            presenter = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean isFinish() {
        return isFinishing();
    }

    /**
     * 返回一个持有Activity对象的Presenter对象
     *
     * @return 返回的presenter对象
     * @see #onCreate(Bundle) 中调用了该方法,子类只需要复写,不需要调用
     */
    protected abstract P getPresenter();

    /**
     * 判断网络是否正常
     *
     * @return 返回true代表网络正常，返回false代表网络异常
     */
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null && networkInfo.length > 0) {
                for (NetworkInfo info : networkInfo) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
