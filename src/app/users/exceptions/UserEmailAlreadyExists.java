package app.users.exceptions;

public class UserEmailAlreadyExists extends RuntimeException {
    public UserEmailAlreadyExists() {
        super(ExceptionConstants.USER_EMAIL_ALREADY_EXISTS);
    }
}
