package com.mycompany.example.myapplication;

import android.support.test.espresso.Espresso;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

// Finally, in my test class, I can use Espresso, or other UI testing facilities to see
// that the team names provided by the MockTeamCursor are displayed in the ListView when
// the activity displays.

// When I execute my test, I see my MockCursor provide the data as if the TeamDatabase
// was in place.
public class MainActivityTest {

    // Create an instance of the Activity under test using a Rule
    @Rule
    public MainActivityTestRule<MainActivity> mActivityRule =
            new MainActivityTestRule(MainActivity.class);

    // Use Espresso to check the UI and make sure that the proper text is being shown
    // on the screen in the ListView using ViewMatchers and ViewAssertions after the Activity
    // has been loaded
    @Test
    public void testInitialDisplay(){
        Espresso.onView(withText("Cubs")).check(matches(isDisplayed()));
        Espresso.onView(withText("Cards")).check(matches(isDisplayed()));
        Espresso.onView(withText("Pirates")).check(matches(isDisplayed()));
        Espresso.onView(withText("Reds")).check(matches(isDisplayed()));
        Espresso.onView(withText("Brewers")).check(matches(isDisplayed()));
    }
}
