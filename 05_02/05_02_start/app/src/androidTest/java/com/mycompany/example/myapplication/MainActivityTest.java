package com.mycompany.example.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    // As a simple example of how Mockito mock objects can assist in instrumentation testing,
    // consider an activity where clicking on one of the collection of buttons causes an onClick()
    // action in the activity.

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    // Should I wish to test the button click method on MainActivity, I can use Mockito to mock the
    // button for my instrumentation test. I can use the Mockito API to respond with the appropriate
    // ID, so that the add or remove work in the button click method gets exercised appropriately.

    // As shown in these example instrumented tests, I create the mock button using Mockito, set
    // the appropriate Id to be returned when requested of the mock, and then exercise the Activity's
    // button click method.

    @Test
    public void testAdd() {

        // Create a mock button
        Button addButton = mock(Button.class);

        // Set the appropriate id for the add button
        // When the buttonClicked() method is called, return the buttonAdd id
        when(addButton.getId()).thenReturn(R.id.buttonAdd);

        // Get an instance of the Activity
        MainActivity activity = mActivityRule.getActivity();

        // Click the add button using the Activity
        activity.buttonClicked(addButton);
    }

    @Test
    public void testRemove() {

        // Create a mock button
        Button removeButton = mock(Button.class);

        // Set the appropriate id for the remove button
        // When the buttonClicked() method is called, return the buttonRemove id
        when(removeButton.getId()).thenReturn(R.id.buttonRemove);

        // Get an instance of the Activity
        MainActivity activity = mActivityRule.getActivity();

        // Click the remove button using the Activity
        activity.buttonClicked(removeButton);
    }

    // When I execute my test, I'm able to exercise the methods of my Activity, without having to
    // physically exercise the UI thanks to mock objects.
}
