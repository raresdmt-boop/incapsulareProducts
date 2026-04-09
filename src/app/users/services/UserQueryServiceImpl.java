package app.users.services;

import app.users.exceptions.UserNotFound;
import app.users.models.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositorySingleton;
import app.users.services.interfaces.UserQueryService;

import java.util.Comparator;
import java.util.List;

public class UserQueryServiceImpl implements UserQueryService {

    private UserRepository userRepository;
    public UserQueryServiceImpl() {
        userRepository = UserRepositorySingleton.getInstance();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getBestUser(Comparator<User> comparator) {
        List<User> users = userRepository.getAll();
        return users.stream()
                .max(comparator)
                .get();
    }

    @Override
    public User getUserbyEmail(String email) throws UserNotFound {
        User user = userRepository.getUserByEmail(email);
        if(user == null) {
            throw new UserNotFound();
        }
        return user;

    }

    @Override
    public User getUserbyEmailAndPassword(String email, String password) {
        User user = userRepository.getUserByEmailAndPassword(email, password);
        if(user == null) {
            throw new UserNotFound();
        }
        return user;
    }
}
