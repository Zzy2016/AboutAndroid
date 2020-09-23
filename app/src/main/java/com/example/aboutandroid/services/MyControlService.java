package com.example.aboutandroid.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RemoteViews;

import com.example.aboutandroid.R;
import com.example.aboutandroid.activity.PlayingActivity;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class MyControlService extends Service {

    private NotificationCompat.Builder builder;
    private RemoteViews remoteView;

    public MyControlService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {




        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.nitification);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder;
        int channelId = 1;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {    //Android 8.0以上适配
            NotificationChannel channel = new NotificationChannel(String.valueOf(channelId), "channel_name", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(getApplicationContext(), String.valueOf(channelId));
        } else {
            builder = new NotificationCompat.Builder(getApplicationContext());
        }

        builder.setContentTitle("this is content title")            //指定通知栏的标题内容
                .setContentText("this is content text")             //通知的正文内容
                .setWhen(System.currentTimeMillis())                //通知创建的时间
                .setSmallIcon(R.drawable.ic_launcher_background)    //通知显示的小图标，只能用alpha图层的图片进行设置
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));
        builder.setContent(remoteViews);

        Notification notification = builder.build();
//        manager.notify(channelId, notification);
        startForeground(1,notification);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
