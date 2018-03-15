package com.mycompany.example.myapplication;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void setUp() {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void tearDown() {
        solo.finishOpenedActivities();
    }

    public void testPushClickMe() {
        solo.waitForActivity(MainActivity.class);
        solo.assertCurrentActivity("MainActivity is not displayed", MainActivity.class);
        assertTrue("This is a test in EditText is not displayed",
                solo.searchText("this is a test"));
        solo.clickOnButton("Click Me");
        assertTrue("You clicked me text is not displayed in the EditText",
                solo.searchText("you clicked me!"));
    }

}
