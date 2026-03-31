package app.orders.models;

import java.time.LocalDate;

public class Order implements Comparable<Order>{

    private int id;
    private int customerId;
    private double amount;
    private String shippingAddress;
    private String orderAddress;
    private String orderEmail;
    private LocalDate orderDate;
    private String orderStatus;

    public Order(String line){
        String[] props =  line.split(",");
        setId(Integer.parseInt(props[0]));
        setCustomerId(Integer.parseInt(props[1]));
        setAmount(Double.parseDouble(props[2]));
        setShippingAddress(props[3]);
        setOrderAddress(props[4]);
        setOrderEmail(props[5]);
        setOrderDate(LocalDate.parse(props[6]));
        setOrderStatus(props[7]);
    }
    public Order(int id, int customerId, double amount, String shippingAddress,
                 String orderAddress, String orderEmail, LocalDate orderDate, String orderStatus) {
        setId(id);
        setCustomerId(customerId);
        setAmount(amount);
        setShippingAddress(shippingAddress);
        setOrderAddress(orderAddress);
        setOrderEmail(orderEmail);
        setOrderDate(orderDate);
        setOrderStatus(orderStatus);
    }
    public Order(int customerId, double amount, String shippingAddress,
                 String orderAddress, String orderEmail, LocalDate orderDate, String orderStatus) {
        setCustomerId(customerId);
        setAmount(amount);
        setShippingAddress(shippingAddress);
        setOrderAddress(orderAddress);
        setOrderEmail(orderEmail);
        setOrderDate(orderDate);
        setOrderStatus(orderStatus);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        validateID(id);
        this.id = id;
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

    private void validateID(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Order ID has to be higher than 0");
        }
    }
    private void validateCustomerId(int customerId) {
        if (customerId < 0) {
            throw new IllegalArgumentException("Customer ID has to be higher than 0");
        }
    }
    private void validateAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount has to be higher than 0");
        }
    }
    private void validateShippingAddress(String shippingAddress) {
        if (shippingAddress == null || shippingAddress.isEmpty()) {
            throw new IllegalArgumentException("Shipping Address has to be non-empty");
        }
    }
    private void validateOrderAddress(String orderAddress) {
        if (orderAddress == null || orderAddress.isEmpty()) {
            throw new IllegalArgumentException("Order Address has to be non-empty");
        }
    }
    private void validateOrderEmail(String orderEmail) {
        if (orderEmail == null || orderEmail.isEmpty()) {
            throw new IllegalArgumentException("Order Email has to be non-empty");
        }
    }
    private void validateOrderDate(LocalDate orderDate) {
        if (orderDate == null) {
            throw new IllegalArgumentException("Order Date has to be non-empty");
        }
    }
    private void validateOrderStatus(String orderStatus) {
        if (orderStatus == null || orderStatus.isEmpty()) {
            throw new IllegalArgumentException("Order Status has to be non-empty");
        }
    }

    @Override
    public String toString() {
        return this.id + "," + this.customerId + "," + this.amount + "," + this.shippingAddress + ","
                + this.orderAddress + "," + this.orderEmail + "," + this.orderDate + "," + this.orderStatus;
    }
    @Override
    public boolean equals(Object obj) {
        return ((Order)obj).id == this.id && ((Order)obj).customerId == this.customerId && this.amount == ((Order)obj).amount
                && ((Order)obj).orderAddress.equals(this.orderAddress) && ((Order)obj).orderEmail.equals(this.orderEmail)
                && ((Order)obj).shippingAddress.equals(this.shippingAddress) && ((Order)obj).orderDate.equals(this.orderDate)
                && ((Order)obj).orderStatus.equals(this.orderStatus);
    }
    @Override
    public int compareTo(Order o){
        if(this.getOrderDate().isAfter(o.getOrderDate())){
            return 1;
        }
        else if(this.getOrderDate().isBefore(o.getOrderDate())){
            return -1;
        }
        return 0;
    }
}
