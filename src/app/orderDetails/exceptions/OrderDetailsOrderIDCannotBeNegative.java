package app.orderDetails.exceptions;

public class OrderDetailsOrderIDCannotBeNegative extends RuntimeException {
    public OrderDetailsOrderIDCannotBeNegative() {
        super(ExceptionConstants.ORDER_DETAILS_ORDER_ID_CANNOT_BE_NEGATIVE);
    }
}
