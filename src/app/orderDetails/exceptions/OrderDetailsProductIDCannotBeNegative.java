package app.orderDetails.exceptions;

public class OrderDetailsProductIDCannotBeNegative extends RuntimeException {
    public OrderDetailsProductIDCannotBeNegative() {
        super(ExceptionConstants.ORDER_DETAILS_PRODUCT_ID_CANNOT_BE_NEGATIVE);
    }
}
