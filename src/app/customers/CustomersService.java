package app.customers;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CustomersService {
    private ArrayList<Customers> customersList;
    private File customersFile;

    public CustomersService(){
        this.customersList = new ArrayList<>();
        customersFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\Customers\\customers.txt");
        loadCustomers();
    }

    public Customers getCustomer(String email, String password){
        for(Customers customer : customersList){
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password)){
                return customer;
            }
        }return null;
    }
    public Customers getCustomerById(int id){
        for(int i=0;i<customersList.size();i++){
            if(customersList.get(i).getId()==id){
                return customersList.get(i);
            }

        }return null;
    }
    public void createCustomer(String email, String password, String fullName, String billingAddress, String defaultShippingAddress, String phone){
        int id = generateID();
        customersList.add(new Customers(id, email, password, fullName, billingAddress, defaultShippingAddress, phone));
        saveCustomers();
    }

    private int generateID() {
        Random rand = new Random();

        int id = rand.nextInt(9999) + 1;
        while (getCustomerById(id) != null) {
            id = rand.nextInt(9999) + 1;
        }

        return id;
    }

    


    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        int i=0;
        for(;i<customersList.size()-1;i++){
            sb.append(customersList.get(i).toString()+"\n");
        }
        sb.append(customersList.get(i).toString());
        return sb.toString();
    }
    private void loadCustomers(){
        try{
            Scanner scanner = new Scanner(customersFile);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                try{
                    customersList.add(new Customers(line));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void saveCustomers(){
        try{
            FileWriter writer = new FileWriter(customersFile);
            PrintWriter pw = new PrintWriter(writer);
            pw.write(this.toString());
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

