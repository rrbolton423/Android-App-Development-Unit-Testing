package com.mycompany.example.myapplication;

// Robolectric executes in the development machine's JVM and not the emulator or device.
// This means that Robolectric tests, like local tests, are considered local tests or
// unit tests versus Android Instrumented tests by Android Studio. Create your Robolectric
// test class in the app/src/test folder versus the app/src/AndroidTest folder, just like you
// do for local tests.

// When you create a test class, in order to use Robolectric, annotate the test with
// @RunWith and @Config annotations.

// The @RunWith annotation specifies the runner used to execute your test. Robolectric provides
// its own runner to be able to execute the Robolectric tests and use its Shadow Objects.
// So the parameter to the @RunWith annotation is Robolectric's own RobolectricGradleTestRunner
// class.
// The @Config annotation specifies to Robolectric where to find the "constants"
// that it uses determines the location of such files as the manifest file,
// resources, etc in the project.

import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/*
       Robolectric is an open-source Android testing tool. Its point of difference compared to other
       Android testing tools is that it runs tests on the development machines JVM, not on a device or emulator.

       You might be thinking, "Wait a minute! Didn't Android SDK local test run on a JVM?"
       Yes, local tests do run on the local JVM. But local tests can can only test code that
       have no Android ties. Robolectric tests allow testers to test Android code that is code
       that uses the Android API on the JVM of the local machine. How is Robolectric able to run
       tests on the JVM? Robolectric provides a jar file, Android jar, which is a collection of
       mock objects, or what Robolectric calls shadow objects.

       Mock objects, something I teach you about in the next chapter, are objects that look
       like real objects, but they only mimic some of the behavior of the real objects in Android.
       When your test runs, Robolectric checks to see if there's a shadow class that corresponds to
       the Android class being used. For example, Robolectric would turn to shadow text view in
       place of Android's text view when a method on a text view is invoked during a test.
       These mock or shadow classes maintain state and try to behave as the real android objects
       but with some limitations, such as an ability to use some native libraries under the covers.

       Another limitation, one often associated to third-party test frameworks, is that the tool
       development often lags behind the release of the Android SDK. In the case of Robolectric,
       it supports up to Android API level 21. At the time of this recording, Android is up to API
       level 23. Therefore, you have to specify the target SDK as 21 in your build gradle file in
       order to use Robolectric, even when Android Studio and your SDK are prepared to use the
       latest and greatest version of Android.

       So, what is the benefit of Robolectric? Speed. Robolectric tests execute must faster than
       on a real device or an emulator. Application and test packages don't need to be loaded on
       to the device or emulator. This is further enhanced given that our development machines are
       typically outfitted with bigger and faster processors than what is on a device.
       I started Android Studio and opened up project four six start. To use Robolectric with
       Android Studio, you simply need to add a dependency line to your build gradle file.
*/
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    // Unlike an Instrumented Test, using "Rules", the SDK isn't going to create an instance
    // of the Activity, Service, or other application component that you wish to test, so you must
    // create the instance yourself, typically in a @Before annotated setup method.
    // Robolectric does provide some convenience methods in the Robolectric library class to
    // help create these components.

    private MainActivity activity;

    // I have Robolectric create an instance of my MainActivity as I prepare to test it. A similar
    // setupService() method exists to create an instance of an Android service.
    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    // In test methods, you can interact with and check parts of the UI, as if these components
    // were just normal Java objects.

    // In this test method, I'm getting the Button of my Activity and checking that it contains the
    // appropriate text. Then, you execute a Robolectric test, just like I would execute a local test.
    @Test
    public void clickButton() {

        // Grab an instance of the UI item you want to test with the given activity
        Button button = (Button) activity.findViewById(R.id.button);

        // Run assertions on the UI element
        assertNotNull("test button could not be found", button);
        assertTrue("button does not contain text 'Click Me'",
                "Click Me".equals(button.getText()));
    }

    /*
    I execute a robolectric test just like I would execute a local test. I right-click on the test
    class or the entire package of tests and select run from the resulting menu. My test results
    would be displayed in the run view just like all test results are. Robolectric offers an
    extensive API and a means to customize and extend it. Remember, its benefit is speed at the
    cost of lagging behind the latest Android SDK and inability to test some parts of the app,
    like those using native libraries.
     */

}
