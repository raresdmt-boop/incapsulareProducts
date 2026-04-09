package app.orders.repository;

import app.orders.dtos.OrderRequest;
import app.orders.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(int id);

    List<Order> getAll();

    Order saveOrder(Order order);

    Order deleteOrder(int id);

    Order updateOrder(int id, OrderRequest orderRequest);

    Order getOrderById(int id);

}
