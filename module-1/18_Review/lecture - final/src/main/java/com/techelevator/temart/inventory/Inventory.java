package com.techelevator.temart.inventory;

import java.util.Map;

public interface Inventory {

    Map<String, Product> getProducts();
    Product getProductBySku(String sku);

}
