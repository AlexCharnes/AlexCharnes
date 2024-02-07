package com.techelevator.temart.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Product> products = new HashMap<String, Product>();

    public Inventory() {
        stockInventory();
    }
    private void stockInventory() {

        Product clothing = new Clothing("C01", "T-shirt", 9.99, 1);
        Product grocery = new Grocery("G01", "Soup", 12.45, 6);
        Product homeGood = new HomeGood("H11", "Barbed Wire Lamp", 350.00, 30);
        Product book = new Book("B22", "First Aid for the Reckless", 19.99, 2 );
        book.setDescription("Free with purchase of Barbed Wire Lamp");

        products.put(clothing.getSku(), clothing);
        products.put(grocery.getSku(), grocery);
        products.put(homeGood.getSku(), homeGood);
        products.put(book.getSku(), book);

    }

    public Map<String, Product> getProducts() {
        return this.products;
    }

    public Product getProductBySku(String sku) {
        return products.get(sku);
    }
}
