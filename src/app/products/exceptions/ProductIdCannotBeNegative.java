package app.products.exceptions;

public class ProductIdCannotBeNegative extends RuntimeException {
    public ProductIdCannotBeNegative() {
        super(ExceptionConstants.PRODUCT_ID_CANNOT_BE_NEGATIVE);
    }
}
