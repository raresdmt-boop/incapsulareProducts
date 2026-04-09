package app.orderDetails.exceptions;

public class OrderDetailsNotFound extends RuntimeException {
    public OrderDetailsNotFound() {
        super(ExceptionConstants.ORDER_DETAILS_NOT_FOUND);
    }
}
