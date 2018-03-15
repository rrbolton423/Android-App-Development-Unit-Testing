package com.mycompany.example.myapplication;

import com.mycompany.example.myapplication.categories.FastTests;
import com.mycompany.example.myapplication.categories.GoogleMapsIntegrationTests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by romellbolton on 2/26/18.
 */

// Using the @RunWith and @Suite.SuiteClasses annotation, I'm telling JUnit which
// particular tests, in this case, "SimpleMathTest" and "AnotherTest", should be
// executed with my test suite. Using the categories with the @RunWith is going to
// suggest that I want to eventually suggest which categories as part of those tests
// I want to run.

// TestSuites also help group Tests together. I can use the @IncludeCategory and @ExcludeCategory
// annotations to further stipulate the categories of test methods.
// In this example, I include fast tests and exclude any tests in GoogleMapsIntegrationTests
// category.

// Think of a test suite and categories specified in the test suite as forming logical
// set operations against all the tests. In my example, the suite calls for those tests
// in SimpleMathTest, or AnotherTest, and also in FastTests, but not in GoogleMapsIntegrationTests
// to be executed.

// The @Categories.IncludeCategory() runs only the classes and methods that are
// annotated with either the category given with the @IncludeCategory annotation. It IMPLICITLY
// excludes any other category.

// The @Categories.ExcludeCategory() DOES NOT run the classes and methods that are
// annotated with either the category given with the @ExcludeCategory annotation. It EXPLICITLY
// excludes any other category.

@RunWith(Categories.class)
@Suite.SuiteClasses({SimpleMathTest.class, AnotherTest.class})
@Categories.IncludeCategory({FastTests.class})
@Categories.ExcludeCategory({GoogleMapsIntegrationTests.class})
public class MyTestSuite {
}
