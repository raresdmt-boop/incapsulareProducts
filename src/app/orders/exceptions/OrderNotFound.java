package app.orders.exceptions;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound() {
        super(ExceptionConstants.ORDER_NOT_FOUND);
    }
}
