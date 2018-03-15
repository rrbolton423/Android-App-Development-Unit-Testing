package com.mycompany.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by romellbolton on 2/25/18.
 */

public class MyTest {
    @Test
    public void testSubtract() {
        // This code will cause a Error Test. This is when a Unit test returns an unexpected
        // exception. In this case, a Arithmetic Exception is thrown.
        double x = 5/0;
        assertEquals(4, 10 - 6);
    }
}
