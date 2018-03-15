package com.mycompany.example.myapplication;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    // The UI Automator provides a test framework or library that allows you to write tests that
    // programmatically exercise your app or any app on the device or emulator from a user interface
    // perspective. It does so without having to know the details of how the app was put together.
    // All you have to know is the elements of the UI you want to interact with. These type of tests
    // are called black box tests, since the test code doesn't know the internal implementation of the
    // app it tests. Black box testing: Tests that examine the functionality without knowing of internal
    // workings of code.

    // UiDevice represents a device or emulator. From a UiDevice instance, you can invoke methods such
    // as rotateDevice(), pressBack(), pressHome(), pressMenu(), click(), swipe(), openNotifications(),
    // and much more.

    // You can also get information about what's up on the device or emulator. For example, you can
    // call on the UiDevice instance methods to determine if the screen is on, get with display width
    // and height of the device, and check if the device is in it natural orientation.

    // UiDevice is a singleton. To get the UiDevice instance, call on the getInstance() method passing
    // and instance of Instrumentation. The instance is obtained with a call to
    // InstrumentationRegistry.getInstrumentation() as a parameter.

    // Im going to write a small test called testUiDevice() in my MainActivityTest, that uses the
    // UIDevice instance and exercises some of it's methods.

    @Test
    @Ignore
    public void testUiDevice() throws RemoteException {

        // In my testUiDevice() method, I get the UiDevice instance and then check to see if the screen
        // is on. If so, I rotate the screen left and then pull down the notification shade just to take
        // the UiDevice API for a spin. Many of the UiDevice methods throw remote exception, so I add
        // throws to my test method in order to recognize and handle potential exceptions.

        // Get the instance of the device
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // If the device's screen is on...
        if (device.isScreenOn()) {

            // Rotate the device to the left
            device.setOrientationLeft();

            // Open the notification tab on the device
            device.openNotification();
        }
    }

    // The UiSelector allows your test code to locate a user interface widget by a great many filters.
    // You can filter by widget class name, whether it has focus or is selected, what text is
    // displayed in the widget, or by resource identifier just to name a few UiSelector filters.

    // You create an instance of UiSelector and call UiSelector methods, and add filters to
    // the selector. It's a tool that can help you understand the widgets displayed and then select
    // them by using the UI Automator's UiSelector API

    // UiSelector allows me to programmatically locate a UI widget. To actually interact with that
    // widget, I need a UiObject. UiObjects, represent Ui widgets in the current display. I get a
    // UiObject by using a combination of UiDevice and UiSelector objects.
    // I call the findObject() method on my UiDevice , passing in the UiSelector to get the UiObject
    // matching the selector's filters.

    // Once I have a UiObject, I can use it's methods to interact with the UI widget. For example,
    // I can click on it and wait for a new window or screen to open. Or set the text in the widget,
    // presuming it was some sort of editable field.

    // Add a method to exercise my activity using the UIAutomator. The test method gets the Ui
    // instance, then creates a UiSelector to locate the EditText widget filtering by className,
    // currently displayed text, and whether it has focus.

    // I then create a UiObject from the UiDevice and new button selector. I use the UiObject to click
    // on the button. I handle the exceptions, and I use Thread.sleep() to see the changes in the
    // app because the tests run quickly.
    @Test
    public void testUiAutomatorAPI() throws InterruptedException, UiObjectNotFoundException {

        // Get the device
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Create a UiSelector that filters for an EditText on the device that says
        // "this is a test", and has focus.
        UiSelector editTextSelector = new UiSelector()
                .className("android.widget.EditText")
                .text("this is a test")
                .focusable(true);

        // Create a EditText widget to interact with in the test using the selector created
        UiObject editTextWidget = device.findObject(editTextSelector);

        // Change the text of the EditText widget
        editTextWidget.setText("this is new text");

        // Sleep the thread to see Ui change
        Thread.sleep(2000);

        // Create a selector to filter for a "Button" in the Activity that says "CLICK ME",
        // and is clickable
        UiSelector buttonSelector = new UiSelector()
                .className("android.widget.Button")
                .text("CLICK ME")
                .clickable(true);

        // Create a Button widget to interact with it in the test using the selector created
        UiObject buttonWidget = device.findObject(buttonSelector);

        // Click the Button widget
        buttonWidget.click();

        // Sleep the thread to see Ui change
        Thread.sleep(2000);

    }

    // Once I run the test on my emulator, I see my results of using the UI Automator API
    // to exercise the simple UI all facilitated by my use of UI Viewer to get the widget
    // information from my UI.
}
