package app;

import app.orderDetails.OrderDetails;
import app.orderDetails.OrderDetailsService;
import app.orders.Order;
import app.orders.OrderService;
import app.products.Product;
import app.products.ProductService;
import app.view.ProductsView;

public class Application {

    static void main() {

        ProductsView productsView = new ProductsView();
        productsView.play();

//        ProductService productService = new ProductService();
//        Product produs = productService.getProductByName("Scanner Documente");
//        System.out.println(produs);
    }
}
