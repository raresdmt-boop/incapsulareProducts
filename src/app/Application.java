package app;



import app.users.models.Customer;
import app.users.models.Permissions;
import app.users.models.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositorySingleton;
import app.view.BaseView;
import app.view.LoginView;


public class Application {

    static void main() {


//        User user = new Customer(199, "ASASASASA", "AAA","AAA", "AAA","AAA",
//                "AAAA");
//        System.out.println("Customer ID: " + user.getId());
//        user.addPermissions(Permissions.MANAGE_OWN_USER_DETAILS);
//        user.addPermissions(Permissions.MANAGE_CART);
//        user.addPermissions(Permissions.VIEW_ALL_ORDERS);
//
//
//        if(user.hasPermissions(Permissions.MANAGE_OWN_USER_DETAILS)){
//            System.out.println("Customer ID: " + user.getId());
//        }

        UserRepository userRepository = UserRepositorySingleton.getInstance();
        System.out.println(userRepository.getAll());
    }
}
