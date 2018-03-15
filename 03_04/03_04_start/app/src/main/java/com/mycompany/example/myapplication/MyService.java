package com.mycompany.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

// Before we can begin to understand ServiceTestRules, I need to add a simple Android Service
// that we can use to explore the rules. One critical note is that ServiceTestRule supports testing
// regular Android Services, but not IntentServices.

// Create a Service to run that extends Service
public class MyService extends Service {

    private static final String TAG = "MyService";
    
    public MyService() {
        Log.i(TAG, "MyService: ");
    }

    // Override Service Lifecycle methods

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    // The onBind method returns the LocalBinder so that the activities that bind the service
    // with bindService() can use the binder to interact with the service.
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        // TODO: Return the communication channel to the service.

        // Return the LocalBinder object that will, in turn, return the Service
        return new LocalBinder();
    }

    // LocalBinder returns an instance of the Service,
    // so you can interact with it directly
    public class LocalBinder extends Binder {

        // getService() returns the service
        MyService getService() {
            return MyService.this;
        }

    }
}

