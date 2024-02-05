package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Tests {

    private Less20 target;
    @Before
    public void Setup(){
        target = new Less20();
    }

    /*
    Tests
    return true if variable is 1 or 2 less then a multiple of 20
    return false if variable is 1-2 more then a multiple of 20
    return false if variable is more then 2 less then multiple of 20
    return false if variable is a multiple of 20
     */

    @Test
    public void returns_true_if_variable_is_1_or_2_less_then_multiple_of_twenty(){
        Assert.assertTrue(target.isLessThanMultipleOf20(19));
    }

    @Test
    public void returns_false_if_variable_is_1_or_2_more_then_multiple_of_twenty(){
        Assert.assertFalse(target.isLessThanMultipleOf20(22));
    }

    @Test
    public void returns_false_if_variable_is_more_then_2_over_the_multiple_of_twenty(){
        Assert.assertFalse(target.isLessThanMultipleOf20(16));
    }

    @Test
    public void returns_false_if_variable_is_a_multiple_of_twenty(){
        Assert.assertFalse(target.isLessThanMultipleOf20(20));
    }
}
