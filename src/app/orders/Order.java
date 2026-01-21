package app.orders;

public class Order {
    private int id;
    private int customerId;
    private int amount;
    private String shippingAddress;
    private String orderAddress;
    private String orderEmail;
    private String orderDate;
    private String orderStatus;
    public Order(String line){
        String[] props = line.split(",");
        this.id = Integer.parseInt(props[0]);
        this.customerId = Integer.parseInt(props[1]);
        this.amount = Integer.parseInt(props[2]);
        this.shippingAddress = props[3];
        this.orderAddress = props[4];
        this.orderEmail = props[5];
        this.orderDate = props[6];
        this.orderStatus = props[7];
    }
    public Order(int id, int customerId, int amount, String shippingAddress, String orderAddress, String orderEmail, String orderDate, String orderStatus){
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.shippingAddress = shippingAddress;
        this.orderAddress = orderAddress;
        this.orderEmail = orderEmail;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return this.id+","+this.customerId+","+this.amount+","+this.shippingAddress+","+this.orderAddress+","+this.orderEmail+","+this.orderDate+","+this.orderStatus;
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
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
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
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
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


    private void validateID(int id){
        if(id<0){
            throw new IllegalArgumentException("Order ID has to be higher than 0");
        }
    }
    private void validateCustomerId(int customerId){
        if(customerId<0){
            throw new IllegalArgumentException("Customer ID has to be higher than 0");
        }
    }
    private void validateAmount(int amount){
        if(amount<0){
            throw new IllegalArgumentException("Amount has to be higher than 0");
        }
    }
    private void validateShippingAddress(String shippingAddress){
        if(shippingAddress==null || shippingAddress.isEmpty()){
            throw new IllegalArgumentException("Shipping Address has to be non-empty");
        }
    }
    private void validateOrderAddress(String orderAddress){
        if(orderAddress==null || orderAddress.isEmpty()){
            throw new IllegalArgumentException("Order Address has to be non-empty");
        }
    }
    private void validateOrderEmail(String orderEmail){
        if(orderEmail==null || orderEmail.isEmpty()){
            throw new IllegalArgumentException("Order Email has to be non-empty");
        }
    }
    private void validateOrderDate(String orderDate){
        if(orderDate==null || orderDate.isEmpty()){
            throw new IllegalArgumentException("Order Date has to be non-empty");
        }
    }
    private void validateOrderStatus(String orderStatus){
        if(orderStatus==null || orderStatus.isEmpty()){
            throw new IllegalArgumentException("Order Status has to be non-empty");
        }
    }
}
