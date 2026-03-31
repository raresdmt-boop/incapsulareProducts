package app.orders.repository;

public class OrderRepositorySingleton {

    private static OrderRepository orderRepository = new OrderRepositoryImpl();
    public static OrderRepository getInstance(){
        return orderRepository;
    }

}
