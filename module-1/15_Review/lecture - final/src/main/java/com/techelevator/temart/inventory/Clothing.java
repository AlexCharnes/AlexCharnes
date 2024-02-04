package com.techelevator.temart.inventory;

public class Clothing extends Product {

    public Clothing(String sku) {
        super(sku);
    }

    public Clothing(String sku, String name, double price, int weightInLbs) {
        super(sku, name, price, weightInLbs);
    }
}
