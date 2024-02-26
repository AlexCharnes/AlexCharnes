package com.techelevator.dao;

import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.dao.JdbcInventoryDao;
import com.techelevator.temart.inventory.Clothing;
import com.techelevator.temart.inventory.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class JdbcInventoryDaoTests extends BaseDaoTests {

    private static final Product PRODUCT_TEST_CLOTHING_1 = new Clothing("C01", "Test Clothing 1", 24.98, 6, "Test Clothing 1 Description", false, true);


    private InventoryDao inventoryDao;

    @Before
    public void setup() {
        inventoryDao = new JdbcInventoryDao(dataSource);
    }

    @Test
    public void get_all_products() {
        Map<String, Product> inventory = inventoryDao.getProducts();
        Assert.assertEquals(5, inventory.size());
        Assert.assertEquals(PRODUCT_TEST_CLOTHING_1, inventory.get(PRODUCT_TEST_CLOTHING_1.getSku()));
    }

    @Test
    public void get_product_by_sku() {
        Product actualProductReturned = inventoryDao.getProductBySku(PRODUCT_TEST_CLOTHING_1.getSku());
        Assert.assertEquals(PRODUCT_TEST_CLOTHING_1, actualProductReturned);
    }


}
