package com.mycompany.example.myapplication;

import com.mycompany.example.myapplication.categories.ContactIntegrationTests;
import com.mycompany.example.myapplication.categories.FastTests;
import com.mycompany.example.myapplication.categories.InAppPurchaseTests;
//import com.mycompany.example.myapplication.categories.SlowTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

@Category(FastTests.class)
public class SimpleMathTest {

    SimpleMath sm;

    @Before
    public void setup() {
        sm = new SimpleMath();
    }

    @Test
    //@Category(FastTests.class)
    public void testAdd() {
        assertEquals("SimpleMath addition not adding correctly", 9, sm.add(4, 5));
    }

    @Test
    //@Category(SlowTests.class)
    @Category({InAppPurchaseTests.class, ContactIntegrationTests.class})
    public void testDiff() {
        assertEquals("SimpleMath diff not subtracting correctly", 5, sm.diff(12, 7));
    }

}
