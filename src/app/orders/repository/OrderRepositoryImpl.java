package app.orders.repository;

import app.orders.dtos.OrderRequest;
import app.orders.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class OrderRepositoryImpl implements OrderRepository {
    protected ArrayList<Order> orders;
    private File ordersFile;

    public OrderRepositoryImpl() {
        orders = new ArrayList<>();
        ordersFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\orders\\data\\orders.txt");
        loadOrders();
    }

    public void loadOrders() {
        try{
            Scanner sc = new Scanner(ordersFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try{
                    orders.add(new Order(line));
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void saveOrders() {
        try{
            FileWriter fw = new FileWriter(ordersFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(this.toString());
            pw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public boolean idExists(int id){
        for(Order order:orders){
            if(order.getId()==id){
                return true;
            }
        }
        return false;
    }
    public int generateOrderId(){
        Random rand = new Random();
        int orderId = rand.nextInt(9999)+1;
        while(idExists(orderId)){
            orderId = rand.nextInt(9999)+1;
        }
        return orderId;
    }
    public Order getOrder(int id){
        for(Order order:orders){
            if(order.getId()==id){
                return order;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        int i=0;
        for(;i<orders.size()-1;i++){
            sb.append(orders.get(i) + "\n");
        }
        sb.append(orders.get(i));
        return sb.toString();
    }

    @Override
    public Optional<Order> findById(int id) {
        for(Order order:orders){
            if(order.getId()==id){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order saveOrder(Order order) {
        order.setId(generateOrderId());
        orders.add(order);
        saveOrders();
        return order;
    }

    @Override
    public Order deleteOrder(int id) {
        Order order = getOrder(id);
        orders.remove(order);
        saveOrders();
        return order;
    }

    @Override
    public Order updateOrder(int id, OrderRequest orderRequest) {
        Order order = getOrder(id);
        order.setCustomerId(orderRequest.getCustomerId());
        order.setAmount(orderRequest.getAmount());
        order.setShippingAddress(orderRequest.getShippingAddress());
        order.setOrderAddress(orderRequest.getOrderAddress());
        order.setOrderEmail(orderRequest.getOrderEmail());
        order.setOrderDate(orderRequest.getOrderDate());
        order.setOrderStatus(orderRequest.getOrderStatus());
        saveOrders();
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        for(Order order:orders){
            if(order.getId()==id){
                return order;
            }
        }
        return null;
    }


}
