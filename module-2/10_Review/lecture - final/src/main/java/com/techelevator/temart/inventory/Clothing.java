package com.techelevator.temart.inventory;

public class Clothing extends Product {

    public Clothing(String sku) {
        super(sku);
    }

    public Clothing(String sku, String name, double price, int weightInLbs) {
        super(sku, name, price, weightInLbs);
    }

    public Clothing(String sku, String name, double price, int weightInLbs, String description, boolean isPerishable, boolean isTaxable) {
        super(sku, name, price, weightInLbs, description, isPerishable, isTaxable);
    }
}
