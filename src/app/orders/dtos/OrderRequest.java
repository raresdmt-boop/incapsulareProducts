package app.orders.dtos;


import app.orders.exceptions.*;
import app.orders.models.Order;

import java.time.LocalDate;
import java.util.Objects;

public class OrderRequest implements OrderRequestFactory{

    public int customerId;
    public double amount;
    public String shippingAddress;
    public String orderAddress;
    public String orderEmail;
    public LocalDate orderDate;
    public String orderStatus;

    public OrderRequest(int customerId, double amount, String shippingAddress,
                        String orderAddress, String orderEmail, LocalDate orderDate, String orderStatus) {
        setCustomerId(customerId);
        setAmount(amount);
        setShippingAddress(shippingAddress);
        setOrderAddress(orderAddress);
        setOrderEmail(orderEmail);
        setOrderDate(orderDate);
        setOrderStatus(orderStatus);
    }
    public OrderRequest(String line) {
        String [] props = line.split(",");
        setCustomerId(Integer.parseInt(props[0]));
        setAmount(Double.parseDouble(props[1]));
        setShippingAddress(props[2]);
        setOrderAddress(props[3]);
        setOrderEmail(props[4]);
        setOrderDate(LocalDate.parse(props[5]));
        setOrderStatus(props[6]);
    }

    @Override
    public String toString() {
        return getCustomerId()+","+getAmount()+","+getShippingAddress()+","+getOrderAddress() +","+
                getOrderEmail()+","+getOrderDate() +","+getOrderStatus();
    }
    @Override
    public boolean equals(Object obj) {
        return ((OrderRequest)obj).getCustomerId()==getCustomerId() &&
                ((OrderRequest)obj).getAmount()==getAmount() &&
                Objects.equals(((OrderRequest) obj).getShippingAddress(), getShippingAddress()) &&
                Objects.equals(((OrderRequest) obj).getOrderAddress(), getOrderAddress()) &&
                Objects.equals(((OrderRequest) obj).getOrderEmail(), getOrderEmail()) &&
                Objects.equals(((OrderRequest) obj).getOrderDate(), getOrderDate()) &&
                Objects.equals(((OrderRequest) obj).getOrderStatus(), getOrderStatus());
    }


    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        validateCustomerId(customerId);
        this.customerId = customerId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        validateAmount(amount);
        this.amount = amount;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        validateShippingAddress(shippingAddress);
        this.shippingAddress = shippingAddress;
    }
    public String getOrderAddress() {
        return orderAddress;
    }
    public void setOrderAddress(String orderAddress) {
        validateOrderAddress(orderAddress);
        this.orderAddress = orderAddress;
    }
    public String getOrderEmail() {
        return orderEmail;
    }
    public void setOrderEmail(String orderEmail) {
        validateOrderEmail(orderEmail);
        this.orderEmail = orderEmail;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        validateOrderDate(orderDate);
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        validateOrderStatus(orderStatus);
        this.orderStatus = orderStatus;
    }


    private void validateCustomerId(int customerId) throws OrderCustomerIDCannotBeNegative {
        if(customerId<0)
        {
            throw  new OrderCustomerIDCannotBeNegative();
        }
    }
    private void validateAmount(double amount) throws OrderAmountCannotBeNegative {
        if(amount<0){
            throw new OrderAmountCannotBeNegative();
        }
    }
    private void validateShippingAddress(String shippingAddress) throws OrderShippingAddressCannotBeNull {
        if(shippingAddress.isEmpty())
        {
            throw new OrderShippingAddressCannotBeNull();
        }
    }
    private void validateOrderAddress(String orderAddress) throws OrderAddressCannotBeNull {
        if(orderAddress.isEmpty())
        {
            throw new OrderAddressCannotBeNull();
        }
    }
    private void validateOrderEmail(String orderEmail) throws OrderEmailCannotBeNull {
        if(orderEmail.isEmpty())
        {
            throw new OrderEmailCannotBeNull();
        }
    }
    private void validateOrderDate(LocalDate orderDate) throws OrderDateCannotBeNull {
        if(orderDate==null)
        {
            throw new OrderDateCannotBeNull();
        }
    }
    private void validateOrderStatus(String orderStatus) throws OrderStatusCannotBeNull {
        if(orderStatus.isEmpty())
        {
            throw new OrderStatusCannotBeNull();
        }
    }

    @Override
    public Order createFromOrderRequest(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public Order createFromText(String text) {
        return null;
    }
}
