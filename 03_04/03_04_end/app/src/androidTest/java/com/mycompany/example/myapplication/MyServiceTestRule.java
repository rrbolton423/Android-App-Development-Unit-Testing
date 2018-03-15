package com.mycompany.example.myapplication;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.rule.ServiceTestRule;
import android.util.Log;

import java.util.concurrent.TimeoutException;

public class MyServiceTestRule extends ServiceTestRule {

    @Override
    public void startService(Intent intent) throws TimeoutException {
        Log.e("MyServiceTestRule", "start the service");
        super.startService(intent);
    }

    @Override
    public IBinder bindService(Intent intent) throws TimeoutException {
        Log.e("MyServiceTestRule", "binding the service");
        return super.bindService(intent);
    }

    @Override
    protected void beforeService() {
        Log.e("MyServiceTestRule", "work before the service starts");
        super.beforeService();
    }

    @Override
    protected void afterService() {
        Log.e("MyServiceTestRule", "work after the service has started");
        super.afterService();
    }
}
