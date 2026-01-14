package app.products;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductsService {
    private File productsFile;
    private ArrayList<Products> productList;

    public ProductsService() {
        this.productList = new ArrayList<>();
        productsFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\products\\products.txt");
        loadProducts();
    }

    public String descriereProdus(int id){
        return productList.get(id).toString();
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
                    this.productList.add(new Products(line));
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
