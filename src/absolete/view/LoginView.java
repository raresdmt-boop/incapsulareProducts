package absolete.view;

import absolete.Admin;
import absolete.Customer;

public class LoginView  extends View{

    public LoginView(){

        super();
        createMeniu();
        playLogin();

    }

    public void playLogin(){
        System.out.println("Welcome to Login View");
        System.out.println(meniu);
        int alegere=Integer.parseInt(sc.next());
        sc.nextLine();
        switch(alegere){
            case 1:
                login();
                break;
            case 2:
                register();
                break;
        }
    }

    private void createMeniu() {
        StringBuilder builder = new StringBuilder();
        builder.append("1. Login\n");
        builder.append("2. Register\n");
        builder.append("3. Forgot Password\n");
        super.meniu = builder.toString();

    }

    public void login(){
        System.out.println("Introduceti email");
        String email = sc.nextLine();
        System.out.println("Introduceti password");
        String password = sc.nextLine();
//        super.user = userService.loggin(email,password);
        if(user==null){
            System.out.println("Date de logare gresite");
        }
        if(user instanceof Customer){
            View customerView = new CustomerView((Customer)user);
            customerView.play();
        }
        if(user instanceof Admin){
            View adminView = new AdminView();
            adminView.play();
        }
    }

    public void register(){
        System.out.println("Introduceti email");
        String email = sc.nextLine();
        System.out.println("Introduceti password");
        String password = sc.nextLine();
        System.out.println("Introduceti fullname");
        String fullname = sc.nextLine();
        System.out.println("Introduceti billing address");
        String billingAddress = sc.nextLine();
        System.out.println("Introduceti shipping address");
        String shippingAddress = sc.nextLine();
        System.out.println("Introduceti phone");
        String phone = sc.nextLine();
//        int id= userService.generateID();
//        User user = new User(id, email, password, fullname);
//        userService.addCustomer(user, billingAddress, shippingAddress, phone);
    }
}
