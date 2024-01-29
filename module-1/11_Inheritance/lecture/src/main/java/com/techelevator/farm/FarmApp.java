package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class FarmApp {

    public static void main(String[] args) {

        Cow cow = new Cow();
        Chicken chicken = new Chicken();
        FarmAnimal pig = new Pig();

        FarmAnimal chickenAsFarmAnimal = chicken;
        Pig pigAsPig = (Pig) pig;

        List<FarmAnimal> farmAnimals = new ArrayList<FarmAnimal>();
        farmAnimals.add(cow);
        farmAnimals.add(chicken);
        farmAnimals.add(pig);

        whatDoesTheAnimalsSay(farmAnimals);

    }




    public static void whatDoesTheAnimalsSay(List<FarmAnimal> animals) {

        for (FarmAnimal animal : animals){
            System.out.println("The " + animal.getName() + " says " + animal.getSound());
        }
    }
}
