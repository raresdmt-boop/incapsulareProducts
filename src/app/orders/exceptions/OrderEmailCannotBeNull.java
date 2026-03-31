package app.orders.exceptions;

public class OrderEmailCannotBeNull extends RuntimeException {
    public OrderEmailCannotBeNull() {
        super(ExceptionConstants.ORDER_EMAIL_CANNOT_BE_NULL);
    }
}
