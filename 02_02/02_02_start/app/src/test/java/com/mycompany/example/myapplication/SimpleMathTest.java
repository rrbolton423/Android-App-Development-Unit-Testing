package com.mycompany.example.myapplication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleMathTest {

    // If there is code you want to initialize, and/or to cleanup things before and after the entire
    // series of test methods in a test class, use @BeforeClass and @AfterClass annotated static methods.
    // If we ran this Test class with a JUnit Runner, the @Before and @After methods run before each
    // unit test method. They would only tun once, that is before all the unit tests and after all the
    // unit tests of the test class.
    @BeforeClass
    public static void testClassSetup() {
        // Print out 1 message before any unit test method runs
        System.out.println("getting test class ready");
    }

    @AfterClass
    public static void testClassCleanup() {
        // Print out 1 message after every unit test method is ran
        System.out.println("done with tests");
    }

    // Define a SimpleMath object for use within the Test class
    private SimpleMath sm;

    // JUnit provides the ability to have a common method executed before and after each unit test,
    // that is before and after each Test annotated method in a Test class. This removes common code
    // from Unit test methods.

    // @Before annotation is used to annotate the method that is to be called before unit test methods.
    // A @Before annotated method can be used to create an instance of the SimpleMath class, which each
    // @Test method uses to exercise one of the math methods.
    @Before
    public void setup() {
        // Create an instance of the SimpleMath class each time a @Test method is ran
        sm = new SimpleMath();

        // Print message to see when the @Before method is executed each time a @Test method is ran
        System.out.println("ready for testing...");
    }

    // The @After annotation is used to annotate the method that is to be called after unit test methods.
    // It is used to free up resources used during the test and cleans up after the test.
    // There isn't a lot of cleanup to do here, so the @After method will be used to write
    // to the standard out to indicate when each @Test is done.
    @After
    public void cleanup() {
        // Print message to see when the @After method is executed after each time a @Test method is ran
        System.out.println("done with unit test");
    }

    @Test
    public void testAdd() {
        int total = sm.add(4, 5);
        assertEquals("Simple Math is not adding correctly", 9, total);
    }

    @Test
    public void testDiff() {
        int total = sm.diff(9, 2);
        assertEquals("Simple Math is not subtracting correctly", 7, total);
    }

    /*
    In my test class, there should be more unit tests for the div method in SimpleMath. Any alternate
    path or conditional in the method should be exercised along with the main, or happy path, as
    developers like to call it.
     */

    @Test
    public void testDiv() {
        double total = sm.div(9,3);
        assertEquals("Simple Math is not dividing correctly", 3.0, total, 0.0);
    }

    // One other JUnit annotation you should be aware of is the @Ignore annotation. This annotation
    // could be placed on a JUnit @Test method, and it tells the JUnit Runner to ignore, or skip,
    // the unit test. This comes in handy in times when you want to run  some tests in a Test class,
    // but not all of them. The ignore annotation provides the power to control what unit tests are run,
    // and which are not. For example, the testDivWithZeroDivisor() will not be executed in the
    // SimpleMathTest class.
    @Ignore
    // Returning 0 when diving by 0 is probably a bad implementation and could create incorrect results
    // in other places in out application. Perhaps a better implementation would be to just have the
    // divide by 0 exception propagate back to the caller. JUnit has the answer.
    // The Test annotation allows for a parameter that specifies the type of exception to generated
    // during a unit test. In this case, a passing Unit test is one where the exception type specified
    // in the Test annotation matches that of the exception thrown by the exercise code.
    @Test(expected = java.lang.ArithmeticException.class)
    public void testDivWithZeroDivisor() {
        double total = sm.div(9,0);
        assertEquals(
                "Simple Math is not handling division by zero correctly",
                0.0,
                total,
                0.0);
        // assertEquals() is checking for equality among double values, therefore
        // it takes a fourth parameter, which is a delta value, or the maximum delta between the expected
        // and actual values. In this case, the delta tolerance is 0.0, suggesting the values should be
        // exactly the same.
    }

}



