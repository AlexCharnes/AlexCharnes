package com.techelevator.temart.dao;

import com.techelevator.temart.inventory.Product;

import java.util.Map;

public interface InventoryDao {

    Map<String, Product> getProducts();
    Product getProductBySku(String sku);

}
