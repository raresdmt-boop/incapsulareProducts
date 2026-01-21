package app.orderDetails;

public class OrderDetails {
    private int id;
    private int orderID;
    private int productID;
    private double price;
    private int sku;
    private int quantity;

    public OrderDetails(String line){
        String[] props = line.split(",");
        id = Integer.parseInt(props[0]);
        orderID = Integer.parseInt(props[1]);
        productID = Integer.parseInt(props[2]);
        price = Double.parseDouble(props[3]);
        sku = Integer.parseInt(props[4]);
        quantity = Integer.parseInt(props[5]);
    }
    public OrderDetails(int id, int orderID, int productID, double price, int sku, int quantity){
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
        this.price = price;
        this.sku = sku;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return this.id+","+this.orderID +","+this.productID +","+this.price+","+this.sku+","+this.quantity;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        validateID(id);
        this.id = id;
    }
    public int getOrderID(){
        return orderID;
    }
    public void setOrderID(int orderID){
        validateOrderID(orderID);
        this.orderID = orderID;
    }
    public int getProductID(){
        return productID;
    }
    public void setProductID(int productID){
        validateProductID(productID);
        this.productID = productID;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }
    public int getSku(){
        return sku;
    }
    public void setSku(int sku){
        validateSKU(sku);
        this.sku = sku;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        validateQuantity(quantity);
        this.quantity = quantity;
    }


    private void validateID(int id){
        if(id<0){
            throw new IllegalArgumentException("ID should be greater than 0");
        }
    }
    private void validateOrderID(int orderID){
        if(orderID<0){
            throw new IllegalArgumentException("Order_ID should be greater than 0");
        }
    }
    private void validateProductID(int productID){
        if(productID<0){
            throw new IllegalArgumentException("Product_ID should be greater than 0");
        }
    }
    private void validatePrice(double price){
        if(price<0){
            throw new IllegalArgumentException("Price should be greater than 0");
        }
    }
    private void validateSKU(int sku){
        if(sku<0){
            throw new IllegalArgumentException("SKU should be greater than 0");
        }
    }
    private void validateQuantity(int quantity){
        if(quantity<0){
            throw new IllegalArgumentException("Quantity should be greater than 0");
        }
    }
}
