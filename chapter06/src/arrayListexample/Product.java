package arrayListexample;

public class Product {

	String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void showInfo() {
        System.out.println(name + " : " + price + "원");
    }
}
