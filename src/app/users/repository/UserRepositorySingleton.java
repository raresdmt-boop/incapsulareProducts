package app.users.repository;

public class UserRepositorySingleton {

    private static UserRepository userRepo = new UserRepositoryImpl();
    public static UserRepository getInstance(){
        return userRepo;
    }

}
