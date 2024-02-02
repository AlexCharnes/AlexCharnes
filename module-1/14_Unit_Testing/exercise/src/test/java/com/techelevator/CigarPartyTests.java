package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTests {
    private CigarParty target;

    @Before
    public void setup(){
        target = new CigarParty();
    }
    /*
    Tests
    number of cigars is less then 40 on a weekday
    number of cigars is between 40-60 on a weekday
    number of cigars is above 60 on a weekday
    number of cigars is over 60 on weekend
    number of cigars is under 40 on weekend
     */

    @Test
    public void cigars_are_less_then_40_on_weekday(){
        Assert.assertFalse(target.haveParty(30, false));
    }

    @Test
    public void cigars_are_within_range_on_weekday(){
        Assert.assertTrue(target.haveParty(45, false));
    }

    @Test
    public void cigars_are_above_60_on_weekday(){
        Assert.assertFalse(target.haveParty(75, false));
    }

    @Test
    public void cigars_are_above_60_on_weekend(){
        Assert.assertTrue(target.haveParty(75, true));
    }
    @Test
    public void cigars_are_under_range_on_weekend(){
        Assert.assertFalse(target.haveParty(30, true));
    }
}
