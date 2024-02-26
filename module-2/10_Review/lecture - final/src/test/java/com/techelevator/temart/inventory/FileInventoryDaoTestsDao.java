package com.techelevator.temart.inventory;

import com.techelevator.temart.dao.FileInventoryDao;
import com.techelevator.temart.dao.InventoryDao;
import org.junit.*;

import java.io.FileNotFoundException;
import java.util.Map;

public class FileInventoryDaoTestsDao {

    private static final String INVENTORY_CSV_FILEPATH = "inventory.csv";
    private InventoryDao fileInventory;
    private Product testGroceryProduct;

    @Before
    public void setup() throws FileNotFoundException {
        fileInventory = new FileInventoryDao(INVENTORY_CSV_FILEPATH);
        testGroceryProduct = new Grocery("C02");
        testGroceryProduct.setName("Soup");
        testGroceryProduct.setDescription("This is a lot of soup");
        testGroceryProduct.setPrice(12.45);
        testGroceryProduct.setWeightInLbs(6);
    }

    @Test
    public void class_instantiates_correctly() {

        // Test (Act)
        try {
            InventoryDao fileInventory = new FileInventoryDao(INVENTORY_CSV_FILEPATH);
        } catch (FileNotFoundException e) {
            Assert.fail("Inventory file not found");
        }

    }

    @Test
    public void products_load_from_file() {
        Map<String, Product> productsFromTheFile = fileInventory.getProducts();
        Assert.assertEquals("Wrong number of products loaded",5, productsFromTheFile.size());

        // Get 1 product from the map by sku
        Product productFromInventory = fileInventory.getProductBySku( testGroceryProduct.getSku() );

        Assert.assertEquals(testGroceryProduct, productFromInventory);
    }



}
