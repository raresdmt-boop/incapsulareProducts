package app.view;


import app.admins.Admin;
import app.customers.Customer;
import app.customers.CustomerService;
import app.orderDetails.OrderDetailsService;
import app.orders.OrderService;
import app.products.Product;
import app.products.ProductService;
import app.orderDetails.OrderDetails;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {

    private final Scanner sc;
    private final OrderService orderService;
    private final ProductService productService;
    private final Admin admin;
    private final OrderDetailsService orderDetailsService;
    private final CustomerService customerService;

    public AdminView(Admin admin) {
        this.sc = new Scanner(System.in);
        this.orderService = new OrderService();
        this.admin = admin;
        this.productService = new ProductService();
        this.orderDetailsService = new OrderDetailsService();
        this.customerService = new CustomerService();
    }

    public void play(){

        boolean continua=true;
        while(continua){
            meniuAdmin();
            int alegere = Integer.parseInt(sc.nextLine());
            switch(alegere){
                case 1:
                    vanzariTotale();
                    break;
                case 2:
                    urgenteStock();
                    break;
                case 3:
                    updateStock();
                    break;
                case 4:
                    stergeProdus();
                    break;
                case 5:
                    createProdus();
                    break;
                case 6:
                    bestSeller();
                    break;
                case 7:
                    bestCustomer();
                    break;

            }
        }
    }

    void meniuAdmin(){
        System.out.println("Welcome Admin");
        System.out.println("1-> Verifica vanzari totale.");
        System.out.println("2-> Verifica urgente stock.");
        System.out.println("3-> Update stock.");
        System.out.println("4-> Sterge products.");
    }

    void vanzariTotale(){
        int vanzari = (int)orderService.vanzariTotale();
        System.out.println("Total de vanzari: "+vanzari);
    }

    void urgenteStock(){
        ArrayList<Product> urgenteStock = productService.getStockEmergencies();
        System.out.println("Urgentele de stock sunt:");
        for( Product product : urgenteStock){
            System.out.println(product.toString());
        }
    }

    void updateStock(){
        System.out.println("Carui produs doriti sa ii dati update de stock?");
        String name = sc.nextLine();
        Product product = productService.getProductByName(name);
        if(product == null){
            System.out.println("Produsul nu exista");
            return;
        }
        System.out.println("Care sa fie stockul acum?");
        int stock = Integer.parseInt(sc.nextLine());
        productService.editStock(product, stock);
        if(product.getStock()==stock){
            System.out.println("Stock-ul a fost updatat acum la "+product.getStock());
        }
    }

    void stergeProdus(){
        System.out.println("Care sa fie produsul ce trebuie sters?");
        String name = sc.nextLine();
        Product product = productService.getProductByName(name);
        if(product == null){
            System.out.println("Produsul nu exista");
            return;
        }
        System.out.println("Sunteti sigur ca doriti sa stergeti produsul "+product.getName()+"?");
        System.out.println("Da/Nu.");
        switch(sc.nextLine()){
            case "Da":
                productService.deleteProduct(product);
                System.out.println("Produsul a fost sters");
                break;
            case "Nu":
                System.out.println("Ok, nu stergem");
                break;
        }
    }

    void createProdus(){
        int id = productService.generateProductId();
        int sku = productService.generateSKU();
        System.out.println("Care sa fie numele produsului?");
        String name = sc.nextLine();
        System.out.println("Care este pretul produsului "+name+"?");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Care este greutatea produsului "+name+"?");
        double weight = Double.parseDouble(sc.nextLine());
        System.out.println("Care este descrierea produsului "+name+"?");
        String description = sc.nextLine();
        System.out.println("Care este stockul produsului "+name+"?");
        int stock = Integer.parseInt(sc.nextLine());

        Product product = new Product(id, sku, name, price,  weight, description, stock);
        productService.addProduct(product);

        if(product == productService.getProductByName(name)){
            System.out.println("Produsul a fost creat cu succes");
        }

    }

    void bestSeller(){
        Product product = productService.getProductByID(orderDetailsService.bestSellerID());
        if(product == null){
            System.out.println("Produsul nu exista");
            return;
        }
        int sales = orderDetailsService.howManyTimesSold(product.getID());
        System.out.println("Cel mai bine vandut produs este: "+product.getName()+" si a fost vandut de "+sales+" ori.");
    }

    void bestCustomer(){
        Customer customer = customerService.getCustomerById(orderService.bestCustomerID());
        if(customer == null){
            System.out.println("Customerul nu exista");
            return;
        }
        double amount = orderService.amountSpentOnSite(customer.getId());
        System.out.println("Cele mai multe cumparaturi le-a facut "+customer.getFullName()+" pentru un total de "+amount+" RON.");
    }
}
