package app.users.services;

import app.users.dtos.AdminRequest;
import app.users.dtos.CustomerRequest;
import app.users.dtos.UserRequest;
import app.users.dtos.UserRequestType;
import app.users.exceptions.UserEmailAlreadyExists;
import app.users.exceptions.UserNotFound;
import app.users.factory.UserFactory;
import app.users.factory.UserFactoryImpl;
import app.users.factory.UserFactorySingleton;
import app.users.models.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositoryImpl;
import app.users.repository.UserRepositorySingleton;
import app.users.services.interfaces.UserCommandService;

import java.util.Optional;

public class UserCommandServiceImpl implements UserCommandService {

    private UserRepository userRepository;
    private UserFactory userFactory;


    public UserCommandServiceImpl() {
        userRepository = UserRepositorySingleton.getInstance();
        userFactory = UserFactorySingleton.getInstance();
    }

    @Override
    public User addUser(UserRequest userRequest) throws UserEmailAlreadyExists {
        if(userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new UserEmailAlreadyExists();
        }
        User user = userFactory.createFromRequest(userRequest);
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(int id) throws UserNotFound {
        Optional<User> user = userRepository.findByID(id);
        if (user.isEmpty()) {
            throw new UserNotFound();
        }
        return userRepository.delete(id);
    }

    @Override
    public User updateUser(int id, UserRequest userRequest) throws UserNotFound {
        Optional <User> user = userRepository.findByID(id);
        if (user.isEmpty()) {
            throw new UserNotFound();
        }
        return userRepository.update(id, userRequest);
    }
}
