package com.mycompany.example.myapplication;

import android.app.Activity;
import android.os.Build;
import android.support.test.filters.RequiresDevice;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

// The AndroidJUnitRunner allows you to annotate your unit tests with filters, which are
// annotators that the runner uses to determine whether or not to execute your unit test.
// Think of these annotations like JUnit's @Ignore annotation. But ignore with some condition
// that must be met before the test is ignored.

// Currently, Android and AndroidJUnitRunner recognizes five of these filters. These annotations
// can be placed on a unit test method or on the test class as a whole, thereby applying to all the
// test methods in the test class.

// In most cases, you don't change the way you execute your test when taking advantage of filters.
// The filter just informs the runner to execute or not execute the test based on the filters.

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    // The @RequireDevice annotation filter prohibits tests from being executed on an emulator.
    // Some things can only be tested, or tested effectively on a real device.
    // Android Studio and the SDK has a bug, which is ignoring the @RequiresDevice annotation,
    // and is running that test even if you are testing on an emulator. This should be fixed
    // in an upcoming release.
    @Test
    @RequiresDevice
    public void testRequiresDevice() {
        Log.d("FilterTesting", "This test requires a device");
        Activity activity = activityTestRule.getActivity();
        assertNotNull("MainActivity is not available", activity);
    }

    // The @SDKSuppress annotation allows you to specify the minimum Android API level on the device
    // or emulator before running the test. Some parts of the app may only work when run on certain
    // versions of the Android API.
    @Test
    @SdkSuppress(minSdkVersion = 30)
    public void testMinSdkVersion() {
        Log.d("FilterTesting", "Checking for min sdk >= 30");
        Activity activity = activityTestRule.getActivity();
        assertNotNull("MainActivity is not available", activity);
    }

    // If you are more familiar with the Android version codes like Gingerbread, Ice Cream Sandwich,
    // and JellyBean, you can use an Android Build Version Code constant to specify the minimum
    // API levels supported by the test.
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void testMinBuild() {
        Log.d("FilterTesting", "Checking for min build > Lollipop");
        Activity activity = activityTestRule.getActivity();
        assertNotNull("MainActivity is not available", activity);
    }

    /*
    The last set of filter annotations all help to classify how long a test should run, what resources
    it's using, and how frequently you expect to execute the test.
     */

    // Size filter annotations require use of the adb shell in order to filter

    // @SmallTest should take milliseconds, and does not require resources like the file system or network,
    // and is ran often
    @Test
    @SmallTest
    public void testSmallTest() {
        Log.d("FilterTesting", "this is a small test");
        Activity activity = activityTestRule.getActivity();
        assertNotNull("MainActivity is not available", activity);
    }

    // @LargeTest may take longer than 2 seconds to execute and may use local and network resources, and
    // is ran infrequently and or at the end of the day
    @Test
    @LargeTest
    public void testLargeTest() {
        Log.d("FilterTesting", "This is a large test");
        Activity activity = activityTestRule.getActivity();
        assertNotNull("MainActivity is not available", activity);
    }
}
