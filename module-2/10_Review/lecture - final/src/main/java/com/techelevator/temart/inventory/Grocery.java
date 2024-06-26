package com.techelevator.temart.inventory;

public class Grocery extends Product {

    public Grocery(String sku) {
        super(sku);
        this.setTaxable(false);
    }

    public Grocery(String sku, String name, double price, int weightInLbs, String description, boolean isPerishable, boolean isTaxable) {
        super(sku, name, price, weightInLbs, description, isPerishable, isTaxable);
    }

    public Grocery(String sku, String name, double price, int weightInLbs) {
        super(sku, name, price, weightInLbs);
        this.setTaxable(false);
    }




}
