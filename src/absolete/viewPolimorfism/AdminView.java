package absolete.viewPolimorfism;

import absolete.OrderService;
import absolete.Product;
import absolete.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView extends View{

    private final ProductService productService = new ProductService();
    private final OrderService orderService = new OrderService();
    private final Scanner sc = new Scanner(System.in);



    @Override
    public void play(){
        System.out.println("Welcome to Admin View");
        boolean continua = true;
        while(continua) {
            System.out.println(this);
            int alegere = Integer.parseInt(sc.nextLine());
            switch (alegere) {
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
                default:
                    System.out.println("Iesire din meniu.");
                    continua = false;
            }
        }
    }
    @Override
    public String createMeniu(){
        StringBuilder sb=new StringBuilder();
        sb.append("Alegeti din meniu");
        sb.append("\n");
        sb.append("1--> Verificati vanzarile");
        sb.append("\n");
        sb.append("2--> Verificati urgente stock");
        sb.append("\n");
        sb.append("3--> Update stock");
        sb.append("\n");
        sb.append("4--> Delete product");
        return sb.toString();
    }
    @Override
    public String toString(){
        return createMeniu();
    }

    private void vanzariTotale(){
        double vanzari = orderService.vanzariTotale();
        System.out.println("Vanzarile totale sunt: " + vanzari + " RON.");
    }
    private void urgenteStock(){
        ArrayList<Product> urgenteStock = productService.getStockEmergencies();
        System.out.println("Urgentele de stock sunt:");
        for( Product product : urgenteStock){
            System.out.println(product.toString());
        }
    }
    private void updateStock(){
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
    private void stergeProdus(){
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
}
