package app.products.repository;

import app.products.request.ProductRequest;
import app.products.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(int id);

    List<Product> getAll();

    Product saveProduct(Product product);

    Product deleteProduct(int id);

    Product updateProduct(int id, ProductRequest productRequest);

    Product findByName(String name);


}
