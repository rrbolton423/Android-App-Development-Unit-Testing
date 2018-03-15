package com.mycompany.example.myapplication;

//import android.support.test.espresso.Espresso;
//import android.support.test.espresso.ViewInteraction;
//import android.support.test.espresso.action.ViewActions;
//import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

//    @Test
//    public void testEspresso() {
//        ViewInteraction interaction =
//                onView(allOf(withId(R.id.editText),
//                        withText("this is a test"),
//                        hasFocus()));
//        interaction.perform(replaceText("how about some new text"));
//        ViewInteraction interaction2 =
//                onView(allOf(withId(R.id.editText),
//                        withText("how about some new text")));
//        interaction2.check(matches(hasFocus()));
//    }

    @Test
    public void testEspressoSimplified() {
        onView(allOf(withId(R.id.editText),
                withText("this is a test"),
                hasFocus())).perform(replaceText("how about some new text"));
        onView(allOf(withId(R.id.editText),
                withText("how about some new text"))).check(matches(hasFocus()));
    }

}
