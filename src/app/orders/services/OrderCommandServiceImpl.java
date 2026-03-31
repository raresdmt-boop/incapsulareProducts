package app.orders.services;

import app.orders.dtos.OrderRequest;
import app.orders.exceptions.OrderNotFound;
import app.orders.models.Order;
import app.orders.repository.OrderRepository;
import app.orders.repository.OrderRepositorySingleton;
import app.orders.services.interfaces.OrderCommandService;

import java.util.Optional;

public class OrderCommandServiceImpl implements OrderCommandService {

    OrderRepository orderRepository;

    public OrderCommandServiceImpl() {
        this.orderRepository = OrderRepositorySingleton.getInstance();
    }

    @Override
    public Order addOrder(OrderRequest orderRequest) {
        return orderRepository.saveOrder(new Order(orderRequest.customerId, orderRequest.amount, orderRequest.shippingAddress,
                orderRequest.orderAddress, orderRequest.orderEmail, orderRequest.orderDate, orderRequest.orderStatus));

    }

    @Override
    public Order deleteOrder(int id) throws OrderNotFound {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) {
            throw new OrderNotFound();
        }
        return orderRepository.deleteOrder(id);
    }

    @Override
    public Order updateOrder(int id, OrderRequest orderRequest) throws OrderNotFound {

        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) {
            throw new OrderNotFound();
        }
        return orderRepository.updateOrder(id, orderRequest);

    }


}
