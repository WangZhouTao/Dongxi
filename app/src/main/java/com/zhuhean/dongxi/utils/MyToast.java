package com.zhuhean.dongxi.utils;

import android.content.Context;
import android.widget.Toast;

public class MyToast {
    public static void showLong(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
    public static void showShort(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
}
