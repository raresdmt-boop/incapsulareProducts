package app.system.basket;

import app.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {
//
    private List<ProductDto> products;

    public Basket() {
        this.products = new ArrayList<>();
    }
    public void addToBasket(ProductDto productDto) {
        if(products.isEmpty()) {
            products.add(productDto);
        }
        ProductDto productinList = findInList(productDto);
        if (productinList == null) {
            products.add(productDto);
        }else{
            productinList.setProductQuantity(productDto.getProductQuantity()+productinList.getProductQuantity());
        }
    }
    public void removeFromBasket(ProductDto productDto){
        if(products.isEmpty()) {
            throw new RuntimeException();
        }

        ProductDto productinList = findInList(productDto);
        if (productinList == null) {
            throw new RuntimeException();
        }else {
            products.remove(productinList);
        }
    }
    public List<ProductDto> getBasketProducts(){
        return products;
    }
    public void editQuantity(ProductDto productDto, int quantity){
        ProductDto productinList = findInList(productDto);
        if(productinList == null) {
            throw new RuntimeException();
        }else{
            productinList.setProductQuantity(quantity);
        }
    }

    public int createDtoID(){
        int id = products.size()+1;
        return id;
    }


    public ProductDto findInList(ProductDto productDto){
        for(int i = 0; i < products.size(); i++){
            if(productDto.getProductId() == products.get(i).getProductId()){
                return products.get(i);
            }
        }return null;
    }


    //crud
}
