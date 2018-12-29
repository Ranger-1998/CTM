package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.LoginBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Tolean on 2018/12/19.
 */

public class LoginModel extends BaseModel {
    public LoginModel(Handler handler) {
        super(handler);
    }

    public void login(ArrayMap<String, String> param) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Gson gson = new Gson();
                if (response.body() != null) {
                    LoginBean bean = gson.fromJson(response.body().string(), LoginBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.login(param, callback);
    }
}
