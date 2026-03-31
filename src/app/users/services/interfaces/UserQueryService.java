package app.users.services.interfaces;

import app.users.models.User;

import java.util.Comparator;
import java.util.List;

public interface UserQueryService {

    List<User> getUsers();
    User getBestUser(Comparator<User> comparator);
    User getUserbyEmail(String email);
    User getUserbyEmailAndPassword(String email, String password);

}
