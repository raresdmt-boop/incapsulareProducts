package app.orderDetails.repository;

public class OrderDetailsRepositorySingleton {

    private static OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepositoryImpl();
    public static OrderDetailsRepository getInstance(){
        return orderDetailsRepository;
    }

}
