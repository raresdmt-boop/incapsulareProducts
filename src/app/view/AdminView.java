package app.view;


import app.orders.OrderService;

import java.util.Scanner;

public class AdminView {

    private final Scanner sc;
    private final OrderService orderService;

    public AdminView() {
        this.sc = new Scanner(System.in);
        this.orderService = new OrderService();
    }

    public void play(){

        boolean continua=true;
        while(continua){
            meniuAdmin();
            int alegere = Integer.parseInt(sc.nextLine());
            switch(alegere){
                case 1:

            }
        }
    }

    void meniuAdmin(){
        System.out.println("Welcome Admin");
        System.out.println("1-> Verifica vanzari totale.");
    }

    void vanzariTotale(){
        int vanzari = (int)orderService.vanzariTotale();
        System.out.println("Total de vanzari: "+vanzari);
    }
}
