package app.view;

import app.users.models.Permissions;
import app.users.models.User;

import java.security.Permission;

public abstract class AuthorizedView extends BaseView {

    protected final User user;

    protected AuthorizedView(User user) {
        super();
        this.user = user;
    }

    protected boolean hasPermission(Permissions permission) {
        return user.hasPermissions(permission);
    }

    protected abstract void validatePermission();
}
