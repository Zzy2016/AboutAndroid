package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;



public class NotifiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifi);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Notification builder = new Notification.Builder(NotifiActivity.this)
//                        .setContentTitle("title")
//                        .setContentText("context")
//                        .build();
//                builder.notify();
            }
        });


    }
}
