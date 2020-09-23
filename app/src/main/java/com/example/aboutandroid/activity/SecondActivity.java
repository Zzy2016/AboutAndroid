package com.example.aboutandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aboutandroid.R;


public class SecondActivity extends AppCompatActivity {

    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//

                Intent it = new Intent(SecondActivity.this, MainActivity.class);
                PendingIntent pit = PendingIntent.getActivity(SecondActivity.this, 0, it, 0);

                //设置图片,通知标题,发送时间,提示方式等属性
                Notification.Builder mBuilder = new Notification.Builder(SecondActivity.this);
                mBuilder.setContentTitle("叶良辰")                        //标题
                        .setContentText("我有一百种方法让你呆不下去~")      //内容
                        .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                        .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                        .setWhen(System.currentTimeMillis())           //设置通知时间
                        .setSmallIcon(R.drawable.back1)            //设置小图标
                                         //设置大图标

                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                          //设置自定义的提示音
                        .setAutoCancel(true)                           //设置点击后取消Notification
                        .setContentIntent(pit);                        //设置PendingIntent
               Notification notify1 = mBuilder.build();
                notificationManager.notify(1, notify1);
            }
        });

    }
}