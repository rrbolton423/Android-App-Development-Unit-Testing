package com.mycompany.example.myapplication;

import com.mycompany.example.myapplication.categories.ContactIntegrationTests;
import com.mycompany.example.myapplication.categories.FastTests;
import com.mycompany.example.myapplication.categories.InAppPurchaseTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

//import com.mycompany.example.myapplication.categories.SlowTests;

// Add all the SimpleMathTest methods into the "FastTests" category
@Category(FastTests.class)
public class SimpleMathTest {

    SimpleMath sm;

    @Before
    public void setup() {
        sm = new SimpleMath();
    }

    // You can also apply test methods to a particular category.
    // Put testAdd() in the FastTests category
    // Test classes and test methods can be in one or more categories.
    // For example, now testAdd() is in the FastCategory by virtue of being in the class
    // that is in the FastTest category
    @Test
    //@Category(FastTests.class)
    public void testAdd() {
        assertEquals("SimpleMath addition not adding correctly", 9, sm.add(4, 5));
    }

    // You can also apply test methods to a particular category.
    // Put testDiff() in the SlowTests category
    // Test classes and test methods can be in one or more categories.
    // testDiff() is now in the InAppPurchaseTests and ContactIntegrationTests category,
    // as well as the FastTests category
    @Test
    @Category({InAppPurchaseTests.class, ContactIntegrationTests.class})
    public void testDiff() {
        assertEquals("SimpleMath diff not subtracting correctly", 5, sm.diff(12, 7));
    }

    /*
    Categories are just labels.
    It's up to you to know and understand the semantic meaning behind your categories.
     */

    /*
    Once you have the categories defined and applied to test cases and/or methods, create a JUnit
    Test suite to suggest the test classes you want executed. Then annotate the test suite with
    indications of which categories of tests to include and exclude.
     */

}
