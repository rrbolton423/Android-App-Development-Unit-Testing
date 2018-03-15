package com.mycompany.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

/**
 * Created by romellbolton on 2/27/18.
 */

// What if you wanted to manage the setup to the environment, in this case MainActivity, a bit more
// before unit testing the Activity? By creating your own custom ActivityTestRule class, you can
// explore the activity in its various states, before and after the Activity is being displayed on
// the screen.

// To create your own ActivityTestRule, create a class that extends ActivityTestRule. Allow the type
// of the Activity to be specified by the generic parameter, represented by "A".
public class MainActivityTestRule<A extends Activity> extends ActivityTestRule<A> {

    // Log TAG
    private static final String TAG = "MainActivityTestRule";

    // Add a constructor for the class passing in the class as a parameter
    public MainActivityTestRule(Class<A> activityClass) {
        super(activityClass);
    }

    // Next, I have to override any of the ActivityTestRule methods.
    // It's in these methods that I have the rule, prepare the app environment before a test,
    // explore the state and condition of the activity before or after a test, or even during
    // or after it's displayed.

    // In this example, I have overridden all of the available lifecycle methods. In each method,
    // I added to the log file so that we can see how the test executes and at what point the rule
    // code is executed.

    // Code to set up the intent as if supplied to startActivity(Intent)
    @Override
    protected Intent getActivityIntent() {
        Log.i(TAG, "getActivityIntent: ");
        return super.getActivityIntent();
    }

    // Code that runs before the Activity is created and launched
    @Override
    protected void beforeActivityLaunched() {
        Log.i(TAG, "beforeActivityLaunched: ");
        super.beforeActivityLaunched();
    }

    // Code that runs before the Activity is launched but before the @Before or test method
    // executes
    @Override
    protected void afterActivityLaunched() {
        Log.i(TAG, "afterActivityLaunched: ");
        super.afterActivityLaunched();
    }

    // Code that runs after the Activity is finished
    @Override
    protected void afterActivityFinished() {
        Log.i(TAG, "afterActivityFinished: ");
        super.afterActivityFinished();
    }

    // Launches the Activity being tested
    @Override
    public A launchActivity(@Nullable Intent startIntent) {
        Log.i(TAG, "launchActivity: ");
        return super.launchActivity(startIntent);
    }
}

