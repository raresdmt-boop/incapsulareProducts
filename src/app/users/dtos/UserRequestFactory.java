package app.users.dtos;


public interface UserRequestFactory {


    UserRequest createUserRequestFromText(String text);
    UserRequest createFromRequest(UserRequest userRequest);
}
