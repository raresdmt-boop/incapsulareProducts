package app.orders.exceptions;

public class OrderStatusCannotBeNull extends RuntimeException {
  public OrderStatusCannotBeNull() {
    super(ExceptionConstants.ORDER_STATUS_CANNOT_BE_NULL);
  }
}
