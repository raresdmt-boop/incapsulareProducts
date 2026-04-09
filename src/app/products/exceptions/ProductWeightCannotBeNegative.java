package app.products.exceptions;

public class ProductWeightCannotBeNegative extends RuntimeException {
    public ProductWeightCannotBeNegative() {
        super(ExceptionConstants.PRODUCT_WEIGHT_CANNOT_BE_NEGATIVE);
    }
}
