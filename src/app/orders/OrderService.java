package app.orders;

import app.customers.Customer;
import app.orderDetails.OrderDetails;
import app.orderDetails.OrderDetailsService;
import app.products.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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



    public ArrayList<Product> getBasket(Customer customer){
        ArrayList<Order> customerOrders = getCustomerOrders(customer);
        Order basketOrder = null;
        for(int i=0;i<customerOrders.size();i++){
            Order order = customerOrders.get(i);
            if (order.getOrderStatus().contains("BASKET")){
                basketOrder = order;
            }
        }
        if(basketOrder==null){
            return new ArrayList<>();
        }
        OrderDetailsService orderDetailsService = new OrderDetailsService();
        return orderDetailsService.productsFromOrder(basketOrder);
    }
    public void createOrder(Customer customer, Product product){
        int orderDetailsID=orderList.size()+1000;
        int orderID=orderList.size()+500;
        OrderDetails orderDetails = new OrderDetails(orderDetailsID, orderID, product.getID(), product.getPrice(), product.getSKU(), 1);
        Order bucket = new Order(orderID, customer.getId(), 1000, customer.getDefaultShippingAddress(), customer.getBillingAddress(), customer.getEmail(), "21/01/2026", "BASKET");
        orderList.add(bucket);
        saveOrders();
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
    private void saveOrders() {
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
