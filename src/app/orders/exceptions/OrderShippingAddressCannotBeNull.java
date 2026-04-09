package app.orders.exceptions;

public class OrderShippingAddressCannotBeNull extends RuntimeException {
    public OrderShippingAddressCannotBeNull() {
        super(ExceptionConstants.ORDER_SHIPPING_ADDRESS_CANNOT_BE_NULL);
    }
}
