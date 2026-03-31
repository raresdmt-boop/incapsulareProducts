package app.products.services;

import app.products.request.ProductRequest;
import app.products.exceptions.ProductNotFound;
import app.products.models.Product;
import app.products.repository.ProductRepository;
import app.products.repository.ProductRepositorySingleton;
import app.products.services.interfaces.ProductCommandService;

import java.util.Optional;

public class ProductCommandServiceImpl implements ProductCommandService {

    protected ProductRepository productRepository;
    public ProductCommandServiceImpl() {
        productRepository = ProductRepositorySingleton.getProductRepository();
    }

    @Override
    public Product addProduct(ProductRequest productRequest) throws ProductNotFound {
        return productRepository.saveProduct(new Product(productRequest.getSKU(), productRequest.getName(), productRequest.getPrice(), productRequest.getWeight(),
                productRequest.getDescriptions(), productRequest.getStock()));
    }

    @Override
    public Product updateProduct(int id, ProductRequest productRequest) throws ProductNotFound {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFound();
        }
        return productRepository.updateProduct(id, productRequest);
    }

    @Override
    public Product deleteProduct(int id) throws ProductNotFound {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFound();
        }
        return productRepository.deleteProduct(id);
    }
}
