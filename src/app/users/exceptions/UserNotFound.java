package app.users.exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound() {
        super(ExceptionConstants.USER_NOT_FOUND);
    }
}
