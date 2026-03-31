package app.orders.dtos;

import app.orders.models.Order;

public interface OrderRequestFactory {

    Order createFromOrderRequest(OrderRequest orderRequest);
    Order createFromText(String text);

}
