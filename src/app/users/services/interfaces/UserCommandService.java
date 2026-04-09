package app.users.services.interfaces;

import app.users.dtos.UserRequest;
import app.users.models.User;

public interface UserCommandService {

    User addUser(UserRequest userRequest);
    User deleteUser(int id);
    User updateUser(int id, UserRequest userRequest);
}
