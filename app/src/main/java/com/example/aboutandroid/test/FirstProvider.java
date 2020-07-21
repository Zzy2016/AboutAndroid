package com.example.aboutandroid.test;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FirstProvider extends ContentProvider {

    @Override
    public boolean onCreate() {
        System.out.println("oncreate方法被调用");
        return true;
    }

    //实现查询方法，该方法返回查询得到的cursor
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        System.out.println(uri+"==query方法被调用====");
        System.out.println("where参数"+s);
        return null;
    }

    //ContentProvider 所提供的数据的MIME类型
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    //实现插入的方法
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        System.out.println(uri+"===insert方法");
        System.out.println(contentValues);
        return null;
    }

    //删除的方法
    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        System.out.println(uri+"===删除的方法");
        System.out.println("where的参数"+s);
        return 0;
    }

    //更新的方法
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        System.out.println(uri+"===更新方法");
        System.out.println("where参数"+s);
        return 0;
    }
}
