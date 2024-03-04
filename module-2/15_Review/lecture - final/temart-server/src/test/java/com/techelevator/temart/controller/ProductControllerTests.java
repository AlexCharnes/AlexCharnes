package com.techelevator.temart.controller;

import com.techelevator.temart.dao.mock.MockInventoryDao;
import com.techelevator.temart.model.Product;
import org.junit.*;
import org.springframework.web.server.ResponseStatusException;

public class ProductControllerTests {

    private ProductsController target;

    @Before
    public void setup() {
        target = new ProductsController( new MockInventoryDao() );
    }

    @Test
    public void get_product_by_sku() {
        Product actualProduct = target.getProductBySku(MockInventoryDao.BOOK_PRODUCT_1.getSku());
        Assert.assertEquals(MockInventoryDao.BOOK_PRODUCT_1, actualProduct);
    }

    @Test
    public void returns_404_when_product_not_found() {
        boolean isException = false;
        try {
            target.getProductBySku("XYZ");
            Assert.fail("Did not return exception");
        }  catch (ResponseStatusException e) {
            isException = true;
        }
        Assert.assertTrue(isException);
    }
}
