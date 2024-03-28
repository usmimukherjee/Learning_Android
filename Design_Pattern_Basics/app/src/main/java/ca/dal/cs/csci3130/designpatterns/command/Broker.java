package ca.dal.cs.csci3130.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {

    List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        this.orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : this.orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
