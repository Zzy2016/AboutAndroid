package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.TextView;

public class MessengerActivity extends AppCompatActivity {

    TextView tv;
    Messenger messenger;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            Message msg = Message.obtain(handler, 0, 5, 10);
            msg.replyTo=reply;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        tv = (TextView) findViewById(R.id.tv);
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    int sum = msg.arg1;
                    tv.setText(sum + "");
                    break;
            }
        }
    };

    private Messenger reply = new Messenger(handler);

    public void messenger() {
        Intent intent = new Intent(this, MessengerService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

}
