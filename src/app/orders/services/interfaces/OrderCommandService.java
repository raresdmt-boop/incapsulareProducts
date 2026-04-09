package app.orders.services.interfaces;

import app.orders.dtos.OrderRequest;
import app.orders.models.Order;

public interface OrderCommandService {

    Order addOrder(OrderRequest orderRequest);
    Order deleteOrder(int id);
    Order updateOrder(int id, OrderRequest orderRequest);
}
