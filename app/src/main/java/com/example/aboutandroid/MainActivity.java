package com.example.aboutandroid;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;

import com.example.aboutandroid.adapter.HomeListAdapter;
import com.example.aboutandroid.base.BaseActivity;
import com.example.aboutandroid.util.PermissionUtil;

import java.security.Permission;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends BaseActivity {

    private RecyclerView rvHomeList;
    private HomeListAdapter adapter;

    private String[] permissions=new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new HomeListAdapter(MainActivity.this);
        rvHomeList = (RecyclerView) findViewById(R.id.rvHomeList);
        rvHomeList.setAdapter(adapter);
        rvHomeList.setLayoutManager(new LinearLayoutManager(this));


//        dialog.show();
//        doCheckPermission();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.cancel();
            }
        }, 1000);
        PermissionUtil.checkPermissions(this,permissions);

    }

    public void doCheckPermission() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
