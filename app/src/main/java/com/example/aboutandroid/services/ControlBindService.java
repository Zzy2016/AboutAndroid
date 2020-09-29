package com.example.aboutandroid.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ControlBindService extends Service {
    public ControlBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
