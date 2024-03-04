package com.techelevator.temart.services;

import com.techelevator.temart.model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class StoreService {

    private String baseApiUrl;

    public StoreService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    RestTemplate restTemplate = new RestTemplate();



}
