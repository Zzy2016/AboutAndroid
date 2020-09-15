package com.example.test;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class NotifiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifi);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder;
                int channelId = 1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {    //Android 8.0以上适配
                    NotificationChannel channel = new NotificationChannel(String.valueOf(channelId), "channel_name", NotificationManager.IMPORTANCE_HIGH);
                    manager.createNotificationChannel(channel);
                    builder = new NotificationCompat.Builder(NotifiActivity.this, String.valueOf(channelId));
                } else {
                    builder = new NotificationCompat.Builder(NotifiActivity.this);
                }

                builder.setContentTitle("this is content title")            //指定通知栏的标题内容
                        .setContentText("this is content text")             //通知的正文内容
                        .setWhen(System.currentTimeMillis())                //通知创建的时间
                        .setSmallIcon(R.drawable.ic_launcher_background)    //通知显示的小图标，只能用alpha图层的图片进行设置
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));

                Notification notification = builder.build();
                manager.notify(channelId, notification);

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.item);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder;
                int channelId = 1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {    //Android 8.0以上适配
                    NotificationChannel channel = new NotificationChannel(String.valueOf(channelId), "channel_name", NotificationManager.IMPORTANCE_HIGH);
                    manager.createNotificationChannel(channel);
                    builder = new NotificationCompat.Builder(NotifiActivity.this, String.valueOf(channelId));
                } else {
                    builder = new NotificationCompat.Builder(NotifiActivity.this);
                }

                builder.setContentTitle("this is content title")            //指定通知栏的标题内容
                        .setContentText("this is content text")             //通知的正文内容
                        .setWhen(System.currentTimeMillis())                //通知创建的时间
                        .setSmallIcon(R.drawable.ic_launcher_background)    //通知显示的小图标，只能用alpha图层的图片进行设置
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));
                builder.setContent(remoteViews);

                Notification notification = builder.build();
                manager.notify(channelId, notification);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                RemoteViews normalView = new RemoteViews(getPackageName(), R.layout.item);
                RemoteViews bigView = new RemoteViews(getPackageName(), R.layout.all);
                NotificationCompat.Builder builder ;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {    //Android 8.0以上适配
                    NotificationChannel channel = new NotificationChannel("id", "channel_name", NotificationManager.IMPORTANCE_HIGH);
                    manager.createNotificationChannel(channel);
                    builder = new NotificationCompat.Builder(NotifiActivity.this, "id");
                } else {
                    builder = new NotificationCompat.Builder(NotifiActivity.this);
                }

                builder                         .setSmallIcon(R.drawable.ic_launcher_background)
                        .setTicker("123").setOngoing(true)
                        .setContent(normalView).setCustomBigContentView(bigView).setPriority(NotificationCompat.PRIORITY_MAX)
                ;


                manager.notify(1,builder.build());
            }
        });


    }
}
