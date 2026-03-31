package app.products.basket;

import app.products.basket.dto.ProductDto;
import app.products.models.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basket implements BasketInt {

    private final List<ProductDto> basketProducts;
    private final File basketFile;
    public Basket() {
        basketProducts = new ArrayList<>();
        basketFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\products\\basket\\data\\basket.txt");
        loadBasket();
    }

    private void loadBasket(){
        try{
            Scanner scanner = new Scanner(basketFile);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    basketProducts.add(new ProductDto(line));
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    @Override
    public List<ProductDto> getBasketProducts() {
        return basketProducts;
    }

    @Override
    public ProductDto addBasketProduct(ProductDto productDto) {
        for(ProductDto product: basketProducts){
            if(product.getName().equals(productDto.getName())){
                product.setQuantity(product.getQuantity()+productDto.getQuantity());
                return product;
            }
        }
        basketProducts.add(productDto);
        return productDto;
    }

    @Override
    public ProductDto removeBasketProduct(ProductDto productDto) {
        for(ProductDto product: basketProducts){
            if(product.getName().equals(productDto.getName())){
                basketProducts.remove(product);
                return product;
            }
        }
        return null;
    }

    @Override
    public ProductDto getDtobyName(String name) {
        for(ProductDto product: basketProducts){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

}
