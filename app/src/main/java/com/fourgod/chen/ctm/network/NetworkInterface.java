package com.fourgod.chen.ctm.network;

import android.support.v4.util.ArrayMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * description 网络请求接口.
 * *
 * Created by czt
 * on 2018/12/17.
 */
public class NetworkInterface {
    private static final String SERVER_HOST = "http://192.168.1.101:8085";

    public static void getNews(String type, Callback callback) {
        Request request = new Request.Builder().url(SERVER_HOST + type).get().build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public static void getInfoList(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/information/list",
                param, callback);
        request.putRequest();
    }
}
