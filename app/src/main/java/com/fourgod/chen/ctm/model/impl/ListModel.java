package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.entity.NewsBean;
import com.fourgod.chen.ctm.event.NewsEvent;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by Tolean on 2018/12/19.
 */

public class ListModel extends BaseModel {
    public ListModel(Handler handler) {
        super(handler);
    }

    public void getInfoList(ArrayMap<String, String> param) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, Response response) throws IOException {
                Gson gson = new Gson();
                if (response.body() != null) {
                    InfoListBean bean = gson.fromJson(response.body().string(), InfoListBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.getInfoList(param, callback);
    }
}
