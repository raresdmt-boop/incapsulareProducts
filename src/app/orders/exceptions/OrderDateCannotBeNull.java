package app.orders.exceptions;

public class OrderDateCannotBeNull extends RuntimeException {
    public OrderDateCannotBeNull() {
        super(ExceptionConstants.ORDER_DATE_CANNOT_BE_NULL);
    }
}
