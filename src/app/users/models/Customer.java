package app.users.models;


public class Customer extends User {

    private String billingAddress;
    private String defaultShippingAddress;
    private String phone;


    public Customer(int id, String email, String password, String fullName,String billingAddress, String defaultShippingAddress, String phone) {
        super(id, email, password, fullName);
        setBillingAddress(billingAddress);
        setDefaultShippingAddress(defaultShippingAddress);
        setPhone(phone);

    }
    public Customer(String line){
        super(line);
        String[] props = line.split(",");
        setBillingAddress(props[5]);
        setDefaultShippingAddress(props[6]);
        setPhone(props[7]);
        String[]permissions = props[8].split(";");
        for(String p : permissions){
             this.addPermissions(Permissions.valueOf(p));
        }
    }
    public Customer(String email,  String password, String fullName, String billingAddress, String defaultShippingAddress, String phone) {
        super(email, password, fullName);
        setBillingAddress(billingAddress);
        setDefaultShippingAddress(defaultShippingAddress);
        setPhone(phone);
    }

    @Override
    public String toString() {
        return "CUSTOMER"+","+super.toString() + "," + getBillingAddress() + "," + getDefaultShippingAddress() + "," + getPhone();
    }
    @Override
    public void play(){

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
            throw new IllegalArgumentException("phone cannot be empty");
        }
    }

}
