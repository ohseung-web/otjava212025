package shopMol03;

public class CartList {
	String userId;
	String itemName;
	int itemPrice;
	int quantity = 1;;
	
	public CartList() {};
	
	public CartList(String userId, String itemName, int itemPrice, int quantity) {
		this.userId = userId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;		
	};
}
