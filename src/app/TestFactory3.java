package app;

import app.users.factory.UserFactory;
import app.users.factory.UserFactoryImpl;
import app.users.factory.UserFactorySingleton;

public class TestFactory3 {
    private final UserFactory userFactory;
    public TestFactory3() {
        this.userFactory = UserFactorySingleton.getInstance();
    }
}
