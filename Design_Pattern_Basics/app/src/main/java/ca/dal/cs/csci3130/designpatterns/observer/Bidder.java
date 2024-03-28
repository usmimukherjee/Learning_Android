package ca.dal.cs.csci3130.designpatterns.observer;

public class Bidder extends Observer {

    int bidIncrement;

    public Bidder(Auctioneer auctioneer) {
        this.auctioneer = auctioneer;
        this.auctioneer.attach(this);
    }

    public void setBidIncrement(int bidIncrement) {
        this.bidIncrement = bidIncrement;
    }

    @Override
    public void update(int state) {
        System.out.println("Bidder: Received=" + state + ", New bid=" + (state + bidIncrement));
    }
}
