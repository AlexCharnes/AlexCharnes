package com.techelevator.farm;

public class MusicBox implements Singable, Sellable {

    public String getSound() {
        return "Lalalalala";
    }
    public String getName() {
        return "Music Box";
    }
    public int getPrice() {
        return 15;
    }
}
