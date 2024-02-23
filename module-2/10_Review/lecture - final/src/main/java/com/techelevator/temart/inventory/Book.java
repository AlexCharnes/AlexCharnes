package com.techelevator.temart.inventory;

public class Book extends Product {
    public Book(String sku) {
        super(sku);
    }

    public Book(String sku, String name, double price, int weightInLbs) {
        super(sku, name, price, weightInLbs);
    }

    public Book(String sku, String name, double price, int weightInLbs, String description, boolean isPerishable, boolean isTaxable) {
        super(sku, name, price, weightInLbs, description, isPerishable, isTaxable);
    }

    @Override
    public double getShippingCost() {
        double originalShippingCost = super.getShippingCost();
        // Should be media shipping cost??
        double mediaShoppingCost = originalShippingCost * .75;
        return mediaShoppingCost;
    }
}
