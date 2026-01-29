package app.admins;

public class Admin {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public Admin(int id, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Admin(String line){
        String[] props = line.split(",");
        this.id = Integer.parseInt(props[0]);
        this.email = props[1];
        this.password = props[2];
        this.firstName = props[3];
        this.lastName = props[4];
    }

    public Admin(){}


    @Override
    public String toString(){
        return this.id + "," + this.email + "," + this.password + "," + this.firstName + "," + this.lastName;
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
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    private void validateID(int id){
        if(id<0){
            throw new IllegalArgumentException("Admin ID cannot be negative");
        }
    }
    private void validateEmail(String email){
        if(email==null || email.isEmpty()){
            throw new IllegalArgumentException("Admin Email cannot be empty");
        }
    }
    private void validatePassword(String password){
        if(password==null || password.isEmpty()){
            throw new IllegalArgumentException("Admin Password cannot be empty");
        }
    }
    private void validateFirstName(String firstName){
        if(firstName==null || firstName.isEmpty()){
            throw new IllegalArgumentException("First Name cannot be empty");
        }
    }
    private void validateLastName(String lastName){
        if(lastName==null || lastName.isEmpty()){
            throw new IllegalArgumentException("Last Name cannot be empty");
        }
    }
}
