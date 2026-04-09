package app.products.request;

import app.products.exceptions.*;

public class ProductRequest {

    private int sku;
    private String name;
    private double price;
    private double weight;
    private String descriptions;
    private int stock;

    public ProductRequest(int sku, String name, double price, double weight, String descriptions, int stock) {
        setSKU(sku);
        setName(name);
        setPrice(price);
        setWeight(weight);
        setDescriptions(descriptions);
        setStock(stock);
    }

    public ProductRequest(String line) {
        String[] props =  line.split(",");
        setSKU(Integer.parseInt(props[0]));
        setName(props[1]);
        setPrice(Double.parseDouble(props[2]));
        setWeight(Double.parseDouble(props[3]));
        setDescriptions(props[4]);
        setStock(Integer.parseInt(props[5]));
    }


    @Override
    public String toString() {
        return this.sku + "," + this.name + "," + this.price + "," + this.weight + "," + this.descriptions + "," + this.stock;
    }


    public int getSKU() {
        return sku;
    }
    public void setSKU(int sku) throws ProductSkuCannotBeNegative {
        validateSKU(sku);
        this.sku = sku;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }
    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        validateDescriptions(descriptions);
        this.descriptions = descriptions;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        validateStock(stock);
        this.stock = stock;
    }


    private void validateID(int id) throws ProductIdCannotBeNegative {
        if (id < 0) {
            throw new ProductIdCannotBeNegative();
        }
    }
    private void validateSKU(int sku) throws ProductSkuCannotBeNegative {
        if (sku < 0) {
            throw new ProductSkuCannotBeNegative();
        }
    }
    private void validateName(String name) throws ProductNameCannotBeNull {
        if (name == null) {
            throw new ProductNameCannotBeNull();
        }
    }
    private void validatePrice(double price) throws ProductPriceCannotBeNegative {
        if (price < 0) {
            throw new ProductPriceCannotBeNegative();
        }
    }
    private void validateWeight(double weight) throws ProductWeightCannotBeNegative {
        if (weight < 0) {
            throw new ProductWeightCannotBeNegative();
        }
    }
    private void validateDescriptions(String descriptions) throws ProductDescriptionCannotBeNull {
        if (descriptions == null) {
            throw new ProductDescriptionCannotBeNull();
        }
    }
    private void validateStock(int stock) throws ProductStockCannotBeNegative {
        if (stock < 0) {
            throw new ProductStockCannotBeNegative();
        }
    }
}
