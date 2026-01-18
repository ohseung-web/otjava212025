package shopMol06;

public class Item {
	String name; // 카테고리의 item 이름
	int price; // item 가격
	String category; // 카테고리 : 육류, 과자 , 어류 기타 등등
	String usersId;
	
	// 매개변수 생성자
	public Item(String name, int price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	// 장바구니용 생성자  << 이렇게 두개로 사용해도 되는지??
	public Item(String name, int price, String category, String usersId) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.usersId = usersId;
	}
	
	//출력 메서드
	public void printInfo() {
		System.out.println("["+name+"]"+"["+price+"]"+"["+category+"]");
	}
}
