package shopMol05;

public class CartItem {
	
	// 멤버 변수
	String logID = null;
	String name = null;
	int price = 0;
	String category = null;
	int quan ; 

	// 기본 디폴트 생성자
	public CartItem() {};
	
	// 매개변수 생성자
	public CartItem(String logID, Item item) {
		this.logID = logID;
		this.name = item.name;
		this.price = item.price;
		this.category = item.category;
		this.quan = 1;
	}
	
	// 출력 메서드
	public void printCart() {
		System.out.println("["+logID+"] 항목: "+name+","+"금액: "+(price*quan)+"원,"+"수량: "+quan+"개");
	}

}
