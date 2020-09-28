package com.example.aboutandroid;

import android.app.Application;
import android.content.Context;

import com.example.aboutandroid.util.SharedPreferencesUtil;

/**
 * @author: Administrator
 * @date: 2020-07-26
 */
public class MyApplication extends Application {

   public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtil.getInstance(this,"AboutAndroid");
        context=this;


    }
}
