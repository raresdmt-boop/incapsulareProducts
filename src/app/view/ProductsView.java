package app.view;

import app.customers.Customers;
import app.customers.CustomersService;

import java.util.Scanner;


public class ProductsView {
//    ProductsService productsService = new ProductsService();
//    OrdersService ordersService = new OrdersService();
//    OrderDetailsService orderDetailsService = new OrderDetailsService();
    CustomersService customersService = new CustomersService();
    Customers logat = null;
    Scanner sc = new Scanner(System.in);

    public void play() {

        boolean continua = true;
        while (continua) {
            meniuInitial();
            int alegere;
            try {
                alegere = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introdu un numar valid!");
                continue;
            }

            if (logat == null && alegere != 1 && alegere != 0 && alegere != 2) {
                System.out.println("Trebuie sa fii logat.");
                continue;
            }
            switch (alegere) {
                case 1:
                    login();
                    break;
                case 2:

            }

        }
    }

    void meniuInitial(){
        System.out.println("1-> Login.");
        System.out.println("2-> Register.");
        System.out.println("3-> Orders.");
        System.out.println("4-> Order Details.");
        System.out.println("5-> Edit Order.");
        System.out.println("6-> Delete Order.");
        System.out.println("7-> New Order.");
        System.out.println("8-> Products.");
        System.out.println("9-> Edit Products.");
        System.out.println("10-> Delete Products.");
        System.out.println("11-> Add Products.");
        System.out.println("12-> Sign out.");
        System.out.println("0/any other number-> Exit. ");
    }

    void login(){
        System.out.println("Insert email: ");
        String email = sc.nextLine();
        System.out.println("Insert password: ");
        String password = sc.nextLine();
        logat = customersService.getCustomer(email, password);
        if(logat != null){
            System.out.println("Login Successfull");
        }else{
            System.out.println("Login Failed");
        }

    }
    void register(){
        System.out.println("Insert email: ");
        String email = sc.nextLine();
        System.out.println("Insert password: ");
        String password = sc.nextLine();
        System.out.println("Insert full name: ");
        String fullName = sc.nextLine();
        System.out.println("Insert billing address: ");
        String billingAddress = sc.nextLine();
        System.out.println("Insert shipping address: ");
        String defaultShippingAddress = sc.nextLine();
        System.out.println("Insert phone number: ");
        String phone = sc.nextLine();
        customersService.createCustomer(email, password, fullName, billingAddress, defaultShippingAddress, phone);

    }


}
