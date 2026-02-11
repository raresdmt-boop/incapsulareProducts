package app.orders;


import app.users.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private final ArrayList<Order> orderList;
    private final File ordersFile;

    public OrderService() {
        orderList = new ArrayList<>();
        ordersFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\Orders\\orders.txt");
        loadOrdersService();
    }

    public ArrayList<Order> getCustomerOrders(Customer customer) {
        ArrayList<Order> customerOrderList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getCustomerId() == customer.getId()) {
                customerOrderList.add(orderList.get(i));
            }
        }
        return customerOrderList;
    }
    public Order getOrderbyID(int orderId) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId() == orderId) {
                return orderList.get(i);
            }
        }
        return null;
    }


    public int generateOrderID() {
        int id = 0;
        for (int i = 0; i < orderList.size(); i++) {
            if (i == orderList.size() - 1) {
                id = orderList.get(i).getId() + 1;
            }
        }
        return id;
    }
    public Order createOrder(Customer customer, double amount) {
        int id = generateOrderID();
        int customerID = customer.getId();
        String shippingAddress = customer.getDefaultShippingAddress();
        String billingAddress = customer.getBillingAddress();
        String email = customer.getEmail();
        String orderDate = "26/01/26";
        String orderStatus = "Pending Payment";

        Order neworder = new Order(id, customerID, amount, shippingAddress, billingAddress, email, orderDate, orderStatus);

        orderList.add(neworder);
        saveOrders();
        return neworder;
    }
    public double vanzariTotale() {
        int total = 0;
        for (Order order : orderList) {
            total += (int) order.getAmount();
        }
        return total;
    }

    public List<Integer> buyingCustomersIDs(){
        List<Integer> customerIDs = new ArrayList<>();
        for(int i = 0; i < orderList.size(); i++){
            customerIDs.add(orderList.get(i).getCustomerId());
        }
        return customerIDs;
    }

    public double amountSpentOnSite(int customerID){
        double amount = 0;
        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getCustomerId() == customerID){
                amount+= orderList.get(i).getAmount();
            }
        }
        return amount;
    }

    public int bestCustomerID(){
        List<Integer> customerIDs = buyingCustomersIDs();
        int bestCustomerID = 0;
        double maxAmount = 0;
        for(int i = 0; i < customerIDs.size(); i++) {
            double amountSpent = amountSpentOnSite(customerIDs.get(i));
            if (amountSpent > maxAmount) {
                bestCustomerID = customerIDs.get(i);
                maxAmount = amountSpent;
            }

        }
        return bestCustomerID;
    }

    @Override
    public String toString() {
        StringBuffer sb1 = new StringBuffer();
        int i = 0;
        for (; i < orderList.size() - 1; i++) {
            sb1.append(orderList.get(i).toString() + "\n");
        }
        sb1.append(orderList.get(i).toString());
        return sb1.toString();
    }

    private void loadOrdersService() {
        try {
            Scanner sc = new Scanner(ordersFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    this.orderList.add(new Order(line));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void saveOrders() {
        try {
            FileWriter fw = new FileWriter(ordersFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(this.toString());
            pw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }




}
