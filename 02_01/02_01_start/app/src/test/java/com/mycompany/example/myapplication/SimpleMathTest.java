package com.mycompany.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleMathTest {
    @Test
    public void testAdd() {

        // First, create an instance of the object to test
        // This is called the Domain object / object under test
        // Object being tested by the unit test
        SimpleMath sm = new SimpleMath();

        // Second, exercise the Domain object's method you want to test
        // You often have to create objects to pass in as parameters to the method
        // you are testing
        int total = sm.add(4, 5);

        // Lastly, confirm the results returned by the method you are testing. JUnit provides
        // an Assert class to help in this last step. It is the result of the assert that are
        // reported by the JUnitRunner after execution. There are numerous assert methods, and I
        // am using the assertEquals() method. assertEquals() is checking that the results of the
        // executing method, the last parameter to the assertEquals() method, are equal to the
        // expected results, which is the first parameter to the assertEquals() call.
        // The assert methods are also overloaded with a method that takes a message string as a
        // parameter. This message string is returned by the JUnit runner whenever
        // the assertion check fails.
        assertEquals("Simple Math is not adding correctly", 9, total);
    }

    @Test
    public void testDiff() {
        SimpleMath sm = new SimpleMath();
        int total = sm.diff(9, 2);
        assertEquals("Simple Math is not subtracting correctly", 7, total);
    }
}



