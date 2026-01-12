package shopMoll;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	Scanner scan = new Scanner(System.in);

	// 카테고리를 String 자료형으로 ArrayList 생성
	ArrayList<String> category = new ArrayList<>();

	//전체 아이템리스트를  Item 자료형으로 ArrayList 생성
	ArrayList<Item> itemList = new ArrayList<>(); 

	// 전체 장바구니
	ArrayList<Cart> jangList = new ArrayList<>(); 

	UserMenu user = new UserMenu();

	public ItemManager() {
		info();
	}

	// 카테고리 추가 및 item 추가 메서드 -------------------------------------------------------
	public void info() {
		category.add("과자"); // index 0번째
		category.add("생선"); // index 1번째
		category.add("육류"); // index 2번째
		category.add("음료수"); // index 3번째
		Item temp = new Item("새우깡", 1000, category.get(0)); // Item 인스턴스 함
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1)); 
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0)); 
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2)); 
		itemList.add(temp);
		temp = new Item("돼지고기", 5500, category.get(2)); 
		itemList.add(temp);
		temp = new Item("콜라", 1000, category.get(3)); 
		itemList.add(temp);
		temp = new Item("사이다", 1500, category.get(3)); 
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1)); 
		itemList.add(temp);
	}

	// 카테고리 출력 메서드 ---------------------------------------------------------------------------
	public void printCategory() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+i+"]"+category.get(i));
		}
	}

	//item 목록 출력 메서드 ---------------------------------------------------------------------------
	public void printItemList() {
		for(int i=0; i< itemList.size(); i++) {
			System.out.print("["+i+"]");
			itemList.get(i).printInfo();
		}
	}

	// 장바구니  ----------------------------------------------------------------------------------------
	// usID => id, caID => 카테고리 index 번호,  itemID => 항목 index 번호
	public void addCart(String usID, int caID, int itemID) {

		int cnt = 0;
		int jangcnt = 0; // 장바구니에 중복된 데이터의 존재 유무  확인 치트키
		int log = user.logindex; // Usermenu클래스의 로그인된 log값을 static로 공유 함
		Cart temp = new Cart();
		temp.userId = usID;

		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(itemID).name.equals(itemList.get(i).name)) {

				jangcnt = 0;

				for(int j=0; j<jangList.size(); j++) {
					if(jangList.get(j).itemName.equals(itemList.get(i).name) 
							&& jangList.get(j).userId.equals(user.id[log]) ) {
						jangList.get(j).price += itemList.get(i).price;
						jangList.get(j).Quantity += 1;
						jangcnt += 1;
					}
				}
				if (jangcnt == 0) {
					temp.itemName = itemList.get(i).name;
					temp.price = itemList.get(i).price ;
					cnt += 1;
					temp.Quantity = cnt;
					jangList.add(temp);
				} 
			}
		}

	}

	// 장바구니 인쇄 ---------------------------------------------------------------------------
	public void printJang() {
		for (int i = 0; i < jangList.size(); i++) {
			jangList.get(i).printCart();
		}
	}


	// 장바구니 delete ---------------------------------------------------------------------------
	public void cartClear() {
		int jangsize = jangList.size();
		for (int i = 0; i < jangsize; i++) {
			jangList.remove(0);
		}
	}

	// item 추가  ---------------------------------------------------------------------------
	public void addItem(String addname, int addprice, int addcategory) {
		Item temp = new Item(addname, addprice, category.get(addcategory)); 
		itemList.add(temp);
	}


	// item 삭제  ---------------------------------------------------------------------------
	public void deleteItem(int deleteindex) {
			itemList.remove(deleteindex);
	}	

	// item 수정  ---------------------------------------------------------------------------
	public void updateItem(int indexNUM, String updatename, int updateprice) {
		for(int i =0; i< itemList.size(); i++) {
			itemList.get(indexNUM).name  = updatename ;
			itemList.get(indexNUM).price  = updateprice ;
		}

	}
}
