package com.techelevator.farm;

/*
 The final keyword prevents other classes from extending this
 class as a superclass
 */
public final class FarmCat extends FarmAnimal {

    public FarmCat() {
        super("Cat", "Meow", 0);
    }

    @Override
    public void move() {
        System.out.println("The cat pounces");
    }

    /*
        This method cannot be Overriden because it is final
     */
//    @Override
//    public String getSound() {
//        return "MEOW!!!!";
//    }
}
