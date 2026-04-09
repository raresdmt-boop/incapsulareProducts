package app.users.services;

import app.users.services.interfaces.UserCommandService;

public class UserCommandServiceSingleton {

    private static UserCommandService instance = new UserCommandServiceImpl();
    public static UserCommandService getInstance() {
        return instance;
    }

}
