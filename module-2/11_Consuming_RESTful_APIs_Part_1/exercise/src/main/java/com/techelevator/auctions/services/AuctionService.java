package com.techelevator.auctions.services;

import jdk.jfr.consumer.RecordedStackTrace;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {

        // call api here
        Auction[] response = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        return response;
    }

    public Auction getAuction(int id) {
        String url = API_BASE_URL + "/" + id;

        // call api here
        return restTemplate.getForObject(url, Auction.class);
    }

    public Auction[] getAuctionsMatchingTitle(String title) {

        String url = API_BASE_URL + "?title_like=" + title;
        // call api here
        return restTemplate.getForObject(url, Auction[].class);
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        //http://localhost:3000/auctions?currentBid_lte=<*value*>
        String url = API_BASE_URL + "?currentBid_lte=" + price;
        // call api here
        return restTemplate.getForObject(url,Auction[].class);
    }

}
