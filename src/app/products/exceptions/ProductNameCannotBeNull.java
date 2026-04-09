package app.products.exceptions;

public class ProductNameCannotBeNull extends RuntimeException {
    public ProductNameCannotBeNull() {
        super(ExceptionConstants.PRODUCT_NAME_CANNOT_BE_NULL);
    }
}
