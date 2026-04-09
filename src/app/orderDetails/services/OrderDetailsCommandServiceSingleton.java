package app.orderDetails.services;

import app.orderDetails.services.interfaces.OrderDetailsCommandService;

public class OrderDetailsCommandServiceSingleton {

    private static OrderDetailsCommandService orderDetailsCommandService = new OrderDetailsCommandServiceImpl();
    public static OrderDetailsCommandService getInstance() {
        return orderDetailsCommandService;
    }

}
