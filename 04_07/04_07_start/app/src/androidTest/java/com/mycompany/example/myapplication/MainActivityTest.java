package com.mycompany.example.myapplication;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/*
Robotium is another third-party test framework for black box testing in Android, for testing
either native or hybrid apps. Again, with black box testing, the tester ins't expected to know
the details of how the application is coded or how the user interface is built.

 Robotium provides a library and API to trigger user interface events, as if a user would invoke
 them. There are calls to click, enter text, hit the back button, etc. And this way, Robotium may
 look a little like Espresso. Indeed, the two have similar features. Robotium has been around longer
 than Espresso and provides regular releases. It provides a rich API for interacting with the app.
 The recorder on top of Robotium can make developing tests quick work. However, Espresso was
 specifically built to deal with synchronization and timing issues with little or no tester work.
 In Robotium, testers are provided sleep and retry APIs, which can still be subject to some timing issues.

 To use Robotium as part of your Android project, simply add the Robotium dependency to your build gradle file.
 */

// When using the Robotium API, test cases need to extend activity instrumentation test case 2,
// rather than use any annotations.
// Note the generic parameter for the class to specify the activity under test.
public class MainActivityTest extends
        ActivityInstrumentationTestCase2<MainActivity> {

    // Robotium provides a class called "solo" that provides a large part of the Robotium testing API.
    // Solo is the main class for executing Robotium tests.
    private Solo solo;

    /*
    A call to super in the constructor, with the activity under test, establishes the instance of
    our activity under test.
     */
    public MainActivityTest() {
        super(MainActivity.class);
    }

    /*
    A JUnit setup method, there's no before annotation to use in a setup method, is always provided
    in Robotium to get the activity under test and the instrumentation for the test ready, which
    are provided by the super class. Robotium provides a class called "solo" that provides a large
    part of the Robotium testing API.
    In the setup method, create a new instance of solo and give it the instrumentation and activity
    for testing. Because the instance of solo is used to call on the UI event methods, it's common
    to declare a solo instance variable and set that variable from within the setup.
    Test methods need to start with "test," just like tests in good old JUnit 3 days, as opposed to
    current JUnit and Android SDK's testing annotation,
     */
    public void setUp() {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    /*
    In a JUnit tear down method, again, no after annotation used on a method in Robotium, clean up
    the activity with a call to finishOpenActivities on the solo instance.
     */
    public void tearDown() {
        solo.finishOpenedActivities();
    }

    /*
     Here's an example test method that waits for the main activity to open, checks that the edit
     text is displaying the correct text, pushes the "Click Me" button, and then rechecks the text
     in edit text is again correct.
     */
    public void testPushClickMe() {

        solo.waitForActivity(MainActivity.class);

        solo.assertCurrentActivity("MainActivity is not displayed",
                MainActivity.class);

        assertTrue("This is a test in EditText is not displayed",
                solo.searchText("this is a test"));

        /*
        There are many click methods, like clickOnButton and clickOnEditText, that cause a click or
        touch on a particular widget or text. There are methods to enter or clear text, methods to
        simulate the press of hardware buttons, like back and home, and methods to wait for the UI
        to display or refresh, like waitForText or waitForActivity. These are methods that Robotium
        provides for developers to do their own synchronization work. There are methods like
        searchText and assertCurrentActivity that allow the checking or assert functions of any unit
        test to take place.
         */
        solo.clickOnButton("Click Me");

        assertTrue("You clicked on me text is not displayed in the EditText",
                solo.searchText("you clicked me"));
    }
}