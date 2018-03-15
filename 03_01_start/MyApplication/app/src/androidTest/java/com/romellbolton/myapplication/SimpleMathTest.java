package com.romellbolton.myapplication;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by romellbolton on 2/26/18.
 */

// Annotate the class with the @RunWith annotation using "AndroidJUnit4",
// as a parameter to that annotation.
@RunWith(AndroidJUnit4.class)
public class SimpleMathTest {

    // I'm set to begin adding test methods

    @Test
    public void testAdd() {
        assertEquals("Addition not performed correctly", 5, 3+2);
    }

    @Test
    public void testDif() {
        assertEquals("Subtraction not performed correctly", 5, 12-7);
    }

    // It's not that exciting, but my InstrumentationTest is ready to go, and I'm ready to
    // execute this Instrumented Test on an Android device, or emulator.


}
