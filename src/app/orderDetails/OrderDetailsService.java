package app.orderDetails;

import app.orders.Order;
import app.products.Product;
import app.system.basket.Basket;
import app.system.basket.ProductDto;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDetailsService {
    private final ArrayList<OrderDetails> orderDetailsList;
    private final File orderDetailsFile;

    public OrderDetailsService() {
        orderDetailsList = new ArrayList<>();
        orderDetailsFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\OrderDetails\\orderDetails.txt");
        loadOrderDetails();
    }

    public String descriereOrderDetails(int id) {
        return orderDetailsList.get(id).toString();
    }

    public List<Integer> orderProductID(Order order) {
        List<Integer> productIdList = new ArrayList<>();
        for (int i = 0; i < orderDetailsList.toArray().length; i++) {
            if (orderDetailsList.get(i).getOrderID() == order.getId()) {
                productIdList.add(orderDetailsList.get(i).getProductID());
            }
        }
        return productIdList;
    }



    @Override
    public String toString() {
        StringBuffer sb;
        sb = new StringBuffer();
        int i = 0;
        for (; i < orderDetailsList.size() - 1; i++) {
            sb.append(orderDetailsList.get(i).toString() + "\n");
        }
        sb.append(orderDetailsList.get(i).toString());
        return sb.toString();
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
    //todo functie de gerare orderDetailsId

    public int generateOrderDetailsID() {
        int orderDetailsID = 0;
        for (int i = 0; i < orderDetailsList.size(); i++) {
            if (i == orderDetailsList.size() - 1) orderDetailsID = orderDetailsList.get(i).getId() + 1;
        }
        return orderDetailsID;
    }
//    public void addOrderDetails(OrderDetails orderDetails){
//        orderDetailsList.add(orderDetails);
//        saveOrderDetails();
//    }

    public void addOrderDetails(List<ProductDto>productDtos, Order order) {
        for (ProductDto productDto : productDtos) {
            OrderDetails orderDetails = OrderDetailsMapper.OrderDetailsFromProductDto(productDto, order.getId());
            orderDetails.setId(generateOrderDetailsID());
            orderDetailsList.add(orderDetails);
        }
        saveOrderDetails();
    }

    public List<Integer> getSoldProductsIDs() {
        List<Integer> soldProducts = new ArrayList<>();
        for (int i = 0; i < orderDetailsList.size(); i++) {
            soldProducts.add(orderDetailsList.get(i).getProductID());
        }
        return soldProducts;
    }

    public int howManyTimesSold(int productID){
        int contor=0;
        for (int i = 0; i < orderDetailsList.size(); i++) {
            if (orderDetailsList.get(i).getProductID() == productID){
                contor+=orderDetailsList.get(i).getQuantity();
            }
        }
        return contor;
    }

    public int bestSellerID(){
        List<Integer> soldProductsID = getSoldProductsIDs();
        int mostSales = 0;
        int bestSellerID = 0;
        for (int i = 0; i < soldProductsID.size(); i++) {
            int sales = howManyTimesSold(soldProductsID.get(i));
            if(sales>mostSales){
                bestSellerID = soldProductsID.get(i);
                mostSales = sales;
            }
        }
        return bestSellerID;
    }


    //functie ce returneaza o lista cu id produselor vandute


}

