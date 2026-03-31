package app.products.exceptions;

public class ProductDtoQuantityCannotBeNegative extends RuntimeException {
    public ProductDtoQuantityCannotBeNegative() {
        super(ExceptionConstants.PRODUCT_DTO_QUANTITY_CANNOT_BE_NEGATIVE);
    }
}
