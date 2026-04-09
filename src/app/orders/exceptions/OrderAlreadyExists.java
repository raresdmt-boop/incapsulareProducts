package app.orders.exceptions;

public class OrderAlreadyExists extends RuntimeException {
    public OrderAlreadyExists() {
        super(ExceptionConstants.ORDER_ALREADY_EXISTS);
    }
}
