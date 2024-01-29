package com.techelevator;

public class Bid {

	private String bidder;
	private int bidAmount;

	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}

	public String getBidder() {
		return bidder;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	@Override
	public String toString() {
		return bidder + " bid $" + bidAmount;
	}

	@Override
	public boolean equals(Object obj) {
		Bid other = (Bid) obj;
		if (this.bidder.equals(other.getBidder()) &&
		this.bidAmount == other.getBidAmount()) {
			return true;
		}
		return false;
	}
}
