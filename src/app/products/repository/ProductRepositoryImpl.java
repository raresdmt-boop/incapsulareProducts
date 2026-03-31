package app.products.repository;

import app.products.request.ProductRequest;
import app.products.models.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;
    private File productsFile;
    public ProductRepositoryImpl(){
        products = new ArrayList<>();
        productsFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\products\\data\\products.txt");
        loadProducts();
    }

    private void loadProducts(){
        try{
            Scanner sc = new Scanner(productsFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                try{
                    products.add(new Product(line));
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
    private void saveProducts(){
        try{
            FileWriter fw = new FileWriter(productsFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(this.toString());
            pw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public boolean IdExists(int id){
        for(Product p:products){
            if(p.getID()==id){
                return true;
            }
        }
        return false;
    }
    public int generateProductID(){
        Random rand = new Random();
        int id = rand.nextInt(9999)+1;
        while(IdExists(id)){
            id = rand.nextInt(9999)+1;
        }
        return id;
    }
    public Product getProduct(int id){
        for(Product p:products){
            if(p.getID()==id){
                return p;
            }
        }
        return null;
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

    @Override
    public Optional<Product> findById(int id) {
        for(Product p:products){
            if(p.getID()==id){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product saveProduct(Product product) {
        product.setID(generateProductID());
        products.add(product);
        saveProducts();
        return product;
    }

    @Override
    public Product deleteProduct(int id) {
        Product product = getProduct(id);
        products.remove(product);
        saveProducts();
        return product;
    }

    @Override
    public Product updateProduct(int id, ProductRequest productRequest) {
        Product product = getProduct(id);
        product.setSKU(productRequest.getSKU());
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());
        product.setDescriptions(productRequest.getDescriptions());
        product.setStock(productRequest.getStock());
        product.setWeight(productRequest.getWeight());
        saveProducts();
        return product;
    }

    @Override
    public Product findByName(String name) {
        for(Product p:products){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
}
