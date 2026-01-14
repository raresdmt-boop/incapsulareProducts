package app.orders;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OrdersService {
    private ArrayList<Orders> orderList;
    private File ordersFile;

    public OrdersService() {
        orderList = new ArrayList<>();
        ordersFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\Orders\\orders.txt");
        loadOrdersService();
    }

    private void loadOrdersService() {
        try{
            Scanner sc = new Scanner(ordersFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                try{
                    this.orderList.add(new Orders(line));
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
