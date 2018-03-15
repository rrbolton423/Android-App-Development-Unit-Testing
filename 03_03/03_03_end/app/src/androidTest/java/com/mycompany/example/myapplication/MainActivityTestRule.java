package com.mycompany.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

public class MainActivityTestRule<A extends Activity> extends ActivityTestRule<A> {

    public MainActivityTestRule(Class<A> activityClass) {
        super(activityClass);
    }
    @Override
    protected Intent getActivityIntent() {
        Log.e("MainActivityTestRule", "prepare the activity's intent");
        return super.getActivityIntent();
    }

    @Override
    protected void beforeActivityLaunched() {
        Log.e("MainActivityTestRule", "work before the activity is launched");
        super.beforeActivityLaunched();
    }

    @Override
    protected void afterActivityLaunched() {
        Log.e("MainActivityTestRule", "work after the activity has been launched");
        super.afterActivityLaunched();
    }

    @Override
    protected void afterActivityFinished() {
        Log.e("MainActivityTestRule", "cleanup after it has finished");
        super.afterActivityFinished();
    }

    @Override
    public A launchActivity(Intent startIntent) {
        Log.e("MainActivityTestRule", "launching the activity");
        return super.launchActivity(startIntent);
    }

}
