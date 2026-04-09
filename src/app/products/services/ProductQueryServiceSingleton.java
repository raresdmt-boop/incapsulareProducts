package app.products.services;

import app.products.services.interfaces.ProductQueryService;

public class ProductQueryServiceSingleton {

    private static ProductQueryService instance = new ProductQueryServiceImpl();
    public static ProductQueryService getInstance() {
        return instance;
    }

}
