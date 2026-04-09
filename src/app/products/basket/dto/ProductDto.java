package app.products.basket.dto;

import app.products.exceptions.*;

public class ProductDto {

    private String name;
    private int quantity;


    public ProductDto(String name, int quantity) {
       setName(name);
       setQuantity(quantity);
    }

    public ProductDto(String line) {
        String[] props =  line.split(",");
        setName(props[0]);
        setQuantity(Integer.parseInt(props[1]));
    }


    @Override
    public String toString() {
        return this.name +","+ this.quantity; }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }




    private void validateName(String name) throws ProductNameCannotBeNull {
        if (name == null) {
            throw new ProductNameCannotBeNull();
        }
    }
    private void validateQuantity(int quantity) throws ProductDtoQuantityCannotBeNegative {
        if (quantity < 0) {
            throw new ProductDtoQuantityCannotBeNegative();
        }
    }

}
