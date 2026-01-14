package app.orders;

import app.customers.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderService {
    private ArrayList<Order> orderList;
    private File ordersFile;

    public OrderService() {
        orderList = new ArrayList<>();
        ordersFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\Orders\\orders.txt");
        loadOrdersService();
    }

    public ArrayList<Order> getCustomerOrders(Customer customer){
        ArrayList<Order> customerOrderList = new ArrayList<>();
        for(int i=0;i<orderList.size();i++){
            if(orderList.get(i).getCustomerId()==customer.getId()){
                customerOrderList.add(orderList.get(i));
            }
        }return customerOrderList;
    }
    public Order getOrderbyID(int orderId){
        for(int i=0;i<orderList.size();i++){
            if(orderList.get(i).getId()==orderId){
                return orderList.get(i);
            }
        }return null;
    }
    public Order createOrder(Customer customer){
        int customerid=customer.getId()
        Order order = new Order(id);
    }

    private void loadOrdersService() {
        try{
            Scanner sc = new Scanner(ordersFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                try{
                    this.orderList.add(new Order(line));
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void saveOrders() throws IOException {
        try {
            FileWriter fw = new FileWriter(ordersFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(this.toString());
            pw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
