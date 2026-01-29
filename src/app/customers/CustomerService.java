package app.customers;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CustomerService {
    public String name = "test";
    private final ArrayList<Customer> customerList;
    private final File customersFile;

    public CustomerService() {
        this.customerList = new ArrayList<>();
        customersFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\Customers\\customers.txt");
        loadCustomers();
        String name = "test2";

        System.out.println(this.name);
    }

    public Customer getCustomer(String email, String password) {
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }
    public Customer getCustomerById(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                return customerList.get(i);
            }

        }
        return null;
    }

    public void createCustomer(String email, String password, String fullName, String billingAddress, String defaultShippingAddress, String phone) {
        int id = generateID();
        customerList.add(new Customer(id, email, password, fullName, billingAddress, defaultShippingAddress, phone));
        saveCustomers();
    }
    public Customer checkEmail(String email) {
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }
    public boolean checkPassword(String password) {
        for (Customer customer : customerList) {
            if (customer.getPassword().equals(password)) {
                return true;
            }
        }return false;
    }



    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        int i = 0;
        for (; i < customerList.size() - 1; i++) {
            sb.append(customerList.get(i).toString() + "\n");
        }
        sb.append(customerList.get(i).toString());
        return sb.toString();
    }

    private void loadCustomers() {
        try {
            Scanner scanner = new Scanner(customersFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    customerList.add(new Customer(line));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void saveCustomers() {
        try {
            FileWriter writer = new FileWriter(customersFile);
            PrintWriter pw = new PrintWriter(writer);
            pw.write(this.toString());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int generateID() {
        Random rand = new Random();

        int id = rand.nextInt(9999) + 1;
        while (getCustomerById(id) != null) {
            id = rand.nextInt(9999) + 1;
        }

        return id;
    }


}

