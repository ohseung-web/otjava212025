package shopMol03;

import java.util.ArrayList;

public class Cart {
	ArrayList<CartList> cartlist = new ArrayList<>();
	Item item = new Item();
	ItemManager itemM = new ItemManager();
	public Cart() {};
	
	
	// 장바구니 추가 함수
	public void cartAdd(String userId, String itemName, int itemPrice, int quantity) {
		for(CartList c : cartlist) {
			if(c.itemName.equals(itemName) && c.userId.equals(userId)) {
				c.quantity += 1;
				c.itemPrice = c.quantity * itemPrice;
				return;
			}
		}
		cartlist.add(new CartList(userId, itemName, itemPrice, quantity));
	}
	
	// 출력 함수
	public void printCart2(String ids) {
		if(cartlist.size() == 0) {
			System.out.println("현재 장바구니가 비었습니다.");
		}else {
			for(int i = 0; i < cartlist.size(); i++) {
//				System.out.println(cartlist.get(i).id);
//				System.out.println(ids);
				if(ids.equals(cartlist.get(i).userId)) {
					CartList c = cartlist.get(i);
					System.out.println("[" + c.userId + "] 항목 : " + c.itemName + ", 금액 : " + c.itemPrice + ", 수량 : " + c.quantity + "개");
				}
			}
		}
	}
	public void printCart() {
		if(cartlist.size() == 0) {
			System.out.println("현재 장바구니가 비었습니다.");
		}else {
			for(int i = 0; i < cartlist.size(); i++) {
				CartList c = cartlist.get(i);
				System.out.println("[" + c.userId + "] 항목 : " + c.itemName + ", 금액 : " + c.itemPrice + ", 수량 : " + c.quantity + "개");
			}
		}
	}
}
