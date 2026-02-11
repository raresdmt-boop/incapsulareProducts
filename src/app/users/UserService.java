package app.users;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserService {

    private final List<User> usersList;
    private final File usersFile;

    public UserService(){
        usersList = new ArrayList<User>();
        usersFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\users\\users.txt");
        loadUsers();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(;i < usersList.size()-1; i++){
            if(usersList.get(i) instanceof Admin){
                Admin admin = (Admin) usersList.get(i);
                sb.append(admin.toString()+"\n");
            }
            if(usersList.get(i) instanceof Customer){
                Customer customer = (Customer) usersList.get(i);
                sb.append(customer.toString()+"\n");
            }
        }
        if(usersList.get(i) instanceof Admin){
            Admin admin = (Admin) usersList.get(i);
            sb.append(admin.toString());
        }
        if(usersList.get(i) instanceof Customer){
            Customer customer = (Customer) usersList.get(i);
            sb.append(customer.toString());
        }
        return sb.toString();
    }

    public void addUser(User user){
        usersList.add(user);
        saveUsers();
    }

    public Admin getAdminbyMail(String mail){
        Admin admin;
        for(User user : usersList){
            if(user.getEmail().equals(mail)&&user instanceof Admin){
                admin = (Admin)user;
                return admin;
            }
        }
        return null;
    }
    public Customer getCustomerbyID(int id){
        Customer customer;
        for(User user : usersList){
            if(user.getId() == id&&user instanceof Customer){
                customer = (Customer)user;
                return customer;
            }
        }
        return null;
    }
    public Customer checkEmail(String email){
        for(User user: usersList){
            if(user.getEmail().equals(email)&&user instanceof Customer){
                return (Customer)user;
            }
        }
        return null;
    }
    public User checkPassword(String password){
        for(User user : usersList){
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public User getUserbyID(int id){
        User user;
        for(User user1 : usersList){
            if(user1.getId() == id){
                user = user1;
                return user;
            }
        }
        return null;
    }
    public String getInstance(String email, String password){
        StringBuilder stringBuilder = new StringBuilder();
        for(User user : usersList){
            if(user.getEmail().equals(email) && user instanceof Admin && user.getPassword().equals(password)){
                stringBuilder.append("ADMIN");
                return stringBuilder.toString();
            }
            if(user.getEmail().equals(email) && user instanceof Customer && user.getPassword().equals(password)){
                stringBuilder.append("CUSTOMER");
                return stringBuilder.toString();
            }
        }
        return null;
    }
    public boolean checkName(String name){
        for(User user : usersList){
            if(user.getFullName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public Admin loggedInAdmin(String email, String password){
        Admin admin;
        for(User user : usersList){
            if(user.getEmail().equals(email) && user.getPassword().equals(password) && user instanceof Admin){
                return (Admin)user;
            }
        }
        return null;
    }
    public Customer loggedInCustomer(String email, String password){
        Customer customer;
        for(User user : usersList){
            if(user.getEmail().equals(email) && user.getPassword().equals(password) && user instanceof Customer){
                return (Customer)user;
            }
        }
        return null;
    }
    public User loggin(String email, String password){
        for(User user : usersList){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }



    private void loadUsers(){
        try{
            Scanner sc = new Scanner(usersFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] props = line.split(",");
                if(props[0].equals("ADMIN")){
                    try{
                        usersList.add(new Admin(line));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                if(props[0].equals("CUSTOMER")){
                    try{
                        usersList.add(new Customer(line));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
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

    public int generateID(){
        Random rand = new Random();

        int id = rand.nextInt(9999)+1;
        while(getUserbyID(id) != null){
            id = rand.nextInt(9999)+1;
        }
        return id;
    }
    public void showUsers(){
        for(User user:usersList){
            System.out.println(user.toString());
        }
    }

}
