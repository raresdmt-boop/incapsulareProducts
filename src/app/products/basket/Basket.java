package app.products.basket;

import app.products.basket.dto.ProductDto;
import app.products.exceptions.ProductNotFound;
import app.products.models.Product;
import app.products.services.ProductQueryServiceSingleton;
import app.products.services.interfaces.ProductQueryService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basket implements BasketInt {

    private final ProductQueryService productQueryService;
    private final List<ProductDto> basketProducts;
    private final File basketFile;
    public Basket() {
        basketProducts = new ArrayList<>();
        basketFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\products\\basket\\data\\basket.txt");
        productQueryService = ProductQueryServiceSingleton.getInstance();
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
    public ProductDto addBasketProduct(ProductDto productDto) throws ProductNotFound {
        if(productQueryService.getProducts().stream().noneMatch(product -> product.getName().equals(productDto.getName()))) {
            throw new ProductNotFound();
        }
        if(basketProducts.stream().noneMatch(p -> p.getName().equals(productDto.getName()))){
            basketProducts.add(productDto);
            return productDto;
        };
        ProductDto pdto = basketProducts.stream().filter(p -> p.getName().equals(productDto.getName())).findFirst().get();
        pdto.setQuantity(productDto.getQuantity() + pdto.getQuantity());
        return pdto;

    }

    @Override
    public ProductDto removeBasketProduct(ProductDto productDto) {
        if(basketProducts.stream().noneMatch(p -> p.getName().equals(productDto.getName()))) {
            throw new ProductNotFound();
        }
        ProductDto pdto = basketProducts.stream().filter(p -> p.getName().equals(productDto.getName())).findFirst().get();
        basketProducts.remove(pdto);
        return pdto;
    }

    @Override
    public ProductDto getDtobyName(String name) {
        return basketProducts.stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }

}
