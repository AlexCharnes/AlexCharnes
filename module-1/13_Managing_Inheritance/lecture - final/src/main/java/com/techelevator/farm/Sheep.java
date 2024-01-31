package com.techelevator.farm;

public class Sheep extends FarmAnimal {

    public Sheep() {
        super("Sheep", "Baa!", 125);
    }


    @Override
    public void move() {
        System.out.println("The sheep wanders");
    }
}
