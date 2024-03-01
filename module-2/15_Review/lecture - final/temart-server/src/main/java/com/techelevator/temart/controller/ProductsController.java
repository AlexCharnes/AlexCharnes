package com.techelevator.temart.controller;

import com.techelevator.temart.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.techelevator.temart.dao.InventoryDao;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private InventoryDao inventoryDao;

    public ProductsController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @RequestMapping(path="", method=RequestMethod.GET)
    public List<Product> list() {
        return inventoryDao.getAllProducts();
    }

    @RequestMapping(path="/{sku}", method=RequestMethod.GET)
    public Product getProductBySku(@PathVariable String sku) {
        Product product=  inventoryDao.getProductBySku(sku);
        if (product == null) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }
        return product;
    }
}
