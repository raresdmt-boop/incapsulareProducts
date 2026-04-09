package app.orderDetails.exceptions;

public class OrderDetailsPriceCannotBeNegative extends RuntimeException {
    public OrderDetailsPriceCannotBeNegative() {
        super(ExceptionConstants.ORDER_DETAILS_PRICE_CANNOT_BE_NEGATIVE);
    }
}
