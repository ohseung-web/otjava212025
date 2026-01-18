package shopMall;

public class Item {
	String name; // 카테고리의 item 이름
	int price; // item 가격
	String category; // 카테고리 : 육류, 과자 , 어류 기타 등등

	//생성자
	public Item(String name, int price, String category) {
	this.name = name;
	this.price = price;
	this.category = category;
	}
	
	//출력 메서드
	public void printInfo() {
	System.out.println("["+name+"]"+"["+price+"]"+"["+category+"]");
	}

	// setter(관리자용)
	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
	    this.name = name;
	}
}
