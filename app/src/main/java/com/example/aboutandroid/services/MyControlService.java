package com.example.aboutandroid.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RemoteViews;

import com.example.aboutandroid.R;
import com.example.aboutandroid.activity.PlayingActivity;

import androidx.annotation.RequiresApi;

public class MyControlService extends Service {

    private Notification.Builder builder;
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

        Intent intent1 = new Intent(MyControlService.this, PlayingActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteView = new RemoteViews(getPackageName(), R.layout.control_view);


        remoteView.setTextViewText(R.id.tv_name,"123");

        remoteView.setImageViewResource(R.id.tv_art,R.drawable.logo);

        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.control_view, null);
        builder = new Notification.Builder(getApplicationContext()).setContentIntent(pendingIntent)
                .setContentIntent(pendingIntent) // 设置PendingIntent
                .setSmallIcon(R.mipmap.ic_launcher) // 设置状态栏内的小图标
                .setContentTitle(getResources().getString(R.string.app_name)).setContentText("正在上传...") // 设置上下文内容
                .setWhen(System.currentTimeMillis()); // 设置该通知发生的时间

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("id", "music", NotificationManager.IMPORTANCE_DEFAULT);


//            notificationChannel.enableLights(false);//如果使用中的设备支持通知灯，则说明此通知通道是否应显示灯
//            notificationChannel.setShowBadge(false);//是否显示角标
//            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_SECRET);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
            builder.setChannelId("id");
        }

        Notification notification = builder.build();
        startForeground(1, notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
