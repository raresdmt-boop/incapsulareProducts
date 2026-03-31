package app.orderDetails.services;

import app.orderDetails.services.interfaces.OrderDetailsQueryService;

public class OrderDetailsQuerySingleton {

    private static OrderDetailsQueryService orderDetailsQueryService = new OrderDetailsQueryServiceImpl();
    public static OrderDetailsQueryService getInstance() {
        return orderDetailsQueryService;
    }

}
