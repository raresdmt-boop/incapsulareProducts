package app.products.repository;

import app.products.comparators.ProductIDComparator;
import app.products.models.Product;
import app.products.request.ProductRequest;

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
        return products.stream().anyMatch((product -> product.getID() == id));
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
        return products.stream()
                .filter((product -> product.getID() == id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        products.stream().limit(products.size()-1).forEach((product -> sb.append(product.toString()+"\n")));
        sb.append(products.stream().max(new ProductIDComparator()));
        return sb.toString();
    }

    @Override
    public Optional<Product> findById(int id) {
        return products.stream().filter((product -> product.getID() == id)).findFirst();
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
        return products.stream()
                .filter((product -> product.getName().equals(name)))
                .findFirst()
                .orElse(null);
    }
}
