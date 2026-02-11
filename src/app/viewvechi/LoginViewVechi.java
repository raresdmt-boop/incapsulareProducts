package app.viewvechi;




import app.users.Admin;
import app.users.Customer;
import app.users.UserService;

import java.util.Scanner;

public class LoginViewVechi {
    //logare si registrare
    private final Scanner scanner;

    Admin admin;
    Customer customer;
    private final UserService userService;


    public LoginViewVechi() {

        this.scanner = new Scanner(System.in);
        this.userService = new UserService();
        this.playFirstPage();
    }


    public void playLogin() {
        System.out.println("Introduceti datele de logare.");
        System.out.println("Introduceti email:");
        String email = scanner.nextLine();
        customer = userService.checkEmail(email);
        if (customer == null) {
            admin = userService.getAdminbyMail(email);
            if(admin == null) {
                System.out.println("email necorespunzator");
                return;
            }
            System.out.println("Introduceti password");
            String password = scanner.nextLine();
            if(password.equals(admin.getPassword())) {
                AdminViewVechi adminView = new AdminViewVechi(admin);
                adminView.play();
            }else{
                System.out.println("Admin Password doesn't match");
                return;}
        }
        System.out.println("Introduceti password:");
        String password = scanner.nextLine();
        if(password.equals(customer.getPassword())) {
             CustomerViewVechi customerView = new CustomerViewVechi(customer);
             customerView.play();
        }else{
            System.out.println("Customer password doesn't match");
        }
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
        int id=userService.generateID();
        Customer customer = new Customer(id, email, password, fullName, billingAddress, defaultShippingAddress, phone);
        userService.addUser(customer);

    }

    private void checkPassword(String password) {
        try {
            userService.checkPassword(password);
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
