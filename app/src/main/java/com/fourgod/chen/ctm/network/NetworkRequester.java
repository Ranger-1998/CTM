package com.fourgod.chen.ctm.network;

import android.support.v4.util.ArrayMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * description 网络请求封装.
 * *
 * Created by czt
 * on 2018/12/17.
 */
public class NetworkRequester {
    static void sendRequest(String url, ArrayMap<String, String> requestParam, Callback callback) {
        Request request = new JsonPostRequest(url, requestParam).getRequest();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
