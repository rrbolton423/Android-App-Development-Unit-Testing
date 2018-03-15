package com.mycompany.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        // This code will cause a Failed Test. This is when a Unit test returns an expected
        // error. In this case, a Assertion Error is thrown.
        assertEquals(5, 2 + 2);
    }
}