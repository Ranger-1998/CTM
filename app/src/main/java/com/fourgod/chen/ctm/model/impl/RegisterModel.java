package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.v4.util.ArrayMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import com.fourgod.chen.ctm.entity.RegisterBean;
import com.fourgod.chen.ctm.entity.YunxinBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;
import java.io.IOException;

/**
 * Created by Tolean on 2018/12/19.
 */

public class RegisterModel extends BaseModel {
    public RegisterModel(Handler handler) {
        super(handler);
    }
    public void sendCode(ArrayMap<String, String> param){
        Callback callback= new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() != null) {
                    //Log.d("lyon",response.body().string());
                    Gson gson = new Gson();
                    YunxinBean bean=gson.fromJson(response.body().string(),YunxinBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.sendCode(param,callback);
    }

    public void checkCode(ArrayMap<String, String> param){
        Callback callback= new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() != null) {
                    //Log.d("lyon",response.body().string());
                    Gson gson = new Gson();
                    YunxinBean bean=gson.fromJson(response.body().string(),YunxinBean.class);
                    bean.setWhat(2);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.checkCode(param,callback);
    }

    public void register(ArrayMap<String, String> param){
        Callback callback= new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() != null) {
                    //Log.d("lyon",response.body().string());
                    Gson gson = new Gson();
                    RegisterBean bean=gson.fromJson(response.body().string(),RegisterBean.class);
                    bean.setWhat(3);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.register(param,callback);
    }
}
