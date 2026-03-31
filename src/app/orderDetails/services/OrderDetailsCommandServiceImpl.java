package app.orderDetails.services;


import app.orderDetails.dtos.OrderDetailsRequest;
import app.orderDetails.exceptions.OrderDetailsNotFound;
import app.orderDetails.models.OrderDetails;
import app.orderDetails.repository.OrderDetailsRepository;
import app.orderDetails.repository.OrderDetailsRepositorySingleton;
import app.orderDetails.services.interfaces.OrderDetailsCommandService;

import java.util.Optional;

public class OrderDetailsCommandServiceImpl implements OrderDetailsCommandService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsCommandServiceImpl() {
        this.orderDetailsRepository = OrderDetailsRepositorySingleton.getInstance();
    }

    @Override
    public OrderDetails addOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        return orderDetailsRepository.saveOrderDetails(new OrderDetails(orderDetailsRequest.getOrderID(), orderDetailsRequest.getProductID(),
                orderDetailsRequest.getPrice(), orderDetailsRequest.getSku(), orderDetailsRequest.getQuantity()));
    }

    @Override
    public OrderDetails updateOrderDetails(int id, OrderDetailsRequest orderDetailsRequest) throws OrderDetailsNotFound {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepository.findById(id);
        if (orderDetailsOptional.isEmpty()) {
            throw new OrderDetailsNotFound();
        }
        return orderDetailsRepository.updateOrderDetails(id, orderDetailsRequest);
    }

    @Override
    public OrderDetails deleteOrderDetails(int id) throws OrderDetailsNotFound {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepository.findById(id);
        if (orderDetailsOptional.isEmpty()) {
            throw new OrderDetailsNotFound();
        }
        return orderDetailsRepository.deleteOrderDetails(id);
    }
}
