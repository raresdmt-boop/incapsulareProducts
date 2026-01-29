package app.view;



import app.admins.Admin;
import app.admins.AdminService;
import app.customers.Customer;
import app.customers.CustomerService;

import java.util.Scanner;

public class LoginView {
    //logare si registrare
    private final Scanner scanner;
    private final CustomerService customerService;
    private final AdminService adminService;
    Customer customer;
    Admin admin;


    public LoginView() {

        this.scanner = new Scanner(System.in);
        this.customerService = new CustomerService();
        this.adminService = new AdminService();
        this.playFirstPage();
    }


    public Customer playLogin() {
        System.out.println("Introduceti datele de logare.");
        System.out.println("Introduceti email:");
        String email = scanner.nextLine();
        customer = customerService.checkEmail(email);
        if (customer == null) {
            System.out.println("Email gresit");
            return null;
        }
        System.out.println("Introduceti password:");
        String password = scanner.nextLine();
        if(password.equals(customer.getPassword())) {
             CustomerView customerView = new CustomerView(customer);
             customerView.play();
        }
        return null;
    }

    public Admin playAdminLogin() {
        System.out.println("Introduceti email:");
        String email = scanner.nextLine();
        admin = adminService.getAdmin(email);
        if (admin == null) {
            System.out.println("Email gresit");
            return null;
        }
        System.out.println("Introduceti password:");
        String password = scanner.nextLine();
        if(password.equals(admin.getPassword())) {
            AdminView adminView = new AdminView();
            adminView.play();
        }
        return null;
    }

    public void registerCustomer() {

        System.out.println("Insert email: ");
        String email = scanner.nextLine();
        System.out.println("Insert password: ");
        String password = scanner.nextLine();
        System.out.println("Insert full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Insert billing address: ");
        String billingAddress = scanner.nextLine();
        System.out.println("Insert shipping address: ");
        String defaultShippingAddress = scanner.nextLine();
        System.out.println("Insert phone number: ");
        String phone = scanner.nextLine();
        customerService.createCustomer(email, password, fullName, billingAddress, defaultShippingAddress, phone);

    }

    private void checkPassword(String password) {
        try {
            customerService.checkPassword(password);
        }catch (Exception e) {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    void meniuLogin(){
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Forgot Password");
    }

    public void playFirstPage() {
        boolean running=true;
        while (running) {
            meniuLogin();
            int alegere = scanner.nextInt();
            scanner.nextLine();
            switch(alegere) {
                case 1:
                    playLogin();
                    break;
                case 2:
                    registerCustomer();
                    break;
                case 3:
                    break;

            }
        }
    }

}
