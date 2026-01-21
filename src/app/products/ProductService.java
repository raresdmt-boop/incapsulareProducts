package app.products;

import app.customers.Customer;
import app.orders.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private File productsFile;
    private ArrayList<Product> productList;
    private ArrayList<Product> basket;

    public ProductService() {
        this.productList = new ArrayList<>();
        productsFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\products\\products.txt");
        loadProducts();
    }

    public String descriereProdus(int id){
        return productList.get(id).toString();
    }
    public String getProductNameById(int productId){
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getID() == productId){
                return productList.get(i).getName();
            }
        }return null;
    }


    //todo: metode pt basket
    public Product getProductByName(String productName){
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getName().equals(productName)){
                return productList.get(i);
            }
        }return null;
    }




    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int i=0;
        for(;i<productList.size()-1;i++){
            sb.append(productList.get(i)+"\n");
        }
        sb.append(productList.get(i));
        return sb.toString();
    }

    private void loadProducts(){
        try{
            Scanner sc = new Scanner(productsFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                try{
                    this.productList.add(new Product(line));
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void saveProducts() {
        try {
            FileWriter fw = new FileWriter(productsFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(this.toString());
            pw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
