package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {

        // 2) Instantiate an HttpHeaders
        HttpHeaders httpHeaders = new HttpHeaders();
        // 3) Set the ContentType to application/json
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 4) Instantiate an HttpEntity<T> T - the data type to serialize into the message body JSON
        //        new HttpEntity<T>(object to serialize, headers)
        HttpEntity<Auction> httpRequest = new HttpEntity<Auction>(newAuction, httpHeaders);

        Auction returnedAuction = null;
        try {
            returnedAuction = restTemplate.postForObject(API_BASE_URL, httpRequest, Auction.class);
        } catch (ResourceAccessException e) {
            // Cannot connect to the server
            BasicLogger.log("Unable to connect to server: " + e.getMessage());
        } catch (RestClientResponseException e) {
            // Response from server, but was an error code
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }

        return returnedAuction;
        // place code here

    }

    public boolean update(Auction updatedAuction) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> requestEntity = new HttpEntity<Auction>(updatedAuction, httpHeaders);

        boolean isSuccessful = false;
        try {
            restTemplate.put(API_BASE_URL + "/" + updatedAuction.getId(), requestEntity);
            isSuccessful = true;
        } catch (ResourceAccessException e) {
            BasicLogger.log("Can not connect to server");
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }

        return isSuccessful;
        // place code here

    }

    public boolean delete(int auctionId) {
        RestTemplate restTemplate = new RestTemplate();
        boolean isSuccessful = false;

        try {
            restTemplate.delete(API_BASE_URL + "/" + auctionId);
            isSuccessful = true;
        } catch (ResourceAccessException e) {
            BasicLogger.log("Cannot connect to server");
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getMessage());
        }
        // place code here
        return isSuccessful;
    }



    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + "/" + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
