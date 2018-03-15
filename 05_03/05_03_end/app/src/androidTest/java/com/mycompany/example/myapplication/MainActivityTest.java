package com.mycompany.example.myapplication;

import android.support.test.espresso.Espresso;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {


    @Rule
    public MainActivityTestRule<MainActivity> mActivityRule =
            new MainActivityTestRule(MainActivity.class);

    @Test
    public void testInitialDisplay(){
        Espresso.onView(withText("Cubs")).check(matches(isDisplayed()));
        Espresso.onView(withText("Cards")).check(matches(isDisplayed()));
        Espresso.onView(withText("Pirates")).check(matches(isDisplayed()));
        Espresso.onView(withText("Reds")).check(matches(isDisplayed()));
        Espresso.onView(withText("Brewers")).check(matches(isDisplayed()));
    }
}
