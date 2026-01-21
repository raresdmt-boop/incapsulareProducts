package app;

import app.orderDetails.OrderDetails;
import app.orderDetails.OrderDetailsService;
import app.orders.Order;
import app.orders.OrderService;
import app.products.Product;
import app.products.ProductService;
import app.system.basket.ProductDto;
import app.view.ProductsView;

public class Application {

    static void main() {

        ProductsView productsView = new ProductsView();
        productsView.play();

    }
}
