package app;


import app.view.View;
import app.view.LoginView;

public class Application {

    static void main() {

        View view = new LoginView();

        view.play();



    }
}
