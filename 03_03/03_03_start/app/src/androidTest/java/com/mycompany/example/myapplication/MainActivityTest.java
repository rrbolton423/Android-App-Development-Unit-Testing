package com.mycompany.example.myapplication;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by romellbolton on 2/27/18.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    // Add a Rule public instance variable
    // The ActivityTestRule creates and launches the Activity specified through the generic
    // parameter, which is MainActivity. It launches once for each test method, and exposes it
    // for use in my test methods by the instance variable reference.

    // MainActivityTest Execution
    // For each Test method,
    // 1. MainActivity is created
    // 2. @Before method is executed
    // 3. @Test method is executed
    // 4. @After method is executed
    // 5. MainActivity is destroyed
    // This rule provides functional testing of a single Activity.
    // When launchActivity is set to true in the constructor, the Activity under test will be
    // launched before each test annotated with @Test and before methods annotated with @Before,
    // and it will be terminated after the test is completed and methods annotated with @After are finished.

    // During the duration of the test you will be able to manipulate your Activity directly using
    // the reference obtained from getActivity().
//    @Rule
//    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new
//            ActivityTestRule<>(MainActivity.class);


    // Before executing my test, I need to change the rule in my MainActivityTest to use an
    // instance of this new custom ActivityTestRule in place of the ActivityTestRule. I leave
    // everything else in my test case the same. I execute my test case one more time and see the new
    // test results methods fire via the logs.
    @Rule
    public MainActivityTestRule<MainActivity> mainActivityActivityTestRule = new
            MainActivityTestRule<>(MainActivity.class);

    // Add a new UnitTest method that I call, testUI. I add the @Test annotation to mark it as
    // a unit test.
    @Test
    public void testUI() {
        // In the UnitTest method, I'm going to get a reference to the Activity that has been
        // created by the rule before this method executes with a call to getActivityMethod()
        // on the ActivityRule instance.
        // Remember, the Activity should've already been created and started by the Android SDK
        // by the time this method is executing.
        Activity activity = mainActivityActivityTestRule.getActivity();

        // After getting the activity, I use some well-known Android activity methods and JUnit
        // test methods, to check that the Activity is indeed displayed and displaying the correct
        // user interface and information. I use a JUnit assert and the Android activity's
        // findViewById() method, to check that the helloTV is available on the Activity, meaning,
        // is it null?
        assertNotNull(activity.findViewById(R.id.helloTV));

        // Next, I check that the helloTV widget is displayed or shown on the screen.
        TextView helloView = (TextView) activity.findViewById(R.id.helloTV);
        assertTrue(helloView.isShown());

        // Then I check that the text in the TextView, is the String "Hello World!".
//        assertEquals("Hello World!", helloView.getText());

        // In your testing, you can use InstrumentationRegistry, a class provided by the Android
        // Testing Support Library, to get the application context. From the application context,
        // you can get a String and other resources, for example, if "Hello World!", was provided
        // as a String resource in strings.xml. Then you could assert using the resources reference,
        // versus hard-coding the string into the test code.
        assertEquals(InstrumentationRegistry.getTargetContext().getString(R.string.helloworld),
                helloView.getText());

        // Finally, to prove that I'm indeed exploring the MainActivity, I check that when I
        // search for a stock Android button on the Activity, with findViewById, it returns null,
        // indicating the stock button isn't available or displayed.
        assertNull(activity.findViewById(android.R.id.button1));

        // Wth the first real Android instrumentation test in place, I'm going to exercise it by
        // running the MainActivityTest.

        // As you can see, you can use the Activity instance made available by the ActivityTestRule,
        // to make sure the UI is working according to your design.

    }
}

