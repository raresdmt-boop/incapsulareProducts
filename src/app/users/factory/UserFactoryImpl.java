package app.users.factory;

import app.users.dtos.AdminRequest;
import app.users.dtos.CustomerRequest;
import app.users.dtos.UserRequest;
import app.users.models.Admin;
import app.users.models.Customer;
import app.users.models.User;

public class UserFactoryImpl implements UserFactory{
    @Override
    public User createUserFromText(String text) {
        String type=text.split("[,;]")[0];
        return switch(type){
            case "ADMIN"-> new Admin(text);
            case "CUSTOMER"-> new Customer(text);
            default -> throw new IllegalArgumentException("Invalid user type");
        };
    }

    @Override
    public User createFromRequest(UserRequest userRequest) {
        if(userRequest instanceof AdminRequest adminRequest){
            return new Admin(adminRequest.getEmail(), adminRequest.getPassword(), adminRequest.getFullName(), adminRequest.getManagerialLevel());
        }
        if(userRequest instanceof CustomerRequest customerRequest){
            return new Customer(customerRequest.getEmail(), customerRequest.getPassword(), customerRequest.getFullName(),
                    customerRequest.getBillingAddress(), customerRequest.getDefaultShippingAddress(), customerRequest.getPhone());
        }
        throw new IllegalArgumentException("Invalid user request");
    }

    @Override
    public User createCustomer(int id, String email, String password, String fullName, String billingAddress, String defaultShippingAddress, String phone) {
        return new Customer(id, email, password, fullName,billingAddress, defaultShippingAddress, phone);
    }

    @Override
    public User createAdmin(int id, String email, String password, String fullName, boolean managerialLevel) {
        return new Admin(id, email, password, fullName,managerialLevel);
    }
}
