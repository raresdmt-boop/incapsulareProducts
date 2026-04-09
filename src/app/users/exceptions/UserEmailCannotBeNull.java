package app.users.exceptions;

public class UserEmailCannotBeNull extends RuntimeException {
    public UserEmailCannotBeNull() {
        super(ExceptionConstants.USER_EMAIL_CANNOT_BE_NULL);
    }
}
