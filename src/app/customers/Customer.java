package app.customers;

public class Customer {

    private int id;
    private String email;
    private String password;
    private String fullName;
    private String billingAddress;
    private String defaultShippingAddress;
    private String phone;

    public Customer(String line) {
        String[] props = line.split(",");
        this.id = Integer.parseInt(props[0]);
        this.email = props[1];
        this.password = props[2];
        this.fullName = props[3];
        this.billingAddress = props[4];
        this.defaultShippingAddress = props[5];
        this.phone = props[6];
    }

    public Customer(int id, String email, String password, String fullName, String billingAddress, String defaultShippingAddress, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.billingAddress = billingAddress;
        this.defaultShippingAddress = defaultShippingAddress;
        this.phone = phone;
    }

    public Customer() {

    }

    @Override
    public String toString() {
        return this.id + "," + this.email + "," + this.password + "," + this.fullName + "," + this.billingAddress + "," + this.defaultShippingAddress + "," + this.phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        validateID(id);
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        validateFullName(fullName);
        this.fullName = fullName;
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

    private void validateID(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid Customer ID");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Email");
        }
    }

    private void validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Password");
        }
    }

    private void validateFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Full Name");
        }
    }

    private void validateBillingAddress(String billingAddress) {
        if (billingAddress == null || billingAddress.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Billing Address");
        }
    }

    private void validateDefaultShippingAddress(String defaultShippingAddress) {
        if (defaultShippingAddress == null || defaultShippingAddress.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Default Shipping Address");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Phone Number");
        }
    }
}
