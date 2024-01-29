package com.techelevator;

public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        /*
            super() calls the constructor of the superclass
         */
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;

        if (getHighBid().getBidAmount() < buyoutPrice) {
            if (offeredBid.getBidAmount() >= buyoutPrice) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            /*
                super.method() calls a superclass version of a method
                even if there is an Override
             */
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }

    public int getBuyoutPrice() {
        return buyoutPrice;
    }
}
