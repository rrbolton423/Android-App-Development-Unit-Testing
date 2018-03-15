package com.mycompany.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MyService", "binding MyService");
        return new LocalBinder();
    }
    @Override
    public void onCreate() {
        Log.e("MyService", "creating MyService");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e("MyService", "destroying MyService");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("MyService", "executing some service work");
        return super.onStartCommand(intent, flags, startId);
    }

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

}
