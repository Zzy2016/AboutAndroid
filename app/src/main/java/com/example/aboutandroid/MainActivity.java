package com.example.aboutandroid;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;

import com.example.aboutandroid.adapter.HomeListAdapter;
import com.example.aboutandroid.base.BaseActivity;
import com.example.aboutandroid.util.PermissionUtil;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends BaseActivity {

    private RecyclerView rvHomeList;
    private HomeListAdapter adapter;

    private String[] permissions=new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        adapter = new HomeListAdapter(MainActivity.this);
        rvHomeList = (RecyclerView) findViewById(R.id.rvHomeList);
        rvHomeList.setAdapter(adapter);
        rvHomeList.setLayoutManager(new LinearLayoutManager(this));


        dialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.cancel();
            }
        }, 1000);
        PermissionUtil.checkPermissions(this,permissions);

    }






}
