package com.mycompany.example.myapplication;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by romellbolton on 3/12/18.
 */

public class MockTest {

    // The methods on the Mockito class are static, so it's typical that we import the static
    // methods and shorten the code a bit.

    @Test
    public void testMock() {

        // Create a Mock instance of SimpleMath using Mockito
        SimpleMath math = mock(SimpleMath.class);

        // Display the type of the instance created by Mockito.mock()
        System.out.println(math.getClass());

        // When you want the mock object to return a particular value, use the
        // Mockito.when() and thenReturn() static methods.
        // Here, I'm making sure that the mock object returns the appropriate int values
        // for my two expected parameter tests.
        when(math.add(9,5)).thenReturn(14);
        when(math.add(4,15)).thenReturn(19);

        // Use the mock to add 2 numbers
        int sum = math.add(9,5);

        // Print the results
        System.out.println(sum);
        // The results will be 0, because the mock object doesn't know, or care,
        // what the add() method really does. It just knows it returns an int.
        // By default it returns the int zero.

        // Same result of zero
        sum = math.add(4,15);
        System.out.println(sum);

    }

    // If I desire a mock object to throw an exception, to simulate what the real object
    // might do. I use Mockito.when() method to cause it to throw the type of throwable I designate.
    @Test
    public void testBadDiff() {

        // To prove the point, in this additional test method, I have the mock object throw
        // an exception if I try to call on the diff() method with two zero parameters.

        // Create a Mock instance of SimpleMath using Mockito
        SimpleMath math = mock(SimpleMath.class);

        // When the Mock object's diff() method is called with zeroes, throw an exception
        when(math.diff(0,0)).thenThrow(new Exception("don't test with zeros"));

        // Use the Mock object to do a diff operation with zeros
        int sum = math.diff(0,0);
    }

    // Recall that one purpose of a mock object versus stub or dummy is to validate that methods
    // in the test object are actually used. You can use Mockito to test that the test object's
    // method is being used and even with particular parameters, if you'd like.

    // In this new test method, I check that the add() method of SimpleMath does get called,
    // and it gets called with parameters four and five.
    @Test
    public void testAddIsCalled() {

        // Create a Mock instance of SimpleMath using Mockito
        SimpleMath math = mock(SimpleMath.class);

        // Make the Mock object return 9 when the add() method is called with parameters 4 and 5
        when(math.add(4,5)).thenReturn(9);

        // Create an instance of MathUser and pass the Mock math object to its constructor
        MathUser user = new MathUser(math);

        // Call the MathUser object's doSomeMath() method
        user.doSomeMath();

        // Make sure that the add() method of SimpleMath was called with parameters 4 and 5
        // If the method on the mock didn't get called, or didn't get called with the right
        // parameters, a test fails. In this case, the test passes because add() is being
        // called by the MathUser object.
        verify(math).add(4,5);
    }

    // If the method on the mock didn't get called, or didn't get called with the right
    // parameters, a test fails.

    // In this test method, I'm verifying SimpleMath's diff() method, but the MathUser
    // code calls on SimpleMath's add() method.
    @Test
    public void testVerifyFail() {

        // Create a Mock instance of SimpleMath using Mockito
        SimpleMath math = mock(SimpleMath.class);

        // Make the Mock object return 9 when the add() method is called with parameters 4 and 5
        when(math.add(4,5)).thenReturn(9);

        // Create an instance of MathUser and pass the Mock math object to its constructor
        MathUser user = new MathUser(math);

        // Call the MathUser object's doSomeMath() method
        user.doSomeMath();

        // Make sure that the diff() method of SimpleMath was called with parameters 4 and 5
        // If the method on the mock didn't get called, or didn't get called with the right
        // parameters, a test fails. In this case, the test fails because add() isn't being
        // called at all by the MathUser object.
        verify(math).diff(4,5);
    }

    // Additional Mockito methods allow us to verify methods are called at least once,
    // x times, no more than y times, or even never.
}
