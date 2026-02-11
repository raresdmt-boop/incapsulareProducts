package app.view;

public class CustomerView extends View{

    public CustomerView() {
        createmeniu();
        customerplay();
    }

    private void customerplay(){

        boolean continua = true;
        while(continua){
            System.out.println(meniu);
            int alegere=sc.nextInt();
            switch(alegere){
                case 1:
                    plaseazacomanda();
                    break;
            }
        }

    }

    public void createmeniu(){
        StringBuilder meniu = new StringBuilder();
        meniu.append("1->Plaseaza comanda\n");
        meniu.append("2->Verifica statusul comenzii\n");
        super.meniu = meniu.toString();
    }

    public void plaseazacomanda(){

    }
}
