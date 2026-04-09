package app.products.exceptions;

public class ProductStockCannotBeNegative extends RuntimeException {
    public ProductStockCannotBeNegative() {
        super(ExceptionConstants.PRODUCT_STOCK_CANNOT_BE_NEGATIVE);
    }
}
