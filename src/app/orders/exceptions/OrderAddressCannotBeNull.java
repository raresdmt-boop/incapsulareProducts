package app.orders.exceptions;

public class OrderAddressCannotBeNull extends RuntimeException {
    public OrderAddressCannotBeNull() {
        super(ExceptionConstants.ORDER_ADDRESS_CANNOT_BE_NULL);
    }
}
