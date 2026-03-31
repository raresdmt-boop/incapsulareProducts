package app.users.dtos;

import app.users.exceptions.UserEmailCannotBeNull;
import app.users.exceptions.UserFullNameCannotBeNull;
import app.users.exceptions.UserPasswordCannotBeNull;


public class UserRequest implements UserRequestFactory {

    private String email;
    private String password;
    private String fullName;


    public UserRequest(String email, String password, String fullName)  {
        setEmail(email);
        setPassword(password);
        setFullName(fullName);
    }
    public UserRequest(String line){
        String[] props = line.split(",");
        setEmail(props[1]);
        setPassword(props[2]);
        setFullName(props[3]);
    }
    public UserRequest() {}

    @Override
    public String toString() {
        return getEmail()+","+getPassword()+","+getFullName();
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws UserEmailCannotBeNull {
        validateEmail(email);
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password)  throws UserPasswordCannotBeNull {
        validatePassword(password);
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) throws UserFullNameCannotBeNull {
        validateFullName(fullName);
        this.fullName = fullName;
    }


    private void validateEmail(String email) throws UserEmailCannotBeNull {
        if(email==null || email.isEmpty()){
            throw new  UserEmailCannotBeNull();
        }
    }
    private void validatePassword(String password) throws UserPasswordCannotBeNull {
        if(password==null || password.isEmpty()){
            throw new UserPasswordCannotBeNull();
        }
    }
    private void validateFullName(String fullName) throws UserFullNameCannotBeNull {
        if(fullName==null || fullName.isEmpty()){
            throw new UserFullNameCannotBeNull();
        }
    }


    @Override
    public UserRequest createUserRequestFromText(String text) {
        String type = text.split(",")[0];
        return switch(type){
            case "ADMIN" -> new AdminRequest(text);
            case "CUSTOMER" -> new CustomerRequest(text);
            default -> throw new IllegalArgumentException("Invalid Product Request Type");
        };
    }

    @Override
    public UserRequest createFromRequest(UserRequest userRequest) {
        if(userRequest instanceof AdminRequest adminRequest){
            return new AdminRequest(adminRequest.getEmail(), adminRequest.getPassword(), adminRequest.getFullName(),
                    adminRequest.getManagerialLevel());
        }
        else if(userRequest instanceof CustomerRequest customerRequest){
            return new CustomerRequest(customerRequest.getEmail(), customerRequest.getPassword(),
                    customerRequest.getFullName(), customerRequest.getBillingAddress(),
                    customerRequest.getDefaultShippingAddress(), customerRequest.getPhone());
        }
        return null;
    }
}
