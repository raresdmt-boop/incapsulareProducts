package app.users.factory;

public class UserFactorySingleton {

    private static UserFactory instance=new  UserFactoryImpl();

    public static UserFactory getInstance() {
        return instance;
    }
}
