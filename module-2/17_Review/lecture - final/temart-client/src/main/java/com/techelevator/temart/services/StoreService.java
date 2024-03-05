package com.techelevator.temart.services;

import com.techelevator.temart.model.AuthenticatedUser;
import com.techelevator.temart.model.Product;
import com.techelevator.temart.model.Wishlist;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreService {

    private String baseApiUrl;
    private AuthenticatedUser currentUser;
    private RestTemplate restTemplate = new RestTemplate();

    public StoreService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    public void setCurrentUser(AuthenticatedUser currentUser){
        this.currentUser = currentUser;
    }

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

    public Wishlist crateWishlist(String wishlistName) {
        String url = baseApiUrl + "wishlists";
        Wishlist returnedWishlist = null;

        // 1) Build a Header
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 2) Create a Http entity
        Wishlist newWishlist = new Wishlist();
        newWishlist.setName(wishlistName);
        HttpEntity<Wishlist> entity = new HttpEntity<Wishlist>(newWishlist, headers);

        // 3) Use Exchange to POST and get back a ResponseEntity
        ResponseEntity<Wishlist> response = restTemplate.exchange(url, HttpMethod.POST, entity, Wishlist.class);
        // 4) Get the created Wishlist from the Body
        returnedWishlist = response.getBody();

        return returnedWishlist;
    }



}
