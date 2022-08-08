package pl.pjatk.Mediator;

import java.util.ArrayList;

public class AuctionMediator implements Mediator{
    private ArrayList<Buyer> buyers;

    public AuctionMediator() {
        this.buyers = new ArrayList<Buyer>();
    }

    @Override
    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
        System.out.println(buyer.name + " was added to the buyer list.");
    }

    @Override
    public void findHighestBidder() {
        int maxBid = 0;
        Buyer winner = null;

        for(Buyer b : buyers){
            if (b.price > maxBid){
                maxBid = b.price;
                winner = b;
            }
            b.auctionHasEnded();
        }

        System.out.println("The auction winner is " + winner.name + ". He paid " + winner.price + "$ for the item.");
    }
}
