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

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);


    @Test
    public void testAdd() {
        Button addButton = mock(Button.class);
        when(addButton.getId()).thenReturn(R.id.buttonAdd);

        MainActivity activity = mActivityRule.getActivity();
        activity.buttonClicked(addButton);
        // assert conditions after add button is pusehd
    }

    @Test
    public void testRemove() {
        Button removeButton = mock(Button.class);
        when(removeButton.getId()).thenReturn(R.id.buttonRemove);

        MainActivity activity = mActivityRule.getActivity();
        activity.buttonClicked(removeButton);
        // assert conditions after add button is pusehd
    }
}
