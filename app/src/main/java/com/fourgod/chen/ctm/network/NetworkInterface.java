package com.fourgod.chen.ctm.network;

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
    private static final String SERVER_HOST = "http://v.juhe.cn/toutiao/index?key=e24783a1a0f8cdcb72d365caa356738a&type=";

    public static void getNews(String type, Callback callback) {
        Request request = new Request.Builder().url(SERVER_HOST + type).get().build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
