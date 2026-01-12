package shopMoll;

public class Cart {
	String userId; // 구입한 유저 id
	String itemName; // 구입한 아이템
	int price ; // 구입한  아이템 금액
	int Quantity ; // 구매수량
	
	public Cart() {}
	public Cart(String itemName, int price) {
		this.itemName = itemName;
		this.price = price;
	}

	public void printCart() {
		System.out.println("["+userId+"]"+"항목 : " + itemName + " ,금액 :"+ price 
				+ " ,수량 : " + Quantity + "개" );
	}
}
