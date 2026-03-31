package app.products.models;

import app.products.exceptions.*;
import app.products.exceptions.*;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private int id;
    private int sku;
    private String name;
    private double price;
    private double weight;
    private String descriptions;
    private int stock;

    public Product(String line) {
        String[] props = line.split(",");
        setID(Integer.parseInt(props[0]));
        setSKU(Integer.parseInt(props[1]));
        setName(props[2]);
        setPrice(Double.parseDouble(props[3]));
        setWeight(Double.parseDouble(props[4]));
        setDescriptions(props[5]);
        setStock(Integer.parseInt(props[6]));
    }

    public Product(int id, int sku, String name, double price, double weight, String descriptions, int stock) {
        setID(id);
        setSKU(sku);
        setName(name);
        setPrice(price);
        setWeight(weight);
        setDescriptions(descriptions);
        setStock(stock);
    }

    public Product(int sku, String name, double price, double weight, String descriptions, int stock) {
        setSKU(sku);
        setName(name);
        setPrice(price);
        setWeight(weight);
        setDescriptions(descriptions);
        setStock(stock);
    }


    @Override
    public String toString() {
        return this.id + "," + this.sku + "," + this.name + "," + this.price + "," + this.weight + "," + this.descriptions + "," + this.stock;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        validateID(id);
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        return ((Product)obj).getID() == this.getID() && ((Product)obj).getSKU() == this.getSKU() && Objects.equals(((Product) obj).getName(), this.getName())
                && ((Product)obj).getPrice() == this.getPrice() && ((Product)obj).getWeight() == this.getWeight() && Objects.equals(((Product) obj).getDescriptions(), this.getDescriptions())
                && ((Product)obj).getStock() == this.getStock();
    }

    @Override
    public int compareTo(Product o) {
        if(this.getPrice()>o.getPrice()) {
            return 1;
        }
        else if(this.getPrice()<o.getPrice()) {
            return -1;
        }
        return 0;
    }
}