package app.products.repository;

public class ProductRepositorySingleton {

    private static ProductRepository productRepository = new ProductRepositoryImpl();
    public static ProductRepository getProductRepository() {
        return productRepository;
    }

}
