package shopMall04;

public class Cart{
	int log;
	String userName;
	String name;
    int price;
    int quantity;
	
    public Cart(int log,String userName, String name, int price, int quantity) {
        this.log = log;
        this.userName = userName;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}