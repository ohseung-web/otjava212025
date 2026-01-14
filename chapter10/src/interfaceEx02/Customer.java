package interfaceEx02;

public class Customer implements Buy, Sell {

	@Override
	public void sell() {
		System.out.println("판매하기");

	}

	@Override
	public void buy() {
		System.out.println("구매하기");
	}

	// Customer에서 오류가 뜨는 이유는 같은 이름의 default 메소드가
	// 정의 되어있으니 오버라이드 하라는 의미이다.
	// 같은 이름의 default 메서드는 재정의 하여 사용한다.
	@Override
	public void order() {
        System.out.println("고객의 판매 주문");
		//Buy.super.order();
	}

}
