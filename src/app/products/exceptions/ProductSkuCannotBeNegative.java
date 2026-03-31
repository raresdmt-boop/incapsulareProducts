package app.products.exceptions;

public class ProductSkuCannotBeNegative extends RuntimeException {
    public ProductSkuCannotBeNegative() {
        super(ExceptionConstants.PRODUCT_SKU_CANNOT_BE_NEGATIVE);
    }
}
