package shopMol05;

public class Item {
	// 멤버변수
	String name; // 카테고리의 item 이름
	int price; // item 가격
	String category; // 카테고리 : 육류, 과자 , 어류 기타 등등
	
	// 기본 디폴트 생성자
	public Item() {};
	
	// 매개변수 생성자
	public Item(String name, int price, String category) {
	this.name = name;
	this.price = price;
	this.category = category;
	}
	
	// 기본 상품 내역 추가 메서드
	
	//출력 메서드
	public void printInfo() {
	System.out.println("["+name+"]"+"["+price+"]"+"["+category+"]");
	}

}
