package app.products.exceptions;

public class BasketQuantityCannotExceedProductStock extends RuntimeException {
    public BasketQuantityCannotExceedProductStock() {
        super(ExceptionConstants.BASKET_QUANTITY_CANNOT_EXCEED_PRODUCT_STOCK);
    }
}
