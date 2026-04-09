package app.orders.comparators;

import app.orders.models.Order;

import java.util.Comparator;

public class OrderIdComparer implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        if(o1.getId()>o2.getId())
            return 1;
        else if(o1.getId()<o2.getId())
            return -1;
        else
            return 0;
    }
}
