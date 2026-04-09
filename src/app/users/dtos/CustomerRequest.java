package app.users.dtos;

public class CustomerRequest extends UserRequest{

    private String billingAddress;
    private String defaultShippingAddress;
    private String phone;

    public CustomerRequest(String email, String password, String fullName,String billingAddress, String defaultShippingAddress, String phone){
        super(email, password, fullName);
        setBillingAddress(billingAddress);
        setDefaultShippingAddress(defaultShippingAddress);
        setPhone(phone);
    }
    public CustomerRequest(String line){
        super(line);
        String[] props = line.split(",");
        setBillingAddress(props[5]);
        setDefaultShippingAddress(props[6]);
        setPhone(props[7]);
    }

    @Override
    public String toString() {
        return "CUSTOMER"+","+super.toString() + ","+ getBillingAddress() + "," + getDefaultShippingAddress() + "," + getPhone();
    }

    public String getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(String billingAddress) {
        validateBillingAddress(billingAddress);
        this.billingAddress = billingAddress;
    }
    public String getDefaultShippingAddress() {
        return defaultShippingAddress;
    }
    public void setDefaultShippingAddress(String defaultShippingAddress) {
        validateDefaultShippingAddress(defaultShippingAddress);
        this.defaultShippingAddress = defaultShippingAddress;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }


    private void validateBillingAddress(String billingAddress){
        if(billingAddress.isEmpty()){
            throw new IllegalArgumentException("billing address cannot be empty");
        }
    }
    private void validateDefaultShippingAddress(String defaultShippingAddress){
        if(defaultShippingAddress.isEmpty()){
            throw new IllegalArgumentException("Default shipping address cannot be empty");
        }
    }
    private void validatePhone(String phone){
        if(phone.isEmpty()){
            throw new IllegalArgumentException("email cannot be empty");
        }
    }
}
