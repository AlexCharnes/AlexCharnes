package com.techelevator.temart.dao;

import com.techelevator.temart.inventory.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileInventoryDao implements InventoryDao {

    private Map<String, Product> products = new LinkedHashMap<>();

    public FileInventoryDao(String inventoryFileName) throws FileNotFoundException {
        stockInventory(inventoryFileName);
    }

    @Override
    public Map<String, Product> getProducts() {
        return this.products;
    }

    @Override
    public Product getProductBySku(String sku) {
        return this.products.get(sku);
    }

    private void stockInventory(String inventoryFileName) throws FileNotFoundException {

        File fileObject = new File(inventoryFileName);

        try (Scanner fileScanner = new Scanner(fileObject)) {

            while (fileScanner.hasNextLine()) {

                String lineFromFile = fileScanner.nextLine();
                String[] partsOfTheLine = lineFromFile.split("\\|");

                Product product = buildProductFromParts(partsOfTheLine);
                products.put(product.getSku(), product);

            }

        }

    }

    private Product buildProductFromParts(String[] partsOfTheLine) {
        Product product = null;

        String productType = partsOfTheLine[0];
        String sku = partsOfTheLine[1];
        String name = partsOfTheLine[2];
        String description = partsOfTheLine[3];
        String price = partsOfTheLine[4];
        String weight = partsOfTheLine[5];

        if (productType.equals("C")) {
            // instantiate a Clothing product
            product = new Clothing(sku);
        } else if (productType.equals("G")) {
            // instantiate a Grocery product
            product = new Grocery(sku);
        } else if (productType.equals("B")) {
            // instantiate a Book product
            product = new Book(sku);
        } else if (productType.equals("H")) {
            // instantiate a HomeGood product
            product = new HomeGood(sku);
        }

        // populate the properties of the product
        product.setName( name );
        product.setDescription( description );
        product.setPrice( Double.parseDouble(price) );
        product.setWeightInLbs( Integer.parseInt(weight) );

        return product;
    }
}
