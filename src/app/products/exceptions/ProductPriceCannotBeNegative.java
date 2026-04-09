package app.products.exceptions;

public class ProductPriceCannotBeNegative extends RuntimeException {
    public ProductPriceCannotBeNegative() {
        super(ExceptionConstants.PRODUCT_PRICE_CANNOT_BE_NEGATIVE);
    }
}
