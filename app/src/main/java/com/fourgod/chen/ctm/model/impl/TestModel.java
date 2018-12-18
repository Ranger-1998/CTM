package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.fourgod.chen.ctm.entity.NewsBean;
import com.fourgod.chen.ctm.event.NewsEvent;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TestModel extends BaseModel {
    public TestModel(Handler handler) {
        super(handler);
    }

    public void test(String type) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, Response response) throws IOException {
                Gson gson = new Gson();
                if (response.body() != null) {
                    NewsBean newsBean = gson.fromJson(response.body().string(), NewsBean.class);
                    NewsEvent event = new NewsEvent();
                    event.setNewsBean(newsBean);
                    event.setWhat(1);
                    postEvent(event);
                }
            }
        };
        NetworkInterface.getNews(type, callback);
    }
}
