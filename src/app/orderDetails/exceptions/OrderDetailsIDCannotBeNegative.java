package app.orderDetails.exceptions;

public class OrderDetailsIDCannotBeNegative extends RuntimeException {
    public OrderDetailsIDCannotBeNegative() {
        super(ExceptionConstants.ORDER_DETAILS_ID_CANNOT_BE_NEGATIVE);
    }
}
