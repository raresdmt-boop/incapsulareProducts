package app.viewvechi;

import app.orderDetails.OrderDetailsService;
import app.orders.Order;
import app.orders.OrderService;
import app.products.Product;
import app.products.ProductService;
import app.system.basket.Basket;
import app.system.basket.ProductDto;
import app.users.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerViewVechi {
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderDetailsService orderDetailsService;
    private final Basket basket;
    private Customer logat;
    private final Scanner sc;


    public CustomerViewVechi(Customer customer) {

        this.productService = new ProductService();
        this.orderService = new OrderService();
        this.orderDetailsService = new OrderDetailsService();
        this.sc = new Scanner(System.in);
        this.basket = new Basket(145);
        this.logat = customer;


    }

    public void play() {

        boolean continua = true;
        while (continua) {
            meniuInitial();
            int alegere = Integer.parseInt(sc.nextLine());
            switch (alegere) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    seeOrders(logat);
                    break;
                case 4:
                    displayOrderProducts(logat);
                    break;
                case 7:
                    createOrder();
                    break;
                case 12:
                    basket();
                    break;
                case 13:
                    basket();
                    addToBasket();
                    break;
                case 14:
                    basket();
                    removeFromBasket();
                    break;
                case 15:
                    basket();
                    editBasketQuantity();
                    break;
                default:
                    System.out.println("Iesire din meniu");
                    continua = false;

            }

        }
    }

    void meniuInitial() {
        System.out.println("1-> Login.");
        System.out.println("2-> Register.");
        System.out.println("3-> See orders.");
        System.out.println("4-> See order products.");
        System.out.println("5-> Edit Order.");
        System.out.println("6-> Delete Order.");
        System.out.println("7-> New Order.");
        System.out.println("8-> Products.");
        System.out.println("9-> Edit Products.");
        System.out.println("10-> Delete Products.");
        System.out.println("11-> Add Products.");
        System.out.println("12-> View Basket.");
        System.out.println("13-> Add to Basket");
        System.out.println("14-> Remove from Basket.");
        System.out.println("15-> Edit Basket Amount.");
        System.out.println("16-> Sign Out.");
        System.out.println("0/any other number-> Exit. ");

    }

//
    void seeOrders(Customer customer) {
        ArrayList<Order> customerOrderList = this.orderService.getCustomerOrders(customer);
        System.out.println("Customer orders are:");
        for (Order order : customerOrderList) {
            System.out.println(order.toString());
        }
    }

    void displayOrderProducts(Customer customer) {
        System.out.println("Enter Order Number:");
        Order order = orderService.getOrderbyID(sc.nextInt());
        if (order == null) {
            System.out.println("Order number doesn't exist!");
            return;
        } else if (customer.getId() != order.getCustomerId()) {
            System.out.println("Order number" + order.getId() + "does not belong to customer");
            return;
        }
        List<Integer> productIdList = orderDetailsService.orderProductID(order);
        if (productIdList.isEmpty()) {
            System.out.println("Nu exista produse in aceasta comanda");
            return;
        }
        System.out.println("Produsele din comanda sunt:");
        for (Integer integer : productIdList) {
            System.out.println(productService.getProductNameById(integer));
        }
    }


    void basket() {
        List<ProductDto> basketlist = basket.getBasketProducts();
        if (basketlist.isEmpty()) {
            System.out.println("Nu exista product in basket");
            return;
        }
        for (ProductDto productDto : basketlist) {
            System.out.println(productDto.toString());
        }
    }

    boolean checkStock(){
        List<ProductDto> basketList = basket.getBasketProducts();
        for(ProductDto productDto : basketList){
            if(!productService.checkStock(productDto)){
                System.out.println(productDto.getProductName()+" nu are suficient stoc");
                return false;
            }
        }
        return true;
    }

    void addToBasket() {
        System.out.println("Ce produs doriti sa adaugati?");
        Product product = productService.getProductByName(sc.nextLine());
        int DtoID = basket.createDtoID();
        System.out.println("Ce cantitate doriti sa adaugati?");
        int quantity = sc.nextInt();
        sc.nextLine();
        ProductDto productDto = new ProductDto(DtoID, product.getID(), product.getName(), product.getPrice(), quantity);
        if (!productService.checkProdductDto(productDto)) {
            System.out.println("Invalid product name.");
            return;
        }
        basket.addToBasket(productDto);
        basket();
    }

    void removeFromBasket() {
        System.out.println("Ce produs doriti sa stergeti?");
        basket.removeFromBasket(sc.nextLine());
        basket();
    }

    void editBasketQuantity() {
        System.out.println("Carui produs doriti sa ii editati cantitatea?");
        Product product = productService.getProductByName(sc.nextLine());
        System.out.println("Ce cantitate doriti sa aiba acum?");
        int quantity = sc.nextInt();
        sc.nextLine();
        basket.editBasketQuantity(product.getName(), quantity);
        basket();
    }

    void createOrder() {
        basket();
        //verificam disponibilitatea
        if(!checkStock()){
            System.out.println("Schimbati cantitatea produsului.");
            return;
        };

        double amount = basket.getAmount();
        System.out.println("Valoarea totala a cosului este " + amount);

        Order newOrder = orderService.createOrder(logat, amount);

        orderDetailsService.addOrderDetails(basket.getBasketProducts(), newOrder);

        if (newOrder != null) System.out.println("Order has been created");

        updateStock();


    }

    void updateStock(){
        List<ProductDto> basketList = basket.getBasketProducts();
        for(ProductDto productDto : basketList){
            productService.editStock(productDto);
        }
    }
    void deleteBasket(){
        List<ProductDto> basketList = basket.getBasketProducts();
        for(ProductDto productDto : basketList){
            basket.removeFromBasket(productDto.getProductName());
        }
    }


//    void login(){
//        logat=loginView.playLogin();
//        if(logat != null){
//            System.out.println("Login Successfull");
//        }else{
//            System.out.println("Login Failed");
//        }
//
//    }
//        void register(){
//        loginView.registerCustomer();
//        System.out.println("Register Successfull");
//    }
}
