package com.techelevator.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    Hello -> ell
    abc  ->  b
    ab  ->  ""
    "" -> ""
    null -> ""
    a -> ""
 */
public class WithoutEndTests {

    private WithoutEnd target;

    @Before
    public void setupBeforeTest() {
        target = new WithoutEnd();
    }

    @Test
    public void returns_ell_with_hello() {
        // Arrange
        String expectedValue = "ell";
        // Act
        String actualResult = target.withoutEnd("Hello");
        // Assert
        Assert.assertEquals(expectedValue, actualResult);
    }

    @Test
    public void returns_empty_for_empty_string() {
        // Arrange
        // Act
        String actualResult = target.withoutEnd("");
        // Assert
        Assert.assertEquals("", actualResult);
    }

    @Test
    public void returns_empty_string_when_null() {
        // Act
        String actualResult = target.withoutEnd(null);
        // Assert
        Assert.assertEquals("", actualResult);
    }
}
