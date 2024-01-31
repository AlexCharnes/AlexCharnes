package com.techelevator.farm;

public class Egg implements Sellable {

    public String getName() {
        return "Egg";
    }
    public int getPrice() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Egg)) {
            return false;
        }
        Egg otherEgg = (Egg) obj;
        return this.getName().equals(otherEgg.getName()) && this.getPrice() == otherEgg.getPrice();
    }
}
