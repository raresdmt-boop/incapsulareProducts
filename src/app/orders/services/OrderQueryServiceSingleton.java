package app.orders.services;

import app.orders.services.interfaces.OrderQueryService;

public class OrderQueryServiceSingleton {

    private static OrderQueryService orderQueryService = new OrderQueryServiceImpl();
    public static OrderQueryService getInstance() {
        return orderQueryService;
    }

}
