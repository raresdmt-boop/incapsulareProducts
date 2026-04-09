package absolete.view;

import absolete.Customer;
import absolete.Order;
import absolete.OrderService;

import java.util.List;

public class CustomerView extends View{

    private final Customer customer;
    private OrderService orderService;



    public CustomerView(Customer customer) {
        this.customer= customer;
        this.orderService = new OrderService();
        System.out.println("Bine ati venit in CustomerView");
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
                    seeOrders();
                    break;
            }
        }

    }

    public void createmeniu(){
        StringBuilder meniu = new StringBuilder();
        meniu.append("1->Vezi orders\n");
        meniu.append("2->Plaseaza comanda\n");
        super.meniu = meniu.toString();
    }

    private void seeOrders(){
        List<Order> customerOrders = orderService.getCustomerOrders(customer);
        for(Order order:customerOrders){
            System.out.println(order);
        }
    }

}
