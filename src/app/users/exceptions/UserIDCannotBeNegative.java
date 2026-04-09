package app.users.exceptions;

public class UserIDCannotBeNegative extends RuntimeException {
    public UserIDCannotBeNegative() {
        super(ExceptionConstants.USER_ID_CANNOT_BE_NEGATIVE);
    }
}
