package com.techelevator.farm;

public class Pig extends FarmAnimal {

    public Pig()
    {
        super("Pig", "Oink", 800);
    }

    public void rollInMud() {
        System.out.println("The Pig rolls in the mud");
    }
}
