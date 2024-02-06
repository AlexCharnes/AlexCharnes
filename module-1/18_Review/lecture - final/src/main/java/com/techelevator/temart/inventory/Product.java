package com.techelevator.temart.inventory;

public abstract class Product {
    private final static double BASE_SHIPPING_COST = 2.50;
    private String sku;
    private String name;
    private double price;
    private int weightInLbs;

    private String description;

    private boolean isPerishable = false;
    private boolean isTaxable = true;


    public Product(String sku) {
        this.sku = sku;
    }

    public Product(String sku, String name, double price, int weightInLbs) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.weightInLbs = weightInLbs;
        this.description = "";
    }

    public double getShippingCost() {
        double shippingCost = BASE_SHIPPING_COST;

        if (weightInLbs > 5 && weightInLbs <= 10) {
            shippingCost *= 2;
        } else if (weightInLbs > 10) {
            shippingCost *= 4;
        }

        if (isPerishable) {
            shippingCost *= 2;
        }

        return shippingCost;
    }

    public double getTotalCostWithShipping() {
        return price + getShippingCost();
    }

    public String getSku() {
        return sku;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeightInLbs() {
        return weightInLbs;
    }

    public void setWeightInLbs(int weightInLbs) {
        this.weightInLbs = weightInLbs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }

    public boolean isTaxable() {
        return isTaxable;
    }

    public void setTaxable(boolean taxable) {
        isTaxable = taxable;
    }
}
