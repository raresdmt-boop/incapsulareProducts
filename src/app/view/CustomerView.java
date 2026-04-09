package app.view;

import app.products.basket.Basket;
import app.products.basket.BasketInt;
import app.products.basket.dto.ProductDto;
import app.products.exceptions.BasketQuantityCannotExceedProductStock;
import app.products.exceptions.ProductNotFound;
import app.products.models.Product;
import app.products.services.ProductQueryServiceSingleton;
import app.products.services.interfaces.ProductQueryService;
import app.users.models.User;

import java.util.List;

import static app.users.models.Permissions.*;

public class CustomerView extends AuthorizedView{

    private final BasketInt basket;
    private final ProductQueryService productQueryService;

    protected CustomerView(User user) {
        super(user);
        productQueryService = ProductQueryServiceSingleton.getInstance();
        this.basket = new Basket();
        play();

    }

    @Override
    protected void validatePermission(){
        if(!hasPermission(MANAGE_CART) || !hasPermission(VIEW_PRODUCTS)
        || !hasPermission(PLACE_ORDER) || !hasPermission((VIEW_OWN_ORDERS))) {
            throw new IllegalArgumentException("Your Customer Profile doesn't have permission to perform this action.");
        }
    }

    @Override
    protected void meniu() {
        System.out.println("CustomerView");
        if(hasPermission(MANAGE_CART) && hasPermission(VIEW_PRODUCTS)) {
            System.out.println("1-> Check Basket.");
            System.out.println("2-> Add to Basket.");
        }
    }

    @Override
    protected boolean getOption(int option) {
        switch (option){
            case 1:
                seeBasket();
                return true;
            case 2:
                addBasketProduct();
                return true;
            case 3:
                removeBasketProduct();
                return true;
            default:
                return false;
        }
    }


    void seeBasket(){
        validatePermission();
        List<ProductDto> basketList = basket.getBasketProducts();
        if(basketList.isEmpty()){
            System.out.println("This basket is empty.");
        }
        System.out.println(basketList);
    }

    void addBasketProduct() throws ProductNotFound, BasketQuantityCannotExceedProductStock {
        System.out.println("Enter product name:");
        String name = sc.nextLine();
        if(productQueryService.findByName(name) == null) {
            throw new ProductNotFound();
        }
        System.out.println("Enter product quantity:");
        int quantity = Integer.parseInt(sc.nextLine());
        if(quantity>productQueryService.findByName(name).getStock()){
            throw new BasketQuantityCannotExceedProductStock();
        }
        basket.addBasketProduct( new ProductDto(name,quantity));
        System.out.println("Product"+name+" added to basket.");
    }

    void removeBasketProduct() throws ProductNotFound{
        System.out.println("Enter product name:");
        String name = sc.nextLine();
        ProductDto dto = basket.removeBasketProduct(basket.getDtobyName(name));
        if(dto == null){
            throw new ProductNotFound();
        }
        System.out.println("Product"+name+" removed from basket.");
    }
}
