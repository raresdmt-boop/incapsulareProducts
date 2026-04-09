package app.orders.comparators;

import app.orders.models.Order;

import java.util.Comparator;

public class OrderDateComparer implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getOrderDate().compareTo(o2.getOrderDate());
    }
}
