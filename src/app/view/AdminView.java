package app.view;

import app.orders.OrderService;
import app.users.Admin;

import java.util.Scanner;

public class AdminView extends View {

    public AdminView() {
        adminmenu();
        adminplay();
    }

    private void adminmenu(){
        StringBuilder adminmenu =  new StringBuilder();
        adminmenu.append("1-> Verifica vanzari totale");
        adminmenu.append("2-> Verifica vanzari totale");
        super.meniu=adminmenu.toString();

    }

    private void adminplay(){
        boolean continua=true;
        while(continua){
            System.out.println(meniu);
            int alegere=Integer.parseInt(sc.nextLine());
            switch(alegere){
                case 1:
                    verificaVanzariTotale();
                    break;
            }
        }
    }

    private void verificaVanzariTotale(){

    }

}
