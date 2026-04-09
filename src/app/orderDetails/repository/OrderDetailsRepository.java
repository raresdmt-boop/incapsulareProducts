package app.orderDetails.repository;

import app.orderDetails.dtos.OrderDetailsRequest;
import app.orderDetails.models.OrderDetails;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsRepository {

    Optional<OrderDetails> findById(int id);

    List<OrderDetails> getAll();

    OrderDetails saveOrderDetails(OrderDetails orderDetails);

    OrderDetails deleteOrderDetails(int id);

    OrderDetails updateOrderDetails(int id, OrderDetailsRequest orderDetailsRequest);

}
