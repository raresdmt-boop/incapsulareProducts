package app.users;

public class User {

    private int id;
    private String email;
    private String password;
    private String fullName;

    public User(int id, String email, String password, String fullName) {
        setId(id);
        setEmail(email);
        setPassword(password);
        setFullName(fullName);
    }
    public User(String line){
        String[] props = line.split(",");
        setId(Integer.parseInt(props[1]));
        setEmail(props[2]);
        setPassword(props[3]);
        setFullName(props[4]);
    }

    @Override
    public String toString() {
        return getId()+","+getEmail()+","+getPassword()+","+getFullName();
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


    private void validateID(int id){
        if(id<0){
            throw new IllegalArgumentException("Invalid ID");
        }
    }
    private void validateEmail(String email){
        if(email==null || email.isEmpty()){
            throw new IllegalArgumentException("User email cannot be empty");
        }
    }
    private void validatePassword(String password){
        if(password==null || password.isEmpty()){
            throw new IllegalArgumentException("User password cannot be empty");
        }
    }
    private void validateFullName(String fullName){
        if(fullName==null || fullName.isEmpty()){
            throw new IllegalArgumentException("User full name cannot be empty");
        }
    }

}
