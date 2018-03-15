package com.mycompany.example.myapplication;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import static org.junit.Assert.assertEquals;

public class SimpleMathWithTestName {

    // Using the JUnit provided "TestName" Rule, I can have unit test methods express the actual
    // test name when logging or reporting Assert Failure messages.
    // The "TestName" Rule makes the current test name available inside test methods.
    // This @Rule will be called every time a test method is executed
    @Rule
    public TestName name = new TestName();

    @Test
    public void testAdd() {
        SimpleMath sm = new SimpleMath();
        int total = sm.add(4, 5);
        assertEquals(name.getMethodName() + " is not adding correctly", 9, total);
    }

    @Test
    public void testDiff() {
        SimpleMath sm = new SimpleMath();
        int total = sm.diff(12, 7);
        assertEquals(name.getMethodName() + " is not subtracting correctly", 5, total);
    }
}
