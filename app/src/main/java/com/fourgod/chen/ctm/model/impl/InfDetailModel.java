package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.CollectBean;
import com.fourgod.chen.ctm.entity.ReportBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by laobo on 2018/12/19.
 */

public class InfDetailModel extends BaseModel {
    public InfDetailModel(Handler handler) {
        super(handler);
    }

    public void collectInfo(ArrayMap<String, String> param) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response)
                    throws IOException {
                if (response.body() != null) {
                    Gson gson = new Gson();
                    CollectBean bean = gson.fromJson(response.body().string(), CollectBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }

            }
        };
        NetworkInterface.collectInfo(param, callback);
    }

    public void reportInfo(ArrayMap<String,String> param) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response)
                    throws IOException {
                if (response.body() != null) {
                    Gson gson = new Gson();
                    ReportBean bean = gson.fromJson(response.body().string(), ReportBean.class);
                    bean.setWhat(2);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.reportInfo(param, callback);
    }
}
