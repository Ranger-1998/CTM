package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.InfoAllListBean;
import com.fourgod.chen.ctm.entity.ResolvedBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by laobo on 2018/12/19.
 */

public class MyResAndReqModel extends BaseModel {
    //资源
    public static final String TYPE_RESOURCE = "1";

    //需求
    public static final String TYPE_REQUIREMENT = "0";

    //收藏
    public static final String TYPE_COLLECTION = "2";
    private String mType;
    public MyResAndReqModel(Handler handler) {
        super(handler);
    }

    public void setType(String type){
        this.mType = type;
    }
    public String getType(){
        return this.mType;
    }

    public void getMyInfoList(ArrayMap<String, String> param) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, Response response) throws IOException {
                Gson gson = new Gson();
                if (response.body() != null) {
                    InfoAllListBean bean = gson.fromJson(response.body().string(), InfoAllListBean.class);
                    bean.setWhat(0);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.getMyInfoList(param, callback);
    }

    public void getMyCollections(ArrayMap<String,String> p){
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, Response response) throws IOException {
                Gson gson = new Gson();
                if (response.body() != null) {
                    InfoAllListBean bean = gson.fromJson(response.body().string(), InfoAllListBean.class);
                    bean.setWhat(0);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.getMyCollections(p,callback);
    }

    public void resolve(String id){
        ArrayMap<String,String> p = new ArrayMap<>();
        p.put("id",id);
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, Response response) throws IOException {
                Gson gson = new Gson();
                if (response.body() != null) {
                    ResolvedBean bean = gson.fromJson(response.body().string(), ResolvedBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.resolved(p,callback);
    }

    public void deleteInfo(String id) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response)
                    throws IOException {
                Gson gson = new Gson();
                if (response.body() != null) {
                    ResolvedBean bean = gson.fromJson(response.body().string(), ResolvedBean.class);
                    bean.setWhat(2);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.deleteInfo(id, callback);

    }
}
