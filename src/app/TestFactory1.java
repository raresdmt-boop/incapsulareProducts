package app;

import app.users.factory.UserFactory;
import app.users.factory.UserFactoryImpl;
import app.users.factory.UserFactorySingleton;

public class TestFactory1 {
    private final UserFactory userFactory;

    public TestFactory1() {
        this.userFactory = UserFactorySingleton.getInstance();
    }
}
