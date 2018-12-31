package com.fourgod.chen.ctm.network;

/**
 * Created by laobo on 2018/12/29.
 */

public class NetworkManager {
    private String token;
    private static NetworkManager instance = null;

    public static NetworkManager getInstance(){
        if(instance == null){
            instance = new NetworkManager();
        }
        return instance;
    }

    private NetworkManager(){

    }


    public String getToken() {
        if(token == null){
            token = "";
        }
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
