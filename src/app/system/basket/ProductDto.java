package app.system.basket;

import app.customers.Customer;

public class ProductDto {

    private int customerId;
    private int id;
    private int productId;
    private String productName;
    private double productPrice;
    private int productQuantity;

    public ProductDto(int id, int productId, String productName, double pret, int quantity, int customerId) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = pret;
        this.productQuantity = quantity;
    }
    public ProductDto(String line){
        String[] props = line.split(",");
        this.id = Integer.parseInt(props[0]);
        this.productId = Integer.parseInt(props[1]);
        this.productName = props[2];
        this.productPrice = Double.parseDouble(props[3]);
        this.productQuantity = Integer.parseInt(props[4]);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        validateId(id);
        this.id = id;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        validateProductId(productId);
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        validateProductName(productName);
        this.productName = productName;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        validateProductPrice(productPrice);
        this.productPrice = productPrice;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        validateProductQuantity(productQuantity);
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString(){
        return this.id + "," + this.productId + "," + this.productName + "," + this.productPrice+ "," + this.productQuantity;
    }

    private void validateId(int id){
        if(id < 0){
            throw new IllegalArgumentException("Product Id can't be negative");
        }
    }
    private void validateProductId(int productId){
        if(productId < 0){
            throw new IllegalArgumentException("Product Id can't be negative");
        }
    }
    private void validateProductName(String productName){
        if(productName == null){
            throw new IllegalArgumentException("Product Name can't be null");
        }
    }
    private void validateProductPrice(double productPrice){
        if(productPrice < 0){
            throw new IllegalArgumentException("Product Price can't be negative");
        }
    }
    private void validateProductQuantity(int productQuantity){
        if(productQuantity < 0){
            throw new IllegalArgumentException("Product Quantity can't be negative");
        }
    }


}
