package app.users.repository;

import app.users.dtos.UserRequest;
import app.users.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByID(int id);
    Optional<User> findByEmail(String email);
    List<User> getAll();
    User save(User user);
    User delete(int id);
    User update(int id, UserRequest userRequest);
    User getUserByEmail(String email);
    User getUserByEmailAndPassword(String email, String password);
}
