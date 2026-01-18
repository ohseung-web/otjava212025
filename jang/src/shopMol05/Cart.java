package shopMol05;

import java.util.ArrayList;

public class Cart extends CartItem{
	
	// 기본 디폴트 생성자
	public Cart() {};
	
	// 장바구니 배열 생성
	ArrayList<CartItem> cartList = new ArrayList<>();
	
	// 장바구니 배열 추가 메서드
	public void addCart(String logID, Item item) {
		
		if(cartList.isEmpty()) {
			cartList.add(new CartItem(logID, item));
		}else {
			for(CartItem c : cartList) { // 장바구니가 비어있을 경우 for 문이 돌아가지 않음 !!
				// 선택 상품이 이미 장바구니에 존재할 경우 수량 증가
				if(c.name.equals(item.name)) {
					c.quan ++; 
					return;
				}
				// 선택 상품이 장바구니에 존재하지 않는 경우 장바구니 추가
				else {
					cartList.add(new CartItem(logID, item));
					return;
				}
			}
		}
		
		
		
	}
	
	// 전체 장바구니 출력
	public void printAllCart() {
		System.out.println("=========== 장바구니 리스트 ===========");
		for(CartItem c : cartList) c.printCart();
		System.out.println("=================================");
	}
	
	// 개인 장바구니 출력
	public void printOneCart(String ID) {
		for(CartItem c : cartList) {
			if(c.logID.equals(ID)) {
				c.printCart();
			}
		}
		
	}
	
	
	
}
