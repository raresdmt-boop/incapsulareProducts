package app.view;

import app.customers.Customer;
import app.orderDetails.OrderDetailsService;
import app.orders.Order;
import app.orders.OrderService;
import app.products.Product;
import app.products.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductsView {
    private ProductService productService;
    private OrderService orderService;
    private OrderDetailsService orderDetailsService;
    private Customer logat = null;
    private Scanner sc;

    public  ProductsView(){

        this.productService = new ProductService();
        this.orderService = new OrderService();
        this.orderDetailsService = new OrderDetailsService();
        this.sc = new Scanner(System.in);

        logat = new Customer(145, "raresdmt@yahoo.com", "1234", "John Doe", "alabala", "alabala", "alabala");

    }
    public void play() {

        boolean continua = true;
        while (continua) {
            meniuInitial();
            int alegere=Integer.parseInt(sc.nextLine());
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
                case 33:
                    basket(logat);
                    break;
                default:
                    System.out.println("Iesire din meniu");
                    break;

            }

        }
    }

    void meniuInitial(){
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
        System.out.println("12-> Sign out.");
        System.out.println("0/any other number-> Exit. ");
        System.out.println("33 - basket");
    }

//    void login(){
//        System.out.println("Insert email: ");
//        String email = sc.nextLine();
//        System.out.println("Insert password: ");
//        String password = sc.nextLine();
//        logat = customerService.getCustomer(email, password);
//        if(logat != null){
//            System.out.println("Login Successfull");
//        }else{
//            System.out.println("Login Failed");
//        }
//
//    }
//    void register(){
//
//        System.out.println("Insert email: ");
//        String email = sc.nextLine();
//        System.out.println("Insert password: ");
//        String password = sc.nextLine();
//        System.out.println("Insert full name: ");
//        String fullName = sc.nextLine();
//        System.out.println("Insert billing address: ");
//        String billingAddress = sc.nextLine();
//        System.out.println("Insert shipping address: ");
//        String defaultShippingAddress = sc.nextLine();
//        System.out.println("Insert phone number: ");
//        String phone = sc.nextLine();
//        customerService.createCustomer(email, password, fullName, billingAddress, defaultShippingAddress, phone);
//
//    }
    void seeOrders(Customer customer){
        ArrayList<Order> customerOrderList= this.orderService.getCustomerOrders(customer);
        System.out.println("Customer orders are:");
        for(Order order:customerOrderList){
            System.out.println(order.toString());
        }
    }
    void displayOrderProducts(Customer customer){
        System.out.println("Enter Order Number:");
        Order order = orderService.getOrderbyID(sc.nextInt());
        if (order == null) {
            System.out.println("Order number doesn't exist!");
            return;
        }else if(customer.getId() != order.getCustomerId()) {
            System.out.println("Order number" + order.getId() + "does not belong to customer");
            return;
        }
        List<Integer> productIdList = orderDetailsService.orderProductID(order);
        if(productIdList.isEmpty()){
            System.out.println("Nu exista produse in aceasta comanda");
            return;
        }
        System.out.println("Produsele din comanda sunt:");
        for (Integer integer : productIdList) {
            System.out.println(productService.getProductNameById(integer));
        }
    }


    void basket (Customer customer){
        ArrayList<Product> basketProducts = new ArrayList<>();
        basketProducts = orderService.getBasket(customer);
        boolean continua=true;
        while (continua) {

            if (basketProducts.isEmpty()) {
                System.out.println("Nu exista produse in cos");
            }else{
                System.out.println("Produsele din cos:\n"+basketProducts);
            }
            System.out.println("Scrieti numele produsului pe care doriti sa il adaugati");
            String numeProdus = sc.nextLine();
            System.out.println("Add or default");

            int alegere = Integer.parseInt(sc.nextLine());
            System.out.println("Add or default") ;
            switch (alegere) {
                case 1:
                    addProductToBasket(customer, basketProducts, productService.getProductByName(numeProdus));
                    break;
                default:
                    continua=false;
                    break;
            }

        }
    }

    private void addProductToBasket(Customer customer, ArrayList<Product> basketProducts, Product product){
        orderService.createOrder(customer, product);
        basketProducts.add(product);
    }

}
