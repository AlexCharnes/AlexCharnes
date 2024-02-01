package com.techelevator.exercises;

/*
    1) import org.junit.*
 */
import org.junit.*;
public class SleepInTests {

    /*
        2) Create a variable to reference the object being tests
     */
    private SleepIn target;

    /*
        3) Create a method with the @Before annotation that
           instantiates the class being tested

           The method with the @Before annotation will be run before
           EVERY test

            Having a method with the @Before annotation is optional
     */
    @Before
    public void setup() {
        target = new SleepIn();
    }

    /*
        It is not common to need an @After method, it is here in this
        class just for demonstration.

        The method with @After annotation will be run after EVERY test

        Having a method with the @After annotation is optional
     */
    @After
    public void cleanup() {
        System.out.println("We don't need the after for these tests");
    }

    /*
        4) Figure out what you are going to tests - what input you will
           give the method and what output you expect for that input

        Tests
        weekday     vacation    result
        true        true        true
        true        false       false
        false       true        true
        false       false       true
     */

    /*
        5) Write one method for each test that is public void name()
          that has the @Test annotation
     */
    @Test
    public void sleep_in_when_weekday_and_on_vacation() {
        // Arrange  (setup for the test - not always needed)
        // Act (the test)
        boolean didSleepIn = target.sleepIn(true, true);
        // Assert (verify the result)
        Assert.assertTrue( didSleepIn );
    }

    @Test
    public void sleep_in_when_weekday_and_not_on_vacation() {
        // Arrange
        // Act
        boolean didSleepIn = target.sleepIn(true, false);
        // Assert
        Assert.assertFalse( didSleepIn );
    }

    @Test
    public void sleep_in_when_weekend_and_on_vacation() {
        Assert.assertTrue( target.sleepIn(false, true) );
    }

    @Test
    public void sleep_in_when_weekend_and_not_on_vacation() {
        Assert.assertTrue("This message will be displayed if the test fails", target.sleepIn(false, false) );
    }


}
