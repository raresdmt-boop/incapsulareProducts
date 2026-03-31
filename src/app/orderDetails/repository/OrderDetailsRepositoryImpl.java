package app.orderDetails.repository;

import app.orderDetails.dtos.OrderDetailsRequest;
import app.orderDetails.models.OrderDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

    private List<OrderDetails> orderDetailsList;
    private File orderDetailsFile;

    public OrderDetailsRepositoryImpl() {
        orderDetailsList = new ArrayList<>();
        orderDetailsFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\orderDetails\\data\\orderDetails.txt");
        loadOrderDetails();
    }

    private void loadOrderDetails() {
        try{
            Scanner sc =  new Scanner(orderDetailsFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try{
                    orderDetailsList.add(new OrderDetails(line));
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    private void saveOrderDetails() {
        try{
            FileWriter fw = new FileWriter(orderDetailsFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(this.toString());
            pw.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        int i=0;
        for(; i< orderDetailsList.size()-1; i++){
            sb.append(orderDetailsList.get(i) + "\n");
        }
        sb.append(orderDetailsList.get(i));
        return sb.toString();
    }
    public boolean idExists(int id) {
        for(OrderDetails orderDetails: orderDetailsList){
            if(orderDetails.getId()==id){
                return true;
            }
        }
        return false;
    }
    public int generateOrderDetID(){
        Random rand = new Random();
        int orderDetID = rand.nextInt(9999)+1;
        while(idExists(orderDetID)){
            orderDetID = rand.nextInt(9999)+1;
        }
        return orderDetID;
    }
    public OrderDetails getOrderDetails(int id) {
        for(OrderDetails orderDetails: orderDetailsList){
            if(orderDetails.getId()==id){
                return orderDetails;
            }
        }
        return null;
    }



    @Override
    public Optional<OrderDetails> findById(int id) {
        for(OrderDetails orderDetails: orderDetailsList){
            if(orderDetails.getId()==id){
                return Optional.of(orderDetails);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<OrderDetails> getAll() {
        return new ArrayList<>(orderDetailsList);
    }

    @Override
    public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
        orderDetails.setId(generateOrderDetID());
        orderDetailsList.add(orderDetails);
        saveOrderDetails();
        return orderDetails;
    }

    @Override
    public OrderDetails deleteOrderDetails(int id) {
        OrderDetails orderDetails = getOrderDetails(id);
        orderDetailsList.remove(orderDetails);
        saveOrderDetails();
        return orderDetails;
    }

    @Override
    public OrderDetails updateOrderDetails(int id, OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = getOrderDetails(id);
        orderDetails.setOrderID(orderDetailsRequest.getOrderID());
        orderDetails.setProductID(orderDetailsRequest.getProductID());
        orderDetails.setPrice(orderDetailsRequest.getPrice());
        orderDetails.setSku(orderDetailsRequest.getSku());
        orderDetails.setQuantity(orderDetailsRequest.getQuantity());
        saveOrderDetails();
        return orderDetails;
    }
}
