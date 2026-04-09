package app.products.exceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super(ExceptionConstants.PRODUCT_NOT_FOUND);
    }
}
