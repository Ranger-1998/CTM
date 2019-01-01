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
    private static final String SERVER_HOST = "http://66.183.250.236:8085";


    public static void updateUserInfo(ArrayMap<String, String> param, Callback callback){
        JsonRequest request = new JsonRequest(SERVER_HOST + "/user/edit",
                param, callback);
        request.putRequest();
    }
    public static void register(ArrayMap<String, String> param, Callback callback){
        JsonRequest request = new JsonRequest(SERVER_HOST + "/user/add",
                param, callback);
        request.postRequest();
    }
    public static void sendCode(ArrayMap<String, String> param, Callback callback){
        JsonRequest request = new JsonRequest(SERVER_HOST + "/code/sendcode",
                param, callback);
        request.postRequest();
    }
    public static void checkCode(ArrayMap<String, String> param,Callback callback){
        JsonRequest request = new JsonRequest(SERVER_HOST + "/code/checkcode",
                param, callback);
        request.postRequest();
    }
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

    public static void getCategoryList(ArrayMap<String, String> param, Callback callback){
        JsonRequest request = new JsonRequest(SERVER_HOST + "/category/list",
                param, callback);
        request.putRequest();
    }

    public static void login(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/login", param, callback);
        request.postRequest();
    }

    public static void getHotList(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/hotSearch/list",
                param, callback);
        request.putRequest();
    }

    public static void getMyInfoList(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/information/getMyInfo",
                param, callback);
        request.putRequest();
    }

    public static void getMyCollections(ArrayMap<String, String> param, Callback callback){
        JsonRequest request = new JsonRequest(SERVER_HOST + "/collection//getMyCollection",
                param, callback);
        request.putRequest();
    }
    public static void getUserInfo(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/user/get",
                param, callback);
        request.putRequest();
    }

    public static void doSearch(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/hotSearch/doSearch",
                param, callback);
        request.putRequest();
    }

    public static void addInformation(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/information/add",
                param, callback);
        request.postRequest();
    }

    public static void addInformationImage(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/information/imgUpdate",
                param,callback);
        request.postRequest();
    }

    public static void uploadImage(String path, Callback callback) {
        FileRequest request = new FileRequest();
        request.uploadMultiFile(SERVER_HOST + "/information/imgUpdate", path,
                "file",callback);
    }

    public static void collectInfo(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/collection/add", param,
                callback);
        request.postRequest();
    }

    public static void reportInfo(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/report/add", param, callback);
        request.postRequest();
    }

    public static void uploadPortrait(String path,Callback callback){
        FileRequest request = new FileRequest();
        request.uploadMultiFile(SERVER_HOST + "/user/imgUpdate", path,
                "file",callback);
    }

    public static void updateInfo(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/information/edit", param,
                callback);
        request.putRequest();
    }

    public static void resolved(ArrayMap<String, String> param, Callback callback) {
        JsonRequest request = new JsonRequest(SERVER_HOST + "/information/setResolved", param,
                callback);
        request.putRequest();
    }
}
