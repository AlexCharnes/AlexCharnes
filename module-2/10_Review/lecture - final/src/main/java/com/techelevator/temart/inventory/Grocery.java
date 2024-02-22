package com.techelevator.temart.inventory;

public class Grocery extends Product {

    public Grocery(String sku) {
        super(sku);
        this.setTaxable(false);
    }

    public Grocery(String sku, String name, double price, int weightInLbs) {
        super(sku, name, price, weightInLbs);
        this.setTaxable(false);
    }




}
