package com.example.test;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7,tv8;
    MyServiceBind.MyBinder myBinder;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyServiceBind.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myBinder = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });

        tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyServiceBind.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });
        tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyServiceBind.class);
                unbindService(serviceConnection);
            }
        });

        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.test();
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.test1();
            }
        });

        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.test2();
            }
        });

        tv7 = (TextView) findViewById(R.id.tv7);
        tv7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MService.class);
//                startService(intent);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //android8.0以上通过startForegroundService启动service
                    startForegroundService(intent);
                } else {
                    startService(intent);
                }
            }
        });

        tv8=(TextView)findViewById(R.id.tv8);
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyIntentService.class);

                for(int i=0;i<10;i++){
                    startService(intent);
                }

            }
        });

        PackageManager packageManager=getPackageManager();
        Log.e("anzhaungbao",packageManager.toString());


        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_DEFAULT);

        // 通过queryIntentActivities获取ResolveInfo对象
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);

        // 调用系统排序，根据name排序
        // 该排序很重要，否则只能显示系统应用，不能显示第三方应用
        // 其实我测试发现有没有其实是一样的，就是输出的顺序是乱的
        Collections.sort(resolveInfos,
                new ResolveInfo.DisplayNameComparator(packageManager));

        for (ResolveInfo resolveInfo : resolveInfos) {
            String appName = resolveInfo.loadLabel(packageManager).toString();// 获取应用名称
            String packageName = resolveInfo.activityInfo.packageName;// 包名
            String className = resolveInfo.activityInfo.name;// 入口类名
            System.out.println("程序名：" + appName + " 包名:" + packageName
                    + " 入口类名：" + className);
        }


    }
}
