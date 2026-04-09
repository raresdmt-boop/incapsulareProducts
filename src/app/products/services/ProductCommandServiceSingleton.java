package app.products.services;

import app.products.services.interfaces.ProductCommandService;

public class ProductCommandServiceSingleton {

    private static ProductCommandService instance = new ProductCommandServiceImpl();
    public static ProductCommandService getInstance() {
        return instance;
    }

}
