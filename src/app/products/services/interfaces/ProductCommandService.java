package app.products.services.interfaces;

import app.products.request.ProductRequest;
import app.products.models.Product;

public interface ProductCommandService {

    Product addProduct(ProductRequest productRequest);
    Product updateProduct(int id, ProductRequest productRequest);
    Product deleteProduct(int id);


}
