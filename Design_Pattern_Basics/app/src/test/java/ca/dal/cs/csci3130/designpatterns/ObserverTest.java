package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.observer.Auctioneer;
import ca.dal.cs.csci3130.designpatterns.observer.Bidder;

public class ObserverTest {

    @Test
    public void testObserverPattern() {
        Auctioneer auctioneer = new Auctioneer();
        Bidder one = new Bidder(auctioneer);
        one.setBidIncrement(10);

        Bidder two = new Bidder(auctioneer);
        two.setBidIncrement(20);

        Bidder three = new Bidder(auctioneer);
        three.setBidIncrement(15);

        System.out.println("First Bid");
        auctioneer.setState(100);

        System.out.println("Second Bid");
        auctioneer.setState(120);

    }

}
