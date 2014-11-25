package com.zhuhean.dongxi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by vincent on 14/11/25.
 */
public class NetworkChecker {
    private Context context;
    public NetworkChecker(Context context){
        this.context=context;
    }

    public boolean isOnline(){
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetWorkInfo=connectivityManager.getActiveNetworkInfo();
        return activeNetWorkInfo!=null&&activeNetWorkInfo.isConnected();
    }
}
