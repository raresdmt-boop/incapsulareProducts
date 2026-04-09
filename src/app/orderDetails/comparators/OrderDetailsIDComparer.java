package app.orderDetails.comparators;

import app.orderDetails.models.OrderDetails;

import java.util.Comparator;

public class OrderDetailsIDComparer implements Comparator<OrderDetails> {
    @Override
    public int compare(OrderDetails o1, OrderDetails o2) {
        if(o1.getId()<o2.getId()){
            return -1;
        }
        else if(o1.getId()>o2.getId()){
            return 1;
        }
        return 0;
    }
}
