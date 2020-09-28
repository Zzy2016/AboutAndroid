package com.example.test;

import android.util.Log;

/**
 * @author: Administrator
 * @date: 2020/9/27
 */
public class A1 implements A{
    @Override
    public void CallBack() {
        Log.e("A","被通知");
    }
}
