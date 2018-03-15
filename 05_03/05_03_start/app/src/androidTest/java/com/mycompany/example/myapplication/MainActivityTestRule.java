package com.mycompany.example.myapplication;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

// I'm ready to use my MockCursor in order to test my Activity. I've already created
// a custom ActivityTestRule called MainActivityTestRule, and overwritten the
// beforeActivityLaunched() method, so that I can inject an instance of MockTeamCursor
// as the cursor in the TeamDatabase singleton before the Activity and test is created.
public class MainActivityTestRule<A extends Activity> extends ActivityTestRule<A> {

    // Create constructor that establishes the Activity using the Rule
    public MainActivityTestRule(Class<A> activityClass) {
        super(activityClass);
    }

    // overwritten the beforeActivityLaunched() method, so that I can inject an instance of
    // MockTeamCursor as the cursor in the TeamDatabase singleton before the Activity and test is
    // created.    @Override
    protected void beforeActivityLaunched() {

        // Set the MockCursor on the Database during the Instrumented Test
        TeamDatabase.getInstance().setCursor(new MockTeamCursor());

        super.beforeActivityLaunched();
    }
}

