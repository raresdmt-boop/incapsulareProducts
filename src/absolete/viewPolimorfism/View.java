package absolete.viewPolimorfism;

import absolete.Customer;
import absolete.User;
import absolete.UserService;

import java.util.Scanner;

public class View {

    private final UserService userService =  new UserService();
    private String menu;


    public View(){

    }

    public void play(){
        System.out.println("View play");
        System.out.println(this);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your choice");
        int alegere = Integer.parseInt(sc.nextLine());
        switch(alegere){
            case 1:
                System.out.println("Enter email");
                String email =  sc.nextLine();
                System.out.println("Enter password");
                String password = sc.nextLine();
                User user = userService.getUser(email,password);
                if(user==null){
                    throw new IllegalArgumentException("Invalid email or password");
                }
                if(user instanceof Customer){
                    View v = new CustomerView((Customer)user);
                    v.play();
                }
                View v = new AdminView();
                v.play();

        }
    }

    public String createMeniu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Menu: \n");
        sb.append("1. Login");
        return sb.toString();
    }

    @Override
    public String toString() {
        return createMeniu();
    }

}
