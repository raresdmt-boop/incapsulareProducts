package app.users.repository;


import app.users.dtos.UserRequest;
import app.users.factory.UserFactory;
import app.users.factory.UserFactoryImpl;
import app.users.factory.UserFactorySingleton;
import app.users.models.Admin;
import app.users.models.Customer;
import app.users.models.Permissions;
import app.users.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class UserRepositoryImpl implements UserRepository {

    private List<User> users;
    private File usersFile;
    private  UserFactory userFactory;

    public UserRepositoryImpl() {
        users = new ArrayList<>();
        usersFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\users\\data\\users.txt");
        userFactory = UserFactorySingleton.getInstance();
        loadUsers();
    }
    private void loadUsers(){
        try{
            Scanner sc = new Scanner(usersFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                User user = userFactory.createUserFromText(line);
                this.users.add(user);
            }
        }catch(Exception e){
            System.out.println("Error in loading users file");
        }
    }
    private void saveUsers(){
        try{
            FileWriter fw = new FileWriter(usersFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(this);
            pw.close();
        }catch (Exception e){
            System.out.println("Error in saving users file");
        }
    }
    public boolean idExists(int id){
        for(User user : users){
            if(user.getId() == id){
                return true;
            }
        }
        return false;
    }
    public int generateID(){
        Random rand = new Random();
        int userId = rand.nextInt(9999)+1;
        while(idExists(userId)){
            userId = rand.nextInt(9999)+1;
        }
        return userId;
    }
    public User getUser(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int i=0;
        for(;i<users.size()-1;i++){
            sb.append(users.get(i)+"\n");
        }
        sb.append(users.get(i));
        return sb.toString();
    }

    @Override
    public Optional<User> findByID(int id) {
        for(User user : users){
            if(user.getId() == id){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User save(User user) {
        user.setId(generateID());
        users.add(user);
        saveUsers();
        return user;
    }

    @Override
    public User delete(int id) {
        User user = getUser(id);
        users.remove(user);
        saveUsers();
        return user;
    }

    @Override
    public User update(int id, UserRequest userRequest) {
        User user = getUser(id);
        user.setEmail(userRequest.getEmail());
        user.setFullName(userRequest.getFullName());
        user.setPassword(userRequest.getPassword());
        saveUsers();
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        for(User user : users){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        for(User user : users){
            if(user.getEmail().equals(email)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }


}
