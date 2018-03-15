package com.mycompany.example.myapplication;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class SimpleMathTest {

    @Test
    public void testAdd() {
        assertEquals("Addition not performed correctly.", 5, 3 + 2);
    }

    @Test
    public void testDiff() {
        assertEquals("Subtraction not performed correctly.", 5, 12 - 7);
    }

}


