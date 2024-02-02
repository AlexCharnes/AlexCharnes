package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AnimalGroupNameTests {

    /*
    Tests
    animal name returns the name of the group
    case sensitivity doesn't effect output
    if animal is not found return "unknown"
    if animal name is null return "unknown"
    if string is empty return "unknown"
     */
    private AnimalGroupName target;



    @Before
    public void setup(){

        target = new AnimalGroupName();
    }

    @Test
    public void animal_name_returns_correct_value(){

        Assert.assertEquals(target.getHerd("rhino"), "Crash");
    }

    @Test
    public void different_case_returns_correct_value(){
        Assert.assertEquals(target.getHerd("RHINO"), "Crash");
    }

    @Test
    public void animal_not_found_will_return_unknown(){
        Assert.assertEquals(target.getHerd("penguin"), "unknown");
    }

    @Test
    public void animal_name_null_returns_unknown(){
        Assert.assertEquals(target.getHerd("null"), "unknown");
    }

    @Test
    public void animal_name_empty_returns_unknown(){
        Assert.assertEquals(target.getHerd(""), "unknown");
    }




}
