package app.orderDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderDetailsService {
    private ArrayList<OrderDetails> orderDetailsList;
    private File orderDetailsFile;

    public OrderDetailsService() {
        orderDetailsList = new ArrayList<>();
        orderDetailsFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\OrderDetails\\orderDetails.txt");
        loadOrderDetails();
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int i=0;
        for(;i<orderDetailsList.size()-1;i++){
            sb.append(orderDetailsList.get(i).toString()+"\n");
        }
        sb.append(orderDetailsList.get(i).toString());
        return sb.toString();
    }

    public String descriereOrderDetails(int id){
        return orderDetailsList.get(id).toString();
    }

    private void loadOrderDetails() {
        try {
            Scanner sc = new Scanner(orderDetailsFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    this.orderDetailsList.add(new OrderDetails(line));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void saveOrderDetails() {
        try {
            FileWriter fw = new FileWriter(orderDetailsFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(this.toString());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

