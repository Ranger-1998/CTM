package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.InfoAllListBean;
import com.fourgod.chen.ctm.entity.UserInfoBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by laobo on 2018/12/18.
 */

public class PersonModel extends BaseModel {
    public PersonModel(Handler handler) {
        super(handler);
    }

    public void loadMyInfo(){
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, Response response) throws IOException {
                Gson gson = new Gson();
                if (response.body() != null) {
                    UserInfoBean bean = gson.fromJson(response.body().string(), UserInfoBean.class);
                    bean.setWhat(0);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.getUserInfo(new ArrayMap<String,String>(), callback);
    }
}
