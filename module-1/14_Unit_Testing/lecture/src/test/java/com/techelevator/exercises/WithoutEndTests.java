package com.techelevator.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WithoutEndTests {
    private WithoutEnd target;

    @Before
    public void setupBeforeTest(){
        target = new WithoutEnd();
    }
    /*
Hello -> ell
abc -> b
ab -> ""
"" -> ""
null -> ""
a -> ""
 */

    @Test
    public void returns_ell_with_hello(){

        String exepectedValue = "ell";
        String actualResult = target.withoutEnd("Hello");

        Assert.assertEquals(exepectedValue, actualResult);
    }

    @Test
    public void returns_empty_with_empty_string(){
        //arrange
        //act and assert
        String actualResult = target.withoutEnd("");

        Assert.assertEquals("", actualResult);
    }

    @Test
    public void returns_empty_string_with_null(){
        String actualResult = target.withoutEnd(null);

        Assert.assertEquals("",actualResult);
    }
}
