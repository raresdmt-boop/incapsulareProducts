package app.users.exceptions;

public class UserPasswordCannotBeNull extends RuntimeException {
    public UserPasswordCannotBeNull() {
        super(ExceptionConstants.USER_PASSWORD_CANNOT_BE_NULL);
    }
}
