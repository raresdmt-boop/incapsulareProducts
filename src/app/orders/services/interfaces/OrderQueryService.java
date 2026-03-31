package app.orders.services.interfaces;

import app.orders.models.Order;

import java.util.Comparator;
import java.util.List;

public interface OrderQueryService {

    List<Order> getOrders();
    Order getOrderbyID(int id);
    Order getBestOrder(Comparator<Order> comparator);
    double getTotal();
}
