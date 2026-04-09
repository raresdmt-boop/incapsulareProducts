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

        BaseView baseView = new LoginView();

    }
}
