package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyServiceBind extends Service {

    private String TAG="MyServiceBind";

    public MyServiceBind() {
        Log.e(TAG,"MyServiceBind");
    }

    public class MyBinder extends Binder{
        public void test(){
            a();
        }

        public void test1(){
            b();
        }

        public void test2(){
            c();
        }
    }


    public void a(){
        Log.e(TAG+"bind","aaaaaaaaaaaa");
    }

    public void b(){
        Log.e(TAG+"bind","bbbbbbbbbbb");
    }

    public void c(){
        Log.e(TAG+"bind","cccccccccccc");
    }

    MyBinder myBinder=new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e(TAG,"onBind");
//        throw new UnsupportedOperationException("Not yet implemented");
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e(TAG,"onRebind");
    }


}
