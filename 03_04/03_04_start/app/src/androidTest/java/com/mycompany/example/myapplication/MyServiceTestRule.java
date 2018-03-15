package com.mycompany.example.myapplication;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.test.rule.ServiceTestRule;
import android.util.Log;

import java.util.concurrent.TimeoutException;

/**
 * Created by romellbolton on 2/28/18.
 */

// If you wish to have more control on the set up and tear down of the service instance used in the
// unit test, you can create your own custom ServiceTestRule. Create a class that extends ServiceTestRule.
// In this example, I'm creating a custom ServiceTestRule called MyServiceTestRule in the Android
// test folder. There are no generic parameters like there are for an ActivityTestRule, so it just
// needs to extend ServiceTestRule.
public class MyServiceTestRule extends ServiceTestRule {

    // Log TAG
    private static final String TAG = "MyServiceTestRule";

    // Next, override the startService() or bindService() methods of the ServiceTestRule, if you'd
    // like to do some work before the Service has started, or when it's bound.

    /*
    Use bindService() or startService() to provide code you want executed as a service is
    created and made available to your unit test
     */

    // Starts the service under test
    @Override
    public void startService(@NonNull Intent intent) throws TimeoutException {
        Log.i(TAG, "startService: ");
        super.startService(intent);
    }

    // Binds the service under test
    @Override
    public IBinder bindService(@NonNull Intent intent) throws TimeoutException {
        Log.i(TAG, "bindService: ");
        return super.bindService(intent);
    }

    // You can also override the beforeService() and afterService() methods to invoke setup code
    // before the service is created, or cleanup code after the services automatically shuts down.

    /*
    Use afterService() and beforeService() to run code to, respectively, prep the environment
    of the service unit test or clean up the environment after a service unit test.
     */

    // Code that runs before the service is started or bounded
    @Override
    protected void beforeService() {
        Log.i(TAG, "beforeService: ");
        super.beforeService();
    }

    // Code that runs after the service is shutdown
    @Override
    protected void afterService() {
        Log.i(TAG, "afterService: ");
        super.afterService();
    }

    // In this example, I've overridden all the methods. Again, in each method I add to the log file
    // so that we can see how the test executes and at what point the rule code is executed.
}
