package app.orders.exceptions;

public class OrderAmountCannotBeNegative extends RuntimeException {
    public OrderAmountCannotBeNegative() {
        super(ExceptionConstants.ORDER_AMOUNT_CANNOT_BE_NEGATIVE);
    }
}
