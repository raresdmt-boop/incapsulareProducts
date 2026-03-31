package app.orders.exceptions;

public class OrderCustomerIDCannotBeNull extends RuntimeException {
    public OrderCustomerIDCannotBeNull() {
        super(ExceptionConstants.ORDER_CUSTOMER_ID_CANNOT_BE_NULL);
    }
}
