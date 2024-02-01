package com.techelevator.exercises;
import org.junit.*;
public class SleepInTests {

    /*
    Create a variable to reference the object being tested
     */
    private SleepIn target;

    /*
    Create a method with the @Before annotation that instantiates the
    class being tested
     */
    @Before
    public void setup(){
        target = new SleepIn();
    }

    @After
    public void cleanup(){
        System.out.println("Do not need after for these tests");
    }

    /*
    It is not common to need a after method.
     */



    /*
    Tests - figure out what you are going to test - what input you will
    give the method and what output you expect for that input
     */
    /*
    Write one method for each text that is public void name()
    that has the @Test annotation
     */
    @Test
    public void sleep_in_when_weekday_and_on_vacation(){
        //Arrange ( not always needed )
        //Act ( The test )
        boolean didSleepIn = target.sleepIn(true, true);
        //Assert ( Verify result )
        Assert.assertTrue( didSleepIn );
    }

    @Test
    public void sleep_in_when_weekday_and_not_on_vacation(){
        boolean didSleepIn = target.sleepIn(true, false);

        Assert.assertFalse(didSleepIn);
    }

    @Test
    public void sleep_in_when_weekend_and_on_vacation(){
        Assert.assertTrue(target.sleepIn(false, true));
    }

    @Test
    public void sleep_in_when_weekend_and_not_on_vacation(){
        Assert.assertTrue(target.sleepIn(false, false));

    }

}
