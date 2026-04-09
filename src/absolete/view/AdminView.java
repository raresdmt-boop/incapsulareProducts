package absolete.view;

import absolete.OrderService;

public class AdminView extends View {

    private final OrderService orderService;

    public AdminView() {
        this.orderService = new OrderService();
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
        int vanzariTotale = (int)orderService.vanzariTotale();
        System.out.println("Total de vanzari: "+vanzariTotale);

    }

}
