package com.mycompany.example.myapplication;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

public class MainActivityTestRule<A extends Activity> extends ActivityTestRule<A> {

    public MainActivityTestRule(Class<A> activityClass) {
        super(activityClass);
    }

    @Override
    protected void beforeActivityLaunched() {
        TeamDatabase.getInstance().setCursor(new MockTeamCursor());
        super.beforeActivityLaunched();
    }
}

