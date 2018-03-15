package com.mycompany.example.myapplication;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * Created by romellbolton on 2/25/18.
 */

public class ReportTestExecution implements MethodRule {

    /*
    A MethodRule is an alteration in how a test method is run and reported.
    Multiple MethodRules can be applied to a test method. The Statement that executes the method is
    passed to each annotated Rule in turn, and each may return a substitute or modified Statement,
    which is passed to the next Rule, if any.
     */

    // The arguments to apply() are the statement, which represents your test class about to execute
    // at runtime. The method is the unit test method about to be executed. The target is the unit
    // test instance whose test method is yet to be executed.

    // The Statement that executes the method is passed to each annotated Rule in turn, and each
    // may return a substitute or modified Statement , which is passed to the next Rule , if any.

    // In the "modified" Statement we return, we implement what should happen before testing a method (like @Before)
    // then call statement.evaluate(), then implement what should happen after testing a method (like @After)

    // The Statement will be returned to the caller, which will call on its evaluate() method to execute its test
    // along with the before and after parts. i.e, execute the modified statement object

    // Arg 1: The Test class
    // Arg 2: The current method yet to be executed
    // Arg 3: The instance of the object being tested on
    // The apply() method returns the modified Statement that executes the test with the modifications
    @Override
    public Statement apply(final Statement statement, FrameworkMethod method, Object target) {

        // With these first 2 lines of code, I'm getting the name of the Test class, and the
        // test method executing using reflection.
        final String className = method.getMethod().getDeclaringClass().getSimpleName();
        final String methodName = method.getName();

        // Next I need to add the return statement. A call statement.evaluate() actually executes
        // the test, which will be done by JUnit. I create a new instance of Statement and override the
        // evaluate method, so that when JUnit does evaluate the statement, and executes the test,
        // it makes calls to my fake Web Service. That will happen both before and after the test evaluation.

        return new Statement() {
            // In this new Statement object we are returning, I am implementing the evaluate() method,
            // which will be called by JUnit. The evaluate() method will receive the current
            // statement inside of our new Statement object, execute the before code, execute the
            // original / current statement, and then execute the after code,

            @Override
            public void evaluate() throws Throwable {
                // The @Rule says what should happen before and after we execute each test method

                // Print a message before method execution (like @Before)
                System.out.println(String.format("Sending to Web service: about to execute %s's method %s", className, methodName));

                // A call to statement.evaluate() is represented here,
                // actually executes the Test, which will be done by JUnit.
                statement.evaluate();

                // Print a message after method execution (like @After)
                System.out.println(String.format("Sending to Web service: done executing %s's method %s", className, methodName));
            }
        };
    }
}
