package com.techelevator.farm;

public class Chicken extends FarmAnimal {

    public Chicken() {
        super("Chicken", "Cluck");
    }

    public void layEgg() {
        System.out.println("The Chicken Laid an Egg");
    }
}
