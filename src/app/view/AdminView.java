package app.view;

import app.orders.services.OrderQueryServiceSingleton;
import app.orders.services.interfaces.OrderQueryService;
import app.users.models.Admin;
import app.users.models.Customer;
import app.users.models.Permissions;
import app.users.models.User;
import app.users.services.UserQueryServiceSingleton;
import app.users.services.interfaces.UserQueryService;

public class AdminView extends AuthorizedView {

    private OrderQueryService orderQueryService;
    private UserQueryService userQueryService;

    protected AdminView(User user) {
        super(user);
        orderQueryService = OrderQueryServiceSingleton.getInstance();
        userQueryService = UserQueryServiceSingleton.getInstance();
        play();
    }

    @Override
    protected void validatePermission() {
        if(!hasPermission(Permissions.VIEW_PRODUCTS)
                || !hasPermission(Permissions.VIEW_ALL_ORDERS)
                || !hasPermission(Permissions.VIEW_ORDER_DETAILS)
                || !hasPermission(Permissions.MANAGE_PRODUCTS)){
            throw new IllegalArgumentException("You don't have permission to perform this action.");
        }
    }

    @Override
    protected void meniu() {
        System.out.println("AdminView");
        System.out.println("1-> Vanzari totale.");

    }

    @Override
    protected boolean getOption(int option) {
        switch (option) {
            case 1:
                vanzariTotale();
                return true;
            case 2:
                deletePermission();
                return false;
            default:
                return false;
        }
    }

    private void vanzariTotale(){
        validatePermission();
        double vanzari = orderQueryService.getTotal();
        System.out.println("Vanzari Totale: " + vanzari);
    }

    private void deletePermission(){
        validatePermission();
        System.out.println("Which Customer?(email)");
        String email = sc.nextLine();
        System.out.println("Which Permission?");
        String permission = sc.nextLine();
        Permissions permissions = Permissions.valueOf(permission);
        if(userQueryService.getUserbyEmail(email) instanceof Admin){
            throw new IllegalArgumentException("You don't have permission to edit admin permissions");
        }
        deletePermissionimpl(userQueryService.getUserbyEmail(email), permissions);
    }
    private void deletePermissionimpl(User customer, Permissions permission){
        if(!hasPermission(Permissions.MANAGE_PERMISSIONS)){
            throw new IllegalArgumentException("You don't have permission to perform this action.");
        }
        customer.removePermissions(permission);
    }

}
