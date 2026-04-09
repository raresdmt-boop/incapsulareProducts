package app.orders.services;

import app.orders.exceptions.OrderNotFound;
import app.orders.models.Order;
import app.orders.repository.OrderRepository;
import app.orders.repository.OrderRepositorySingleton;
import app.orders.services.interfaces.OrderQueryService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OrderQueryServiceImpl implements OrderQueryService {

    OrderRepository orderRepository;

    public OrderQueryServiceImpl() {
        this.orderRepository = OrderRepositorySingleton.getInstance();
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.getAll();
    }

    @Override
    public Order getOrderbyID(int id) throws OrderNotFound {
        Optional<Order> orderOptional =  orderRepository.findById(id);
        if(orderOptional.isEmpty()) {
            throw new OrderNotFound();
        }
        return orderRepository.getOrderById(id);
    }

    @Override
    public Order getBestOrder(Comparator<Order> comparator) {
        return orderRepository.getAll().stream().max(comparator).get();
    }

    @Override
    public double getTotal() {
        List<Order> orders = orderRepository.getAll();
        double total = 0;
        for(Order order : orders) {
            total+=order.getAmount();
        }
        return total;
    }

}
