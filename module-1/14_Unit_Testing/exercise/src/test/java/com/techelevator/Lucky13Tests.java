package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Tests {
    private Lucky13 target;

    @Before
    public void setup(){
    target = new Lucky13();
    }
    //if does not contain 1 or 3 return true
    //if does not contain 3 return true
    //if array does not contain 1 or 3 return false


    @Test
    public void if_one_or_three_is_found_return_false(){
        Assert.assertFalse( true);
    }


}
