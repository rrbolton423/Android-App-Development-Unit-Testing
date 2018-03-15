package com.mycompany.example.myapplication;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//import org.mockito.Mockito;

public class MockTest {

    @Test
    public void testMock() {
        SimpleMath math = mock(SimpleMath.class);
        when(math.add(9, 5)).thenReturn(14);
        when(math.add(4, 15)).thenReturn(19);
        System.out.println(math.getClass());
        int sum = math.add(9, 5);
        System.out.println(sum);
        sum = math.add(4, 15);
        System.out.println(sum);
    }

    // this test results in MockitoException
    @Test
    public void testBadDiff() {
        SimpleMath math = mock(SimpleMath.class);
        when(math.diff(0, 0)).thenThrow(new Exception("don't test with zeros"));
        int sum = math.add(0, 0);
    }

    @Test
    public void testAddIsCalled() {

        SimpleMath math = mock(SimpleMath.class);
        when(math.diff(4, 5)).thenReturn(9);

        MathUser user = new MathUser(math);
        user.doSomeMath();
        verify(math).add(4, 5);
    }

    // this test fails verification
    @Test
    public void testVerifyFail() {

        SimpleMath math = mock(SimpleMath.class);
        when(math.diff(4, 5)).thenReturn(9);

        MathUser user = new MathUser(math);
        user.doSomeMath();
        verify(math).diff(4, 5);
    }


}

