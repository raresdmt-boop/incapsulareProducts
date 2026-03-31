package app.orderDetails.services.interfaces;


import app.orderDetails.dtos.OrderDetailsRequest;
import app.orderDetails.models.OrderDetails;

public interface OrderDetailsCommandService {

    OrderDetails addOrderDetails(OrderDetailsRequest orderDetailsRequest);
    OrderDetails updateOrderDetails(int id, OrderDetailsRequest orderDetailsRequest);
    OrderDetails deleteOrderDetails(int id);
}
