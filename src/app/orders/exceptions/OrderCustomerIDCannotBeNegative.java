package app.orders.exceptions;

public class OrderCustomerIDCannotBeNegative extends RuntimeException {
    public OrderCustomerIDCannotBeNegative() {
        super(ExceptionConstants.ORDER_CUSTOMER_ID_CANNOT_BE_NEGATIVE);
    }
}
