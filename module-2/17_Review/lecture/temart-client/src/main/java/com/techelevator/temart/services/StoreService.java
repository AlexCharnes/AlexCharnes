package com.techelevator.temart.services;

import com.techelevator.temart.model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreService {

    private String baseApiUrl;

    public StoreService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    RestTemplate restTemplate = new RestTemplate();

    public List<Product> getInventory() {
        List<Product> products = new ArrayList<Product>();

        String url = baseApiUrl + "products";

        Product[] productsAsArray = restTemplate.getForObject(url, Product[].class);

        return Arrays.asList(productsAsArray);
    }

    public Product getProductBySku(String sku) {
        // Make the URL
        String url = baseApiUrl + "products/" + sku;
        // Call the API
        return restTemplate.getForObject(url, Product.class);
    }



}
