package com.mycompany.example.myapplication;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by romellbolton on 2/27/18.
 */

// I create MyServiceTest in the AndroidTest folder. As with other instrumented tests, I
// annotate the class with the @RunWith annotation, adding AndroidJUnit4 as a parameter
// to the annotation to mark it as an instrumented test class.
@RunWith(AndroidJUnit4.class)
public class MyServiceTest {

    // Next I add a public instance variable I call MyServiceRule of type ServiceTestRule,
    // and assign it to a new instance of ServiceTestRule. I then annotate the instance variable
    // with the @Rule annotation. The ServiceTestRule allows me to start, or bind if the service
    // is found, the service before each test method in the test case via the ServiceTestRule instance
    // variable reference, in this case called MyServiceRule. The service will automatically be stopped
    // or unbound and then destroyed after the test method completes.
//    @Rule
//    public ServiceTestRule myServiceRule = new ServiceTestRule();

    // Before executing my test, I need to change the rule in the MyServiceTest class to use an
    // instance of the new custom MyServiceTestRule, in place of ServiceTestRule
    // I leave everything else in my test case the same. Now, I execute my test case and get a chance
    // to see the new test rule methods fire via the logs.
    /*
    A service is started when an application component, such as an activity, starts it by calling
    startService(). Once started, a service can run in the background indefinitely,
    even if the component that started it is destroyed.
     */
    @Rule
    public MyServiceTestRule myServiceRule = new MyServiceTestRule();

    // I add two test methods to exemplify how to start the service using the ServiceTestRule
    // instance variable.

    // One, in the case of an unbound service...
    // In the case of an unbound service, I use MyServiceRule instance to request to start the
    // service.
    @Test
    public void testService() throws TimeoutException {

        myServiceRule.startService(new Intent(InstrumentationRegistry
                .getTargetContext(), MyService.class));

        // Not able to get a reference to the MyService object
    }

    // And the other, in the case of a bound service...
    // In the case of a bound service, I use MyServiceRule instance to bind the service from IBinder.
    /*
    A service is bound when an application component binds to it by calling bindService().
    A bound service offers a client-server interface that allows components to interact
    with the service, send requests, get results, and even do so across processes with
    inter process communication (IPC).
     */
    @Test
    public void testBoundService() throws TimeoutException {

        // Bind to the service
        // Get a reference to the Binder object that I declared in the Service class.
        IBinder binder = myServiceRule.bindService(new Intent(InstrumentationRegistry
                .getTargetContext(), MyService.class));

        // When you bind the service, it will start the service with onBind, which will return a
        // Binder that you can use to interact with the service. Since it's declared as an IBinder
        // type you actually have to cast it as a MyService.LocalBinder to be able to call getService.
        // Now I can get the Service reference.
        // I now have a direct connection to the service and I can call it's methods.

        // Able to get a reference to the MyService object
        // Cast the binder to be a "MyService.LocalBinder" to use the getService() method
        MyService service = ((MyService.LocalBinder) binder).getService();

        // do work with the service here
        assertNotNull("Bound service is null", service);
    }

    // When I run MyServiceTest, I could see an instance of MyService is created and then destroyed
    // for each test annotated Unit test method.
}


