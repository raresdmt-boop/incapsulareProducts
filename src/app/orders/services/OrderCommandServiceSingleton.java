package app.orders.services;

import app.orders.services.interfaces.OrderCommandService;

public class OrderCommandServiceSingleton {

    private static OrderCommandService instance = new OrderCommandServiceImpl();
    public static OrderCommandService getInstance() {
        return instance;
    }

}
