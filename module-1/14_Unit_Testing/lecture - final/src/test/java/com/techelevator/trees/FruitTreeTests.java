package com.techelevator.trees;


/*
    -type of fruit is correct
    -piecesOfFruitLeft starts correct
    -successfully pick fruit
    -0 fruit
    -can't pick more fruit than remaining
    -pick all remaining fruit
    -pick negative fruit
    pick fruit twice
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTests {

    private static final String TYPE_OF_FRUIT = "Apple";
    private static final int STARTING_FRUIT_COUNT = 10;
    private FruitTree fruitTree;

    @Before
    public void setup() {
        fruitTree = new FruitTree(TYPE_OF_FRUIT, STARTING_FRUIT_COUNT);
    }

    @Test
    public void type_of_fruit_is_correct() {
        // Arrange
        // Act
        String typeOfFruitOnTree = fruitTree.getTypeOfFruit();
        // Assert
        Assert.assertEquals(TYPE_OF_FRUIT, typeOfFruitOnTree);
    }

    @Test
    public void tree_starts_with_correct_number_of_fruit() {
        Assert.assertEquals(STARTING_FRUIT_COUNT, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void can_pick_fruit_successfully() {
        // Act
        boolean wasFruitPicked = fruitTree.pickFruit(4);
        // Assert
        Assert.assertTrue("Expected True but returned false",wasFruitPicked);
        Assert.assertEquals("Wrong number of fruit left on tree", 6, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_zero_fruit() {
        boolean wasFruitPicked = fruitTree.pickFruit(0);
        Assert.assertTrue(wasFruitPicked);
        Assert.assertEquals(STARTING_FRUIT_COUNT, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_too_many_fruit() {
        Assert.assertFalse( fruitTree.pickFruit(11));
        Assert.assertEquals(STARTING_FRUIT_COUNT, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_all_remaining_fruit() {
        Assert.assertTrue( fruitTree.pickFruit(STARTING_FRUIT_COUNT));
        Assert.assertEquals(0, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_negative_fruit() {
        Assert.assertFalse( fruitTree.pickFruit(-1));
        Assert.assertEquals(STARTING_FRUIT_COUNT, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_fruit_twice() {
        // Arrange
        fruitTree.pickFruit(2);
        // Act
        boolean wasSuccessful = fruitTree.pickFruit(5);
        // Assert
        Assert.assertTrue(wasSuccessful);
        Assert.assertEquals(3, fruitTree.getPiecesOfFruitLeft());
    }
}
