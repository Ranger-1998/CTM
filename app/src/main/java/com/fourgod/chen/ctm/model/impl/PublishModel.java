package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.BaseBean;
import com.fourgod.chen.ctm.entity.CategoryListBean;
import com.fourgod.chen.ctm.entity.ImageResultBean;
import com.fourgod.chen.ctm.entity.ImageUploadBean;
import com.fourgod.chen.ctm.entity.PushBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PublishModel extends BaseModel {
    public PublishModel(Handler handler) {
        super(handler);
    }

    public void publish(ArrayMap<String, String> param) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response)
                    throws IOException {
                if (response.body() != null) {
                    Gson gson = new Gson();
                    PushBean bean = gson.fromJson(response.body().string(), PushBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }

            }
        };
        NetworkInterface.addInformation(param, callback);
    }

    public void uploadImage(final List<String> files) {
        final List<ImageUploadBean> result = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            Callback callback = new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {

                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response)
                        throws IOException {

                    if (response.body() != null) {
                        Gson gson = new Gson();
                        ImageUploadBean bean = gson.fromJson(response.body().string(),
                                ImageUploadBean.class);
                        result.add(bean);
                    }

                    if (result.size() == files.size()) {
                        ImageResultBean bean = new ImageResultBean();
                        bean.setBeans(result);
                        bean.setWhat(3);
                        postEvent(bean);
                    }
                }
            };
            NetworkInterface.uploadImage(files.get(i), callback);
        }
    }

    public void getCateList(ArrayMap<String,String> param) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response)
                    throws IOException {
                if (response.body() != null) {
                    Gson gson = new Gson();
                    CategoryListBean bean = gson.fromJson(response.body().string(),
                            CategoryListBean.class);
                    bean.setWhat(2);
                    postEvent(bean);
                }

            }
        };
        NetworkInterface.getCategoryList(param, callback);
    }
}
