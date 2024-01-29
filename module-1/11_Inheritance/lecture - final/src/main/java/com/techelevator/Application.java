package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Bid ourBid = new Bid("TestName", 10);
        System.out.println( ourBid.toString() );

        Bid bidTwo = new Bid("TestName", 10);

        if (ourBid.equals(bidTwo)) {
            System.out.println("They are the same bid");
        } else {
            System.out.println("They are not the same bid");
        }


        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        BuyoutAuction buyoutAuction = new BuyoutAuction("Book", 25);

        buyoutAuction.placeBid(new Bid("Steve", 10));
        buyoutAuction.placeBid(new Bid("Rachelle", 20));
        System.out.println(  buyoutAuction.getHighBid() );


        ReserveAuction reserveAuction = new ReserveAuction("Stanley", 100);
        reserveAuction.placeBid(new Bid("John", 25));
        reserveAuction.placeBid(new Bid("Rachelle", 125));


        // Upcasting is going from subclass to a superclass.  It is implicit because
        // it is not possible a subclass to not be able to be its superclass
        Auction reserveAuctionAsAuction = reserveAuction;

        Object reserveAuctionAsObject = reserveAuction;

        // Downcasting is from a superclass to a subclass.  It is explicit, because
        // a superclass may have many subclasses and it is possible it is not the right type.
        ReserveAuction backToReserveAuction = (ReserveAuction) reserveAuctionAsObject;

        List<Auction> auctions = new ArrayList<Auction>();
        auctions.add(generalAuction);
        auctions.add(buyoutAuction);
        auctions.add(reserveAuction);

        for (Auction auction : auctions) {
            auction.placeBid(new Bid("Rachelle", 50));
        }

    }
}
