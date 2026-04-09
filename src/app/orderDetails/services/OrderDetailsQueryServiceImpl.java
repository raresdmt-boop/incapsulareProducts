package app.orderDetails.services;

import app.orderDetails.models.OrderDetails;
import app.orderDetails.repository.OrderDetailsRepository;
import app.orderDetails.repository.OrderDetailsRepositorySingleton;
import app.orderDetails.services.interfaces.OrderDetailsQueryService;
import app.orders.repository.OrderRepositorySingleton;

import java.util.Comparator;
import java.util.List;

public class OrderDetailsQueryServiceImpl implements OrderDetailsQueryService {

    private final OrderDetailsRepository orderDetailsRepository;
    public OrderDetailsQueryServiceImpl() {
        orderDetailsRepository = OrderDetailsRepositorySingleton.getInstance();
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.getAll();
    }

    @Override
    public OrderDetails getBestOrderDetails(Comparator<OrderDetails> cmp) {
        return orderDetailsRepository.getAll()
                .stream()
                .max(cmp)
                .orElse(null);
    }
}
