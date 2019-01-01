package com.fourgod.chen.ctm.network;

import android.support.v4.util.ArrayMap;
import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * post方式的json请求
 *
 * *
 * Created by czt
 * on 2018/12/17.
 */
public class JsonRequest {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String mUrl;                                //请求地址
    private ArrayMap<String, String> mRequestParam;     //请求参数
    private RequestBody body;
    private String token;
    private Request request;
    private Callback callback;
    private NetworkManager networkManager;

    public JsonRequest(String url, ArrayMap<String, String> requestParam, Callback callback) {
        this.mUrl = url;
        this.mRequestParam = requestParam;
        String gson = new Gson().toJson(mRequestParam);
        body = RequestBody.create(JSON, gson);
        networkManager = NetworkManager.getInstance();
        token = networkManager.getToken();
        this.callback = callback;
    }
    /**
     * 创建一个请求
     * 可以给请求添加tag,便于取消含有该tag的请求
     *
     * @return request
     */
    public void postRequest() {
        //将map转换为json字串
         request = new Request.Builder().header("token", token).url(mUrl)
                .post(body).tag("tag").build();
        sendRequest();
    }

    /**
     * 创建一个请求
     * 可以给请求添加tag,便于取消含有该tag的请求
     *
     * @return request
     */
    public void putRequest() {
        request = new Request.Builder().header("token", token).url(mUrl)
                .put(body).tag("tag").build();
        sendRequest();
    }

    /**
     * 创建一个请求
     * 可以给请求添加tag,便于取消含有该tag的请求
     *
     * @return request
     */
    public void deleteRequest() {
        request = new Request.Builder().header("token", token).url(mUrl)
                .delete(body).tag("tag").build();
        sendRequest();
    }

    private void sendRequest() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

}
