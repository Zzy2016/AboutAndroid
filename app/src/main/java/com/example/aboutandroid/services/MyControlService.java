package com.example.aboutandroid.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RemoteViews;

import com.example.aboutandroid.Constant;
import com.example.aboutandroid.MyApplication;
import com.example.aboutandroid.R;
import com.example.aboutandroid.activity.PlayingActivity;
import com.example.aboutandroid.bean.Sound;
import com.example.aboutandroid.util.MediaPlayerHelper;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class MyControlService extends Service {


    private RemoteViews remoteViews;

    private MediaPlayerHelper mediaPlayerHelper;
    private MyReceiver myReceiver;


    public MyControlService() {



//        Log.e("1", (getApplicationContext() == null) + "");
        Log.e("1", (getApplication() == null) + "");
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        mediaPlayerHelper = new MediaPlayerHelper(MyApplication.context);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("music_playing");
        intentFilter.addAction("sound_stop");
        intentFilter.addAction("sound_restart");


        Log.e("------1",(myReceiver==null)+"");

        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, intentFilter);


        remoteViews = new RemoteViews(getPackageName(), R.layout.nitification);
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


//        setContentTitle("this is content title")            //指定通知栏的标题内容
//                .setContentText("this is content text")             //通知的正文内容
//                .setWhen(System.currentTimeMillis())
        builder             //通知的正文内容
                .setWhen(System.currentTimeMillis())                //通知创建的时间
                .setSmallIcon(R.drawable.ic_launcher_background)    //通知显示的小图标，只能用alpha图层的图片进行设置
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));
        builder.setContent(remoteViews);


        Notification notification = builder.build();
//        manager.notify(channelId, notification);
        startForeground(1, notification);

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {


            switch (intent.getAction()) {
                case "music_playing":

                    Sound sound = (Sound) intent.getSerializableExtra("song");
                    mediaPlayerHelper.setPath(sound.getUrl());
                    mediaPlayerHelper.start();

                    break;
                case "sound_stop":
                    mediaPlayerHelper.pause();

                    break;
                case "sound_restart":


                    break;

            }
        }
    }

}
