package arrayListexample;

import java.util.ArrayList;

public class Cart {
	
	ArrayList<Product> list = new ArrayList<>();

    public void addProduct(Product p) {
        list.add(p);
    }

    public void removeProduct(int index) {
        list.remove(index);
    }

    public void showCart() {
        for (Product p : list) {
            p.showInfo();
        }
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product p : list) {
            sum += p.price;
        }
        return sum;
    }
}
