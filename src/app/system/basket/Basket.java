package app.system.basket;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Basket {
//
    private List<ProductDto> products;
    private File basketfile;
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }



    public Basket(int customerId) {
        this.customerId = customerId;
        this.products = new ArrayList<>();
        basketfile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\system\\basket\\basket.txt");
        loadBasket();
    }
    public void addToBasket(ProductDto productDto) {
        if(products.isEmpty()) {
            products.add(productDto);
        }
        ProductDto productinList = findInList(productDto);
        if (productinList == null) {
            products.add(productDto);
        }else{
            productinList.setProductQuantity(productDto.getProductQuantity()+productinList.getProductQuantity());
        }

        saveBasket();
    }
    public void removeFromBasket(String name){
        if(products.isEmpty()) {
            throw new IllegalArgumentException("Basket is empty");
        }

        ProductDto productinList = findInListByName(name);
        if (productinList == null) {
            throw new IllegalStateException("Product not found in basket");
        }else {
            products.remove(productinList);
        }

        saveBasket();
    }
    public void editBasketQuantity(String name, int quantity){
        if(products.isEmpty()) {
            throw new IllegalArgumentException("Basket is empty");
        }
        ProductDto productinList = findInListByName(name);
        if (productinList == null) {
            throw new IllegalArgumentException("Product not found in basket");
        }else{
            productinList.setProductQuantity(quantity);
        }
    }
    public List<ProductDto> getBasketProducts(){
        return products;
    }
    public void editQuantity(ProductDto productDto, int quantity){
        ProductDto productinList = findInList(productDto);
        if(productinList == null) {
            throw new RuntimeException();
        }else{
            productinList.setProductQuantity(quantity);
        }
    }


    public int createDtoID(){
        return products.size()+1;
    }


    public ProductDto findInList(ProductDto productDto){
        for(int i = 0; i < products.size(); i++){
            if(productDto.getProductId() == products.get(i).getProductId()){
                return products.get(i);
            }
        }return null;
    }
    public ProductDto findInListByName(String name){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductName().equals(name)){
                return products.get(i);
            }
        }return null;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        int i=0;
        for(;i<products.size()-1;i++){
            sb.append(products.get(i)+"\n");
        }
        sb.append(products.get(i));
        return sb.toString();
    }

    private void loadBasket(){
        try{
            Scanner scanner = new Scanner(basketfile);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                try{
                    this.products.add(new ProductDto(line));
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void saveBasket(){
        try {
            FileWriter fw = new FileWriter(basketfile);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(this.toString());
            pw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }


    //crud
}
