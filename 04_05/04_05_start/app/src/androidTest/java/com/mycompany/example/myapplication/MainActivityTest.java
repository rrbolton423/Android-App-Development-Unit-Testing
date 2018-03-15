package com.mycompany.example.myapplication;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    // Espresso automatically synchronizes test code and app UI/code,
    // makes tests more durable and reliable across platforms,
    // and no need to use waits/sleeps to synchronize UI and test code
    // Espresso automatically deals with UI delay issues, making UI testing faster.
    // Espresso provides the means for testers to interact with UI without having to get
    // into the details of the UI construction.

    // Espresso API Formula
    // 1. Locate the UI element of interest
    // 2. Interact with the UI element of choice
    // 3. Verify or assert the results on the screen

    // Espresso is based on JUnit with Hamcrest libraries. The API Espresso provided simply
    // extends those libraries and offers 3 major classes to "find it", "interact with it",
    // and "check it". The Big 3 Espresso classes that help perform the "find it", "interact with it",
    // and "check it", are ViewMatcher, ViewInteraction, and ViewAssertion.

    // Espresso is apart of the Android Testing Support Library, but I still need to add the
    // Espresso library to the project's dependency.

    // Espresso test methods use a static method on the Espresso class as the starting point for
    // UI testing, and the find it, interact with it, check it formula.
    // The onView() method locates a view component on the display. The argument to the onView()
    // method is a ViewMatcher. ViewMatcher is a collection of Hamcrest matchers, that match on
    // Android View widgets. There are many ViewMatchers to locate a view by resource identifier;
    // class name;whether it's displayed, enabled, has focus; contains some text; and more.

    // This Espresso test method example, I use 3 ViewMatchers with the "allOf()", Hamcrest Matcher,
    // to have Espresso locate the View widget with a resource identifier of R.id.editText,
    // containing the text "this is a test", and having focus in the currently displayed activity.

    // The onView() method call in Espresso returns a "ViewInteraction" object. The perform() method
    // on the ViewInteraction is passed a "ViewAction" object. With a view located on the screen,
    // you may wish to interact with the widget, that is to click on it, edit it's text, or take other
    // action. The ViewActions is a class with many static methods that represent ViewAction, and is
    // the mechanism used in Espresso to take action on the View located by the "ViewMatcher".
    // There are several ViewAction methods to include: click, typeText, clearText, swipeLeft,
    // swipeRight, longClick, pressKey, replaceText, scrollTo, and more to interact with UI views.

    // Once I've located a view, and I've interacted with it, I want to check the state of the
    // display, checking that it meets my expectations. I use "ViewAssertion" in Espresso
    // to assert the UI is as expected.

    // Does a view have the right text? Is the view even displayed? Does the view have focus?
    // These are some of the types of questions we want to assert after interacting with the UI.

    // The check() method on a "ViewInteraction" is passed a ViewAssertion object to validate the
    // state of a view. A ViewAssertions utility class provides a collection of static methods
    // that return common ViewAssertion. The most well-used of these is the "matches()" static method on
    // ViewAssertions. The matches() method is passed "ViewMatchers", to validate against the view.
    @Test
    public void testEspresso() {

        // ViewInteraction object returned by onView() method call
        onView( // ViewMatcher to locate View to interact with
                allOf(withId(R.id.editText), withText("this a test"), hasFocus()))
                // ViewAction to replace the located widget's text
                .perform(ViewActions.replaceText("how about some new text"));

        // Checking that the EditText that I interacted with in my Espresso test still has
        // focus after I change the text, but also contains the replaced text of
        // "how about some new text".

        // ViewInteraction object returned by onView() method call
        onView( // ViewMatcher to locate View to check / assert with
                allOf(withId(R.id.editText), withText("how about some new text"), hasFocus()))
                // View Assertion to check / assert if the view has focus
                .check(ViewAssertions.matches(hasFocus()));

        // Notice in my Espresso test, I didn't have to wait or sleep for the UI to set up for
        // the action to be performed, something you'll often see in things like UI Automator testing.
        // This is the benefit of the Espresso framework. It handles the synchronization so that you
        // don't have to.

        // Much of Espresso uses static methods, so static imports are often used to simplify the code.
        // Also, Espresso's API are often chained together to further simplify the code, so testers
        // don't have to think about the API classes like ViewActions, ViewAssertions, especially
        // ViewInteraction.

    }

}
