package app.products.comparators;

import app.products.models.Product;

import java.util.Comparator;

public class ProductIDComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getID()>o2.getID()){
            return 1;
        }
        else if(o1.getID()<o2.getID()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
