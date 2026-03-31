package app.products.services;

import app.products.exceptions.ProductNotFound;
import app.products.models.Product;
import app.products.repository.ProductRepository;
import app.products.repository.ProductRepositorySingleton;
import app.products.services.interfaces.ProductQueryService;

import java.util.Comparator;
import java.util.List;

public class ProductQueryServiceImpl implements ProductQueryService {

    ProductRepository productRepository;
    public ProductQueryServiceImpl() {
        this.productRepository = ProductRepositorySingleton.getProductRepository();
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.getAll();
    }

    @Override
    public Product getBestProduct(Comparator<Product> comparator) {
        List<Product> products = productRepository.getAll();
        Product prod = products.get(0);
        for(Product p : products) {
            if(comparator.compare(p, prod) > 0) {
                prod = p;
            }
        }
        return prod;
    }

    @Override
    public Product findByName(String productName) throws ProductNotFound {
        productRepository.findByName(productName);
        if(productRepository.findByName(productName) == null) {
            throw new ProductNotFound();
        }
        return productRepository.findByName(productName);
    }
}
