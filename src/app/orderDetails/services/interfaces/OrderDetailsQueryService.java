package app.orderDetails.services.interfaces;

import app.orderDetails.models.OrderDetails;

import java.util.Comparator;
import java.util.List;

public interface OrderDetailsQueryService {


    List<OrderDetails> getAllOrderDetails();
    OrderDetails getBestOrderDetails(Comparator<OrderDetails> cmp);
}
