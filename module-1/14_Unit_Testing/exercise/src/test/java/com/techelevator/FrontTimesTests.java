package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTests {

    private FrontTimes target;

    @Before
    public void setup(){
        target = new FrontTimes();
    }

    @Test
    public void returns_first_3_letters_of_string_n_copies(){
        Assert.assertEquals(target.generateString("Chocolate", 2), "ChoCho");
    }

    @Test
    public void returns_first_letters_of_string_less_then_3_n_times(){
        Assert.assertEquals(target.generateString("AC", 2), "ACAC");
    }
    @Test
    public void returns_empty_string_when_empty_string_entered(){
        Assert.assertEquals(target.generateString("", 2), "");
    }
}
