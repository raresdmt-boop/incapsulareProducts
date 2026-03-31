package app.users.factory;

import app.users.dtos.UserRequest;
import app.users.models.User;

public interface UserFactory {

    User createUserFromText(String text);
    User createFromRequest(UserRequest userRequest);

    User createCustomer(int id, String email, String password, String fullName, String billingAddress, String defaultShippingAddress, String phone);

    User createAdmin(int id, String email, String password, String fullName, boolean managerialLevel);
}
