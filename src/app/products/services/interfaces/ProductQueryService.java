package app.products.services.interfaces;

import app.products.models.Product;

import java.util.Comparator;
import java.util.List;

public interface ProductQueryService {

    List<Product> getProducts();
    Product getBestProduct(Comparator<Product> comparator);
    Product findByName(String productName);




}
