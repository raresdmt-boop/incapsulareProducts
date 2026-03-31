package app.users.dtos;


import app.users.models.User;

public interface UserRequestFactory {


    UserRequest createUserRequestFromText(String text);
    UserRequest createFromRequest(UserRequest userRequest);
}
