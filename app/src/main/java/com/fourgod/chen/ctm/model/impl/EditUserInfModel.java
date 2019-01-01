package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.fourgod.chen.ctm.entity.ImageResultBean;
import com.fourgod.chen.ctm.entity.ImageUploadBean;
import com.fourgod.chen.ctm.entity.MyInfBean;
import com.fourgod.chen.ctm.entity.RegisterBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Tolean on 2018/12/19.
 */

public class EditUserInfModel extends BaseModel {
    public EditUserInfModel(Handler handler) {
        super(handler);
    }

    public void updateInfo(ArrayMap<String, String> p){
        Callback callback=new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.body()!=null){
                    Gson gson = new Gson();
                    String body=response.body().string();
                    Log.d("Lyon",body);
                    RegisterBean bean = gson.fromJson(body,RegisterBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.updateUserInfo(p,callback);
    }
    public void uploadPortrait(String url){
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() != null) {
                    Gson gson = new Gson();
                    ImageUploadBean bean = gson.fromJson(response.body().string(),
                            ImageUploadBean.class);
                    bean.setWhat(2);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.uploadPortrait(url,callback);
    }
}
