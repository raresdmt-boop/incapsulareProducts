package app;

import app.users.factory.UserFactory;
import app.users.factory.UserFactorySingleton;

public class TestFactory2 {
    private final UserFactory userFactory;

    public TestFactory2() {
        this.userFactory = UserFactorySingleton.getInstance();
    }
}
