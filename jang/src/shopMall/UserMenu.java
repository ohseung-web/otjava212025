package shopMall;



public class UserMenu extends User {
	String userid;

	public UserMenu() {}
	public UserMenu(String userid, String itemName, int itemPrice, int itemQty) {
		this.userid = userid;
		super.itemName = itemName;
		super.itemPrice = itemPrice;
		super.itemQty = itemQty;
	}
	// 사용자 로그 메서드
	public int userLog(int idx) {
		log = idx;
		if(idx!=-1) userid=id[idx];
		return log;
	};

}
