package app.view;

import app.users.models.Admin;
import app.users.models.Customer;
import app.users.models.User;
import app.users.services.UserCommandServiceSingleton;
import app.users.services.UserQueryServiceSingleton;
import app.users.services.interfaces.UserCommandService;
import app.users.services.interfaces.UserQueryService;

public class LoginView extends BaseView {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public LoginView(){
        super();
        userCommandService = UserCommandServiceSingleton.getInstance();
        userQueryService = UserQueryServiceSingleton.getInstance();
        play();
    }

    @Override
    protected void meniu() {
        System.out.println("Login View meniu");
        System.out.println("1->Login.");
        System.out.println("2->Register.");
    }

    @Override
    protected boolean getOption(int option) {
        switch (option) {
            case 1:
                login();
                return true;
            case 2:
                register();
                return true;
            default:
                System.out.println("Invalid option");
                return true;
        }
    }

    public void login() {
        System.out.println("Introduceti username/email");
        String email = sc.nextLine();
        System.out.println("Introduceti password");
        String password = sc.nextLine();
        User user = userQueryService.getUserbyEmailAndPassword(email, password);
        if (user == null) {
            System.out.println("Invalid username or password");
            return;
        }
        if(user instanceof Admin){
            AdminView adminView = new AdminView(user);
        }
        else if(user instanceof Customer){
            CustomerView customerView = new CustomerView(user);
        }
    }

    public void register() {}
}
