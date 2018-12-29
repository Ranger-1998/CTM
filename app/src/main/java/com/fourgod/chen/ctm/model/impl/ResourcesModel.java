package com.fourgod.chen.ctm.model.impl;

import android.os.Handler;
import android.support.v4.util.ArrayMap;

import com.fourgod.chen.ctm.entity.CategoryListBean;
import com.fourgod.chen.ctm.entity.InfoListBean;
import com.fourgod.chen.ctm.network.NetworkInterface;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Tolean on 2018/12/19.
 */

public class ResourcesModel extends BaseModel {
    public ResourcesModel(Handler handler) {
        super(handler);
    }
    public void getCategoryList(ArrayMap<String, String> param){
        Callback callback = new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.body()!=null){
                    Gson gson=new Gson();
                    CategoryListBean bean = gson.fromJson(response.body().string(), CategoryListBean.class);
                    bean.setWhat(1);
                    postEvent(bean);
                }
            }
        };
        NetworkInterface.getCategoryList(param, callback);
    }
}
