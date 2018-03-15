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

    @Test
    @Ignore
    public void testUiDevice() throws RemoteException {
        UiDevice device = UiDevice.getInstance(
                InstrumentationRegistry.getInstrumentation());
        if (device.isScreenOn()) {
            device.setOrientationLeft();
            device.openNotification();
        }
    }

    @Test
    public void testUiAutomatorAPI() throws UiObjectNotFoundException, InterruptedException {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        UiSelector editTextSelector = new UiSelector().className("android.widget.EditText").text("this is a test").focusable(true);
        UiObject editTextWidget = device.findObject(editTextSelector);
        editTextWidget.setText("this is new text");

        Thread.sleep(2000);

        UiSelector buttonSelector = new UiSelector().className("android.widget.Button").text("Click Me").clickable(true);
        UiObject buttonWidget = device.findObject(buttonSelector);
        buttonWidget.click();

        Thread.sleep(2000);

    }


}
