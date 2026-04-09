package app.products.services.interfaces;

import app.products.models.Product;
import app.products.request.ProductRequest;

public interface ProductCommandService {

    Product addProduct(ProductRequest productRequest);
    Product updateProduct(int id, ProductRequest productRequest);
    Product deleteProduct(int id);


}
