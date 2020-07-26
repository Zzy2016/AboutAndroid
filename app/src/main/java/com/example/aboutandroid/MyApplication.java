package com.example.aboutandroid;

import android.app.Application;

import com.example.aboutandroid.util.SharedPreferencesUtil;

/**
 * @author: Administrator
 * @date: 2020-07-26
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtil.getInstance(this,"AboutAndroid");
    }
}
