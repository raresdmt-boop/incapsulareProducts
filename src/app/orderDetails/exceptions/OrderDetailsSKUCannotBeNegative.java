package app.orderDetails.exceptions;

public class OrderDetailsSKUCannotBeNegative extends RuntimeException {
    public OrderDetailsSKUCannotBeNegative() {
        super(ExceptionConstants.ORDER_DETAILS_SKU_CANNOT_BE_NEGATIVE);
    }
}
