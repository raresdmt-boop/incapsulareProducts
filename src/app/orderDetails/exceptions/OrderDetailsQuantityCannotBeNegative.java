package app.orderDetails.exceptions;

public class OrderDetailsQuantityCannotBeNegative extends RuntimeException {
    public OrderDetailsQuantityCannotBeNegative() {
        super(ExceptionConstants.ORDER_DETAILS_QUANTITY_CANNOT_BE_NEGATIVE);
    }
}
