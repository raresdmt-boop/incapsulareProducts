package app.orderDetails.dtos;

import app.orderDetails.exceptions.*;
import app.orderDetails.exceptions.*;
import app.orderDetails.models.OrderDetails;

public class OrderDetailsRequest {

    private int orderID;
    private int productID;
    private double price;
    private int sku;
    private int quantity;


    public OrderDetailsRequest(String line) {
        String[] props = line.split(",");
        setOrderID(Integer.parseInt(props[0]));
        setProductID(Integer.parseInt(props[1]));
        setPrice(Double.parseDouble(props[2]));
        setSku(Integer.parseInt(props[3]));
        setQuantity(Integer.parseInt(props[4]));
    }
    public OrderDetailsRequest(int orderID, int productID, double price, int sku, int quantity) {
        setOrderID(orderID);
        setProductID(productID);
        setPrice(price);
        setSku(sku);
        setQuantity(quantity);
    }

    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) throws OrderDetailsOrderIDCannotBeNegative {
        validateOrderID(orderID);
        this.orderID = orderID;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) throws OrderDetailsProductIDCannotBeNegative {
        validateProductID(productID);
        this.productID = productID;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) throws OrderDetailsPriceCannotBeNegative {
        validatePrice(price);
        this.price = price;
    }
    public int getSku() {
        return sku;
    }
    public void setSku(int sku)  throws OrderDetailsSKUCannotBeNegative {
        validateSKU(sku);
        this.sku = sku;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) throws OrderDetailsQuantityCannotBeNegative {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getOrderID()+","+getProductID()+","+getPrice()+","+getSku()+","+getQuantity();
    }
    @Override
    public boolean equals(Object obj) {
        return ((OrderDetails)obj).getOrderID() == this.getOrderID()
                && ((OrderDetails)obj).getProductID() == this.getProductID() && ((OrderDetails)obj).getPrice() == this.getPrice()
                && ((OrderDetails)obj).getSku() == this.getSku() && ((OrderDetails)obj).getQuantity() == this.getQuantity();
    }


    private void validateOrderID(int orderID) throws OrderDetailsOrderIDCannotBeNegative {
        if (orderID < 0) {
            throw new OrderDetailsOrderIDCannotBeNegative();
        }
    }
    private void validateProductID(int productID) throws OrderDetailsProductIDCannotBeNegative {
        if (productID < 0) {
            throw new OrderDetailsProductIDCannotBeNegative();
        }
    }
    private void validatePrice(double price) throws OrderDetailsPriceCannotBeNegative {
        if (price < 0) {
            throw new OrderDetailsPriceCannotBeNegative();
        }
    }
    private void validateSKU(int sku) throws OrderDetailsSKUCannotBeNegative {
        if (sku < 0) {
            throw new OrderDetailsSKUCannotBeNegative();
        }
    }
    private void validateQuantity(int quantity) throws OrderDetailsQuantityCannotBeNegative {
        if (quantity < 0) {
            throw new OrderDetailsQuantityCannotBeNegative();
        }
    }

}
