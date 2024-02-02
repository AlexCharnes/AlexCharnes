package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class DateFashionTests {
    private DateFashion target;

    @Before
    public void setup(){
        target = new DateFashion();
    }
    /*
    returns 2 if one is considered stylish
    returns 0 if one is 2 or less
    returns 1 if both are between 2-8
     */

    @Test
    public void you_is_fashionable_and_date_is_decent(){
        Assert.assertEquals(target.getATable(9, 6), 2);
    }

    @Test
    public void one_is_under_2(){
        Assert.assertEquals(target.getATable(9, 2), 0);
    }
    @Test
    public void both_are_between_2_and_8(){
        Assert.assertEquals(target.getATable(6, 6), 1);
    }

}
