package absolete.viewPolimorfism;

import absolete.OrderDetailsService;
import absolete.Order;
import absolete.OrderService;
import absolete.ProductService;
import absolete.system.basket.Basket;
import absolete.system.basket.ProductDto;
import absolete.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerView extends View {

    private final Scanner sc=new Scanner(System.in);
    private OrderService orderService = new OrderService();
    private Customer customer;
    OrderDetailsService orderDetailsService = new OrderDetailsService();
    ProductService productService = new ProductService();

    public CustomerView(Customer customer) {
        this.customer=customer;
    }

    @Override
    public void play(){
        System.out.println("Welcome to CustomerView");
        boolean continua=true;
        while(continua){
            System.out.println(this);
            int alegere = Integer.parseInt(sc.nextLine());
            switch (alegere){
                case 1:
                    seeOrders(this.customer);
                    break;
                case 2:
                    seeBasket(this.customer);
                    break;
                default:
                    System.out.println("Iesire din meniu");
                    continua = false;

            }
        }
    }

    @Override
    public String createMeniu(){
        StringBuilder sb=new StringBuilder();
        sb.append("Customer logat");
        sb.append("\n");
        sb.append("1--> See orders\n");
        sb.append("2--> See basket");
        return sb.toString();
    }
    @Override
    public String toString() {
        return createMeniu();
    }


    public void seeOrders(Customer customer){
        List<Order> orderList = orderService.getCustomerOrders(customer);
        for(Order order : orderList){
            System.out.println(order);
        }
        if(orderList.size()>0){
            System.out.println("1--> See order products.");
            int alegere = Integer.parseInt(sc.nextLine());
            switch (alegere){
                case 1:
                    Order order = orderService.getOrderbyID(sc.nextInt());
                    if (order == null) {
                        System.out.println("Order number doesn't exist!");
                        return;
                    } else if (customer.getId() != order.getCustomerId()) {
                        System.out.println("Order number" + order.getId() + "does not belong to customer");
                        return;
                    }
                    List<Integer> productIdList = orderDetailsService.orderProductID(order);
                    if (productIdList.isEmpty()) {
                        System.out.println("Nu exista produse in aceasta comanda");
                        return;
                    }
                    System.out.println("Produsele din comanda sunt:");
                    for (Integer integer : productIdList) {
                        System.out.println(productService.getProductNameById(integer));
                    }
            }
        }
    }
    public void seeBasket(Customer customer){
        Basket basket = new Basket(customer.getId());
        List<ProductDto> basketlist = basket.getBasketProducts();
        System.out.println(basketlist);
    }
}
