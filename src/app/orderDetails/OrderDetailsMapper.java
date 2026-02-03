package app.orderDetails;

import app.system.basket.ProductDto;

public class OrderDetailsMapper {

    public static void test() {
        System.out.println("ceva");
    }


    public static OrderDetails OrderDetailsFromProductDto(ProductDto product, int orderID) {
        return new OrderDetails(orderID, product.getProductId(), product.getProductPrice(), product.getProductQuantity());
    }


}
