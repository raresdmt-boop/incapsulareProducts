package app.users.models;

import app.users.exceptions.UserEmailCannotBeNull;
import app.users.exceptions.UserFullNameCannotBeNull;
import app.users.exceptions.UserIDCannotBeNegative;
import app.users.exceptions.UserPasswordCannotBeNull;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String email;
    private String password;
    private String fullName;
    private final List<Permissions> permissions = new ArrayList<>();

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
    public User(String email, String password, String fullName) {
        setEmail(email);
        setPassword(password);
        setFullName(fullName);
    }

    @Override
    public String toString() {
        return getId()+","+getEmail()+","+getPassword()+","+getFullName();
    }
    @Override
    public boolean equals(Object obj) {
        return ((User)obj).getId()==getId() && ((User)obj).getEmail().equals(getEmail()) && ((User)obj).getPassword().equals(getPassword())
                && ((User)obj).getFullName().equals(getFullName());
    }

    public void play(){
        System.out.println("Playing User");
    }

    public int getId() {
        return id;
    }
    public void setId(int id) throws UserIDCannotBeNegative {
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
    public void setPassword(String password) throws UserPasswordCannotBeNull {
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


    private void validateID(int id) throws UserIDCannotBeNegative {
        if(id<0){
            throw new UserIDCannotBeNegative();
        }
    }
    private void validateEmail(String email) throws UserEmailCannotBeNull {
        if(email==null || email.isEmpty()){
            throw new UserEmailCannotBeNull();
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

 // de adaugare
    public void addPermissions(Permissions permissions){
        this.permissions.add(permissions);
    }
    public void removePermissions(Permissions permissions){
        this.permissions.remove(permissions);
    }
    public boolean hasPermissions(Permissions permissions){
        return this.permissions.contains(permissions);
    }
    public Permissions getPermissionbyName(String name){
        for(Permissions p : this.permissions){
            if(p.name().equals(name)){
                return p;
            }
        }return null;
    }


}
