package app.users.exceptions;

public class UserFullNameCannotBeNull extends RuntimeException {
    public UserFullNameCannotBeNull() {
        super(ExceptionConstants.USER_FULL_NAME_CANNOT_BE_NULL);
    }
}
