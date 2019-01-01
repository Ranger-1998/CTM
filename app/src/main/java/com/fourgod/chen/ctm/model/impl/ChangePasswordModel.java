package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.ResolvedBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ChangePasswordModel extends BaseModel{

    public ChangePasswordModel(Handler handler) {
        super(handler);
    }

    public void changePassword(ArrayMap<String,String> param) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response)
                    throws IOException {
                if (response.body() != null) {
                    Gson gson = new Gson();
                    ResolvedBean bean = gson.fromJson(response.body().string(), ResolvedBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.changePassword(param, callback);
    }
}
