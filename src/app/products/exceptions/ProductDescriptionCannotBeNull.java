package app.products.exceptions;

public class ProductDescriptionCannotBeNull extends RuntimeException {
    public ProductDescriptionCannotBeNull() {
        super(ExceptionConstants.PRODUCT_DESCRIPTION_CANNOT_BE_NULL);
    }
}
