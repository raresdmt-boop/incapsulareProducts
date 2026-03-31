package app.users.services;

import app.users.services.interfaces.UserQueryService;

public class UserQueryServiceSingleton {

    private static UserQueryService instance = new UserQueryServiceImpl();
    public static UserQueryService getInstance() {
        return instance;
    }

}
