package com.mycompany.example.myapplication;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

// To use the UI Automator testing framework in test classes, I must first add the UI automator
// library from the Android Test Support Library to the dependencies list of the app's build.gradle
// file.
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    // Use the ActivityTestRule to create an instance of the MainActivity before the test method call
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    // Write a simple test to press the back button on my device or emulator after the MainActivity displays.
    // Add a new unit test called testPressBackButton().
    @Test
    public void testPressBackButton() {
        // The UI device is part of the UI
        // Automator API discussed in the next video. However, note the call to the press back
        // method on the instance of the UI device obtained.
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack();
    }

    // When ran, what happened is that the MainActivity displayed, but when the UIDevice's
    // pressBack() method got called, it caused the MainActivity to be destroyed.

}
