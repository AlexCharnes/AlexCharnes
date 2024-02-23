package com.techelevator.temart.inventory;

public class HomeGood extends Product {

    public HomeGood(String sku) {
        super(sku);
    }

    public HomeGood(String sku, String name, double price, int weightInLbs) {
        super(sku, name, price, weightInLbs);
    }

    public HomeGood(String sku, String name, double price, int weightInLbs, String description, boolean isPerishable, boolean isTaxable) {
        super(sku, name, price, weightInLbs, description, isPerishable, isTaxable);
    }
}
