package com.mycompany.example.myapplication;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

// To use the Hamcrest Library you need to import the methods.
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    /*
    Assertions are the way to check and validate results in unit tests. However, as tests become
    complex, the simple assertion methods found in the Assert class can make writing and reading the
    unit tests awkward. Further, the assertion methods put much of the onus on the developers to produce
    good quality unit tests. Developers must provide helpful failure messages and they must be very
    type conscious when comparing the expected to the actual.

    The Hamcrest library is an augmenting library to help unit testers create assertions that are easier
    to read and write, provide better failure messages, and provide some type safety. Specifically, the
    library contains a set of predicates called matchers. These matchers are used with the assertThat()
    static method provided in the Assert class.
     */

    // This simple unit tests exemplifies how a test that needs to check for many conditions. In other
    // words a test that needs many asserts can start to become a bit overwhelming, both to read and
    // to write. In this a list of strings must contain the words "dog" and "fox", and must be between
    // 3 and 12 words in length, The assertion check overwhelms this test, and you have to read
    // the test code carefully to see that the words are represented in the assert statements.
    @Test
    public void testWithAsserts() {
        List<String> list = someListProducingMethod();
        assertTrue(list.contains("dog"));
        assertTrue(list.contains("fox"));
        assertTrue(list.size() > 3);
        assertTrue(list.size() < 12);
    }

    // I could condense the assertions all in one call, as I've done in the testWithBigAssert()
    // method. But that doesn't help readability.
    @Test
    public void testWithBigAssert() {
        List<String> list = someListProducingMethod();
        assertTrue(list.contains("dog") && list.contains("fox") && list.size() > 3 && list.size() < 12);
    }

    // Consider the same validation checking using assertThat() with Hamcrest matchers like the
    // The first parameter to the assertThat(), is the actual value, while the parameter to the Hamcrest
    // matcher, like "hasItems()", is the expected value or values.
    // The tests are more readable.
    @Test
    public void testWithHamcrest() {
        List<String> list = someListProducingMethod();
        // Check that the list has "dog" and "fox"
        assertThat(list, (hasItems("dog", "fox")));
        // Check that the list size is both greater than 3 and less than 12.
        assertThat(list, allOf(hasSize(greaterThan(3)), hasSize(lessThan(12))));
    }

    // In the normal assert case, if a failure occurs the default message provided by a JUnit
    // doesn't always lead the developer to quickly recognize the issue. The onus is on you as the
    // developer to leave yourself and others a better error message to convey the what and where
    // of the failure.
    @Test
    public void testFailureWithAsserts() {
        List<String> list = someListProducingMethod();
        assertTrue(list.contains("dog"));
        assertTrue(list.contains("panda"));
        assertTrue(list.size() > 3);
        assertTrue(list.size() < 12);
    }

    // Using the Hamcrest matchers, the error message conveys a lot more details and assists the
    // developer to understand the what and where of the failure.
    @Test
    public void testFailureWithHamcrest() {
        List<String> list = someListProducingMethod();
        assertThat(list, (hasItems("dog", "panda")));
        assertThat(list, allOf(hasSize(greaterThan(3)), hasSize(lessThan(12))));
    }

    // As a Unit test developer, you must make sure that you've considered type when looking at
    // expected and actual objects. Hamcrest matchers allows the developers to easily write tests
    // that mistakenly compare two different types of objects that should likely never be compared.
    // Assert methods don't help developers write meaningful tests. Using assertThat() with
    // Hamcrest matchers type safety is generally checked between actual and expected values.
    @Test
    public void testTypeSafety() {
        //assertThat("123", equalTo(123));
        //assertThat(123, equalTo("123"));
    }

    private List<String> someListProducingMethod() {
        String[] sentence = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        return Arrays.asList(sentence);
    }
}