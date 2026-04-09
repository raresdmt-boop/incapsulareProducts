package app.products.basket;


import app.products.basket.dto.ProductDto;
import app.products.models.Product;

import java.util.List;

public interface BasketInt {
    List<ProductDto> getBasketProducts();
    ProductDto addBasketProduct(ProductDto productDto);
    ProductDto removeBasketProduct(ProductDto productDto);
    ProductDto getDtobyName(String name);


}
